package com.dev.auca.onlineticketmanagmentsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class CustometTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ctId;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "tId")
    private Ticket ticket;
    private Integer numberOfTicket;
    private Double amount;
    @OneToMany(mappedBy = "customerTicket")
    private List<Payment> payments;
    private LocalDate buyDate;
    @PrePersist
    public void prePersist() {
        this.buyDate = LocalDate.now();
    }
}
