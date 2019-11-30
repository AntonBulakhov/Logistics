package com.project.logistics.repository;

import com.project.logistics.entity.RouteHasSegmentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RouteHasSegmentRepository extends CrudRepository<RouteHasSegmentEntity, Integer> {
    List<RouteHasSegmentEntity> getAllByRouteId(Integer routeId);
}
