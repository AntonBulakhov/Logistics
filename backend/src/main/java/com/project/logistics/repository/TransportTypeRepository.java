package com.project.logistics.repository;

import com.project.logistics.entity.TransportTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportTypeRepository extends CrudRepository<TransportTypeEntity, Integer> {
}
