package day04;


// 추상클래스
abstract class Animal1{
	protected String name;
	protected String category;
	
	// 일반메서드
	public void printInfo() {
		System.out.println(name + "("+category+")");
	}
	
	// 추상메서드
	
	abstract public void howl();

	
	
}

class Dog1 extends Animal1{
	
	private String eat; //먹이종류
	
		
	public Dog1() {
		super();
	}
	
	
	public Dog1(String name , String category) {
		super.name = name;
		super.category = category;
	}
	
	public Dog1(String name , String category, String eat) {
		this(name, category);
		this.eat = eat;
		
	}
	
	
	
	@Override
	public void howl() {
		System.out.println("울음소리 > 멍멍 ~!!");
		
	}
	
	public void menu(String eat) {
		this.eat = eat;
		System.out.println("먹이 > " + eat);
	}
	
}


public class Abstract01 {

	public static void main(String[] args) {
		
		
		Dog1 d1= new Dog1("강아지", "진돗개");
		
		d1.printInfo();
		d1.howl();
		
		d1.menu("사료");
		
		
		
		/*
		 * 추상클래스 : 미완성 클래스, 추상메서드를 포함하는 클래스
		 * 추상클래스 요소 : 멤버변수 + 상수(final) + 일반메서드 + 추상메서드 
		 * 추상클래스 : 객체를 생성할 수 없다. 반드시 추상메서드를 구현하여 완성해야 객체를 생성
		 * 추상메서드 : 메서드의 선언부만 있고, 구현이 없는 메서드
		 * 추상 키워드 : abstract
		 * 
		 * abstract class Animal{}
		 * abstract public void howl(매개변수); // 추상메서드
		 * - 추상클래스에 abstract 키워드는 반드시 포함해야 함.
		 * - 인터페이스는 추상메서드를 포함해도 abstract 키워드가 생략가능.
		 * - 추상클래스는 상속을 하기위한 부모클래스를 생성 할 때 사용
		 * - 상속받은 클래스에 추상메서드가 있다면 반드시 구현 
		 */
	
		

	}

}
