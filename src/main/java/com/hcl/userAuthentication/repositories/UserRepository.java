package com.hcl.userAuthentication.repositories;

import com.hcl.userAuthentication.models.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
