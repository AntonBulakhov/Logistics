package com.project.logistics.service.impl;

import com.project.logistics.dto.NewRouteDto;
import com.project.logistics.entity.RouteEntity;
import com.project.logistics.entity.RouteHasSegmentEntity;
import com.project.logistics.entity.SegmentEntity;
import com.project.logistics.repository.RouteHasSegmentRepository;
import com.project.logistics.repository.RouteRepository;
import com.project.logistics.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private RouteRepository routeRepository;
    private RouteHasSegmentRepository relationsRepository;

    @Override
    public boolean createRoute(NewRouteDto routeDto) {
        RouteEntity createdRoute = routeRepository.save(routeDto.getRoute());
        if (createdRoute == null) {
            return false;
        }
        createdRoute = routeRepository.getByStartPointAndEndPoint(createdRoute.getStartPoint(),
                createdRoute.getEndPoint());
        List<RouteHasSegmentEntity> routeHasSegmentEntityList = new ArrayList<>();
        for (SegmentEntity entity : routeDto.getRelations()) {
            RouteHasSegmentEntity hasSegmentEntity = new RouteHasSegmentEntity();
            hasSegmentEntity.setRouteId(createdRoute.getId());
            hasSegmentEntity.setSegmentId(entity.getId());
            routeHasSegmentEntityList.add(hasSegmentEntity);
        }
        return relationsRepository.saveAll(routeHasSegmentEntityList) != null;
    }

    @Autowired
    public void setRouteRepository(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Autowired
    public void setRelationsRepository(RouteHasSegmentRepository relationsRepository) {
        this.relationsRepository = relationsRepository;
    }
}
