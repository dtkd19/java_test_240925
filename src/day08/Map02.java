package day08;

import java.util.HashMap;
import java.util.Scanner;

public class Map02 {

	public static void main(String[] args) {
		/* 과목과 점수를 입력받아 (Scanner) map에 저장 후 출력
		 * 합계, 평균 출력
		 * 종료 키워드가 나올 때까지 반복 ( 1 = 계속, 0 = 종료 )
		 * 과목/점수 입력 > 국어 78 
		 * 1= 계속 , 0= 종료 > 1
		 * 영어 98
		 * ... 반복
		 * 
		 */
		
		Scanner scan = new Scanner(System.in);
		
		int end;
		String subject = null;
		int point = 0;
		int sum = 0;
		double avg = 0;
		
		HashMap<String, Integer> map = new HashMap<>();
		
		while(true) {
			
			System.out.println(" 1 = 계속, 0 = 종료  선택 >> ");
			end = scan.nextInt();
			
			if(end == 0 ) {
				System.out.println("종료합니다.");
				break;
			}
				
			System.out.println("과목/점수 입력 >> ");
			subject = scan.next();
			point = scan.nextInt();
			
			map.put(subject, point);
			
			sum += map.get(subject);
			avg = (double)sum / map.size();	
			
		}
		System.out.println(map);
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		
		scan.close();
		
	}

}
