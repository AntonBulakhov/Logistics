package com.project.logistics.dto;

import com.project.logistics.entity.OrderEntity;
import com.project.logistics.entity.PointEntity;

public class NewOrder {
    private OrderEntity newOrder;
    private PointEntity startPoint;
    private PointEntity endPoint;

    public OrderEntity getNewOrder() {
        return newOrder;
    }

    public void setNewOrder(OrderEntity newOrder) {
        this.newOrder = newOrder;
    }

    public PointEntity getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(PointEntity startPoint) {
        this.startPoint = startPoint;
    }

    public PointEntity getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(PointEntity endPoint) {
        this.endPoint = endPoint;
    }
}
