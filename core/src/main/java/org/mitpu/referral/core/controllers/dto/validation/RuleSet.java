package org.mitpu.referral.core.controllers.dto.validation;

import java.util.HashMap;

public class RuleSet {

    public static final HashMap<DtoProperty, Rule> PROPERTY_RULE = new HashMap<>();

    {
        PROPERTY_RULE.put(DtoProperty.ID, new Rule(1, Integer.MAX_VALUE));
        PROPERTY_RULE.put(DtoProperty.FIRSTNAME, new Rule(1, 80));
        PROPERTY_RULE.put(DtoProperty.MIDDLENAME, new Rule(1, 80));
        PROPERTY_RULE.put(DtoProperty.LASTNAME, new Rule(1, 80));
        PROPERTY_RULE.put(DtoProperty.EMAIL, new Rule(1, 100));
        PROPERTY_RULE.put(DtoProperty.PHONE, new Rule(1, 15));
        PROPERTY_RULE.put(DtoProperty.CITY, new Rule(1, 50));
        PROPERTY_RULE.put(DtoProperty.STATE, new Rule(1, 50));
        PROPERTY_RULE.put(DtoProperty.ZIP, new Rule(1, 15));
        PROPERTY_RULE.put(DtoProperty.COUNTRY, new Rule(1, 50));
        PROPERTY_RULE.put(DtoProperty.WORKAUTHORIZATION, new Rule(1, 4));
        PROPERTY_RULE.put(DtoProperty.LINKEDIN, new Rule(1, 200));
        PROPERTY_RULE.put(DtoProperty.STAGE, new Rule(1, 4));
        PROPERTY_RULE.put(DtoProperty.STATUS, new Rule(1, 5));
    }

    public enum DtoProperty {
        ID, FIRSTNAME, MIDDLENAME, LASTNAME, EMAIL, PHONE, CITY, STATE, ZIP, COUNTRY, WORKAUTHORIZATION, LINKEDIN, STAGE, STATUS
    }

    public class Rule {
        public int maxValue;

        public int minValue;

        public Rule(int maxValue, int minValue) {
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }
}
