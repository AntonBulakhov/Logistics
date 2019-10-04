package com.project.logistics.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RouteHasSegmentEntityPK implements Serializable {
    private int routeId;
    private int segmentId;

    @Column(name = "route_id")
    @Id
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Column(name = "segment_id")
    @Id
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

        RouteHasSegmentEntityPK that = (RouteHasSegmentEntityPK) o;

        if (routeId != that.routeId) return false;
        if (segmentId != that.segmentId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = routeId;
        result = 31 * result + segmentId;
        return result;
    }
}
