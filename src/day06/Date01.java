package day06;

import java.util.Calendar;
import java.util.Date;

public class Date01 {

	public static void main(String[] args) {
		/* 날짜/시간 클래스 
		 * Date 클래스 => Deprecated(비권장)
		 * Calendar => Date 후속작. 추상클래스  => 객체를 생성할 수 없음.
		 * new 키워드로 객체 생성이 불가능.
		 * getInstance() 메서드를 이용하여 객체를 얻어 옴
		 * 
		 */
		Date d = new Date();
		
		System.out.println(d);
//		d.getDay();
//		d.getDate();
		
		Calendar c = Calendar.getInstance(); // 오늘날짜
		
		System.out.println(c);
		// month 0~11 +1 표현
		
		
		int year = c.get(Calendar.YEAR);
		System.out.println(year);
		
		int month = c.get(Calendar.MONTH)+1;
		System.out.println(month);

		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
	
		int week = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(week);
		System.out.println(year + "-" + month + "-" + day);
		
		// 2024-10-7(월) 오후 3:51
		
		int AP = c.get(Calendar.AM_PM);
		int hour = c.get(Calendar.HOUR);
		int min = c.get(Calendar.MINUTE);
//		int sec = c.get(Calendar.SECOND);
		
		String A_PM = null;
		
		A_PM = (AP == 0) ? "오전" : "오후";
		
		
		String day_of_week = null;
		
		switch (week) {
		case 1: day_of_week = "일"; break;
		case 2: day_of_week = "월"; break;
		case 3: day_of_week = "화"; break;
		case 4: day_of_week = "수"; break;
		case 5: day_of_week = "목"; break;
		case 6: day_of_week = "금"; break;
		case 7: day_of_week = "토"; break;		
		default:
			System.out.println("잘못된 요일입니다.");
		}
		
		System.out.println(year + "-" + month + "-" + day + "(" + day_of_week +") "  + A_PM + " " + hour+":"+ min );
		
	}

}
