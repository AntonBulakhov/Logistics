package com.project.logistics.repository;

import com.project.logistics.entity.OrderEntity;
import com.project.logistics.entity.OrderStatusEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
    List<OrderEntity> getAllByOrderStatusIn(List<OrderStatusEntity> statuses);
}
