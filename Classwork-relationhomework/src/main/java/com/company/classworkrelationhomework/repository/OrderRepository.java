package com.company.classworkrelationhomework.repository;

import com.company.classworkrelationhomework.model.entity.Order;
import com.company.classworkrelationhomework.projection.OrderProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("""
            SELECT o.id           AS orderId,\s
                   o.amount       AS orderAmount,
                   o.orderStatus  AS orderStatus,
                   op.id as orderProductId,
                   p.id as productId,
                   op.quantity as orderProductQuantity,
                   op.price as orderProductPrice,
                   p.name as productName
            FROM OrderProduct op
            join op.order o
            join op.product p
            order by o.id""")
    List<OrderProjection> findProjection();
}