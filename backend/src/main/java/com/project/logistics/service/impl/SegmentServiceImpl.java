package com.project.logistics.service.impl;

import com.project.logistics.entity.SegmentEntity;
import com.project.logistics.entity.TransportEntity;
import com.project.logistics.repository.SegmentRepository;
import com.project.logistics.service.SegmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public boolean ifSegmentExists(SegmentEntity entity) {
        SegmentEntity existing =
                repository.getSegmentEntityByStartPointAndEndPointAndDistanceAndTransport(entity.getStartPoint(),
                        entity.getEndPoint(), entity.getDistance(), entity.getTransport());
        return existing != null;
    }

    @Override
    public List<SegmentEntity> getAllSegments() {
        return (List<SegmentEntity>) repository.findAll();
    }

    @Autowired
    public void setRepository(SegmentRepository repository) {
        this.repository = repository;
    }
}
