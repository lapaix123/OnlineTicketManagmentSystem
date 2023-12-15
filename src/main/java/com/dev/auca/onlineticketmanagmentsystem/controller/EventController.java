package com.dev.auca.onlineticketmanagmentsystem.controller;

import com.dev.auca.onlineticketmanagmentsystem.model.Admin;
import com.dev.auca.onlineticketmanagmentsystem.model.Customer;
import com.dev.auca.onlineticketmanagmentsystem.model.Event;
import com.dev.auca.onlineticketmanagmentsystem.service.EventService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EventController {
    @Autowired
    private EventService eventService;
    @GetMapping("/event")
    public String getEvents(Model model,HttpSession session) {
        Admin authanticatedAdmin=(Admin) session.getAttribute("adminAuthenticated");
        if(authanticatedAdmin != null) {
            model.addAttribute("adminAuthenticated", authanticatedAdmin);
            Event event = new Event();
            List<Event> events = eventService.getEvents();
            model.addAttribute("events",events);
            model.addAttribute("event",event);
            return "event";
        }else{
            return "adminLogin";
        }

    }
    @GetMapping("/eventForm")
    public String eventForm(Model model,HttpSession session){
        Admin authanticatedAdmin=(Admin) session.getAttribute("adminAuthenticated");
        if(authanticatedAdmin != null) {
            model.addAttribute("adminAuthenticated", authanticatedAdmin);
            Event event = new Event();
            model.addAttribute("event",event);
            return "eventForm";
        }else{
            return "adminLogin";
        }

    }
    @PostMapping("/newEvent")
    public String newEvent(Event event,Model model) {
        Event newEvent = eventService.newEvent(event);
        return "redirect:/event";
    }
    @GetMapping("/deleteEvent/{eventId}")
    public String deleteEvent(@PathVariable Integer eventId, Model model) {
        eventService.delete(eventId);
        return "redirect:/event";
    }

    @GetMapping("/editEvent/{eventId}")
    public String editBranchPage(@PathVariable Integer eventId, Model model,HttpSession session) {
        Admin authanticatedAdmin=(Admin) session.getAttribute("adminAuthenticated");
        if(authanticatedAdmin != null) {
            model.addAttribute("adminAuthenticated", authanticatedAdmin);
            Event event = eventService.findById(eventId);
            model.addAttribute("event", event);
            return "eventForm";
        }else{
            return "adminLogin";
        }

    }
    @GetMapping("/allEvent")
    public String eventForCustomer(HttpSession session,Model model){
        Customer authanticatedCustomer = (Customer) session.getAttribute("authenticatedCustomer");
        if(authanticatedCustomer != null){
            model.addAttribute("authenticatedCustomer",authanticatedCustomer);
            Event event = new Event();
            List<Event> events = eventService.getEvents();
            model.addAttribute("events",events);
            model.addAttribute("event",event);
            return "allEvent";
        }else {
            return "login";
        }
    }

}
