package org.mitpu.referral.core.repositories.database;

import org.mitpu.referral.core.services.exception.ConflictException;
import org.mitpu.referral.core.services.exception.ParentNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBConstants {

    public static final HashMap<Column, ValueRange> VALUE_CONSTRAINTS = new HashMap<>();

    public static final List<DBConstraint> CONSTANTS_LIST = new ArrayList<>();

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
        VALUE_CONSTRAINTS.put(Column.ABOUT, new ValueRange(1, 500));
        VALUE_CONSTRAINTS.put(Column.DATE, new ValueRange(1, 19));

        // setting unique constraints
        HashMap<String, String> uniqueConstraintModel = new HashMap<>();
        uniqueConstraintModel.put("linkedin_UNIQUE", "linkedin");
        uniqueConstraintModel.put("phone_UNIQUE", "phone");
        uniqueConstraintModel.put("email_UNIQUE", "email");
        uniqueConstraintModel.put("skill_UNIQUE", "skill");
        uniqueConstraintModel.put("name_UNIQUE", "participation");
        uniqueConstraintModel.put("careerlink_UNIQUE", "career link");

        // setting foreign constraints
        HashMap<String, String> foreignConstraintModel = new HashMap<>();
        foreignConstraintModel.put("(`candidate_id`) REFERENCES `candidate` (`id`)", "candidate");
        foreignConstraintModel.put("(`participation_id`) REFERENCES `candidate` (`id`)", "participation");
        foreignConstraintModel.put("(`skill_id`) REFERENCES `skill` (`id`)", "skill");
        foreignConstraintModel.put("(`referrer_id`) REFERENCES `referrer` (`id`)", "referrer");
        foreignConstraintModel.put("(`company_id`) REFERENCES `company` (`id`)", "company");
        foreignConstraintModel.put("(`coordinator_id`) REFERENCES `coordinator` (`id`)", "coordinator");

        //
        CONSTANTS_LIST.add(new DBConstraint("^(.+)FOREIGN\\sKEY\\s(.+)\\sON\\sDELETE\\sCASCADE\\sON\\sUPDATE\\sCASCADE\\)$", 2, foreignConstraintModel, ParentNotFoundException.class));
        CONSTANTS_LIST.add(new DBConstraint("^(.+)Duplicate entry\\s(.+)\\sfor key\\s'(.+)';(.+)$", 3, uniqueConstraintModel, ConflictException.class));
    }

    public enum Column {
        ID, FIRSTNAME, MIDDLENAME, LASTNAME, EMAIL, PHONE, CITY, STATE, ZIP, COUNTRY, WORKAUTHORIZATION, LINKEDIN, STAGE, STATUS, COORDINATOR_ID, SKILL, PARTICIPATION, COMM_METHOD, REFER_METHOD, DIALOG, COMMENT, DESCRIPTION, TITLE, INSTITUTION, NAME, CAREER_LINK, INDUSTRY, POSITION_LINK, POSITION, ABOUT, DATE,
    }
}
