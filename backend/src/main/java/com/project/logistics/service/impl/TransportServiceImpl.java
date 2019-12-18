package com.project.logistics.service.impl;

import com.project.logistics.entity.TransportEntity;
import com.project.logistics.entity.TransportTypeEntity;
import com.project.logistics.repository.TransportRepository;
import com.project.logistics.repository.TransportTypeRepository;
import com.project.logistics.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportServiceImpl implements TransportService {

    private TransportRepository repository;
    private TransportTypeRepository transportTypeRepository;

    @Override
    public List<TransportEntity> getAllTransports() {
        return (List<TransportEntity>) repository.findAll();
    }

    @Override
    public List<TransportEntity> getAllTransportsByType(Integer id) {
        TransportTypeEntity type = transportTypeRepository.findById(id).get();
        return repository.getAllByTransportType(type);
    }

    @Override
    public List<TransportTypeEntity> getAllTypes() {
        return (List<TransportTypeEntity>) transportTypeRepository.findAll();
    }

    @Override
    public Boolean saveTransport(TransportEntity transportEntity) {
        TransportEntity transport = repository.findByName(transportEntity.getName());
        if (transport != null) {
            return false;
        }
        return repository.save(transportEntity) != null;
    }

    @Autowired
    public void setRepository(TransportRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setTransportTypeRepository(TransportTypeRepository transportTypeRepository) {
        this.transportTypeRepository = transportTypeRepository;
    }
}
