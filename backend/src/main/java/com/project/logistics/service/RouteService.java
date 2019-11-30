package com.project.logistics.service;

import com.project.logistics.dto.AlternativeRoute;
import com.project.logistics.dto.NewOrder;
import com.project.logistics.dto.NewRouteDto;
import com.project.logistics.entity.RouteEntity;

import java.util.List;

public interface RouteService {
    boolean createRoute(NewRouteDto routeDto);
    List<AlternativeRoute> getAlternativeRoutes(NewOrder newOrder);
}
