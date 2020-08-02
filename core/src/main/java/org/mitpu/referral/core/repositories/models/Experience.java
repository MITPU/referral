package org.mitpu.referral.core.repositories.models;

import java.time.LocalDateTime;

public class Experience {

    private Integer id;

    private String institution;

    private String title;

    private Status status;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer candidateId;

    public enum Status {

        CURRENT(0), PAST(1);

        public final byte status;

        private Status(int status) {
            this.status = (byte) status;
        }
    }

    public Experience() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }
}
