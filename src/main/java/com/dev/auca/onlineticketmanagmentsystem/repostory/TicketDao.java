package com.dev.auca.onlineticketmanagmentsystem.repostory;

import com.dev.auca.onlineticketmanagmentsystem.model.Ticket;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface
TicketDao extends JpaRepository<Ticket,Integer> {
    @Query("from Ticket where event.eventId =:eventId")
    Ticket findByEvent(Integer eventId);
}
