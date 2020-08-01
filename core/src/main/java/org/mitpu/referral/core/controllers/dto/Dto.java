package org.mitpu.referral.core.controllers.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Dto {

    @JsonIgnore
    private transient String objectName;

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
}
