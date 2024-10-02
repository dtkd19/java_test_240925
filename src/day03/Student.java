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



/*
 * 객체를 생성시 값을 초기화 하는 방법
 * - 기본값, 명시적 초기값, 
 *  1. 기본값 : 기본적으로 지정되는 값 int = 0 / String = null
 *  2. 명시적 초기값 : 사용자가 멤버변수를 선언함과 동시에 값을 지정
 *  3. 초기화 블럭 : { } 멤버변수들의 초기화
 *  4. 생성자 : 객체 생성시 초기화를 해서 생성
 *  
 *  초기값의 우선순위 ( 순위가 높은 값으로 덮여 쓰여짐) 
 *  기본값 -> 명시적 초기값 -> 초기화 블럭 -> 생성자
 */


public class Student {
	
	private String spot = "incheon"; // 명시적 초기값
	private String name; // 기본값 기본적으로 주는 null / 0 의 값
	private String program;
	private String tel;
	
	// 초기화 블럭 영역
	
	{
		name = "student";
		program = "JAVA";
	}
	
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
	
	
	// 객체의 내용을 출력하는 메서드 (toString)
	public void print() {
		System.out.println(spot + "지점 " + name + "(" + program + ") " + "tel : " + tel);
	}
	
	// 생성자 , getter/ setter, toString => 자동생성가능.
	
	

	public String getSpot() {
		return spot;
	}
	
	// @Override : 어노테이션(에너테이션) => 작은 기능이 있는 정의어 
	// override(오버라이드) : 부모의 메서드를 자식이 가져와서 재정의 하는 기능
	@Override
	public String toString() {
		return "Student [spot=" + spot + ", name=" + name + ", program=" + program + ", tel=" + tel + "]";
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
