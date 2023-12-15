package com.dev.auca.onlineticketmanagmentsystem.repostory;

import com.dev.auca.onlineticketmanagmentsystem.model.CustometTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerTicketDao extends JpaRepository<CustometTicket,Integer> {
    @Query("from CustometTicket where customer.customerId =:customerId")
    List<CustometTicket> findByCustomerId(Integer customerId);
}
