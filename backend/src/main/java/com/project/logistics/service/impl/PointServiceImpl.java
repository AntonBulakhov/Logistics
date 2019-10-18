package com.project.logistics.service.impl;

import com.project.logistics.entity.PointEntity;
import com.project.logistics.repository.PointRepository;
import com.project.logistics.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointServiceImpl implements PointService {

    private PointRepository pointRepository;

    @Override
    public PointEntity createPoint(PointEntity pointEntity) {
        return pointRepository.save(pointEntity);
    }

    @Override
    public PointEntity getPointById(Integer id) {
        return pointRepository.getPointEntityById(id);
    }

    @Override
    public PointEntity getPointByName(String name) {
        return pointRepository.getPointEntityByName(name);
    }

    @Override
    public List<PointEntity> getLeftPoints(List<Integer> ids) {
        return pointRepository.getPointEntitiesByIdNotIn(ids);
    }

    @Override
    public List<PointEntity> getAllPoints() {
        return (List<PointEntity>) pointRepository.findAll();
    }

    @Autowired
    public void setPointRepository(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }
}
