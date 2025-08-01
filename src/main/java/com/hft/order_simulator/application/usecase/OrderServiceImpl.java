package com.hft.order_simulator.application.usecase;

import com.hft.order_simulator.domain.model.Order;
import com.hft.order_simulator.domain.model.OrderStatus;
import com.hft.order_simulator.domain.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Random;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    private final Random random = new Random();

    @Override
    public Order createOrder(Order order) {
        order.setStatus(OrderStatus.PENDING);
        order.setCreatedTime(LocalDateTime.now());
        Order saved = orderRepository.save(order);
        logger.info("Order created: " + saved);
        return saved;
    }
}
