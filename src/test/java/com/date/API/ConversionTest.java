package com.date.API;

import static org.junit.Assert.*;

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

import org.junit.Test;

import com.date.API.Conversion;

public class ConversionTest {

	@Test
	public void testConvertCalendarToLocalDate() {
		Calendar c = Calendar.getInstance();
		c.set(2019, Calendar.JANUARY, 1);
		LocalDate ld = LocalDate.of(2019, 1, 1);
		LocalDate ld1 = LocalDate.now();
		assertEquals(ld, Conversion.convertCalendarToLocalDate(c));
		assertNotEquals(ld1, Conversion.convertCalendarToLocalDate(c));
		
	}

	@Test
	public void testConvertCalendarToLocalTime() {
		Calendar c = Calendar.getInstance();
		int hour = LocalTime.now().getHour();
		int minute = LocalTime.now().getMinute();
		assertEquals(hour, Conversion.convertCalendarToLocalTime(c).getHour());
		assertEquals(minute, Conversion.convertCalendarToLocalTime(c).getMinute());
	}

	@Test
	public void testConvertCalendarToLocalDateTime() {
		Calendar c = Calendar.getInstance();
		LocalDateTime ldt1 = LocalDateTime.now();
		assertEquals(ldt1.getYear(), Conversion.convertCalendarToLocalDateTime(c).getYear());
		assertEquals(ldt1.getMonth(), Conversion.convertCalendarToLocalDateTime(c).getMonth());
		assertEquals(ldt1.getDayOfMonth(), Conversion.convertCalendarToLocalDateTime(c).getDayOfMonth());
		assertEquals(ldt1.getHour(), Conversion.convertCalendarToLocalDateTime(c).getHour());
		assertEquals(ldt1.getMinute(), Conversion.convertCalendarToLocalDateTime(c).getMinute());
	}

	@Test
	public void testConvertCalendarToZonedTime() {
		ZoneId zid = ZoneId.of("Asia/Dhaka");
		Calendar cal = Calendar.getInstance();
		ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zid);
		assertEquals(zonedDateTime.getHour(), Conversion.convertCalendarToZonedTime(cal, zid).getHour());
		assertEquals(zonedDateTime.getMinute(), Conversion.convertCalendarToZonedTime(cal, zid).getMinute());
	}

	@Test
	public void testConvertDateToOffsetDateTime() {
		Calendar c = Calendar.getInstance();
		ZoneOffset offset = ZoneOffset.ofHoursMinutes(1, 30);
		OffsetDateTime dateTime = OffsetDateTime.of(LocalDateTime.of(2017, 05, 12, 05, 45),
				ZoneOffset.ofHoursMinutes(6, 30));
		assertNotEquals(dateTime, Conversion.convertDateToOffsetDateTime(c, offset));
	}

	@Test
	public void testUsingCalenderToFetchMonthDay() {
		Calendar c = Calendar.getInstance();
		c.set(2019, Calendar.JANUARY, 3);
		LocalDate ld = LocalDate.of(2019, 1, 3);
		assertEquals(ld.getDayOfMonth(), Conversion.usingCalenderToFetchMonthDay(c));
	}

	@Test
	public void testUsingClaendarToFindPeriod() {
		LocalDate ld1 = LocalDate.of(2019, 1, 16);
		LocalDate ld2 = LocalDate.of(1895, 1, 16);
		Period p = Period.between(ld2, ld1);
		assertEquals(p.getYears(), Conversion.usingClaendarToFindPeriod(ld2, ld1).getYears());
	}

	@Test
	public void testConvertLocalDateToDate() throws Exception {
		Calendar c = Calendar.getInstance();
		String string = "1/16/2019";
		Date d1 = Conversion.convertStringToDate(string);
		LocalDate ld2 = LocalDate.of(2019, 1, 16);

		assertEquals(d1, Conversion.convertLocalDateToDate(ld2));
	}

//	@Test
//	public void testConvertDateToLocalTime() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testConvertLocalToDate() {
//		fail("Not yet implemented");
//	}

}
