package com.dev.auca.onlineticketmanagmentsystem.service.implementation;

import com.dev.auca.onlineticketmanagmentsystem.model.Participant;
import com.dev.auca.onlineticketmanagmentsystem.repostory.ParticipantDao;
import com.dev.auca.onlineticketmanagmentsystem.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParticipantImplementation implements ParticipantService {
    @Autowired
    private ParticipantDao dao;
    @Override
    public Participant newParticipant(Participant participant) {
        return dao.save(participant);
    }

    @Override
    public void deleteParticipant(Integer participantId) {
        if(dao.existsById(participantId)){
            dao.deleteById(participantId);
        }
    }

    @Override
    public Participant updateParticipant(Integer participantId, Participant participant) {
        if(dao.existsById(participantId)){
            return dao.save(participant);
        }else {
            return null;
        }

    }

    @Override
    public List<Participant> allParticipants() {
        return dao.findAll();
    }

    @Override
    public Participant findById(Integer participantId) {
        return dao.findById(participantId).get();
    }
}
