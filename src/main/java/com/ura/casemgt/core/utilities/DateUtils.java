package com.ura.casemgt.core.utilities;

import com.ura.casemgt.core.exception.ErrorCategory;
import com.ura.casemgt.core.exception.ErrorCode;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * @author smallGod
 **/
public final class DateUtils {

    /**
     * Convert Java 8 LocalDateTime to Joda LocalDateTime
     *
     * @param dateTime
     * @return
     */
//    public LocalDateTime convertToLocalDateTime(java.time.LocalDateTime dateTime){
//
//        ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.systemDefault());
//        Instant instant = zonedDateTime.toInstant();
//        long millis = instant.toEpochMilli();
//
//        return new LocalDateTime(millis);
//    }

    /**
     * Convert String date to java8 LocalDateTime
     *
     * @param dateTime
     * @return
     */
    public static LocalDateTime convertToLocalDateTime(String dateTime)
            throws IllegalArgumentException, DateTimeParseException {

        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern(NamedConstants.DATE_TIME_DASH_NO_SECONDS_FORMAT);

        return LocalDateTime.parse(dateTime, formatter);
    }
}