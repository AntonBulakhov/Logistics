package com.project.logistics.service.impl;

import com.project.logistics.entity.TransportEntity;
import com.project.logistics.repository.TransportRepository;
import com.project.logistics.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportServiceImpl implements TransportService {

    private TransportRepository repository;

    @Override
    public List<TransportEntity> getAllTransports() {
        return (List<TransportEntity>) repository.findAll();
    }

    @Autowired
    public void setRepository(TransportRepository repository) {
        this.repository = repository;
    }
}
