package com.project.logistics.controller;

import com.project.logistics.entity.SegmentEntity;
import com.project.logistics.service.SegmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/segment")
public class SegmentController {

    private SegmentService segmentService;

    @PostMapping
    public Boolean createSegment(@RequestBody SegmentEntity entity) {
        SegmentEntity createdSegment = segmentService.createSegment(entity);
        return createdSegment != null;
    }

    @PostMapping("/exist")
    public Boolean ifSegmentExists(@RequestBody SegmentEntity entity) {
        return segmentService.ifSegmentExists(entity);
    }

    @GetMapping("/all")
    public List<SegmentEntity> getAllSegments() {
        return segmentService.getAllSegments();
    }

    @Autowired
    public void setSegmentService(SegmentService segmentService) {
        this.segmentService = segmentService;
    }
}
