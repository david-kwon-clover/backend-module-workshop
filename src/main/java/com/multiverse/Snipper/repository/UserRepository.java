package com.multiverse.Snipper.repository;

import com.multiverse.Snipper.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
  User save(User user);
  User findById(long id);
  void deleteById(long id);
}
