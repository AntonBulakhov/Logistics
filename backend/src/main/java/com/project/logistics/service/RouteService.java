package com.project.logistics.service;

import com.project.logistics.dto.NewRouteDto;

public interface RouteService {
    boolean createRoute(NewRouteDto routeDto);
}
