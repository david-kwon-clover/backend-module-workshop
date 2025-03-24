package com.multiverse.Snipper.service;

import com.multiverse.Snipper.model.Snippet;
import com.multiverse.Snipper.repository.SnippetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnippetServiceImpl implements SnippetService {
  @Autowired private SnippetRepository snippetRepository;

  @Override
  public Snippet createSnippet(Snippet snippet) {
    return snippetRepository.save(snippet);
  }

  @Override
  public Snippet getSnippet(Long id) {
    return snippetRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteSnippet(Long id) {
    snippetRepository.deleteById(id);
  }
}
