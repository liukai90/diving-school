package com.drs.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	
	public static String dateToString(Date date){
		
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

}
