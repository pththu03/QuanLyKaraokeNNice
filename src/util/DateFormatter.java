package util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class DateFormatter {
	public static String format(LocalDate date) {
		String day = String.valueOf(date.getDayOfMonth());
		String month = String.valueOf(date.getMonthValue());
		String year = String.valueOf(date.getYear());
		if (date.getDayOfMonth() < 10) {
			day = "0" + day;
		}

		if (date.getMonthValue() < 10) {
			month = "0" + month;
		}

		return day + "/" + month + "/" + year;
	}

	public static String format(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		String formattedDate = dateFormat.format(date);
		return formattedDate;
	}

	public static String format(java.util.Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		String formattedDate = dateFormat.format(date);
		return formattedDate;
	}
}
