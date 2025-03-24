package com.multiverse.Snipper.controller;

import com.multiverse.Snipper.model.User;
import com.multiverse.Snipper.service.UserServiceImpl;
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

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserServiceImpl userServiceImpl;

  @PostMapping("")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    return new ResponseEntity<>(userServiceImpl.create(user), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
    return new ResponseEntity<>(userServiceImpl.findById(id), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public HttpStatus deleteUser(@PathVariable("id") Long id) {
    userServiceImpl.deleteById(id);
    return HttpStatus.OK;
  }
}
