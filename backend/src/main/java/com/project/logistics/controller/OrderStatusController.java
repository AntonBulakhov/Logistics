package com.project.logistics.controller;

import com.project.logistics.entity.OrderStatusEntity;
import com.project.logistics.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class OrderStatusController {

    private OrderStatusService orderStatusService;

    @GetMapping("/all")
    public List<OrderStatusEntity> getAllStatuses() {
        return orderStatusService.getAll();
    }

    @Autowired
    public void setOrderStatusService(OrderStatusService orderStatusService) {
        this.orderStatusService = orderStatusService;
    }
}
