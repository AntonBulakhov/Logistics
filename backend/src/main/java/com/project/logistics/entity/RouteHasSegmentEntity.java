package com.project.logistics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "route_has_segment", schema = "logisticsdb", catalog = "")
@IdClass(RouteHasSegmentEntityPK.class)
public class RouteHasSegmentEntity {
    private int routeId;
    private int segmentId;

    @Id
    @Column(name = "route_id")
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Id
    @Column(name = "segment_id")
    public int getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(int segmentId) {
        this.segmentId = segmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteHasSegmentEntity entity = (RouteHasSegmentEntity) o;

        if (routeId != entity.routeId) return false;
        if (segmentId != entity.segmentId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = routeId;
        result = 31 * result + segmentId;
        return result;
    }
}
