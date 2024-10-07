package day06;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date02 {

	public static void main(String[] args) {
		// LocalDateTime 
		LocalDateTime today = LocalDateTime.now();
		System.out.println(today);
		System.out.println(today.getYear());
		String t = today.toString();
		System.out.println(t);
		String date = t.substring(0, t.indexOf("T"));
		System.out.println(date);
		String time = t.substring(t.indexOf("T")+1,t.indexOf("."));
		System.out.println(time);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		System.out.println(dtf.format(today));
		LocalDateTime sDate = LocalDateTime.of(1998, 10, 18, 3, 30);
		System.out.println(sDate.format(dtf));
	}

}
