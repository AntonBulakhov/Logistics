package com.project.logistics.repository;

import com.project.logistics.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity getByLogin(String login);
}
