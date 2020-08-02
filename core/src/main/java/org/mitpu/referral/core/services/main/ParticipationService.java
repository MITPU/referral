package org.mitpu.referral.core.services.main;

import org.mitpu.referral.core.repositories.ParticipationRepository;
import org.mitpu.referral.core.repositories.models.Participation;
import org.mitpu.referral.core.services.exception.ConflictException;
import org.mitpu.referral.core.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipationService {

    private final static String OBJECT_NAME = "participation";

    private ParticipationRepository participationRepository;

    @Autowired
    public ParticipationService(ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    public Participation getParticipation(Integer id) {
        Participation participation = participationRepository.findById(id);
        if (participation == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        return participation;
    }

    public List<Participation> getParticipations() {
        List<Participation> participationList = participationRepository.findAll();
        if (participationList == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        return participationList;
    }

    public void deleteParticipation(Integer id) {
        Participation participation = participationRepository.findById(id);
        if (participation == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        if (participationRepository.delete(id)) {
            // TODO log
        }
    }

    public Integer createParticipation(Participation participation) {
        Integer newKey = participationRepository.save(participation);
        if (newKey == null) {
            throw new ConflictException(OBJECT_NAME);
        }
        return newKey;
    }
}
