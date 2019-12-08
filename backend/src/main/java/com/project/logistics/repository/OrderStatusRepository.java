package com.project.logistics.repository;

import com.project.logistics.entity.OrderStatusEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderStatusRepository extends CrudRepository<OrderStatusEntity, Integer> {
    List<OrderStatusEntity> getAllByNameIn(List<String> names);
}
