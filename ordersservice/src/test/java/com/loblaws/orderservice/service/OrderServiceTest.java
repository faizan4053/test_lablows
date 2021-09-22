//package com.loblaws.orderservice.service;
//
//import com.loblaws.orderservice.constants.OrderStatus;
//import com.loblaws.orderservice.entity.OrderDetails;
//import com.loblaws.orderservice.repository.OrdersRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class OrderServiceTest {
//
//    @InjectMocks
//    private OrdersService ordersService;
//
//    @Mock
//    private OrdersRepository ordersRepository;
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
//    void testSaveOrder() {
//
//        /**
//         * When
//         */
//        when(ordersRepository.save(order)).thenReturn(order);
//
//        /**
//         * Then
//         */
//        Assertions.assertEquals(ordersService.saveOrder(order).getOrderId(),order.getOrderId());
//
//    }
//
//    @Test
//    void testGetOrderByWhenProductIsAvailable(){
//
//        /**
//         * Given
//         */
//        Long orderId=1L;
//
//        /**
//         * When
//         */
//        when(ordersRepository.findByOrderId(orderId)).thenReturn(order);
//
//        /**
//         * Then
//         */
//        Assertions.assertNotNull(ordersService.getOrder(orderId));
//    }
//
//    @Test
//    void testGetOrderByWhenProductIsNotAvailable(){
//
//        /**
//         * Given
//         */
//        Long orderId=3L;
//
//        /**
//         * When
//         */
//        when(ordersRepository.findByOrderId(orderId)).thenReturn(null);
//
//        /**
//         * Then
//         */
//        Assertions.assertNull(ordersService.getOrder(orderId));
//    }
//
//    @Test
//    void testGetOrdersByUserIdWhenUserIdIsAvailable(){
//
//        /**
//         * Given
//         */
//        Long userId=1L;
//        /**
//         * When
//         */
//        List<OrderDetails> ordersList=new ArrayList<>();
//        ordersList.add(order);
//        when(ordersRepository.findByUserId(userId)).thenReturn(ordersList);
//
//        /**
//         * Then
//         */
//        Assertions.assertNotNull(ordersService.getOrdersByUserId(userId));
//
//    }
//
//    @Test
//    void testGetOrdersByUserIdWhenUserIdIsNotAvailable(){
//
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
//        when(ordersRepository.findByUserId(userId)).thenReturn(null);
//
//        /**
//         * Then
//         */
//        Assertions.assertNull(ordersService.getOrdersByUserId(userId));
//    }
//
//}
