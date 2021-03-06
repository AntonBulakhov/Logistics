package com.project.logistics.repository;

import com.project.logistics.entity.PointEntity;
import com.project.logistics.entity.SegmentEntity;
import com.project.logistics.entity.TransportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SegmentRepository extends CrudRepository<SegmentEntity, Integer> {
    SegmentEntity getSegmentEntityByStartPointAndEndPointAndDistanceAndTransport(PointEntity startPoint,
                                                                                 PointEntity endPoint,
                                                                                 Double distance,
                                                                                 TransportEntity transport);
    List<SegmentEntity> getAllByIdIn(List<Integer> segmentIds);
}
