package com.hcl.db.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

	public static Date convertStringToDate(String date, String formatter) {
		return null;
	}

	public static LocalDate convertStringToLocalDate(String date, String formatter) {
		DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern(formatter);
		return LocalDate.parse(date, dtFormatter);
	}

	public static String convertDateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	public static String convertLocalDateToString(LocalDate date) {
		return null;
	}

	public static Date convertLongToDate(Long date) {
		return null;
	}

	public static Long convertDateToLong(Date date) {
		return null;
	}
}
