package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dates {
	private static SimpleDateFormat sdfDateTime = new SimpleDateFormat("HH:MM MMM dd, YYYY");
	public static String formatDateTime(Date date){
		return sdfDateTime.format(date);
	}
}
