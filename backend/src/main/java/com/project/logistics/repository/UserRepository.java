package com.project.logistics.repository;

import com.project.logistics.entity.RoleEntity;
import com.project.logistics.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity getByLogin(String login);
    List<UserEntity> getAllByRole(RoleEntity role);
}
