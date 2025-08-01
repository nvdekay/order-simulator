package com.hft.order_simulator.domain.repository;

import com.hft.order_simulator.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(Long id);
    List<Order> findAll();
    void update(Order order);
}
