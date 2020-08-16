package org.mitpu.referral.core.repositories.models;

import java.time.LocalDateTime;

public class Job {

    private Integer id;

    private Integer companyId;

    private Integer candidateId;

    private String position;

    private Type type;

    private LocalDateTime date;

    private Stack stack;

    private String positionLink;

    private String state;

    private String city;

    private String country;

    private Integer referrerId;

    public enum Type {

        INTERNSHIP(0), EXPERIENCED(1);

        public static Type getType(byte code) {
            switch (code) {
                case 0:
                    return INTERNSHIP;
                case 1:
                    return EXPERIENCED;
                default:
                    return null;
            }
        }

        public final byte value;

        private Type(int value) {
            this.value = (byte) value;
        }
    }

    public enum Stack {

        FRONT_END(0), BACK_END(1), FULL_STACK(2), DEV_OPS(3), AUTOMATION(4), TEST(5), DATABASE(6);

        public static Stack getStack(byte code) {
            switch (code) {
                case 0:
                    return FRONT_END;
                case 1:
                    return BACK_END;
                case 2:
                    return FULL_STACK;
                case 3:
                    return DEV_OPS;
                case 4:
                    return AUTOMATION;
                case 5:
                    return TEST;
                case 6:
                    return DATABASE;
                default:
                    return null;
            }
        }

        public final byte value;

        private Stack(int value) {
            this.value = (byte) value;
        }
    }

    public Job() {
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Stack getStack() {
        return stack;
    }

    public void setStack(Stack stack) {
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
