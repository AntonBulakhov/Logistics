package com.project.logistics.controller;

import com.project.logistics.dto.SafeUser;
import com.project.logistics.entity.UserEntity;
import com.project.logistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public Boolean saveUser(@RequestBody UserEntity userEntity) {
        return userService.saveUser(userEntity) != null;
    }

    @GetMapping("/profile/{id}")
    public UserEntity getFullUserByLogin(@PathVariable Integer id) {
        UserEntity user = userService.getUserById(id);
        user.setPassword("");
        return user;
    }

    @GetMapping("/employees")
    public List<SafeUser> getAllEmployees() {
        return userService.getAllEmployees();
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
