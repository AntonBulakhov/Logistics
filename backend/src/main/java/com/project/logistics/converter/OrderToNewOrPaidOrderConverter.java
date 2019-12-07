package com.project.logistics.converter;

import com.project.logistics.dto.neworder.NewOrPaidOrder;
import com.project.logistics.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderToNewOrPaidOrderConverter implements Converter<OrderEntity, NewOrPaidOrder> {

    private UserToSafeUserConverter userConverter;

    public List<NewOrPaidOrder> convert(List<OrderEntity> list) {
        List<NewOrPaidOrder> newOrPaidOrders = new ArrayList<>();
        for(OrderEntity entity : list) {
            newOrPaidOrders.add(convert(entity));
        }
        return newOrPaidOrders;
    }

    @Override
    public NewOrPaidOrder convert(OrderEntity orderEntity) {
        NewOrPaidOrder newOrPaidOrder = new NewOrPaidOrder();
        newOrPaidOrder.setId(orderEntity.getId());
        newOrPaidOrder.setCost(orderEntity.getCost());
        newOrPaidOrder.setDeliveryDate(orderEntity.getDeliveryDate());
        newOrPaidOrder.setOrderStatus(orderEntity.getOrderStatus());
        newOrPaidOrder.setRoute(orderEntity.getRoute());
        newOrPaidOrder.setValue(orderEntity.getValue());
        newOrPaidOrder.setWeight(orderEntity.getWeight());
        newOrPaidOrder.setUser(userConverter.convert(orderEntity.getUser()));
        return newOrPaidOrder;
    }

    @Autowired
    public void setUserConverter(UserToSafeUserConverter userConverter) {
        this.userConverter = userConverter;
    }
}
