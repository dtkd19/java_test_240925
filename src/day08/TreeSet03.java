package day08;

import java.util.Scanner;

public class TreeSet03 {

	public static void main(String[] args) {
		/*
		 * 단어장 프로그램 작성 menu 1.단어등록 | 2.단어검색 | 3.단어수정 | 4.단어출력 | 5.단어삭제|6.종료
		 * WordController 메서드 구현 map을 이용하여 단어 등록 기본단어 등록 ( 5가지 등록 ) main 에서 메뉴 반복처리
		 * 
		 */

		Scanner scan = new Scanner(System.in);

		WordController wc = new WordController();
		
		wc.insertWord();

		int menu = 0;

		while (menu != 6) {
			
			System.out.println("메뉴를 선택해주세요");
			System.out.println("1.단어등록 | 2.단어검색 | 3.단어수정 | 4.단어출력 | 5.단어삭제 |6.종료 >> ");

			menu = scan.nextInt();
			
			switch (menu) {
			case 1:
				wc.addWord(scan);
				break;
			case 2:
				wc.searchWord(scan);
				break;

			case 3:
				wc.modifyWord(scan);
				break;

			case 4:
				wc.printWord();
				break;

			case 5:
				wc.delWord(scan);
				break;
			case 6:
				System.out.println("종료합니다");
				break;
			default:
				System.out.println("잘못된 메뉴를 선택하셨습니다.");
				break;
			}
		}

		scan.close();
	}

}
