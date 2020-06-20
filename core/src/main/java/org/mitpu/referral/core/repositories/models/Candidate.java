package org.mitpu.referral.core.repositories.models;

public class Candidate extends Person {

    private byte workAuthorization;

    private String linkedin;

    private byte stage;

    private byte status;

    private int coordinatorId;

    public Candidate() {
    }

    public Candidate(byte workAuthorization, String linkedin, byte stage, byte status, int coordinatorId) {
        super();
        this.workAuthorization = workAuthorization;
        this.linkedin = linkedin;
        this.stage = stage;
        this.status = status;
        this.coordinatorId = coordinatorId;
    }

    public byte getWorkAuthorization() {
        return workAuthorization;
    }

    public void setWorkAuthorization(byte workAuthorization) {
        this.workAuthorization = workAuthorization;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public byte getStage() {
        return stage;
    }

    public void setStage(byte stage) {
        this.stage = stage;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public int getCoordinatorId() {
        return coordinatorId;
    }

    public void setCoordinatorId(int coordinatorId) {
        this.coordinatorId = coordinatorId;
    }
}
