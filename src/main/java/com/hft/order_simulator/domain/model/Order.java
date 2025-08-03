package com.hft.order_simulator.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    private Long id;
    private String symbol;
    private BigDecimal price;
    private int quantity;
    private OrderSide side;
    private OrderStatus status;
    private LocalDateTime createdTime;
}
