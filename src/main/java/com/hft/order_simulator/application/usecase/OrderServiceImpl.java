package com.hft.order_simulator.application.usecase;

import com.hft.order_simulator.domain.model.Order;
import com.hft.order_simulator.domain.model.OrderStatus;
import com.hft.order_simulator.domain.repository.OrderRepository;
import com.hft.order_simulator.exception.InvalidOrderStateException;
import com.hft.order_simulator.exception.OrderNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
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

    @Override
    public Order getOrderById(Long id) {
        return  orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order cancelOrder(Long id) {
        Order order = getOrderById(id);
        if(order.getStatus() != OrderStatus.PENDING) {
            throw new InvalidOrderStateException("Only PENDING orders can be cancelled!");
        }
        order.setStatus(OrderStatus.CANCELLED);
        orderRepository.update(order);
        logger.info("Order cancelled: {}", order);
        return order;
    }

    @Override
    public void simulateExecution() {
        List<Order> orders = getAllOrders();
        for (Order order : orders) {
            if (order.getStatus() == OrderStatus.PENDING && random.nextBoolean()) {
                order.setStatus(OrderStatus.EXECUTED);
                orderRepository.update(order);
                logger.info("Order executed: {}", order);
            }
        }
    }
}
