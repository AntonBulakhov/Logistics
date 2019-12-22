package com.project.logistics.service;

import com.project.logistics.dto.NewTransport;
import com.project.logistics.entity.TransportEntity;
import com.project.logistics.entity.TransportTypeEntity;

import java.util.List;

public interface TransportService {
    List<TransportEntity> getAllTransports();

    List<TransportEntity> getAllTransportsByType(Integer id);

    List<TransportTypeEntity> getAllTypes();

    Boolean saveTransport(NewTransport transportEntity);
}
