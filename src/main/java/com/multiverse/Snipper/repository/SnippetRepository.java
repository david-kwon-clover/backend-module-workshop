package com.multiverse.Snipper.repository;

import com.multiverse.Snipper.model.Snippet;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SnippetRepository extends CrudRepository<Snippet, Long> {
  Snippet save(Snippet snippet);
  Optional<Snippet> findById(Long id);
  void deleteById(Long id);
}
