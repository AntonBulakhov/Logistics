package com.project.logistics.dto;

import com.project.logistics.entity.RouteEntity;
import com.project.logistics.entity.SegmentEntity;

import java.util.List;

public class AlternativeRoute {
    private RouteEntity route;
    private List<SegmentEntity> segments;
    private float price;
    private int deliveryTime;

    public RouteEntity getRoute() {
        return route;
    }

    public void setRoute(RouteEntity route) {
        this.route = route;
    }

    public List<SegmentEntity> getSegments() {
        return segments;
    }

    public void setSegments(List<SegmentEntity> segments) {
        this.segments = segments;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
