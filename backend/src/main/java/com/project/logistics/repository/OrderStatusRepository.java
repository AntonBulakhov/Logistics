package com.project.logistics.repository;

import com.project.logistics.entity.OrderStatusEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderStatusRepository extends CrudRepository<OrderStatusEntity, Integer> {
}
