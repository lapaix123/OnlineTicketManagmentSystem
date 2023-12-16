package com.dev.auca.onlineticketmanagmentsystem.service.implementation;

import com.dev.auca.onlineticketmanagmentsystem.model.Event;
import com.dev.auca.onlineticketmanagmentsystem.model.Ticket;
import com.dev.auca.onlineticketmanagmentsystem.repostory.TicketDao;
import com.dev.auca.onlineticketmanagmentsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TicketImp implements TicketService {
    @Autowired
    private TicketDao dao;
    @Override
    public Ticket newTicket(Ticket ticket) {
        return dao.save(ticket);
    }

    @Override
    public void deleteTicket(Integer ticketId) {
        if(dao.existsById(ticketId)){
            dao.deleteById(ticketId);
        }
    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
            return dao.save(ticket);

    }

    @Override
    public Ticket findById(Integer ticketId) {
        return dao.findById(ticketId).get();
    }

    @Override
    public List<Ticket> allTickets() {
        return dao.findAll();
    }

    @Override
    public Ticket findByEvent(Integer eventId) {
        return dao.findByEvent(eventId);
    }
}
