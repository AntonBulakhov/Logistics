package com.project.logistics.controller;

import com.project.logistics.entity.PointEntity;
import com.project.logistics.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/point")
public class PointController {
    private PointService pointService;

    @PostMapping
    public ResponseEntity<Boolean> createPoint(@RequestBody PointEntity pointEntity) {
        Boolean created = pointService.createPoint(pointEntity) != null;
        return ResponseEntity.ok(created);
    }

    @GetMapping("/id/{id}")
    public PointEntity getPointById(@PathVariable Integer id) {
        return pointService.getPointById(id);
    }

    @GetMapping("/all")
    public List<PointEntity> getAllPoints() {
        return pointService.getAllPoints();
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
