package jdbcStudent;

import java.util.List;
import java.util.Scanner;

public class StudentController {
	
	private Scanner scan;
	private Service svc;
	private boolean on;
	
	StudentController() {
		scan = new Scanner(System.in);
		svc = new StuSvcImpl();
		on = true;
		printStuMenu();	
	}

	private void printStuMenu() {
		
		System.out.println(" -- 학생관리 프로그램 --");
	
		while(on) {
			System.out.println(" 1. 학생등록 | 2. 학생리스트 | 3. 학생검색(내정보보기) | 4. 내정보수정 | 5. 학생삭제 | 6. 종료 ");
			System.out.println(" menu 선택 >> ");
			int menu = scan.nextInt();
			
			switch (menu) {
			case 1:
				insert();
				break;
			case 2:
				list();
				break;
			case 3:
				search();
				break;
			case 4:
				modify();
				break;
			case 5:
				delete();
				break;
			case 6:
				on = false;
				System.out.println("종료합니다.");
				break;

			default:
				System.out.println("잘못된 메뉴를 선택하셨습니다.");
				break;
			}
			
		
		}
		

		
		
		
	}

	private void delete() {
		
		System.out.println(" 삭제할 학생의 고유번호를 입력해주세요. ");
		int no = scan.nextInt();
			
		int pass = svc.delete(no);
		System.out.println("학생정보 수정 > "+ ( (pass > 0) ? "성공" : "실패" ));
		
	}

	private void modify() {
		System.out.println(" 수정할 학생의 고유번호를 입력해주세요.");
		int no = scan.nextInt();
		System.out.println(" 학생의 수정 정보를 입력합니다. ");
		System.out.println("학번 >> ");
		String s_no = scan.next();
		System.out.println("이름 >> ");
		String s_name = scan.next();
		System.out.println("생년월일 >> ");
		String s_btday = scan.next();
		System.out.println("전화번호 >> ");
		String s_tel = scan.next();
		scan.nextLine();
		System.out.println("주소 >> ");
		String s_addr = scan.nextLine();
		
		Student s = new Student(no , s_no , s_name, s_btday, s_tel , s_addr);
		
		int pass = svc.update(s);
		System.out.println("학생정보 수정 > "+ ( (pass > 0) ? "성공" : "실패" ));
		
		
		
	}

	private void search() {
		
		System.out.println(" 정보를 찾을 학생의 고유번호를 입력해주세요.");
		int no = scan.nextInt();
		
		Student s = svc.getInfo(no);
		
		System.out.println(s);
		
	}

	private void list() {
		
		List<Student> list = svc.getList();
		
		
		for (Student l : list) {
			l.printStudentList();
		}
		
		
	}

	private void insert() {
		
		System.out.println("등록 할 학생의 정보를 입력해주세요.");
		System.out.println("학번 >> ");
		String s_no = scan.next();
		System.out.println("이름 >> ");
		String s_name = scan.next();
		System.out.println("생년월일 >> ");
		String s_btday = scan.next();
		System.out.println("전화번호 >> ");
		String s_tel = scan.next();
		scan.nextLine();
		System.out.println("주소 >> ");
		String s_addr = scan.nextLine();
		
		Student s = new Student(s_no , s_name, s_btday, s_tel , s_addr);
		
		int pass = svc.insert(s);
		System.out.println("학생등록 > "+ ( (pass > 0) ? "성공" : "실패" ));
		
	}
	

}
