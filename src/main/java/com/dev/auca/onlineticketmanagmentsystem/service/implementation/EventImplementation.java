package com.dev.auca.onlineticketmanagmentsystem.service.implementation;

import com.dev.auca.onlineticketmanagmentsystem.model.Event;
import com.dev.auca.onlineticketmanagmentsystem.repostory.EventDao;
import com.dev.auca.onlineticketmanagmentsystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventImplementation implements EventService {
    @Autowired
    private EventDao dao;
    @Override
    public Event newEvent(Event event) {
        return dao.save(event);
    }

    @Override
    public void delete(Integer eventId) {
        if(dao.existsById(eventId)){
            dao.deleteById(eventId);
        }

    }

    @Override
    public Event updateEvent(Event event) {
            return dao.save(event);

    }

    @Override
    public List<Event> getEvents() {
        return dao.findAll();
    }

    @Override
    public Event findById(Integer eventId) {
        return dao.findById(eventId).get();
    }
}
