package org.mitpu.referral.core.repositories.models;

import java.time.LocalDateTime;

public class CandidateParticipation {

    private Integer id;

    private Integer participationId;

    private Integer candidateId;

    private Integer referrerId;

    private Status status;

    private LocalDateTime date;

    public enum Status {
        REQUESTED(0), DONE(1);

        public static Status getStatus(byte value) {
            switch (value) {
                case 0:
                    return REQUESTED;
                case 1:
                    return DONE;
                default:
                    return null;
            }
        }

        public final byte value;

        private Status(int value) {
            this.value = (byte) value;
        }
    }

    public CandidateParticipation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParticipationId() {
        return participationId;
    }

    public void setParticipationId(Integer participationId) {
        this.participationId = participationId;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public Integer getReferrerId() {
        return referrerId;
    }

    public void setReferrerId(Integer referrerId) {
        this.referrerId = referrerId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
