package day04;

/*
 * - 학생 정보를 관리하기 위한 클래스
 * - 학생 기본정보 : 이름, 생년월일, 전화번호, 나이
 * - 학원 정보 : 학원명 = "EZEN" (final static), 지점
 * - 수강 정보 : 수강과목, 기간 
 * => 여러과목을 들을 수 있음. (여러과목을 수강하기 위해서는 배열로 처리 5과목까지 가능)
 * 
 * ex) 홍길동(010101) 010-1111-1111 / 25  -> 학생정보
 * 	   EZEN(인천) -> 학원정보
 * 	   자바 6개월, 파이썬1개월 , SQLD 1개월 -> 수강정보
 * 
 * 기능(메서드)
 * - 학생의 기본정보를 출력하는 기능
 * - 학원 정보를 출력하는 기능
 * - 수강정보를 출력하는 기능
 * - 학생이 수강정보를 추가하는 기능
 * 
 */

public class Student {

	private String name;
	private String btday;
	private String tel;
	private int age;
	private static final String BRAND = "EZEN";
	private String gigum;
	private String[] program = new String[5];
	private String[] date = new String[5];
	private int cnt;


	public Student() {

	}

	public Student(String name, String btday, String tel, int age) {
		this.name = name;
		this.btday = btday;
		this.tel = tel;
		this.age = age;
	}

	public Student(String name, String btday, String tel, int age, String gigum) {
		this(name, btday, tel, age);
		this.gigum = gigum;
	}

	public Student(String name, String btday, String tel, int age, String gigum, String[] program, String[] date) {
		this(name, btday, tel, age, gigum);
		this.program = program;
		this.date = date;
	}
	

	public void stPrint() {
		System.out.println(name + "(" + btday + ") " + tel + " / " + age);
	}
	
	public void ePrint() {
		System.out.println(BRAND + "(" + gigum + ")");
	}
	
	public void infoPrint() {
		for (String ptmp : program) {
			System.out.print(ptmp + " ");
		}
		System.out.println();
		for (String dtmp : date) {
			System.out.print(dtmp + " ");
		}
		System.out.println();
	}
	
	public void infoPrint2() {
		if( program.length == 0 || cnt ==0) {
			System.out.println("수강과목이 없습니다.");
			return;
		}
		for(int i=0; i<cnt; i++) {
			System.out.print(program[i] + "(" + date[i] +")  ");
		}
		System.out.println();
	}
	
	public void addProgram(String program, String date) {
		for (int i = 0; i < this.program.length; i++) {
			if (this.program[i] == null) {
				this.program[i] = program;
				this.date[i] = date;
				return;
			} 
		}
		System.out.println("5개이상의 강의를 들을 수 없습니다.");
	}
	public void addProgram2(String program, String date) {
		// cnt 가 0인 상황 ( 하나도 추가되지 않은 상황 )
		if( cnt >= 5 ) {
			System.out.println("더이상 수강하실 수 없습니다.");
			// 배열을 늘려서 더 많은 수강을 받을 수도 있음. (배열복사)
			return;
		} 
		this.program[cnt] = program;
		this.date[cnt] = date;
		cnt++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBtday() {
		return btday;
	}

	public void setBtday(String btday) {
		this.btday = btday;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGigum() {
		return gigum;
	}

	public void setGigum(String gigum) {
		this.gigum = gigum;
	}

	public String[] getProgram() {
		return program;
	}

	public void setProgram(String[] program) {
		this.program = program;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String[] getDate() {
		return date;
	}

	public void setDate(String[] date) {
		this.date = date;
	}

	public static String getBrand() {
		return BRAND;
	}

}
