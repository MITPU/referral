package org.mitpu.referral.core.repositories.database;

import java.util.HashMap;

public class DBConstants {

    public static final HashMap<Column, ValueRange> VALUE_CONSTRAINTS = new HashMap<>();

    public static final HashMap<String, String> UNIQUE_CONSTRAINTS = new HashMap<>();

    static {
        // setting value constraints
        VALUE_CONSTRAINTS.put(Column.ID, new ValueRange(1, Integer.MAX_VALUE));
        VALUE_CONSTRAINTS.put(Column.FIRSTNAME, new ValueRange(1, 80));
        VALUE_CONSTRAINTS.put(Column.MIDDLENAME, new ValueRange(1, 80));
        VALUE_CONSTRAINTS.put(Column.LASTNAME, new ValueRange(1, 80));
        VALUE_CONSTRAINTS.put(Column.EMAIL, new ValueRange(1, 100));
        VALUE_CONSTRAINTS.put(Column.PHONE, new ValueRange(1, 15));
        VALUE_CONSTRAINTS.put(Column.CITY, new ValueRange(1, 50));
        VALUE_CONSTRAINTS.put(Column.STATE, new ValueRange(1, 50));
        VALUE_CONSTRAINTS.put(Column.ZIP, new ValueRange(1, 15));
        VALUE_CONSTRAINTS.put(Column.COUNTRY, new ValueRange(1, 50));
        VALUE_CONSTRAINTS.put(Column.WORKAUTHORIZATION, new ValueRange(0, 4));
        VALUE_CONSTRAINTS.put(Column.LINKEDIN, new ValueRange(1, 200));
        VALUE_CONSTRAINTS.put(Column.STAGE, new ValueRange(0, 4));
        VALUE_CONSTRAINTS.put(Column.STATUS, new ValueRange(0, 5));
        VALUE_CONSTRAINTS.put(Column.SKILL, new ValueRange(1, 50));
        VALUE_CONSTRAINTS.put(Column.PARTICIPATION, new ValueRange(1, 100));
        VALUE_CONSTRAINTS.put(Column.COMM_METHOD, new ValueRange(1, 100));
        VALUE_CONSTRAINTS.put(Column.REFER_METHOD, new ValueRange(1, 100));
        VALUE_CONSTRAINTS.put(Column.DIALOG, new ValueRange(1, 1000));
        VALUE_CONSTRAINTS.put(Column.COMMENT, new ValueRange(1, 1000));
        VALUE_CONSTRAINTS.put(Column.DESCRIPTION, new ValueRange(1, 100));
        VALUE_CONSTRAINTS.put(Column.TITLE, new ValueRange(1, 100));
        VALUE_CONSTRAINTS.put(Column.INSTITUTION, new ValueRange(1, 50));
        VALUE_CONSTRAINTS.put(Column.NAME, new ValueRange(1, 100));
        VALUE_CONSTRAINTS.put(Column.CAREER_LINK, new ValueRange(1, 200));
        VALUE_CONSTRAINTS.put(Column.INDUSTRY, new ValueRange(1, 100));
        VALUE_CONSTRAINTS.put(Column.POSITION, new ValueRange(1, 100));
        VALUE_CONSTRAINTS.put(Column.POSITION_LINK, new ValueRange(1, 200));

        // setting value constraints
        UNIQUE_CONSTRAINTS.put("linkedin_UNIQUE", "linkedin");
        UNIQUE_CONSTRAINTS.put("phone_UNIQUE", "phone");
        UNIQUE_CONSTRAINTS.put("email_UNIQUE", "email");
        UNIQUE_CONSTRAINTS.put("skill_UNIQUE", "skill");
        UNIQUE_CONSTRAINTS.put("name_UNIQUE", "participation");
        UNIQUE_CONSTRAINTS.put("careerlink_UNIQUE", "career link");
    }

    public enum Column {
        ID, FIRSTNAME, MIDDLENAME, LASTNAME, EMAIL, PHONE, CITY, STATE, ZIP, COUNTRY, WORKAUTHORIZATION, LINKEDIN, STAGE, STATUS, COORDINATOR_ID, SKILL, PARTICIPATION, COMM_METHOD, REFER_METHOD, DIALOG, COMMENT, DESCRIPTION, TITLE, INSTITUTION, NAME, CAREER_LINK, INDUSTRY, POSITION_LINK, POSITION,
    }
}
