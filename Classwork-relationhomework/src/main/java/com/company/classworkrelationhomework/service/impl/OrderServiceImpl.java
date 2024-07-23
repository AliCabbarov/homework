package com.company.classworkrelationhomework.service.impl;

import com.company.classworkrelationhomework.model.dto.request.OrderRequestDto;
import com.company.classworkrelationhomework.model.dto.response.OrderProductResponseDto;
import com.company.classworkrelationhomework.model.dto.response.OrderResponseDto;
import com.company.classworkrelationhomework.model.entity.Order;
import com.company.classworkrelationhomework.model.entity.OrderProduct;
import com.company.classworkrelationhomework.model.entity.Product;
import com.company.classworkrelationhomework.model.enums.OrderStatus;
import com.company.classworkrelationhomework.projection.OrderProjection;
import com.company.classworkrelationhomework.repository.OrderProductRepository;
import com.company.classworkrelationhomework.repository.OrderRepository;
import com.company.classworkrelationhomework.service.OrderService;
import com.company.classworkrelationhomework.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private final ProductService productService;


    @Override
    @Transactional
    public ResponseEntity<OrderResponseDto> create(List<OrderRequestDto> dto) {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.ORDERED);
        List<OrderProduct> orderProducts = new ArrayList<>();

        for (OrderRequestDto orderRequestDto : dto) {
            Product product = productService.getById(orderRequestDto.getProductId());

            if (product.getQuantity() < orderRequestDto.getQuantity()) {
                throw new RuntimeException("requested quantity is higher than product quantity");
            }

            OrderProduct orderProduct = new OrderProduct(orderRequestDto.getQuantity(), order, product, product.getPrice());
            orderProducts.add(orderProduct);
            order.setAmount(order.getAmount().add(product.getPrice().multiply(BigDecimal.valueOf(orderRequestDto.getQuantity()))));
            product.setQuantity((int) (product.getQuantity() - orderRequestDto.getQuantity()));
        }

        Order savedOrder = orderRepository.save(order);
        List<OrderProduct> savedOrderProduct = orderProductRepository.saveAll(orderProducts);

        OrderResponseDto orderResponseDto = new OrderResponseDto(savedOrder.getId(), savedOrder.getAmount(), savedOrder.getOrderStatus());
        for (OrderProduct orderProduct : savedOrderProduct) {
            orderResponseDto.getOrderProducts()
                    .add(new OrderProductResponseDto(orderProduct.getProduct().getId(),
                            orderProduct.getQuantity(),
                            orderProduct.getProduct().getPrice(),
                            orderProduct.getProduct().getName()));
        }

        return ResponseEntity.ok(orderResponseDto);
    }

    @Override
    public ResponseEntity<Collection<OrderResponseDto>> getAll() {
        List<OrderProjection> projection = orderRepository.findProjection();

        Map<Long, OrderResponseDto> response = new HashMap<>();

        for (OrderProjection orderProjection : projection) {
            OrderResponseDto existOrderResponseDto = response.get(orderProjection.getOrderId());
            OrderProductResponseDto orderProduct = buildProductResponse(orderProjection);

            if (existOrderResponseDto == null) {

                OrderResponseDto orderResponseDto =
                        new OrderResponseDto(orderProjection.getOrderId(),
                                orderProjection.getOrderAmount(),
                                orderProjection.getOrderStatus(),
                                new ArrayList<>());
                orderResponseDto.getOrderProducts().add(orderProduct);

                response.put(orderProjection.getOrderId(), orderResponseDto);
            } else {
                existOrderResponseDto.getOrderProducts().add(orderProduct);
            }

        }

        return ResponseEntity.ok(response.values());
    }

    private OrderProductResponseDto buildProductResponse(OrderProjection orderProjection) {
        return new OrderProductResponseDto(orderProjection.getOrderProductId(),
                orderProjection.getOrderProductQuantity(),
                orderProjection.getOrderProductPrice(),
                orderProjection.getProductName());

    }
}
