package com.dev.auca.onlineticketmanagmentsystem.controller;

import com.dev.auca.onlineticketmanagmentsystem.model.*;
import com.dev.auca.onlineticketmanagmentsystem.service.CustomerService;
import com.dev.auca.onlineticketmanagmentsystem.service.CustomerTicketService;
import com.dev.auca.onlineticketmanagmentsystem.service.EventService;
import com.dev.auca.onlineticketmanagmentsystem.service.TicketService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerTicketController {
    private CustomerService customerService;
    private CustomerTicketService customerTicketService;
    private EventService eventService;
    private TicketService ticketService;
    @Autowired

    public CustomerTicketController(CustomerService customerService, CustomerTicketService customerTicketService, EventService eventService, TicketService ticketService) {
        this.customerService = customerService;
        this.customerTicketService = customerTicketService;
        this.eventService = eventService;
        this.ticketService = ticketService;
    }

    @GetMapping("/customerTicket")
    public String getCustomerTicket(Model model, HttpSession session) {
        Admin authanticatedAdmin=(Admin) session.getAttribute("adminAuthenticated");
        if(authanticatedAdmin != null) {
            model.addAttribute("adminAuthenticated", authanticatedAdmin);
            CustometTicket customerTicket = new CustometTicket();
            List<CustometTicket> customerTickets= customerTicketService.allCustomerTickets();
            model.addAttribute("customerTickets",customerTickets);
            model.addAttribute("customerTicket",customerTicket);
            return "customerTicket";
        }else{
            return "adminLogin";
        }



    }
    @PostMapping("/newCustomerTicket")
    public String newCustomerTicket(CustometTicket customerTicket,Model model) {
        customerTicketService.newTicket(customerTicket);
        return "redirect:/customerTicket";
    }

    @PostMapping("/buyTicketEvent")
    public String buyTicketEvent(CustometTicket customerTicket,Model model) {
        customerTicketService.newTicket(customerTicket);
        return "redirect:/yourTicket";
    }

    @GetMapping("/deleteCustomerTicket/{ticketId}")
    public String deleteCustomerTicket(@PathVariable Integer ticketId,Model model) {
        customerTicketService.deleteCustomerTicket(ticketId);
        return "redirect:/customerTicket";
    }

    @GetMapping("/editCustomerTicket/{ticketId}")
    public String editCustomerTicket(@PathVariable Integer ticketId,Model model,HttpSession session){
        Admin authanticatedAdmin=(Admin) session.getAttribute("adminAuthenticated");
        if(authanticatedAdmin != null) {
            model.addAttribute("adminAuthenticated", authanticatedAdmin);
            CustometTicket customerTicket = customerTicketService.findByCustomerTicketId(ticketId);
            model.addAttribute("customerTicket",customerTicket);
            Customer customer = new Customer();
            List<Customer> customers = customerService.allCustomers();
            model.addAttribute("customers",customers);
            model.addAttribute("customer",customer);
            return "customerTicketForm";
        }else{
            return "adminLogin";
        }

    }
    @GetMapping("/customerTicketForm")
    public String getCustomerTicketForm(Model model,HttpSession session) {
        Admin authanticatedAdmin=(Admin) session.getAttribute("adminAuthenticated");
        if(authanticatedAdmin != null) {
            model.addAttribute("adminAuthenticated", authanticatedAdmin);
            CustometTicket customerTicket = new CustometTicket();
            model.addAttribute("customerTicket", customerTicket);
            List<Customer> customers = customerService.allCustomers();
            model.addAttribute("customers", customers);
            Customer customer = new Customer();
            model.addAttribute("customer", customer);
            List<Ticket> tickets = ticketService.allTickets();
            model.addAttribute("tickets", tickets);
            Ticket ticket = new Ticket();
            model.addAttribute("ticket", ticket);
            return "customerTicketForm";
        }else{
            return "adminLogin";
        }

    }

    @GetMapping("/yourTicket")
    public String getEmployeeTicket(HttpSession session, Model model) {
        Customer authanticatedCustomer = (Customer) session.getAttribute("authenticatedCustomer");
        if(authanticatedCustomer != null){
            model.addAttribute("authenticatedCustomer",authanticatedCustomer);
            CustometTicket customerTicket = new CustometTicket();
           Integer customerId= authanticatedCustomer.getCustomerId();
            List<CustometTicket> customerTickets=customerTicketService.findAllTicketsOfCustomer(customerId);
            model.addAttribute("customerTicket",customerTicket);
            model.addAttribute("customerTickets",customerTickets);
            return "yourTicket";
        }else {
            return "login";
        }
    }

    @GetMapping("/buyTicket")
    public String getBuyTicket(HttpSession session, Model model) {
        Customer authanticatedCustomer = (Customer) session.getAttribute("authenticatedCustomer");
        if(authanticatedCustomer != null){
            model.addAttribute("customerTicket", new CustometTicket());
            model.addAttribute("authenticatedCustomer",authanticatedCustomer);
            model.addAttribute("ticket",new Ticket());
            model.addAttribute("tickets",ticketService.allTickets());
            return "buyTicket";
        }else {
            return "login";
        }
    }

    @GetMapping("/buyTicketEvent/{eventId}")
    public String getBuyTicketEvent(HttpSession session, Model model,@PathVariable Integer eventId) {
        Customer authanticatedCustomer = (Customer) session.getAttribute("authenticatedCustomer");
        if(authanticatedCustomer != null){
            model.addAttribute("authenticatedCustomer",authanticatedCustomer);
            model.addAttribute("ticketFound",ticketService.findByEvent(eventId));
            model.addAttribute("customerTicket",new CustometTicket());
            return "buyTicketEvent";
        }else {
            return "login";
        }
    }

}
