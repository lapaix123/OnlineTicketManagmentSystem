package com.dev.auca.onlineticketmanagmentsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    @ManyToOne
    @JoinColumn(name = "ctId")
    private CustometTicket customerTicket;
    @Enumerated(EnumType.STRING)
    private EPayment status;
}
