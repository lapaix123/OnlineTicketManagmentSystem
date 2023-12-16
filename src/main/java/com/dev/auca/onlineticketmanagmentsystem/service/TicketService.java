package com.dev.auca.onlineticketmanagmentsystem.service;

import com.dev.auca.onlineticketmanagmentsystem.model.Event;
import com.dev.auca.onlineticketmanagmentsystem.model.Ticket;

import java.util.List;

public interface TicketService {
    Ticket newTicket(Ticket ticket);
    void deleteTicket(Integer ticketId);
    Ticket updateTicket(Ticket ticket);
    Ticket findById(Integer ticketId);
    List<Ticket> allTickets();
    Ticket findByEvent(Integer eventId);

}
