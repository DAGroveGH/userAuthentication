package com.hcl.userAuthentication.services;

import com.hcl.userAuthentication.models.UserEntity;
import com.hcl.userAuthentication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public boolean addUser(UserEntity userEntity) {
        if(userEntity == null) {
            return false;
        }
        userRepository.save(userEntity);
        return true;
    }

    public UserEntity getUserByUsername(String username) {
        Iterable<UserEntity> users = userRepository.findAll();
        for(UserEntity userEntity : users) {
            if(userEntity.getUsername().equals(username)) {
                return userEntity;
            }
        }
        return null;
    }

    public boolean validateUser(UserEntity userEntity, String password) {
        return (userEntity.getPassword().equals(password));
    }
}
