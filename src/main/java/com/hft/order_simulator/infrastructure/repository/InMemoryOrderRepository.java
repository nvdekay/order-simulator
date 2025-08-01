package com.hft.order_simulator.infrastructure.repository;

import com.hft.order_simulator.domain.model.Order;
import com.hft.order_simulator.domain.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryOrderRepository implements OrderRepository {
    private final Map<Long, Order> storage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Order save(Order order) {
        long id = idGenerator.getAndIncrement();
        order.setId(id);
        storage.put(id, order);
        return order;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void update(Order order) {
        storage.put(order.getId(), order);
    }
}

