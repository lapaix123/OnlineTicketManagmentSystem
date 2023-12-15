package com.dev.auca.onlineticketmanagmentsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.util.Date;
@Entity

@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  customerId;
    private String nId;
    private  String names;
    private String phone;
    private String email;
    private String location;
    private LocalDate dob;
    private String password;
}
