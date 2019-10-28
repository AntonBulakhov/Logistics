package com.project.logistics.repository;

import com.project.logistics.entity.PointEntity;
import com.project.logistics.entity.RouteEntity;
import org.springframework.data.repository.CrudRepository;

public interface RouteRepository extends CrudRepository<RouteEntity, Integer> {
    RouteEntity getByStartPointAndEndPoint(PointEntity startPoint, PointEntity endPoint);
}
