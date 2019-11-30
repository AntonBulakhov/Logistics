package com.project.logistics.controller;

import com.project.logistics.dto.AlternativeRoute;
import com.project.logistics.dto.NewOrder;
import com.project.logistics.entity.RouteEntity;
import com.project.logistics.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private RouteService routeService;

    @PostMapping("/alternative")
    public List<AlternativeRoute> getAlternativeRoutes(@RequestBody NewOrder newOrder) {
        return routeService.getAlternativeRoutes(newOrder);
    }

    @Autowired
    public void setRouteService(RouteService routeService) {
        this.routeService = routeService;
    }
}
