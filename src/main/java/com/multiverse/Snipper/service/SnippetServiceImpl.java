package com.multiverse.Snipper.service;

import com.multiverse.Snipper.model.Snippet;
import com.multiverse.Snipper.repository.SnippetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SnippetServiceImpl implements SnippetService {
  @Autowired
  private SnippetRepository snippetRepository;

  @Override
  public Snippet createSnippet(Snippet snippet) {
    return snippetRepository.save(snippet);
  }

  @Override
  public Optional<Snippet> getSnippet(Long id) {
    Optional<Snippet> snippet = snippetRepository.findById(id);
    if (snippet.isPresent()) {
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
