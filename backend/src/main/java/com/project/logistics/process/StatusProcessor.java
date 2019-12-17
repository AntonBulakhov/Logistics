package com.project.logistics.process;

import com.project.logistics.entity.OrderEntity;
import com.project.logistics.repository.OrderRepository;
import com.project.logistics.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

import static com.project.logistics.constants.InitialAdminConstants.DELIVERED_ORDER_STATUS;

@Component
public class StatusProcessor {

    private OrderRepository orderRepository;
    private OrderStatusRepository orderStatusRepository;

    @Scheduled(cron = "0 0 * * * ?")
    public void changeStatus() {
        List<OrderEntity> orders = (List<OrderEntity>) orderRepository.findAll();
        long millis = System.currentTimeMillis();

        for (OrderEntity order : orders) {
            Date date = new Date(millis);
            if(order.getDeliveryDate().equals(date)) {
                order.setOrderStatus(orderStatusRepository.findById(DELIVERED_ORDER_STATUS).get());
                orderRepository.save(order);
            }
        }
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setOrderStatusRepository(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }
}
