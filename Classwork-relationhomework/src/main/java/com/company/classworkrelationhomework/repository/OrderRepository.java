package com.company.classworkrelationhomework.repository;

import com.company.classworkrelationhomework.model.entity.Order;
import com.company.classworkrelationhomework.projection.IncomeCalculation;
import com.company.classworkrelationhomework.projection.OrderProjection;
import org.springframework.cache.annotation.CachePut;
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

    @Query(value = """
            select  sum(op.quantity * op.price) as total_income,
                    _order.id as id
            from _order
                     left join order_product op on _order.id = op.order_id
            group by  _order.id
            """, nativeQuery = true)
    List<IncomeCalculation> calculateIncome();

    @CachePut(value = "orderCache", key = "#entity.id")
    Order save(Order entity);
}