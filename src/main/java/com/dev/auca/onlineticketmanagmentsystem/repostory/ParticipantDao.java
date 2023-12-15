package com.dev.auca.onlineticketmanagmentsystem.repostory;

import com.dev.auca.onlineticketmanagmentsystem.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantDao extends JpaRepository<Participant,Integer> {
}
