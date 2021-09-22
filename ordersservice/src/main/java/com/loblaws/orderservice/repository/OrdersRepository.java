package com.loblaws.orderservice.repository;

import com.loblaws.orderservice.constants.OrderStatus;
import com.loblaws.orderservice.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<OrderDetails,Long> {

   public OrderDetails findByOrderId(Long orderId);

   public List<OrderDetails> findByUserId(Long userId);

   @Query("SELECT u FROM OrderDetails u WHERE u.orderStatus = ?1")
   public List<OrderDetails> findPendingOrders(OrderStatus orderStatus);

//   public Boolean changeStatusForOrder()
//@Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
//User findUserByStatusAndName(Integer status, String name);
}
