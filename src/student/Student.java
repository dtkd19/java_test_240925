package student;

import java.util.Scanner;

public class Student {
	private String st_num;
	private String st_name;
	private int st_age;
	private String tel;
	private String st_home;
	private Subject[] sj = new Subject[10];
	private int number;
	private int cnt;
	
	public Student() {
		
	}
	
	
	public Student(String st_num, String st_name, int st_age, String tel , String st_home) {
		this.st_num = st_num;
		this.st_name = st_name;
		this.st_age = st_age;
		this.tel = tel;
		this.st_home = st_home;
	}
	
	

	public void insertSt(String st_num, String st_name, int st_age, String tel , String st_home) {		
		this.st_num = st_num;
		this.st_name = st_name;
		this.st_age = st_age;
		this.tel = tel;
		this.st_home = st_home;
	}
	
	
	public void registerSubject(Scanner scan) {
		
		if (cnt == sj.length) {
			Subject[] tmp = new Subject[sj.length + 5];
			System.arraycopy(sj, 0, tmp, 0, cnt);
			sj = tmp;
		}
		
		System.out.println("신청할 수강 정보를 입력해주세요 ( 과목코드, 과목명, 학점, 시수, 교수명, 시간표, 강의장 순서 )");
		String su_code = scan.next();
		String su_name = scan.next();
		int su_point = scan.nextInt();
	    int su_time = scan.nextInt();
		String su_proName = scan.next();
		String timetable = scan.next();
		String su_place = scan.next();
		
		Subject sub = new Subject();
		
		sub.insertSubject(su_code, su_name, su_point, su_time, su_proName, timetable, su_place);
		
		sj[cnt] = sub;
		
		cnt++;
		
	    System.out.println("과목이 등록되었습니다: " + sub);
		
	}
	
	public void deleteStudent(Scanner scan) {
		System.out.println("삭제할 과목명을 입력해주세요");
		String delName = scan.next();

		int index = -1; // 없는 번지를 기본값으로 설정

		for (int i = 0; i < cnt; i++) {
			if (sj[i].getSu_name().equals(delName)) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			System.out.println("해당 과목이 목록에 없습니다.");
		}

		int copyCnt = sj.length - index - 1;
		System.arraycopy(sj, index + 1, sj, index, copyCnt);

		sj[cnt - 1] = null;
		cnt--;

	}



	@Override
	public String toString() {
		return "Student [st_num=" + st_num + ", st_name=" + st_name + ", st_age=" + st_age + ", tel=" + tel
				+ ", st_home=" + st_home +  "]";
	}
	

	public String getTel() {
		return tel;
	}




	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getSt_num() {
		return st_num;
	}

	public void setSt_num(String st_num) {
		this.st_num = st_num;
	}

	public String getSt_name() {
		return st_name;
	}

	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}

	public int getSt_age() {
		return st_age;
	}

	public void setSt_age(int st_age) {
		this.st_age = st_age;
	}

	public String getSt_home() {
		return st_home;
	}

	public void setSt_home(String st_home) {
		this.st_home = st_home;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public Subject[] getSj() {
		return sj;
	}


	public void setSj(Subject[] sj) {
		this.sj = sj;
	}
	
	
	
	
}
