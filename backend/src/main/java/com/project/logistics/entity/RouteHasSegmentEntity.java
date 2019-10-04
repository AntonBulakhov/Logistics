package com.project.logistics.entity;

import javax.persistence.*;

@Entity
@Table(name = "route_has_segment", schema = "logisticsdb")
@IdClass(RouteHasSegmentEntityPK.class)
public class RouteHasSegmentEntity {
    private int routeId;
    private int segmentId;
    private RouteEntity route;
    private SegmentEntity segment;

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

        RouteHasSegmentEntity that = (RouteHasSegmentEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "id", nullable = false)
    public RouteEntity getRoute() {
        return route;
    }

    public void setRoute(RouteEntity route) {
        this.route = route;
    }

    @ManyToOne
    @JoinColumn(name = "segment_id", referencedColumnName = "id", nullable = false)
    public SegmentEntity getSegment() {
        return segment;
    }

    public void setSegment(SegmentEntity segment) {
        this.segment = segment;
    }
}
