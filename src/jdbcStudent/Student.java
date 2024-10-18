package jdbcStudent;

public class Student {
	
	private int no; // 데이터베이스 ai로 자동생성
	private String s_no;
	private String s_name;
	private String s_btday;
	private String s_tel;
	private String s_addr;
	private String regdate; // now()로 자동
	
	
	public Student () {
		
	}

	// 학생등록
	// 학번, 이름, 생일 ,전화번호, 주소

	public Student(String s_no, String s_name, String s_btday, String s_tel, String s_addr) {
		this.s_no = s_no;
		this.s_name = s_name;
		this.s_btday = s_btday;
		this.s_tel = s_tel;
		this.s_addr = s_addr;
	}

	// 학생리스트
	// 학번, 이름
	
	public Student(String s_no, String s_name) {
		this.s_no = s_no;
		this.s_name = s_name;
	}

	// 학생검색
	// 전부
	public Student(int no, String s_no, String s_name, String s_btday, String s_tel, String s_addr, String regdate) {
		this.no = no;
		this.s_no = s_no;
		this.s_name = s_name;
		this.s_btday = s_btday;
		this.s_tel = s_tel;
		this.s_addr = s_addr;
		this.regdate = regdate;
	}

	// 학생정보수정
	// 학번,이름,생일,전화번호,주소, 고유넘버
	
	public Student(int no, String s_no, String s_name, String s_btday, String s_tel, String s_addr) {
		this.no = no;
		this.s_no = s_no;
		this.s_name = s_name;
		this.s_btday = s_btday;
		this.s_tel = s_tel;
		this.s_addr = s_addr;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getS_no() {
		return s_no;
	}

	public void setS_no(String s_no) {
		this.s_no = s_no;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_btday() {
		return s_btday;
	}

	public void setS_btday(String s_btday) {
		this.s_btday = s_btday;
	}

	public String getS_tel() {
		return s_tel;
	}

	public void setS_tel(String s_tel) {
		this.s_tel = s_tel;
	}

	public String getS_addr() {
		return s_addr;
	}

	public void setS_addr(String s_addr) {
		this.s_addr = s_addr;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "No" + no + ". 학번 : " + s_no + " , 이름/생일 : " + s_name + "(" + s_btday + ") , tel : "
				+ s_tel + " , 주소 : " + s_addr + " , 등록 날짜 : [" + regdate + "]";
	}
	
	
	public void printStudentList() {
		System.out.println("학번 : " + s_no + " / 이름 : " + s_name);
	}
	
	
	
	
}
