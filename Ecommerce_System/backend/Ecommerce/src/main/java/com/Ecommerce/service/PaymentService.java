package com.Ecommerce.service;



import com.Ecommerce.model.Payment;
import com.Ecommerce.model.Order;
import com.Ecommerce.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // Create / Save payment
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Get all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get payment by ID
    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    // Get payments for a specific order
    public List<Payment> getPaymentsByOrder(Order order) {
        return paymentRepository.findByOrder(order);
    }

    // Update payment status
    public Payment updatePaymentStatus(Long id, Payment.PaymentStatus status) {
        return paymentRepository.findById(id).map(payment -> {
            payment.setStatus(status);
            return paymentRepository.save(payment);
        }).orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    // Delete payment
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
