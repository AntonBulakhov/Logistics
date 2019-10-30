package com.project.logistics.controller;

import com.project.logistics.dto.NewRouteDto;
import com.project.logistics.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/route")
public class RouteController {

    private RouteService routeService;

    @PostMapping
    public Boolean createNewRoute(@RequestBody NewRouteDto routeDto) {
        return routeService.createRoute(routeDto);
    }

    @Autowired
    public void setRouteService(RouteService routeService) {
        this.routeService = routeService;
    }
}
