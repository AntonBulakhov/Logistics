package com.project.logistics.repository;

import com.project.logistics.entity.TransportEntity;
import com.project.logistics.entity.TransportTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportRepository extends CrudRepository<TransportEntity, Integer> {
    List<TransportEntity> getAllByTransportType(TransportTypeEntity type);
    TransportEntity findByName(String name);
}
