package com.project.logistics.entity;

import javax.persistence.*;

@Entity
@Table(name = "route", schema = "logisticsdb")
public class RouteEntity {
    private int id;
    private PointEntity startPoint;
    private PointEntity endPoint;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteEntity that = (RouteEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
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
}
