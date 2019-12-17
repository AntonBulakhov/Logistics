package com.project.logistics.dto;

import com.project.logistics.dto.neworder.NewOrPaidOrder;

import java.util.List;

public class DeliveryDto {
    private List<NewOrPaidOrder> order;
    private Integer routeId;

    public List<NewOrPaidOrder> getOrder() {
        return order;
    }

    public void setOrder(List<NewOrPaidOrder> order) {
        this.order = order;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }
}
