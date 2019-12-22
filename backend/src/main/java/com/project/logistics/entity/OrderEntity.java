package com.project.logistics.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "`order`", schema = "logisticsdb", catalog = "")
public class OrderEntity {
    private int id;
    private double weight;
    private double value;
    private double cost;
    private Date deliveryDate;
    private OrderTypeEntity orderType;
    private RouteEntity route;
    private UserEntity user;
    private OrderStatusEntity orderStatus;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "weight")
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "value")
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Basic
    @Column(name = "cost")
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "delivery_date")
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity entity = (OrderEntity) o;

        if (id != entity.id) return false;
        if (Double.compare(entity.weight, weight) != 0) return false;
        if (Double.compare(entity.value, value) != 0) return false;
        if (Double.compare(entity.cost, cost) != 0) return false;
        if (deliveryDate != null ? !deliveryDate.equals(entity.deliveryDate) : entity.deliveryDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "order_type_id", referencedColumnName = "id", nullable = false)
    public OrderTypeEntity getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderTypeEntity orderType) {
        this.orderType = orderType;
    }

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "id", nullable = false)
    public RouteEntity getRoute() {
        return route;
    }

    public void setRoute(RouteEntity route) {
        this.route = route;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "order_status_id", referencedColumnName = "id", nullable = false)
    public OrderStatusEntity getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEntity orderStatus) {
        this.orderStatus = orderStatus;
    }
}
