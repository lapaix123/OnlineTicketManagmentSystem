package com.dev.auca.onlineticketmanagmentsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketNumber;
    private String ticketName;
    private Integer number;
    private Double tAmount;
    @ManyToOne
    @JoinColumn(name = "eventId")
    private Event event;
}
