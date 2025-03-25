package com.multiverse.Snipper.service;

import com.multiverse.Snipper.model.User;

import java.util.Optional;

public interface UserService {
  User create(User user);
  Optional<User> findById(Long id);
  void deleteById(Long id);
}
