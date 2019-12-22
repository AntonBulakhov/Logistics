package com.project.logistics.service.impl;

import com.project.logistics.entity.RouteHasSegmentEntity;
import com.project.logistics.entity.SegmentEntity;
import com.project.logistics.entity.TransportEntity;
import com.project.logistics.repository.RouteHasSegmentRepository;
import com.project.logistics.repository.SegmentRepository;
import com.project.logistics.service.SegmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SegmentServiceImpl implements SegmentService {

    private SegmentRepository segmentRepository;
    private RouteHasSegmentRepository routeHasSegmentRepository;

    @Override
    public SegmentEntity createSegment(SegmentEntity entity) {
        if (entity.getStartPoint() == null || entity.getEndPoint() == null ||
                entity.getTransport() == null) {
            return null;
        }
        if (!entity.getStartPoint().equals(entity.getEndPoint())) {
            return segmentRepository.save(entity);
        } else {
            return null;
        }
    }

    @Override
    public boolean ifSegmentExists(SegmentEntity entity) {
        SegmentEntity existing =
                segmentRepository.getSegmentEntityByStartPointAndEndPointAndDistanceAndTransport(entity.getStartPoint(),
                        entity.getEndPoint(), entity.getDistance(), entity.getTransport());
        return existing != null;
    }

    @Override
    public List<SegmentEntity> getAllSegmentsByRouteId(Integer routeId) {
        List<RouteHasSegmentEntity> routeHasSegmentEntities = routeHasSegmentRepository.getAllByRouteId(routeId);
        List<Integer> segmentIds = new ArrayList<>();
        for (RouteHasSegmentEntity routeHasSegmentEntity : routeHasSegmentEntities) {
            segmentIds.add(routeHasSegmentEntity.getSegmentId());
        }
        return segmentRepository.getAllByIdIn(segmentIds);
    }

    @Override
    public List<SegmentEntity> getAllSegments() {
        return (List<SegmentEntity>) segmentRepository.findAll();
    }

    @Autowired
    public void setSegmentRepository(SegmentRepository segmentRepository) {
        this.segmentRepository = segmentRepository;
    }

    @Autowired
    public void setRouteHasSegmentRepository(RouteHasSegmentRepository routeHasSegmentRepository) {
        this.routeHasSegmentRepository = routeHasSegmentRepository;
    }
}
