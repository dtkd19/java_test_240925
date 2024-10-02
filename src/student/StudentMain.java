package student;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		/*
		 * 메뉴처리 1.학생등록 | 2.학생리스트출력 | 3.학생검색(학생정보, 수강정보) | 4.학생정보수정 | 5.학생삭제 | 6.수강신청 |
		 * 7.수강철회 | 8.종료
		 */

		StudentController sc = new StudentController();

		Scanner scan = new Scanner(System.in);

		int menu = 0;

		do {

			// 메뉴를 받을 때 필요, 상품을 받을 때 필요
			// 스캐너를 매개변수로 전달
			System.out.println(
					"메뉴를 선택해주세요 1.학생등록 | 2.학생리스트출력 | 3.학생검색(학생정보, 수강정보) | 4.학생정보수정 | 5.학생삭제 | 6.수강신청 | 7.수강철회 | 8.종료 ");
			System.out.println("menu >> ");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				sc.insertStudent(scan);
				break;
			case 2:
				sc.printStudent();
				break;
			case 3:
				sc.searchStudent(scan);
				break;
			case 4:
				sc.modifyStudent(scan);
				break;
			case 5:
				sc.deleteStudent(scan);
				break;
			case 6:
				sc.registerSubject(scan);
				break;
			case 7:
				sc.deleteSubject(scan);
				break;
			case 8:
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");

			}

		} while (menu != 8);
	}

}
