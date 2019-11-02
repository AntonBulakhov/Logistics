package com.project.logistics.service;

import com.project.logistics.entity.OrderStatusEntity;

import java.util.List;

public interface OrderStatusService {
    List<OrderStatusEntity> getAll();
}
