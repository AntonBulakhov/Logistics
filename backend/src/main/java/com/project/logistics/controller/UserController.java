package com.project.logistics.controller;

import com.project.logistics.entity.UserEntity;
import com.project.logistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @GetMapping("/profile/{id}")
    public UserEntity getFullUserByLogin(@PathVariable Integer id) {
        UserEntity user = userService.getUserById(id);
        user.setPassword("");
        return user;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
