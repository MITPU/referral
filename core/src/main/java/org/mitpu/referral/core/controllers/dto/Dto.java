package org.mitpu.referral.core.controllers.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class Dto {

    @JsonIgnore
    private final transient String reqID = UUID.randomUUID().toString();

    @JsonIgnore
    private final transient String objectName;

    public Dto(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getReqID() {
        return reqID;
    }
}
