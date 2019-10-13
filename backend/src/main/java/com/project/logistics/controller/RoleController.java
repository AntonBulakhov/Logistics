package com.project.logistics.controller;

import com.project.logistics.entity.RoleEntity;
import com.project.logistics.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    private RoleService roleService;

    @GetMapping("/all")
    public List<RoleEntity> getAllRoles() {
        return roleService.getAllRoles();
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
