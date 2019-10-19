package com.project.logistics.service.impl;

import com.project.logistics.entity.SegmentEntity;
import com.project.logistics.entity.TransportEntity;
import com.project.logistics.repository.SegmentRepository;
import com.project.logistics.service.SegmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SegmentServiceImpl implements SegmentService {

    private SegmentRepository repository;

    @Override
    public SegmentEntity createSegment(SegmentEntity entity) {
        if (entity.getStartPoint() == null || entity.getEndPoint() == null ||
                entity.getTransport() == null) {
            return null;
        }
        if (!entity.getStartPoint().equals(entity.getEndPoint())) {
            TransportEntity transportEntity = entity.getTransport();
            double cost = (entity.getDistance() / transportEntity.getSpeed())
                    * transportEntity.getCostPerHour();
            entity.setCost(cost);
            return repository.save(entity);
        } else {
            return null;
        }
    }

    @Autowired
    public void setRepository(SegmentRepository repository) {
        this.repository = repository;
    }
}
