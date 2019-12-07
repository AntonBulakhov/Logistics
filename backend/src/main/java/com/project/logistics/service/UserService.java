package com.project.logistics.service;

import com.project.logistics.dto.SafeUser;
import com.project.logistics.entity.UserEntity;

public interface UserService {
    UserEntity getUserByLogin(String login);
    SafeUser getSafeUserByLogin(String login);
    UserEntity saveUser(UserEntity userEntity);
    UserEntity getUserById(Integer id);
}
