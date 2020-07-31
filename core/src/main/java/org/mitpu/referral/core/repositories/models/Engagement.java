package org.mitpu.referral.core.repositories.models;

import java.time.LocalDateTime;

public class Engagement {

    private Integer id;

    private Type type;

    private String dialog;

    private LocalDateTime date;

    private LocalDateTime expireDate;

    private Integer candidateId;

    private Integer coordinatorId;

    public enum Type {

        SMS(0), EMAIL(1), CALL(2), APPOINTMENT(3);

        public final byte type;

        private Type(int type) {
            this.type = (byte) type;
        }
    }

    public Engagement() {
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public Integer getCoordinatorId() {
        return coordinatorId;
    }

    public void setCoordinatorId(Integer coordinatorId) {
        this.coordinatorId = coordinatorId;
    }
}
