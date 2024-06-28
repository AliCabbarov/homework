package com.company.classworkrelationhomework.projection;

import com.company.classworkrelationhomework.model.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.List;

public interface OrderProjection {
    Long getOrderId();
    BigDecimal getOrderAmount();
    OrderStatus getOrderStatus();
    Long getProductId();

    Long getOrderProductId();

    Long getOrderProductQuantity();

    BigDecimal getOrderProductPrice();

    String getProductName();
}
