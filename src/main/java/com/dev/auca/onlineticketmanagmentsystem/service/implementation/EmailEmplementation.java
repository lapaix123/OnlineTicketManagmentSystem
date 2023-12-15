package com.dev.auca.onlineticketmanagmentsystem.service.implementation;

import com.dev.auca.onlineticketmanagmentsystem.model.Customer;
import com.dev.auca.onlineticketmanagmentsystem.model.CustometTicket;
import com.dev.auca.onlineticketmanagmentsystem.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailEmplementation implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendEmail(Customer customer) {

        SimpleMailMessage message= new SimpleMailMessage();
        message.setTo(customer.getEmail());
        message.setSubject("payment of Ticket");
        message.setText("hello "+"  "+customer.getNames() +"  with phone number "+customer.getPhone()+"welcome to online Ticket Manegment System ");
        javaMailSender.send(message);

    }
}
