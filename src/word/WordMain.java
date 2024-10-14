package word;

import java.io.IOException;
import java.util.Scanner;

public class WordMain {

	public static void main(String[] args) throws IOException {
		/* 단어장 프로그램
		 * 1.단어등록 | 2.단어검색 | 3.단어수정 | 4.단어출력 | 5.단어삭제 | 6.단어파일로출력 | 7.종료
		 * Word class 생성
		 * - 단어, 뜻 (list <String>)
		 * 
		 *  Word (equals 사용) : 단어가 같으면 같은 객체
		 */
		
		Scanner scan = new Scanner(System.in);

		WordController wc = new WordController();
		
		int menu = -1;

		while (menu != 7) {
			
			System.out.println("메뉴를 선택해주세요");
			System.out.println("1.단어등록 | 2.단어검색 | 3.단어수정 | 4.단어출력 | 5.단어삭제 | 6.단어파일로 출력 | 7.종료 >> ");

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
				wc.filePrint();
				break;
			case 7:
				System.out.println("종료하겠습니다.");
				break;
			default:
				System.out.println("잘못된 메뉴를 선택하셨습니다.");
				break;
			}
		}

		scan.close();
		
		

	}

}
