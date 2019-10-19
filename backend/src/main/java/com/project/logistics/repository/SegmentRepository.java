package com.project.logistics.repository;

import com.project.logistics.entity.SegmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SegmentRepository extends CrudRepository<SegmentEntity, Integer> {

}
