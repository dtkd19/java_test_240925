package day01;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		/*
		 * Scanner 클래스 : 콘솔에서 값을 입력받을 때 사용 (int)(Math.random()*개수) + 시작 : 시작값부터 개수만큼 정숭형
		 * 랜덤 값 생성
		 */
		// 값을 입력받으려면 Scanner scan = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);

		// 랜덤으로 주사위를 굴려 총 30칸을 이동하시오.
		// 주사위 던진 횟수를 출력.
		/*
		 * 주사위 게임. 주사위는 Enter를 치면 던져짐. 주사위 : 3 3칸 전진 => 27칸 남음 ... 도착 !! 총 던진횟수 => ??
		 */

		int count = 0;
		int sum = 0;
		int end = 30;
		int random = 0;

		while (true) {
			if (sum >= end) {
				System.out.println("도착 !! 총 던진횟수 => " + count);
				break;
			}
			System.out.println("주사위를 굴려주세요 => Enter");
			scan.nextLine();
			count++;
			random = (int) (Math.random() * 6) + 1;
			sum += random;
			System.out.printf("%d칸 전진 => %d칸 남음", random, (end - sum >= 0) ? end - sum : 0);
			System.out.println();
		}

		scan.close();
	}

}
