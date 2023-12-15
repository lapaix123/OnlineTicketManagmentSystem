package com.dev.auca.onlineticketmanagmentsystem.service;

import com.dev.auca.onlineticketmanagmentsystem.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment newPayment(Payment payment);
    void deletePayment(Integer paymentId);
    Payment updatePayment(Payment payment);
    List<Payment> getPayments();
    Payment findPaymentById(Integer paymentId);
}
