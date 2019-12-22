package com.project.logistics.controller;

import com.project.logistics.dto.AlternativeRoute;
import com.project.logistics.dto.DeliveryDto;
import com.project.logistics.dto.NewOrder;
import com.project.logistics.dto.neworder.NewOrPaidOrder;
import com.project.logistics.entity.OrderEntity;
import com.project.logistics.entity.OrderTypeEntity;
import com.project.logistics.service.OrderService;
import com.project.logistics.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private RouteService routeService;
    private OrderService orderService;

    @PostMapping("/alternative")
    public List<AlternativeRoute> getAlternativeRoutes(@RequestBody NewOrder newOrder) {
        return routeService.getAlternativeRoutes(newOrder);
    }

    @PostMapping("/save")
    public Boolean saveNewOrder(@RequestBody OrderEntity newOrder) {
        return orderService.saveNewOrder(newOrder);
    }

    @GetMapping("/paid")
    public List<NewOrPaidOrder> getNewOrPaidOrders() {
        return orderService.getNewOrPaidOrders();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public List<OrderEntity> getOrdersByUserId(@PathVariable Integer id) {
        return orderService.getOrdersByUserId(id);
    }

    @PostMapping("/route")
    public List<DeliveryDto> getOrdersByRoute(@RequestBody OrderEntity route) {
        return orderService.getOrdersByRoute(route);
    }

    @PostMapping("/status")
    public Boolean setOrderStatus(@RequestBody OrderEntity order) {
        return orderService.setOrderStatus(order);
    }

    @GetMapping("/type")
    public List<OrderTypeEntity> getAllTypes() {
        return orderService.getAllTypes();
    }

    @PostMapping("/type")
    public Boolean saveOrderType(@RequestBody OrderTypeEntity order) {
        return orderService.saveOrderType(order);
    }

    @Autowired
    public void setRouteService(RouteService routeService) {
        this.routeService = routeService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
