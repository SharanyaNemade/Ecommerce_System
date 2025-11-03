package com.Ecommerce.controller;


import com.Ecommerce.model.Payment;
import com.Ecommerce.model.Order;
import com.Ecommerce.service.PaymentService;
import com.Ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private OrderService orderService;

    // Create a payment
    @PostMapping("/add")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    // Get all payments
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Get payment by ID
    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    // Get payments for a specific order
    @GetMapping("/order/{orderId}")
    public List<Payment> getPaymentsByOrder(@PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return paymentService.getPaymentsByOrder(order);
    }

    // Update payment status
    @PutMapping("/{id}/status")
    public Payment updatePaymentStatus(@PathVariable Long id, @RequestParam Payment.PaymentStatus status) {
        return paymentService.updatePaymentStatus(id, status);
    }

    // Delete payment
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.ok("Payment deleted successfully");
    }
}
