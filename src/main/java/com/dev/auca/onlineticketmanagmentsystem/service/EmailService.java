package com.dev.auca.onlineticketmanagmentsystem.service;

import com.dev.auca.onlineticketmanagmentsystem.model.Customer;
import com.dev.auca.onlineticketmanagmentsystem.model.CustometTicket;

public interface EmailService {
    void sendEmail(Customer customer);
}
