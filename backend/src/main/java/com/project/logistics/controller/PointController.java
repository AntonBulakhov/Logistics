package com.project.logistics.controller;

import com.project.logistics.entity.PointEntity;
import com.project.logistics.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/point")
public class PointController {
    private PointService pointService;

    @PostMapping()
    public void createPoint(@RequestBody PointEntity pointEntity) {
        pointService.createPoint(pointEntity);
    }

    @GetMapping("/id/{id}")
    public PointEntity getPointById(@PathVariable Integer id) {
        return pointService.getPointById(id);
    }

    @GetMapping("/name/{name}")
    public PointEntity getPointByName(@PathVariable String name) {
        return pointService.getPointByName(name);
    }

    @PostMapping("/left")
    public List<PointEntity> getLeftPoints(@RequestBody List<Integer> ids) {
        return pointService.getLeftPoints(ids);
    }

    @Autowired
    public void setPointService(PointService pointService) {
        this.pointService = pointService;
    }
}
