package com.dev.auca.onlineticketmanagmentsystem.controller;

import com.dev.auca.onlineticketmanagmentsystem.model.Admin;
import com.dev.auca.onlineticketmanagmentsystem.model.Customer;
import com.dev.auca.onlineticketmanagmentsystem.model.Event;
import com.dev.auca.onlineticketmanagmentsystem.model.Ticket;
import com.dev.auca.onlineticketmanagmentsystem.service.EventService;
import com.dev.auca.onlineticketmanagmentsystem.service.TicketService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private EventService eventService;
    @GetMapping("/ticket")
    public String getTicket(Model model,HttpSession session) {
        Admin authanticatedAdmin=(Admin) session.getAttribute("adminAuthenticated");
        if(authanticatedAdmin != null) {
            model.addAttribute("adminAuthenticated", authanticatedAdmin);
            Ticket ticket=new Ticket();
            List<Ticket> tickets = ticketService.allTickets();
            model.addAttribute("tickets", tickets);
            model.addAttribute("ticket", ticket);
            return "ticket";
        }else{
            return "adminLogin";
        }

    }
    @GetMapping("/ticketForm")
    private String TicketForm(Model model,HttpSession session){
        Admin authanticatedAdmin=(Admin) session.getAttribute("adminAuthenticated");
        if(authanticatedAdmin != null) {
            model.addAttribute("adminAuthenticated", authanticatedAdmin);
            Ticket ticket = new Ticket();
            model.addAttribute("ticket", ticket);
            Event event = new Event();
            List<Event> events = eventService.getEvents();
            model.addAttribute("events",events);
            model.addAttribute("event",event);
            return "ticketForm";
        }else{
            return "adminLogin";
        }


    }
    @PostMapping("/newTicket")
    public String newTicket(Ticket ticket,Model model){
        Ticket newTicket = ticketService.newTicket(ticket);
        return "redirect:/ticket";
    }
    @GetMapping("/deleteTicket/{ticketId}")
    public String deleteTicket(@PathVariable Integer ticketId, Model model){
        ticketService.deleteTicket(ticketId);
        return "redirect:/ticket";
    }
    @GetMapping("/editTicket/{ticketId}")
    public String editTicket(@PathVariable Integer ticketId, Model model,HttpSession session){
        Admin authanticatedAdmin=(Admin) session.getAttribute("adminAuthenticated");
        if(authanticatedAdmin != null) {
            model.addAttribute("adminAuthenticated", authanticatedAdmin);
            Ticket ticket = ticketService.findById(ticketId);
            model.addAttribute("ticket", ticket);
            Event event = new Event();
            List<Event> events = eventService.getEvents();
            model.addAttribute("events",events);
            model.addAttribute("event",event);
            return "ticketForm";
        }else{
            return "adminLogin";
        }

    }

}
