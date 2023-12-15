package com.dev.auca.onlineticketmanagmentsystem.controller;

import com.dev.auca.onlineticketmanagmentsystem.model.Admin;
import com.dev.auca.onlineticketmanagmentsystem.model.Event;
import com.dev.auca.onlineticketmanagmentsystem.model.Participant;
import com.dev.auca.onlineticketmanagmentsystem.service.EventService;
import com.dev.auca.onlineticketmanagmentsystem.service.ParticipantService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ParticipantController {
    @Autowired
    private ParticipantService participantService;
    @Autowired
    private EventService eventService;
    @GetMapping("/participant")
    public String allParticipants(Model model, HttpSession session) {
        Admin authanticatedAdmin=(Admin) session.getAttribute("adminAuthenticated");
        if(authanticatedAdmin != null) {
            model.addAttribute("adminAuthenticated", authanticatedAdmin);
            Participant participant=new Participant();
            List<Participant> participants=participantService.allParticipants();
            model.addAttribute("participants",participants);
            model.addAttribute("participant",participant);
            return "participant";
        }else{
            return "adminLogin";
        }


    }

    @GetMapping("/participantForm")
    public String eventForm(Model model,HttpSession session){
        Admin authanticatedAdmin=(Admin) session.getAttribute("adminAuthenticated");
        if(authanticatedAdmin != null) {
            model.addAttribute("adminAuthenticated", authanticatedAdmin);
            Participant participant=new Participant();
            model.addAttribute("participant",participant);
            Event event = new Event();
            List<Event> events = eventService.getEvents();
            model.addAttribute("events",events);
            model.addAttribute("event",event);
            return "participantForm";
        }else{
            return "adminLogin";
        }

    }
    @PostMapping("/newParticipant")
    public String newEvent(Participant participant,Model model) {
        Participant newParticipant=participantService.newParticipant(participant);
        return "redirect:/participant";
    }
    @GetMapping("/deleteParticipant/{participantId}")
    public String deleteEvent(@PathVariable Integer participantId, Model model) {
        participantService.deleteParticipant(participantId);
        return "redirect:/participant";
    }

    @GetMapping("/editParticipant/{participantId}")
    public String editBranchPage(@PathVariable Integer participantId, Model model,HttpSession session) {
        Admin authanticatedAdmin=(Admin) session.getAttribute("adminAuthenticated");
        if(authanticatedAdmin != null) {
            model.addAttribute("adminAuthenticated", authanticatedAdmin);
            Participant participant=participantService.findById(participantId);
            model.addAttribute("participant", participant);
            Event event = new Event();
            List<Event> events = eventService.getEvents();
            model.addAttribute("events",events);
            model.addAttribute("event",event);
            return "participantForm";
        }else{
            return "adminLogin";
        }

    }
}
