package com.multiverse.Snipper.controller;

import com.multiverse.Snipper.model.Snippet;
import com.multiverse.Snipper.service.SnippetServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/snippet")
public class SnippetController {
  @Autowired
  private SnippetServiceImpl snippetServiceImpl;

  @PostMapping
  public ResponseEntity<Snippet> createSnippet(@RequestBody @Valid Snippet snippet) {
    return new ResponseEntity<>(snippetServiceImpl.createSnippet(snippet), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Snippet>> getAllSnippets(@RequestParam(required = false) String language) {
    if (language != null) {
      return new ResponseEntity<>(snippetServiceImpl.getSnippetsByLanguage(language), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(snippetServiceImpl.getAllSnippets(), HttpStatus.OK);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Snippet>> getSnippet(@PathVariable("id") Long id) {
    Optional<Snippet> snippet = snippetServiceImpl.getSnippet(id);
    return new ResponseEntity<>(snippet, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSnippet(@PathVariable("id") Long id) {
    Optional<Snippet> snippet = snippetServiceImpl.getSnippet(id);
    snippetServiceImpl.deleteSnippet(snippet.get().getId());
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
