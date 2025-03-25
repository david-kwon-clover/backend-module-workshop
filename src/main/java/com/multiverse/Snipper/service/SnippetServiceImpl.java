package com.multiverse.Snipper.service;

import com.multiverse.Snipper.encryption.EncryptionService;
import com.multiverse.Snipper.model.Snippet;
import com.multiverse.Snipper.repository.SnippetRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SnippetServiceImpl implements SnippetService {

  @Autowired
  private final EncryptionService encryptionService;

  @Autowired
  private SnippetRepository snippetRepository;

  @Override
  public Snippet createSnippet(Snippet snippet) {
    String encryptedContent = encryptionService.encrypt(snippet.getContent());
    snippet.setContent(encryptedContent);
    return snippetRepository.save(snippet);
  }

  @Override
  public List<Snippet> getAllSnippets() {
    List<Snippet> allSnippets = snippetRepository.findAll();
    allSnippets.forEach(snippet ->
      snippet.setContent(encryptionService.decrypt(snippet.getContent()))
    );
    return allSnippets;
  }

  @Override
  public List<Snippet> getSnippetsByLanguage(String language) {
    List<Snippet> allSnippetsByLanguage = snippetRepository.findAllByLanguage(language);
    allSnippetsByLanguage.forEach(snippet ->
      snippet.setContent(encryptionService.decrypt(snippet.getContent()))
    );
    return allSnippetsByLanguage;
  }

  @Override
  public Optional<Snippet> getSnippet(Long id) {
    Optional<Snippet> snippet = snippetRepository.findById(id);
    if (snippet.isPresent()) {
      String decryptedContent = encryptionService.decrypt(snippet.get().getContent());
      snippet.get().setContent(decryptedContent);
      return snippet;
    } else {
      throw new EntityNotFoundException("Snippet with id " + id + " not found");
    }
  }

  @Override
  public void deleteSnippet(Long id) {
    snippetRepository.deleteById(id);
  }

}
