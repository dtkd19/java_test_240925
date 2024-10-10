package day08;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class MapEx01 {

	public static void main(String[] args) {
		/* 단어장
		 * 단어 5개를 입력받아 콘솔에 출력하는 기능
		 * -- 단어장 -- 
		 * hello : 안녕
		 * apple : 사과
		 * orange : 오렌지
		 * map 저장 후 출력 
		 */
		
		int size = 5;
		
		Scanner scan = new Scanner(System.in);
		
		
		Map<String, String> map = new HashMap<>();
		
		String str1 = null;
		String str2 = null;
		
		
		for(int i =0; i < size; i++) {
			System.out.println("단어와 뜻을 입력해주세요");
			// 공백허용 scan.nextLine();
			// enter 콘솔입력시 완료 
			// nextLine() : enter값으로 인지하는 케이스는 
			// 다른 입력값 -> nextLine() 이 오는 케이스 
			str1 = scan.nextLine();
			str2 = scan.nextLine();
			
			map.put(str1, str2);
		}
		System.out.println(" -- 단어장 --");
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + " : " + map.get(key));
		}
		
		scan.close();
		
	}

}
