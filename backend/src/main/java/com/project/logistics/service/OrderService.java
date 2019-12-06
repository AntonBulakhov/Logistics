package com.project.logistics.service;

import com.project.logistics.entity.OrderEntity;

public interface OrderService {
    boolean saveNewOrder(OrderEntity newOrder);
}
