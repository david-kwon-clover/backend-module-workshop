package com.multiverse.Snipper.service;

import com.multiverse.Snipper.model.User;
import com.multiverse.Snipper.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public User create(User user) {
    return userRepository.save(user);
  }

  @Override
  public Optional<User> findById(Long id) {
    Optional<User> user = userRepository.findById(id);
    if (user.isPresent()) {
      return user;
    } else {
      throw new EntityNotFoundException("User with id " + id + " not found");
    }
  }

  @Override
  public void deleteById(Long id) {
    userRepository.deleteById(id);
  }
}
