package com.project.logistics.service;

import com.project.logistics.entity.PointEntity;

import java.util.List;

public interface PointService {
    PointEntity createPoint(PointEntity pointEntity);

    PointEntity getPointByName(String name);

    PointEntity getPointById(Integer id);

    List<PointEntity> getLeftPoints(List<Integer> ids);

    List<PointEntity> getAllPoints();
}
