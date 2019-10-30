package com.project.logistics.dto;

import com.project.logistics.entity.RouteEntity;
import com.project.logistics.entity.SegmentEntity;

import java.util.List;

public class NewRouteDto {
    private RouteEntity route;
    private List<SegmentEntity> relations;

    public RouteEntity getRoute() {
        return route;
    }

    public void setRoute(RouteEntity route) {
        this.route = route;
    }

    public List<SegmentEntity> getRelations() {
        return relations;
    }

    public void setRelations(List<SegmentEntity> relations) {
        this.relations = relations;
    }
}
