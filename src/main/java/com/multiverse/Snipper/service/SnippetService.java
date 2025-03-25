package com.multiverse.Snipper.service;

import com.multiverse.Snipper.model.Snippet;

import java.util.Optional;

public interface SnippetService {
  Snippet createSnippet(Snippet snippet);
  Optional<Snippet> getSnippet(Long id);
  void deleteSnippet(Long id);
}
