package com.project.logistics.controller;

import com.project.logistics.dto.NewTransport;
import com.project.logistics.entity.TransportEntity;
import com.project.logistics.entity.TransportTypeEntity;
import com.project.logistics.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transport")
public class TransportController {

    private TransportService transportService;

    @GetMapping("/all")
    public List<TransportEntity> getAllTransports() {
        return transportService.getAllTransports();
    }

    @GetMapping("/all/type/{id}")
    public List<TransportEntity> getAllTransportsByType(@PathVariable Integer id) {
        return transportService.getAllTransportsByType(id);
    }

    @GetMapping("/types")
    public List<TransportTypeEntity> getAllTypes() {
        return transportService.getAllTypes();
    }

    @PostMapping()
    public Boolean saveTransport(@RequestBody NewTransport transportEntity) {
        return transportService.saveTransport(transportEntity);
    }

    @Autowired
    public void setTransportService(TransportService transportService) {
        this.transportService = transportService;
    }
}
