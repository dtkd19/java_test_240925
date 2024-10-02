package student;

import java.util.Scanner;

public class StudentController implements Program {

	// 멤버변수 추가

	private Student[] s = new Student[10];
	private int cnt = 0;

	@Override
	public void insertStudent(Scanner scan) {
		if (cnt == s.length) {
			// 5개 더 많은 길이의 배열을 생성
			Student[] tmp = new Student[s.length + 5];
			// 배열 복사 기존배열의 0 번지부터 새배열으ㅏ 0번지부터 복사 cnt 개수만큼
			System.arraycopy(s, 0, tmp, 0, cnt);
			s = tmp;
		}

		System.out.println("학번,이름,나이,전화번호,주소를 순서대로 입력해주세요");
		String st_num = scan.next();
		String st_name = scan.next();
		int st_age = scan.nextInt();
		String st_tel = scan.next();
		String st_home = scan.next();

		Student st = new Student();

		st.insertSt(st_num, st_name, st_age, st_tel, st_home);
		st.setNumber(cnt + 1);

		s[cnt] = st;

		cnt++;

	}

	@Override
	public void printStudent() {
		if (cnt == 0) {
			System.out.println("학생이 없습니다. 추가해주세요");
		} else {
			for (int i = 0; i < cnt; i++) {
				System.out.println(s[i]);
			}
		}

	}

	@Override
	public void deleteStudent(Scanner scan) {
		System.out.println("삭제할 학생명을 입력해주세요");
		String delName = scan.next();

		int index = -1; // 없는 번지를 기본값으로 설정

		for (int i = 0; i < cnt; i++) {
			if (s[i].getSt_name().equals(delName)) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			System.out.println("해당 학생이 목록에 없습니다.");
		}

		int copyCnt = s.length - index - 1;
		System.arraycopy(s, index + 1, s, index, copyCnt);

		s[cnt - 1] = null;
		cnt--;

		printStudent();
	}

	public void deleteStudent2(Scanner scan) {
		System.out.println("삭제할 학생명을 입력해주세요");
		String delName = scan.next();

		boolean found = false;

		for (int i = 0; i < cnt; i++) {
			if (s[i].getSt_name().equals(delName)) {
				for (int j = i; j < cnt - 1; j++) {
					s[j] = s[j + 1];
					s[j].setNumber(j + 1);
				}
				s[cnt - 1] = null;
				cnt--;
				found = true;
				break;
			}

		}

		if (!found) {
			System.out.println("해당 학생이 목록에 없습니다.");
		}

		printStudent();
	}

	@Override
	public void modifyStudent(Scanner scan) {
		System.out.println("수정할 학생명을 입력해주세요");
		String modifyName = scan.next();
		boolean found = false;

		for (int i = 0; i < cnt; i++) {
			if (s[i].getSt_name().equals(modifyName)) {
				System.out.println("수정 정보를 입력해주세요(학번,이름,나이,번호,사는곳 순서로 입력)");
				String st_num = scan.next();
				String st_name = scan.next();
				int st_age = scan.nextInt();
				String st_tel = scan.next();
				String st_home = scan.next();
				s[i].setSt_num(st_num);
				s[i].setSt_name(st_name);
				s[i].setSt_age(st_age);
				s[i].setTel(st_tel);
				s[i].setSt_home(st_home);

				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("해당 학생이 목록에 없습니다.");
		}

	}

	@Override
	public void searchStudent(Scanner scan) {
		System.out.println("검색할 학생명을 입력해주세요");
		String searchName = scan.next();
		boolean found = false;

		for (int i = 0; i < cnt; i++) {
			if (s[i].getSt_name().equals(searchName)) {
				System.out.println(s[i]);
				Subject[] subjects = s[i].getSj();

				if (subjects != null && subjects.length > 0) {
					for (Subject subject : subjects) {
						if (subject != null) {
							System.out.println(subject); 
						}
					}
				} else {
					System.out.println("등록된 과목이 없습니다.");
				}

				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("해당 학생이 목록에 없습니다.");
		}

	}

	@Override
	public void registerSubject(Scanner scan) {

		System.out.println("과목을 등록할 학생의 이름을 입력해주세요:");
		String studentName = scan.next();
		boolean found = false;

		for (int i = 0; i < cnt; i++) {
			if (s[i].getSt_name().equals(studentName)) {
				s[i].registerSubject(scan);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("해당 학생이 목록에 없습니다.");
		}

	}

	@Override
	public void deleteSubject(Scanner scan) {
		System.out.println("과목을 삭제할 학생의 이름을 입력해주세요:");
		String studentName = scan.next();
		boolean found = false;
		
		for (int i = 0; i < cnt; i++) {
			if (s[i].getSt_name().equals(studentName)) {
				s[i].deleteStudent(scan);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("해당 학생이 목록에 없습니다.");
		}
		
		
	}

}
