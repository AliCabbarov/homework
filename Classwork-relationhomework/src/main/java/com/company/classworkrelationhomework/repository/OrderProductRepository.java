package com.company.classworkrelationhomework.repository;

import com.company.classworkrelationhomework.model.entity.Order;
import com.company.classworkrelationhomework.model.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
    @Query("select op from OrderProduct op where op.order in :orders ")
    List<OrderProduct> findAllByOrders(List<Order> orders);

    List<OrderProduct> findByOrder(Order order);
}