package com.project.logistics.repository;

import com.project.logistics.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {
    List<RoleEntity> getAll();
}
