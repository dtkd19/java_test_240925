package day03;


/*
 * 학생 클래스 생성
 * 멤버변수 : 지점, 이름 , 과정 ,전화번호
 * 생성자 : 
 * - 지점과 이름만 받는 생성자
 * - 지점, 이름, 과정 ,전화번호를 받는 생성자 ( 생성자 호출로 호출)
 * 메서드 : 해당 내용을 출력하는 메서드 print()
 * -getter / setter
 */


public class Student {
	
	private String spot;
	private String name;
	private String program;
	private String tel;
	
	
	public Student() {
		
	}
	
	public Student( String spot, String name) {
		this.spot = spot;
		this.name = name;
	}
	
	public Student (String spot, String name, String program, String tel) {
		this(spot,name);
		this.program = program;
		this.tel = tel;
	}
	
	
	public void print() {
		System.out.println(spot + "지점 " + name + "(" + program + ") " + "tel : " + tel);
	}

	public String getSpot() {
		return spot;
	}

	public void setSpot(String spot) {
		this.spot = spot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	

}
