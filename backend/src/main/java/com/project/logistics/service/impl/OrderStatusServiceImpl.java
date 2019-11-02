package com.project.logistics.service.impl;

import com.project.logistics.entity.OrderStatusEntity;
import com.project.logistics.repository.OrderStatusRepository;
import com.project.logistics.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

    private OrderStatusRepository repository;

    @Override
    public List<OrderStatusEntity> getAll() {
        return (List<OrderStatusEntity>) repository.findAll();
    }

    @Autowired
    public void setRepository(OrderStatusRepository repository) {
        this.repository = repository;
    }
}
