package com.project.logistics.service;

import com.project.logistics.dto.DeliveryDto;
import com.project.logistics.dto.neworder.NewOrPaidOrder;
import com.project.logistics.entity.OrderEntity;
import com.project.logistics.entity.RouteEntity;

import java.util.List;

public interface OrderService {
    boolean saveNewOrder(OrderEntity newOrder);

    List<NewOrPaidOrder> getNewOrPaidOrders();

    List<OrderEntity> getOrdersByUserId(Integer id);

    List<DeliveryDto> getOrdersByRoute(OrderEntity route);

    Boolean setOrderStatus(OrderEntity order);
}
