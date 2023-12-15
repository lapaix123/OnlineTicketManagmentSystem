package com.dev.auca.onlineticketmanagmentsystem.service;

import com.dev.auca.onlineticketmanagmentsystem.model.Participant;

import java.util.List;

public interface ParticipantService {
    Participant newParticipant(Participant participant);
    void  deleteParticipant(Integer participantId);
    Participant updateParticipant(Integer participantId, Participant participant);
    List<Participant> allParticipants();
    Participant findById(Integer participantId);
}
