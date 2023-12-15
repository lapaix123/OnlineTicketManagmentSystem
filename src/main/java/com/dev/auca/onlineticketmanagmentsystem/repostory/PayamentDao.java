package com.dev.auca.onlineticketmanagmentsystem.repostory;

import com.dev.auca.onlineticketmanagmentsystem.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayamentDao extends JpaRepository<Payment,Integer> {
}
