package org.mitpu.referral.core.repositories.models;

public class ReferrerParticipation {

    private Integer id;

    private Integer participationId;

    private Integer referrerId;

    public ReferrerParticipation() {
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

    public Integer getReferrerId() {
        return referrerId;
    }

    public void setReferrerId(Integer referrerId) {
        this.referrerId = referrerId;
    }
}
