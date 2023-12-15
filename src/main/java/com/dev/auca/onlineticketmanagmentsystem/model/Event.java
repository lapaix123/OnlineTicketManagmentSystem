package com.dev.auca.onlineticketmanagmentsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventId;
    private String eventName;
    private LocalDate eventDate;
    private String location;
    @OneToMany(mappedBy = "event")
    private List<Ticket> tickets;
    @OneToMany(mappedBy = "event")
    private List<Participant> participants;

}
