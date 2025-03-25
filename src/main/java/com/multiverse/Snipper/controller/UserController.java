package com.multiverse.Snipper.controller;

import com.multiverse.Snipper.model.User;
import com.multiverse.Snipper.service.UserServiceImpl;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserServiceImpl userServiceImpl;

  @PostMapping("")
  public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
    return new ResponseEntity<>(userServiceImpl.create(user), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<User>> getUser(@PathVariable("id") Long id) {
    Optional<User> user = userServiceImpl.findById(id);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
    Optional<User> user = userServiceImpl.findById(id);
    userServiceImpl.deleteById(user.get().getId());
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
