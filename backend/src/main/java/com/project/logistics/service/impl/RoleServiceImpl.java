package com.project.logistics.service.impl;

import com.project.logistics.entity.RoleEntity;
import com.project.logistics.repository.RoleRepository;
import com.project.logistics.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Override
    public List<RoleEntity> getAllRoles() {
        return (List<RoleEntity>)roleRepository.findAll();
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
