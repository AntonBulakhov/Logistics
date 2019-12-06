package com.project.logistics.service.impl;

import com.project.logistics.entity.OrderEntity;
import com.project.logistics.entity.UserEntity;
import com.project.logistics.repository.OrderRepository;
import com.project.logistics.repository.UserRepository;
import com.project.logistics.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private UserRepository userRepository;

    @Override
    public boolean saveNewOrder(OrderEntity newOrder) {
        Optional<UserEntity> userEntity = userRepository.findById(1);
        newOrder.setUser(userEntity.get());
        return orderRepository.save(newOrder) != null;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
