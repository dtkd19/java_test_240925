package day01;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		 
		String[] fileName = {"spring.java" , "python.py" , "react.jsx" , "css.css" , "String.java" , "component.jsx" , "text.txt"};
		
		// ex: 검색어를 입력받아 fileName 배열에 검색어가 존재하면 해당 파일 이름을 출력
		/* 검색어 : java
		 * spring.java , String.java
		 * 
		 * 검색어 : s
		 * spirng.java, css.css, String.java, react.jsx
		 * 
		 * 검색어 : 가나다
		 * 검색결과가 없습니다.
		 * */
			
		
		Scanner scan = new Scanner(System.in);
		System.out.println("검색어를 입력해주세요");
		String str1 = scan.next();
		int count = 0;
		
		for(String s : fileName ) {
			if(s.toLowerCase().contains(str1.toLowerCase())) {
				System.out.println(s);
				count++;
			}
		}
		if(count == 0) {
			System.out.println("검색결과가 없습니다.");
		}
		
		scan.close();
		
	}

}
