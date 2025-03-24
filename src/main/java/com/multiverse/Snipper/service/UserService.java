package com.multiverse.Snipper.service;

import com.multiverse.Snipper.model.User;

public interface UserService {
  User create(User user);
  User findById(Long id);
  void deleteById(Long id);
}
