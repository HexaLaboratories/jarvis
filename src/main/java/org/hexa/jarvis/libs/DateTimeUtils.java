package org.hexa.jarvis.libs;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    public static ZonedDateTime parse(String dateTime, String format, ZoneId inputZone, ZoneId targetZone) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, formatter);
        ZonedDateTime zonedInput = ZonedDateTime.of(localDateTime, inputZone);
        return zonedInput.withZoneSameInstant(targetZone);
    }

    public static ZonedDateTime parse(String dateTime, ZoneId inputZone, ZoneId targetZone) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
        ZonedDateTime zonedInput = ZonedDateTime.of(localDateTime, inputZone);
        return zonedInput.withZoneSameInstant(targetZone);
    }

    public static ZonedDateTime parse(String dateTime, String format, ZoneId targetZone) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, formatter);
        ZonedDateTime zonedInput = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        return zonedInput.withZoneSameInstant(targetZone);
    }

    public static ZonedDateTime parse(String dateTime, ZoneId targetZone) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
        ZonedDateTime zonedInput = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        return zonedInput.withZoneSameInstant(targetZone);
    }
}
