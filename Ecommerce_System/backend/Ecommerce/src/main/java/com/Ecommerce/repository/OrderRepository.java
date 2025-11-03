package com.Ecommerce.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.model.Order;
import com.Ecommerce.model.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Find orders for a specific user
    List<Order> findByUser(User user);
}
