package day01;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		// 배열 : 같은 타입, 같은 의미를 가지는 변수들의 집합 ( 참조 변수 )
		// 타입 배열명[] = new 타입[개수];
		// String 워낙 자주 사용하는 참조 변수 => 일반 지역변수처럼 사용
		// 지역변수는 초기값이 없음. (안정해주면 에러가 남.)
		// 참조변수는 처기값이 있음. (숫자는 0, 문자는 null)

		int arr[] = new int[5];

		// arr 배열에 숫자를 1,2,3,4,5 로 채우고 출력

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		System.out.println("---------------");

		/*
		 * 5자리 숫자를 입력받아서 각자리의 합을 출력 입력값 => 12345 출력 => 1+2+3+4+5 = ?? 출력 => 5+4+3+2+1 =
		 * ??
		 */
		Scanner scan = new Scanner(System.in);

		System.out.println(" 숫자 5자리를 입력 해주세요 ");
		String str1 = scan.next();
		String[] num1 = str1.split("");
		int sum = 0;

		for (int i = 0; i < num1.length - 1; i++) {
			sum += Integer.parseInt(num1[i]);
			System.out.print(num1[i] + "+");
		}
		sum += Integer.parseInt(num1[num1.length - 1]);
		System.out.println(num1[num1.length - 1] + " = " + sum);

		int sum2 = 0;
		for (int i = num1.length - 1; i > 0; i--) {
			sum2 += Integer.parseInt(num1[i]);
			System.out.print(num1[i] + "+");
		}
		sum2 += Integer.parseInt(num1[0]);
		System.out.println(num1[0] + " = " + sum2);
		
		scan.close();

	}

}
