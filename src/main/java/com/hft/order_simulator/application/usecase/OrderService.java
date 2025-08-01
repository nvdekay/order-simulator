package com.hft.order_simulator.application.usecase;

import com.hft.order_simulator.domain.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    Order getOrderById(Long id);
    List<Order> getAllOrders();
    Order cancelOrder(Long id);
    void simulateExecution();
}
