package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Helpers {
	public static LocalDate StringToDate(String dateString)
	{
		String pattern = "yyyy-MM-dd";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		formatter = formatter.withLocale( Locale.ENGLISH );  
		return LocalDate.parse(dateString, formatter);
	}
}
