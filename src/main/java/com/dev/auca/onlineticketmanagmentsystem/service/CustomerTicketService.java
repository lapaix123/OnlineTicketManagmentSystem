package com.dev.auca.onlineticketmanagmentsystem.service;

import com.dev.auca.onlineticketmanagmentsystem.model.Customer;
import com.dev.auca.onlineticketmanagmentsystem.model.CustometTicket;

import java.util.List;

public interface CustomerTicketService {
    CustometTicket newTicket(CustometTicket customerTicket);
    void deleteCustomerTicket(Integer ctId);
    CustometTicket updateCustomerTicket(Integer ctId, CustometTicket customerTicket);
    List<CustometTicket> allCustomerTickets();
    CustometTicket findByCustomerTicketId(Integer ctId);
    List<CustometTicket> findAllTicketsOfCustomer(Integer customerId);

}
