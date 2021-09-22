//package com.loblaws.orderservice.controller;
//
//import com.loblaws.orderservice.constants.OrderStatus;
//import com.loblaws.orderservice.entity.OrderDetails;
//import com.loblaws.orderservice.service.OrdersService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class OrderControllerTest {
//
//    @InjectMocks
//    private OrdersController ordersController;
//
//    @Mock
//    private OrdersService ordersService;
//
//    private OrderDetails order;
//
//    @BeforeEach
//    void setUp(){
//
//        /**
//         * Given Order
//         */
//        order=new OrderDetails();
//        order.setOrderId(1L);
//        order.setUserId(2L);
//        order.setProductId(3L);
//        order.setProductQty(2);
//        order.setEmailId("abc@gmail.com");
//        order.setOrderStatus(OrderStatus.FULFILLED);
//    }
//
//    @Test
//    void testSaveOrder(){
//        /**
//         * Given order
//         */
//        Long orderId=1L;
//
//        /**
//         * When
//         */
//        when(ordersService.saveOrder(order)).thenReturn(order);
//        ResponseEntity<OrderDetails> response = ResponseEntity.status(HttpStatus.OK).body(order);
//        /**
//         * Then
//         */
//        Assertions.assertEquals(ordersController.saveOrder(order),response);
//    }
//
//    @Test
//    void testGetOrderWhenOrderIdIsAvailable(){
//        /**
//         * Given
//         */
//        Long orderId=1L;
//
//        /**
//         * When
//         */
//        when(ordersService.getOrder(orderId)).thenReturn(order);
//        ResponseEntity<OrderDetails> response = ResponseEntity.status(HttpStatus.OK).body(order);
//        /**
//         * Then
//         */
//        Assertions.assertEquals(ordersController.getOrder(orderId),response);
//    }
//
//    @Test
//    void testGetOrderWhenOrderIdIsNotAvailable(){
//        /**
//         * Given
//         */
//        Long orderId=1L;
//
//        /**
//         * When
//         */
//        when(ordersService.getOrder(orderId)).thenReturn(null);
//        ResponseEntity<OrderDetails> response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        /**
//         * Then
//         */
//        Assertions.assertEquals(ordersController.getOrder(orderId),response);
//    }
//
//    @Test
//    void testGetOrdersByUserIdWhenUserIdIsAvailable(){
//        /**
//         * Given
//         */
//        Long userId=1L;
//
//        /**
//         * When
//         */
//        List<OrderDetails> ordersList=new ArrayList<>();
//        ordersList.add(order);
//        when(ordersService.getOrdersByUserId(userId)).thenReturn(ordersList);
//        ResponseEntity<List> response = ResponseEntity.status(HttpStatus.OK).body(ordersList);
//        /**
//         * Then
//         */
//        Assertions.assertEquals(ordersController.getOrdersByUserId(userId),response);
//    }
//
//    @Test
//    void testGetOrdersByUserIdWhenUserIdIsNotAvailable(){
//        /**
//         * Given
//         */
//        Long userId=1L;
//
//        /**
//         * When
//         */
//        List<OrderDetails> ordersList=new ArrayList<>();
//        when(ordersService.getOrdersByUserId(userId)).thenReturn(ordersList);
//        ResponseEntity<List> response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//
//        /**
//         * Then
//         */
//        Assertions.assertEquals(ordersController.getOrdersByUserId(userId),response);
//    }
//}
