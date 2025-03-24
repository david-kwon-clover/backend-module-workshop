package com.multiverse.Snipper.repository;

import com.multiverse.Snipper.model.Snippet;
import org.springframework.data.repository.CrudRepository;

public interface SnippetRepository extends CrudRepository<Snippet, Long> {
  Snippet save(Snippet snippet);
  Snippet findById(long id);
  void deleteById(long id);
}
