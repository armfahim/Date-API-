package com.date.API;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class Conversion {

	// String d1 = new SimpleDateFormat("yyyy-MM-dd").format(date);

	public static LocalDate convertCalendarToLocalDate(Calendar c) {
		Date date = c.getTime();
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static LocalTime convertCalendarToLocalTime(Calendar c) {
		Date date = c.getTime();
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
	}

	public static LocalDateTime convertCalendarToLocalDateTime(Calendar c) {
		Date date = c.getTime();
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

	}

	public static ZonedDateTime convertCalendarToZonedTime(Calendar c, ZoneId id) {
		// ZoneId id = ZoneId.of("Asia/Tokyo");

		ZonedDateTime zonedDateTime = ZonedDateTime.of(convertCalendarToLocalDateTime(c), id);

		return zonedDateTime;

	}

	public static OffsetDateTime convertDateToOffsetDateTime(Calendar c, ZoneOffset offset) {

		OffsetDateTime offsetDateTime = OffsetDateTime.of(convertCalendarToLocalDateTime(c), offset);

		return offsetDateTime;
	}

	public static int usingCalenderToFetchMonthDay(Calendar c) {
		return convertCalendarToLocalDateTime(c).getDayOfMonth();
	}

	public static Period usingClaendarToFindPeriod(LocalDate d1, LocalDate d2) {

		Period p = Period.between(d1, d2);

		return p;

	}

	public static Date convertLocalDateToDate(LocalDate date) {
		return Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

	}

	public static Date convertDateToLocalTime(LocalDateTime dateTime) {

		Date in = new Date();
		dateTime = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
		Date date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
		return date;

	}

	public static Date convertStringToDate(String string) throws Exception {
		DateFormat format = new SimpleDateFormat("MM/dd/yy");
		Date date = format.parse(string);
		return date;

	}

}
