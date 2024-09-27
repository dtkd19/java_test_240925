package day02;

import java.util.Scanner;

public class MethodEx01 {
	

	public static void main(String[] args) {
		/*
		 * 계산기 만들기
		 * -- menu -- 
		 * 1. 덧셈 | 2. 뺄셈 | 3. 곱셈 | 4. 나눗셈 | 5. 나머지 | 6. 종료
		 * > 메뉴선택 1
		 * > 숫자입력 : 1, 5
		 * 결과 : 1+5 = 6 
		 * (더하기 메서드를 호출하여 연산결과를 출력)
		 * 4,5번은 두번째 숫자가 이면 0으로 나눌 수 없습니다.
		 */
		
		// 기존에 다른 클래스에서 만든 메서드를 호출
		Method02 m2 = new Method02();
		
		Scanner scan = new Scanner(System.in);
		
		
		while(true) {
			System.out.println(" 메뉴를 선택해주세요 ");
			System.out.println(" 1. 덧셈 | 2. 뺄셈 | 3. 곱셈 | 4. 나눗셈 | 5. 나머지 | 6. 종료 ");
			int menu = scan.nextInt();
			if(menu == 6) {
				System.out.println("계산기를 종료합니다.");
				break;
			}
			if(menu <= 5 && menu >0) {
				System.out.println( " 두 수를 입력해주세요. ");
				int num1 = scan.nextInt();
				int num2 = scan.nextInt();
				
				switch(menu) {
				case 1 :
					m2.sum(num1,num2);
					break;
				case 2 :
					m2.sub(num1, num2);
					break;
				case 3 :
					m2.mul(num1, num2);
					break;
				case 4:
					m2.div(num1, num2);
					break;
				case 5:
					m2.mod(num1, num2);
					break;
				}
			} else {
				System.out.println("잘못된 메뉴를 선택하셨습니다 다시 선택해주세요.");
			}
			
		}
			
		scan.close();
	}

}
