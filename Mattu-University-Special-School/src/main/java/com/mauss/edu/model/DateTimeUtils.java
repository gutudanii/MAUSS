package com.mauss.edu.model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String formatLocalDateTime(LocalDateTime dateTime) {
        return dateTime != null ? dateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)) : null;
    }

    public static LocalDateTime parseToLocalDateTime(String dateTimeString) {
        return dateTimeString != null ? LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)) : null;
    }
}

