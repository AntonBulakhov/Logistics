package com.project.logistics.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transport", schema = "logisticsdb", catalog = "")
public class TransportEntity {
    private int id;
    private String name;
    private double speed;
    private double maxValue;
    private double maxWeight;
    private double coefficient;
    private double costPerHour;
    private TransportTypeEntity transportType;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "speed")
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Basic
    @Column(name = "max_value")
    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    @Basic
    @Column(name = "max_weight")
    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Basic
    @Column(name = "coefficient")
    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    @Basic
    @Column(name = "cost_per_hour")
    public double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransportEntity that = (TransportEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.speed, speed) != 0) return false;
        if (Double.compare(that.maxValue, maxValue) != 0) return false;
        if (Double.compare(that.maxWeight, maxWeight) != 0) return false;
        if (Double.compare(that.coefficient, coefficient) != 0) return false;
        if (Double.compare(that.costPerHour, costPerHour) != 0) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(speed);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maxValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maxWeight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(coefficient);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(costPerHour);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "transport_type_id", referencedColumnName = "id", nullable = false)
    public TransportTypeEntity getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportTypeEntity transportType) {
        this.transportType = transportType;
    }
}
