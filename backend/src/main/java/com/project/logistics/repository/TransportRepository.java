package com.project.logistics.repository;

import com.project.logistics.entity.TransportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends CrudRepository<TransportEntity, Integer> {
}
