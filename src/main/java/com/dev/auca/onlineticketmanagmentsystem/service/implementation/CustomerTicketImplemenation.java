package com.dev.auca.onlineticketmanagmentsystem.service.implementation;

import com.dev.auca.onlineticketmanagmentsystem.model.CustometTicket;
import com.dev.auca.onlineticketmanagmentsystem.repostory.CustomerTicketDao;
import com.dev.auca.onlineticketmanagmentsystem.service.CustomerTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTicketImplemenation implements CustomerTicketService {
    @Autowired
    private CustomerTicketDao dao;
    @Override
    public CustometTicket newTicket(CustometTicket customerTicket) {
        return dao.save(customerTicket);
    }

    @Override
    public void deleteCustomerTicket(Integer ctId) {
        if(dao.existsById(ctId)){
            dao.deleteById(ctId);
        }

    }

    @Override
    public CustometTicket updateCustomerTicket(Integer ctId, CustometTicket customerTicket) {
        if(dao.existsById(ctId)){
            return dao.save(customerTicket);
        }else{
            return null;
        }

    }

    @Override
    public List<CustometTicket> allCustomerTickets() {
        return dao.findAll();
    }

    @Override
    public CustometTicket findByCustomerTicketId(Integer ctId) {
        return dao.findById(ctId).orElse(null);
    }

    @Override
    public List<CustometTicket> findAllTicketsOfCustomer(Integer customerId) {
        return dao.findByCustomerId(customerId);
    }
}
