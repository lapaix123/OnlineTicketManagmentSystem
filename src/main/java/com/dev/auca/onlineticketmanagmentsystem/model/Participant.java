package com.dev.auca.onlineticketmanagmentsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer participantId;
    private String participantNames;
    @ManyToOne
    @JoinColumn(name = "eventId")
    private Event event;
}
