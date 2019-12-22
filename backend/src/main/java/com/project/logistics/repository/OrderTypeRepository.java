package com.project.logistics.repository;

import com.project.logistics.entity.OrderTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTypeRepository extends CrudRepository<OrderTypeEntity, Integer> {
}
