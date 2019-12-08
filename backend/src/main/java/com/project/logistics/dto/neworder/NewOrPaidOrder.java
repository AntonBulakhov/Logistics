package com.project.logistics.dto.neworder;

import com.project.logistics.dto.SafeUser;
import com.project.logistics.entity.OrderStatusEntity;
import com.project.logistics.entity.RouteEntity;

import java.sql.Date;

public class NewOrPaidOrder {
    private int id;
    private double weight;
    private double value;
    private double cost;
    private Date deliveryDate;
    private RouteEntity route;
    private SafeUser user;
    private OrderStatusEntity orderStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public RouteEntity getRoute() {
        return route;
    }

    public void setRoute(RouteEntity route) {
        this.route = route;
    }

    public SafeUser getUser() {
        return user;
    }

    public void setUser(SafeUser user) {
        this.user = user;
    }

    public OrderStatusEntity getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEntity orderStatus) {
        this.orderStatus = orderStatus;
    }
}
