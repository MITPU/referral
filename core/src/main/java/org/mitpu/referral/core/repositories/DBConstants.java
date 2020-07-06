package org.mitpu.referral.core.repositories;

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

        // setting value constraints
        UNIQUE_CONSTRAINTS.put("linkedin_UNIQUE", "linkedin");
        UNIQUE_CONSTRAINTS.put("phone_UNIQUE", "phone");
        UNIQUE_CONSTRAINTS.put("email_UNIQUE", "email");
    }

    public enum Column {
        ID, FIRSTNAME, MIDDLENAME, LASTNAME, EMAIL, PHONE, CITY, STATE, ZIP, COUNTRY, WORKAUTHORIZATION, LINKEDIN, STAGE, STATUS, COORDINATOR_ID
    }
}
