package com.project.logistics.service.impl;

import com.project.logistics.converter.OrderToNewOrPaidOrderConverter;
import com.project.logistics.dto.Backpack;
import com.project.logistics.dto.DeliveryDto;
import com.project.logistics.dto.neworder.NewOrPaidOrder;
import com.project.logistics.entity.OrderEntity;
import com.project.logistics.entity.OrderStatusEntity;
import com.project.logistics.entity.RouteEntity;
import com.project.logistics.entity.RouteHasSegmentEntity;
import com.project.logistics.entity.SegmentEntity;
import com.project.logistics.entity.TransportEntity;
import com.project.logistics.entity.UserEntity;
import com.project.logistics.repository.OrderRepository;
import com.project.logistics.repository.OrderStatusRepository;
import com.project.logistics.repository.RouteHasSegmentRepository;
import com.project.logistics.repository.RouteRepository;
import com.project.logistics.repository.SegmentRepository;
import com.project.logistics.repository.UserRepository;
import com.project.logistics.service.OrderService;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private OrderStatusRepository orderStatusRepository;
    private RouteRepository routeRepository;
    private RouteHasSegmentRepository routeHasSegmentRepository;
    private SegmentRepository segmentRepository;

    private OrderToNewOrPaidOrderConverter toNewOrPaidOrderConverter;

    private static final String NEW_ORDER = "new";
    private static final String PAID_ORDER = "paid";

    private static final Integer PAID_ORDER_STATUS_ID = 7;
    private static final Integer ACCEPTED_ORDER_STATUS_ID = 2;

    @Override
    public boolean saveNewOrder(OrderEntity newOrder) {
        Optional<UserEntity> userEntity = userRepository.findById(newOrder.getUser().getId());
        newOrder.setUser(userEntity.get());
        return orderRepository.save(newOrder) != null;
    }

    @Override
    public List<NewOrPaidOrder> getNewOrPaidOrders() {
        List<OrderStatusEntity> statuses = orderStatusRepository.getAllByNameIn(Arrays.asList(NEW_ORDER, PAID_ORDER));
        List<OrderEntity> entities = orderRepository.getAllByOrderStatusIn(statuses);
        return toNewOrPaidOrderConverter.convert(entities);
    }

    @Override
    public List<OrderEntity> getOrdersByUserId(Integer id) {
        UserEntity userEntity = userRepository.findById(id).get();
        List<OrderEntity> orders = orderRepository.getAllByUser(userEntity);
        for (OrderEntity order : orders) {
            order.getUser().setLogin("");
            order.getUser().setPassword("");
        }
        return orders;
    }

    @Override
    public List<DeliveryDto> getOrdersByRoute(OrderEntity route) {
        List<RouteEntity> routes = routeRepository.getAllByStartPointAndEndPoint(
                route.getRoute().getStartPoint(), route.getRoute().getEndPoint());
        if (CollectionUtils.isEmpty(routes)) {
            return null;
        }
        OrderStatusEntity status = orderStatusRepository.findById(ACCEPTED_ORDER_STATUS_ID).get();
        List<OrderEntity> orders = orderRepository.getAllByRouteInAndOrderStatusAndDeliveryDateLessThan(
                routes, status, route.getDeliveryDate());

        List<DeliveryDto> deliveryDtos = new ArrayList<>();
        List<NewOrPaidOrder> newOrPaidOrders = toNewOrPaidOrderConverter.convert(orders);
        MultiValuedMap<Integer, NewOrPaidOrder> map = getGroupedOrders(newOrPaidOrders);

        for (Integer key : map.keySet()) {
            double minimalWeight = getMinimalWeight(map.get(key));
            Backpack backpack = new Backpack(minimalWeight);
            backpack.makeAllSets((List<NewOrPaidOrder>) map.get(key));

            DeliveryDto deliveryDto = new DeliveryDto();
            deliveryDto.setOrder(backpack.getBestItems());
            deliveryDto.setRouteId(key);

            deliveryDtos.add(deliveryDto);
        }
        return deliveryDtos;
    }

    private double getMinimalWeight(Collection<NewOrPaidOrder> newOrPaidOrders) {
        SortedSet<Double> sortedSet = new TreeSet<>();
        for (NewOrPaidOrder order : newOrPaidOrders) {
            List<RouteHasSegmentEntity> routeHasSegmentEntities = routeHasSegmentRepository.getAllByRouteId(
                    order.getRoute().getId());
            List<Integer> segmentIds = new ArrayList<>();
            for (RouteHasSegmentEntity routeHasSegmentEntity : routeHasSegmentEntities) {
                segmentIds.add(routeHasSegmentEntity.getSegmentId());
            }

            List<SegmentEntity> segmentEntities = segmentRepository.getAllByIdIn(segmentIds);
            for (SegmentEntity segmentEntity : segmentEntities) {
                TransportEntity transportEntity = segmentEntity.getTransport();
                sortedSet.add(transportEntity.getMaxWeight());
            }
        }

        return sortedSet.first();
    }

    private MultiValuedMap<Integer, NewOrPaidOrder> getGroupedOrders(List<NewOrPaidOrder> newOrPaidOrders) {
        MultiValuedMap<Integer, NewOrPaidOrder> map = new ArrayListValuedHashMap<>();
        for (NewOrPaidOrder order : newOrPaidOrders) {
            map.put(order.getRoute().getId(), order);
        }
        return map;
    }

    @Override
    public Boolean setOrderStatus(OrderEntity order) {
        OrderEntity entity = orderRepository.findById(order.getId()).get();
        entity.setOrderStatus(order.getOrderStatus());
        entity = orderRepository.save(entity);
        return entity.getOrderStatus().getId() == order.getOrderStatus().getId();
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setOrderStatusRepository(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    @Autowired
    public void setRouteRepository(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Autowired
    public void setRouteHasSegmentRepository(RouteHasSegmentRepository routeHasSegmentRepository) {
        this.routeHasSegmentRepository = routeHasSegmentRepository;
    }

    @Autowired
    public void setSegmentRepository(SegmentRepository segmentRepository) {
        this.segmentRepository = segmentRepository;
    }

    @Autowired
    public void setToNewOrPaidOrderConverter(OrderToNewOrPaidOrderConverter toNewOrPaidOrderConverter) {
        this.toNewOrPaidOrderConverter = toNewOrPaidOrderConverter;
    }
}
