package day04;

public class Extends02 {
	
	

	public static void main(String[] args) {
		// 오버라이딩 : 부모클래스의 메서드를 재정의하여 사용하는 것
		// - 부모클래스의 메서드와 선언부가 일치해야함. { 구현만 재정의 가능. }
		// - 접근제한자는 더 넓은 범위만 가능, 축소는 안됨.
		
		
		Dog d = new Dog("개", "코카스파니엘");
		
		d.printInfo();
		d.howl();
		
		System.out.println();
		
		Cat c = new Cat("고양이", "러시안블루");
		
		c.printInfo();
		c.howl();
		
		System.out.println();

		Tiger t = new Tiger("호랑이" , "뱅갈호랑이");
		
		t.printInfo();
		t.howl();
		
	}

}

class Animal{
	// 동물의 이름과 종류를 나타내는 클래스0
	// 메서드 : 이름과 종류를 출력하는 메서드, 동물의 울음소리를 출력하는 메서드
	private String name;
	private String category;
	
	
	public Animal() {}
	public Animal(String name, String category) {
		this.name = name;
		this.category = category;
	}
	// 출력메서드
	public void printInfo() {
		System.out.println("이름:" + name + " / 종류:" + category );

	}
	
	public void howl() {
		System.out.println("--" + name + "의 울음소리--");
		// 자식이 구현
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
	
	// Dog, Cat Animal 클래스를 상속받아 생성
	// printInfo() / howl() : 오버라이딩 후 본인의 울음소리를 추가해서 출력
	
	
class Dog extends Animal{
	
	
	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dog(String name, String category) {
		super(name, category);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void howl() {
		// TODO Auto-generated method stub
		super.howl();
		System.out.println("멍멍 ~");
	}
	
}

class Cat extends Animal{

	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cat(String name, String category) {
		super(name, category);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void howl() {
		// TODO Auto-generated method stub
		super.howl();
		System.out.println("야옹~!!");
	}
	
}

class Tiger extends Animal{
	
	public Tiger() {
		super();
	}
	
	public Tiger(String name, String category) {
		super.setName(name);
		super.setCategory(category);
	}
	
	public void howl() {
		super.howl();
		System.out.println("어흥~~!");
	}
	
	
}







