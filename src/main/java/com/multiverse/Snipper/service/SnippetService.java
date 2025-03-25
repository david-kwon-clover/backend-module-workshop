package com.multiverse.Snipper.service;

import com.multiverse.Snipper.model.Snippet;

import java.util.List;
import java.util.Optional;

public interface SnippetService {
  Snippet createSnippet(Snippet snippet);
  List<Snippet> getAllSnippets();
  List<Snippet> getSnippetsByLanguage(String language);
  Optional<Snippet> getSnippet(Long id);
  void deleteSnippet(Long id);
}
