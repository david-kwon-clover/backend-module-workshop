package com.multiverse.Snipper.service;

import com.multiverse.Snipper.model.User;
import com.multiverse.Snipper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public User create(User user) {
    return userRepository.save(user);
  }

  @Override
  public User findById(Long id) {
    return userRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteById(Long id) {
    userRepository.deleteById(id);
  }
}
