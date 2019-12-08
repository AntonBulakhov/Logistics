package com.project.logistics.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "segment", schema = "logisticsdb", catalog = "")
public class SegmentEntity {
    private int id;
    private double distance;
    private double cost;
    private PointEntity startPoint;
    private PointEntity endPoint;
    private TransportEntity transport;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "distance")
    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Basic
    @Column(name = "cost")
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SegmentEntity that = (SegmentEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.distance, distance) != 0) return false;
        if (Double.compare(that.cost, cost) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(distance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "start_point_id", referencedColumnName = "id", nullable = false)
    public PointEntity getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(PointEntity startPoint) {
        this.startPoint = startPoint;
    }

    @ManyToOne
    @JoinColumn(name = "end_point_id", referencedColumnName = "id", nullable = false)
    public PointEntity getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(PointEntity endPoint) {
        this.endPoint = endPoint;
    }

    @ManyToOne
    @JoinColumn(name = "transport_id", referencedColumnName = "id", nullable = false)
    public TransportEntity getTransport() {
        return transport;
    }

    public void setTransport(TransportEntity transport) {
        this.transport = transport;
    }
}
