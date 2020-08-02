package org.mitpu.referral.core.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    private static final DateTimeFormatter SIMPLE_DATETIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String dateTimeToString(LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.format(dateTimeFormatter);
    }

    public static LocalDateTime stringToDateTime(String localDateTime, DateTimeFormatter dateTimeFormatter) {
        if (localDateTime == null) {
            return null;
        }
        return LocalDateTime.parse(localDateTime, dateTimeFormatter);
    }

    public static String dateTimeToString(LocalDateTime localDateTime) {
        return dateTimeToString(localDateTime, SIMPLE_DATETIME_FORMAT);
    }

    public static LocalDateTime stringToDateTime(String localDateTime) {
        return stringToDateTime(localDateTime, SIMPLE_DATETIME_FORMAT);
    }

}
