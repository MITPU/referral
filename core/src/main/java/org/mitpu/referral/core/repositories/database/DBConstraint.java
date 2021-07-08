package org.mitpu.referral.core.repositories.database;

import org.mitpu.referral.core.services.exception.ReferralException;

import java.util.HashMap;

public class DBConstraint {

    private final String regexPattern;
    private final Integer regexGroup;
    private final HashMap<String, String> constraintModelMap;
    private Class<? extends ReferralException> exceptionClass;

    public DBConstraint(String regexPattern, Integer regexGroup, HashMap<String, String> constraintModelMap, Class<? extends ReferralException> exceptionClass) {
        this.regexPattern = regexPattern;
        this.regexGroup = regexGroup;
        this.constraintModelMap = constraintModelMap;
        this.exceptionClass = exceptionClass;
    }

    public String getRegexPattern() {
        return regexPattern;
    }

    public Integer getRegexGroup() {
        return regexGroup;
    }

    public HashMap<String, String> getConstraintModelMap() {
        return constraintModelMap;
    }

    public Class<? extends ReferralException> getExceptionClass() {
        return exceptionClass;
    }
}
