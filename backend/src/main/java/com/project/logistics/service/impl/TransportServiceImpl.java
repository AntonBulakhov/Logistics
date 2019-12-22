package com.project.logistics.service.impl;

import com.project.logistics.dto.NewTransport;
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

    private static final double COEFFICIENT = 1.5;

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
    public Boolean saveTransport(NewTransport transportEntity) {
        TransportEntity transport = repository.findByName(transportEntity.getTransport().getName());
        if (transport != null) {
            return false;
        }
        transport = transportEntity.getTransport();

        double cost = transportEntity.getOil() + transportEntity.getFuel() + transportEntity.getRepair()
                + transportEntity.getTech() + transportEntity.getTires();

        transport.setCostPerHour(cost * COEFFICIENT);

        return repository.save(transport) != null;
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
