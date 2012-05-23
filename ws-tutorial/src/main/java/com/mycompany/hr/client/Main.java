package com.mycompany.hr.client;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws Exception {
		
		HolidayRequestClient holidayRequestClient = new HolidayRequestClient();

		String url = "http://localhost:8080/ws-tutorial/services";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = dateFormat.parse("2008-08-01");
		Date endDate = dateFormat.parse("2008-08-31");
		
		holidayRequestClient.bookHoliday(url, startDate, endDate, 1, "William", "Nicholson");
		
		System.exit(0);
	}
	
}
