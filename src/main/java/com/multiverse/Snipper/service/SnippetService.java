package com.multiverse.Snipper.service;

import com.multiverse.Snipper.model.Snippet;

public interface SnippetService {
  Snippet createSnippet(Snippet snippet);
  Snippet getSnippet(Long id);
  void deleteSnippet(Long id);
}
