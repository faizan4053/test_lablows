package com.loblaws.orderservice.service;


import com.loblaws.orderservice.constants.OrderStatus;
import com.loblaws.orderservice.entity.OrderDetails;
import com.loblaws.orderservice.repository.OrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Order Service Class
 */
@Service
@Slf4j
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    /**
     * @implNote method to save order
     * @param order
     * @return OrderDetails
     */
    public OrderDetails saveOrder(OrderDetails order){
//        log.info("Order is saved successfully");
        return ordersRepository.save(order);
    }

    /**
     * @implNote Method to fetch order by order id
     * @param orderId
     * @return OrderDetails
     */
    public OrderDetails getOrder(Long orderId){
//        log.info("Inside getOrder function in OrderService");
        return ordersRepository.findByOrderId(orderId);
    }

    /**
     * @implNote Method to fetch orders by user id
     * @param userId
     * @return  List<OrderDetails>
     */
    public List<OrderDetails> getOrdersByUserId(Long userId){
//        log.info("Inside getOrdersByUserId() in OrderService");
        return ordersRepository.findByUserId(userId);
    }

    /**
     * @implNote Method to fetch Pending orders to be picked by pickers
     * @param orderStatus
     * @return List<OrderDetails>
     */
    public List<OrderDetails> getPendingOrders(OrderStatus orderStatus){
//        log.info("Inside getPendingOrders() in OrderService for pending orders");
        return ordersRepository.findPendingOrders(orderStatus);
    }

}

