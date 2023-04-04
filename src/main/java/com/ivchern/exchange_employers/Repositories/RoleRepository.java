package com.ivchern.exchange_employers.Repositories;

import com.ivchern.exchange_employers.Model.ERole;
import com.ivchern.exchange_employers.Model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
