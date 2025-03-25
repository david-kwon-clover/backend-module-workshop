package com.multiverse.Snipper.repository;

import com.multiverse.Snipper.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
  User save(User user);
  Optional<User> findById(Long id);
  void deleteById(Long id);
}
