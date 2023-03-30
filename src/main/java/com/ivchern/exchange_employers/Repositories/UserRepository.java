package com.ivchern.exchange_employers.Repositories;

import com.ivchern.exchange_employers.Model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
//    User findByUsername(String username);
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
