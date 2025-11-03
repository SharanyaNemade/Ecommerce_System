package com.Ecommerce.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.model.Payment;
import com.Ecommerce.model.Order;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Find payments by order
    List<Payment> findByOrder(Order order);

    // Optional: find by status
    List<Payment> findByStatus(Payment.PaymentStatus status);
}
