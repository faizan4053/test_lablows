package com.loblaws.orderservice.controller;

import com.loblaws.orderservice.constants.OrderStatus;
import com.loblaws.orderservice.entity.OrderDetails;
import com.loblaws.orderservice.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController for order service
 */
@RestController
@RequestMapping("orders/api/v1")
@Slf4j
public class OrdersController {

    @Autowired
    private OrdersService orderService;

    /**
     * @apiNote Rest Api to save order
     * @param order
     * @return ResponseEntity<OrderDetails>
     */
    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDetails> saveOrder(@RequestBody OrderDetails order){
        OrderDetails savedOrder=orderService.saveOrder(order);
        System.out.println(savedOrder);
        return ResponseEntity.ok().body(orderService.saveOrder(savedOrder));
    }

    /**
     * @apiNote Rest Api to get order using order id
     * @param orderId
     * @return ResponseEntity<OrderDetails>
     */
    @GetMapping("/getOrder/{id}")
    public ResponseEntity<OrderDetails> getOrder(@PathVariable("id") Long orderId){
        OrderDetails order=orderService.getOrder(orderId);
        System.out.println(order);
        if(order==null){
//            log.error("Order is not available");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
//        log.info("Order is found for order id "+orderId);
        return ResponseEntity.ok().body(order);
    }

    /**
     * @apiNote Rest Api to get orders using user id
     * @param userId
     * @return List<OrderDetails>
     */

    @GetMapping("/getOrdersByUserId/{id}")
    public ResponseEntity<List> getOrdersByUserId(@PathVariable("id") Long userId){
        List<OrderDetails> ordersList=orderService.getOrdersByUserId(userId);
        System.out.println(ordersList.isEmpty());
        if(ordersList.isEmpty()){
//            log.error("Orders not available for user "+userId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
//        log.info("Orders are available for user "+userId);
        return ResponseEntity.ok().body(ordersList);
    }

    @GetMapping("/getPendingOrders")
//            "{status}")@PathVariable("status")
    public ResponseEntity<List> getPendingOrders(@RequestParam OrderStatus orderStatus){
        System.out.println(orderStatus.getClass()+":"+OrderStatus.PENDING.getClass());
//        List<OrderDetails> ordersList=orderService.getPendingOrders(OrderStatus.PENDING);
//        System.out.println(ordersList.isEmpty());
//        if(ordersList.isEmpty()){
//            log.info("No Orders are Pending");
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//        log.info(ordersList.size()+" orders are pending");
        return ResponseEntity.ok().body(null);
    }


}