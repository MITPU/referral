package org.mitpu.referral.core.controllers.dto;

public class JobDto {

    private Integer id;

    private Integer companyId;

    private Integer candidateId;

    private String position;

    private Byte type;

    private String date;

    private Byte stack;

    private String positionLink;

    private String state;

    private String city;

    private String country;

    private Integer referrerId;

    public JobDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Byte getStack() {
        return stack;
    }

    public void setStack(Byte stack) {
        this.stack = stack;
    }

    public String getPositionLink() {
        return positionLink;
    }

    public void setPositionLink(String positionLink) {
        this.positionLink = positionLink;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getReferrerId() {
        return referrerId;
    }

    public void setReferrerId(Integer referrerId) {
        this.referrerId = referrerId;
    }
}
