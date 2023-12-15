package com.dev.auca.onlineticketmanagmentsystem.service;

import com.dev.auca.onlineticketmanagmentsystem.model.Event;

import java.util.List;

public interface EventService {
    Event newEvent(Event event);
    void delete(Integer eventId);
    Event updateEvent(Event event);
    List<Event> getEvents();
    Event findById(Integer eventId);


}
