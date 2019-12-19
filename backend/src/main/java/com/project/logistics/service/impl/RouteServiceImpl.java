package com.project.logistics.service.impl;

import com.project.logistics.dto.AlternativeRoute;
import com.project.logistics.dto.NewOrder;
import com.project.logistics.dto.NewRouteDto;
import com.project.logistics.entity.RouteEntity;
import com.project.logistics.entity.RouteHasSegmentEntity;
import com.project.logistics.entity.SegmentEntity;
import com.project.logistics.entity.TransportEntity;
import com.project.logistics.repository.RouteHasSegmentRepository;
import com.project.logistics.repository.RouteRepository;
import com.project.logistics.service.RouteService;
import com.project.logistics.service.SegmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static com.project.logistics.constants.TransportConstants.CAR_TYPE_ID;

@Service
public class RouteServiceImpl implements RouteService {

    private final double MINIMAL_PRICE = 20.0;

    private RouteRepository routeRepository;
    private RouteHasSegmentRepository relationsRepository;

    private SegmentService segmentService;

    @Override
    public boolean createRoute(NewRouteDto routeDto) {
        RouteEntity createdRoute = routeRepository.save(routeDto.getRoute());
        if (createdRoute == null) {
            return false;
        }

        List<RouteHasSegmentEntity> routeHasSegmentEntityList = new ArrayList<>();
        for (SegmentEntity entity : routeDto.getRelations()) {
            RouteHasSegmentEntity hasSegmentEntity = new RouteHasSegmentEntity();
            hasSegmentEntity.setRouteId(createdRoute.getId());
            hasSegmentEntity.setSegmentId(entity.getId());
            routeHasSegmentEntityList.add(hasSegmentEntity);
        }
        return relationsRepository.saveAll(routeHasSegmentEntityList) != null;
    }

    @Override
    public List<AlternativeRoute> getAlternativeRoutes(NewOrder newOrder) {
        List<RouteEntity> routes = routeRepository.getAllByStartPointAndEndPoint(
                newOrder.getStartPoint(), newOrder.getEndPoint());
        return getAllAlternativeRoutes(routes, newOrder);
    }

    private List<AlternativeRoute> getAllAlternativeRoutes(List<RouteEntity> routes, NewOrder newOrder) {
        List<AlternativeRoute> alternativeRoutes = new ArrayList<>();
        for (RouteEntity route : routes) {
            List<SegmentEntity> segments = segmentService.getAllSegmentsByRouteId(route.getId());
            float price = 0;
            int time = 0;
            if (!orderSuitsTransport(segments, newOrder)) {
                continue;
            }
            for (SegmentEntity segment : segments) {
                TransportEntity transport = segment.getTransport();
                time += processDeliveryTime(segment);
                price += processPriceConfiguration(transport, segment, newOrder);
            }

            AlternativeRoute alternativeRoute = new AlternativeRoute();
            alternativeRoute.setRoute(route);
            alternativeRoute.setSegments(segments);

            BigDecimal priceBig = BigDecimal.valueOf(price).setScale(2, RoundingMode.CEILING);
            alternativeRoute.setPrice(priceBig.floatValue());

            alternativeRoute.setDeliveryTime(time);

            alternativeRoutes.add(alternativeRoute);
        }
        return alternativeRoutes;
    }

    private boolean orderSuitsTransport(List<SegmentEntity> segments, NewOrder order) {
        for (SegmentEntity segment : segments) {
            TransportEntity transport = segment.getTransport();
            if (order.getNewOrder().getWeight() > transport.getMaxWeight()) {
                return false;
            }
        }
        return true;
    }

    private int processDeliveryTime(SegmentEntity segmentEntity) {
        TransportEntity transportEntity = segmentEntity.getTransport();
        double time = 0;
        BigDecimal deliveryDays;
        if (transportEntity.getTransportType().getId() == CAR_TYPE_ID) {
            time += segmentEntity.getDistance() / transportEntity.getSpeed();
            deliveryDays = BigDecimal.valueOf(time % 8).setScale(0, RoundingMode.HALF_UP);
        } else {
            time += segmentEntity.getDistance() / transportEntity.getSpeed();
            deliveryDays = BigDecimal.valueOf(time / 24).setScale(0, RoundingMode.HALF_UP);
        }

        return deliveryDays.intValue() + 1;
    }

    protected float processPriceConfiguration(TransportEntity transportEntity, SegmentEntity segmentEntity, NewOrder order) {

        double time = segmentEntity.getDistance() / segmentEntity.getTransport().getSpeed();

        double price = transportEntity.getCostPerHour() * time;

        return price < MINIMAL_PRICE ? (float) MINIMAL_PRICE : (float) price;
    }

    @Autowired
    public void setRouteRepository(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Autowired
    public void setRelationsRepository(RouteHasSegmentRepository relationsRepository) {
        this.relationsRepository = relationsRepository;
    }

    @Autowired
    public void setSegmentService(SegmentService segmentService) {
        this.segmentService = segmentService;
    }
}
