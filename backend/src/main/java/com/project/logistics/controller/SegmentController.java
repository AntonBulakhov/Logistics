package com.project.logistics.controller;

import com.project.logistics.entity.SegmentEntity;
import com.project.logistics.service.SegmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/segment")
public class SegmentController {

    private SegmentService segmentService;

    @PostMapping
    public Boolean createSegment(@RequestBody SegmentEntity entity) {
        SegmentEntity createdSegment = segmentService.createSegment(entity);
        return createdSegment != null;
    }

    @Autowired
    public void setSegmentService(SegmentService segmentService) {
        this.segmentService = segmentService;
    }
}
