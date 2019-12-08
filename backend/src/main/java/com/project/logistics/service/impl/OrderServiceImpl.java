package com.project.logistics.service.impl;

import com.project.logistics.converter.OrderToNewOrPaidOrderConverter;
import com.project.logistics.dto.neworder.NewOrPaidOrder;
import com.project.logistics.entity.OrderEntity;
import com.project.logistics.entity.OrderStatusEntity;
import com.project.logistics.entity.UserEntity;
import com.project.logistics.repository.OrderRepository;
import com.project.logistics.repository.OrderStatusRepository;
import com.project.logistics.repository.UserRepository;
import com.project.logistics.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private OrderStatusRepository orderStatusRepository;

    private OrderToNewOrPaidOrderConverter toNewOrPaidOrderConverter;

    private static final String NEW_ORDER = "new";
    private static final String PAID_ORDER = "paid";

    @Override
    public boolean saveNewOrder(OrderEntity newOrder) {
        Optional<UserEntity> userEntity = userRepository.findById(1);
        newOrder.setUser(userEntity.get());
        return orderRepository.save(newOrder) != null;
    }

    @Override
    public List<NewOrPaidOrder> getNewOrPaidOrders() {
        List<OrderStatusEntity> statuses = orderStatusRepository.getAllByNameIn(Arrays.asList(NEW_ORDER, PAID_ORDER));
        List<OrderEntity> entities = orderRepository.getAllByOrderStatusIn(statuses);
        return toNewOrPaidOrderConverter.convert(entities);
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setOrderStatusRepository(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    @Autowired
    public void setToNewOrPaidOrderConverter(OrderToNewOrPaidOrderConverter toNewOrPaidOrderConverter) {
        this.toNewOrPaidOrderConverter = toNewOrPaidOrderConverter;
    }
}
