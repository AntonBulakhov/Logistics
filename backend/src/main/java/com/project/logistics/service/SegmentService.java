package com.project.logistics.service;

import com.project.logistics.entity.SegmentEntity;

import java.util.List;

public interface SegmentService {
    SegmentEntity createSegment(SegmentEntity entity);
    boolean ifSegmentExists(SegmentEntity entity);
    List<SegmentEntity> getAllSegments();
    List<SegmentEntity> getAllSegmentsByRouteId(Integer routeId);
}
