package com.Ecommerce.service;

import com.Ecommerce.model.Order;
import com.Ecommerce.model.User;
import com.Ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Place a new order
    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    // Get all orders for a specific user
    public List<Order> getOrdersByUser(User user) {
        return orderRepository.findByUser(user);
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get order by ID
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // Update order status
    public Order updateOrder(Long id, Order updatedOrder) {
        return orderRepository.findById(id).map(order -> {
            order.setStatus(updatedOrder.getStatus());
            return orderRepository.save(order);
        }).orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
