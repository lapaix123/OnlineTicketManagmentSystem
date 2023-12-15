package com.dev.auca.onlineticketmanagmentsystem.service.implementation;

import com.dev.auca.onlineticketmanagmentsystem.model.Payment;
import com.dev.auca.onlineticketmanagmentsystem.repostory.PayamentDao;
import com.dev.auca.onlineticketmanagmentsystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaymentImplementation implements PaymentService {
    @Autowired
    private PayamentDao dao;
    @Override
    public Payment newPayment(Payment payment) {
        return dao.save(payment);
    }

    @Override
    public void deletePayment(Integer paymentId) {
        if(dao.existsById(paymentId)){
            dao.deleteById(paymentId);
        }
    }

    @Override
    public Payment updatePayment(Payment payment) {
            return dao.save(payment);

    }

    @Override
    public List<Payment> getPayments() {
        return dao.findAll();
    }

    @Override
    public Payment findPaymentById(Integer paymentId) {
        return dao.findById(paymentId).orElse(null);
    }
}
