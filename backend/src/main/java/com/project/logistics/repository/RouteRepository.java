package com.project.logistics.repository;

import com.project.logistics.entity.PointEntity;
import com.project.logistics.entity.RouteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RouteRepository extends CrudRepository<RouteEntity, Integer> {
    RouteEntity getByStartPointAndEndPoint(PointEntity startPoint, PointEntity endPoint);
    List<RouteEntity> getAllByStartPointAndEndPoint(PointEntity startPoint, PointEntity endPoint);
}
