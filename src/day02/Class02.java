package day02;

public class Class02 {
	
	// 생성자 : 객체를 생성하기위해 객체의 초기화를 담당.
	// Car c = new Car();  => 클래스 객체명 = new 생성자();
	// 생성자는 여러개 만들 수 있음. ( 생성자 오버로딩. )
	// 생성자명은 클래스명과 동일
	// 생성자가 하나도 없는 경우는 기본 생성자를 자동으로 생성 => Car()
	// 생성자를 하나라도 생성하면 기본 생성자는 주지 않음.
	// 생성자를 사용자지정으로 생성하려면 기본생성자도 같이 생성해야 함.
	// 생성자 오버로딩 조건 (매개변수 개수가 달라야함 || 매개변수 타입이 달라야 함. )
	// 생성자 호출가능. (생성자 내에서만)
	// this : 내 클래스의 요소라는 것을 나타내는 키워드
	// super : 자신이 상속받은 부모 클래스에 대한 레퍼런스 변수
	

	public static void main(String[] args) {
		
		Car c = new Car(); // 생성자 호출은 단 1번 객체 생성시만 가능.
		
		c.setName("소나타");
		c.setColor("black");
		c.setYear(2022);
		c.carPrint();
		
		c.power();
		c.upSpeed();
		c.upSpeed();
		c.power();
		c.upSpeed();
		c.power();
		c.upSpeed();
		c.downSpeed();
		c.power();
		c.downSpeed();
		c.power();
		c.downSpeed();
		c.downSpeed();
		c.downSpeed();
		c.power();
		c.upSpeed();
		c.power();
		c.print();
		c.downSpeed2();
		c.upSpeed();
		c.power3();
		c.print();
		
		Car c1 = new Car("BMW");
		
		c1.carPrint();
		
		Car c2 = new Car("BMW" ,"gray");
		
		c2.carPrint();
		
		Car c3 = new Car("BMW", "gray",2024);
		
		c3.carPrint();
	}

}


// Car 클래스 생성
// 멤버변수 : name, color , year, power , speed; => private 선언 ( getter / setter 생성)
// 소나타 ( 블랙 / 2024) => 출력메서드
// power : 시동 상태 나타내는 메서드 ( true / false )
// speed : 속도 up / down 메서드 
class Car{
	
	private String name;
	private String color;
	private int year;
	private boolean power = false;
	private int speed;
	
	// 멤버변수 => 생성자 => 메서드 => getter / setter 
	// 생성자 위치
	// 객체를 생성할 때 초기값 지정
	// 생성자의 접근제한자는 반드시 public 이여야 함.
	// 생성자명은 클래스명과 반드시 같아야 함.
	// 생성자는 메서드와 달리 return 타입이 없음.
	
	public Car() {
		// 기본생성자 필수
	}
	
	public Car(String name ) { // 이름만 넣는 생성자
		this.name = name;
	}
	public Car(String name , String color) { 
		this.name = name;
		this.color = color;
	}
	
	// 생성자 호출 : 생성자 내에 다른 생성자의 값과 완전히 동일한 값이 있을경우 사용가능
	public Car(String name , String color, int year) { 
		this(name,color);
//		this.name = name;
//		this.color = color;
		this.year = year;
	}
	
	
	public void carPrint() {
		System.out.println( name+ " (" + color + "/" + year + ") " );
	}
	
	public void print() {
		if(!power) {
			System.out.println("시동이 꺼져있습니다.");
		} else {
			System.out.println("power : " + power);
			System.out.println("현재속도 : " + speed );
		}
	}
	

	public void power3() {
		if(speed == 0) {
			power = !power;
		} else {
			System.out.println("속도를 줄이세요 현재속도 : " + speed);
		}
	}
	
	
	public boolean power() {		
		power = !power;
		if(power) {
			System.out.println("시동이 켜졌습니다.");
			return true;
		} else {
			if(speed != 0) {
				power = !power;
				System.out.println("speed가 0이 아닙니다. 속도를 줄여주세요 현재속도" + speed );
				return true;
			}
		}
		System.out.println("시동이 꺼졌습니다.");
		return false;
	}
	
	public void upSpeed() {
		if(power) {
			if(speed >= 200) {
				speed = 200;
				System.out.println("speed : " + speed);
			} else {
				speed += 10;
				System.out.println("speed : " + speed);
			}
		} else {
			System.out.println("시동이 꺼져있습니다.");
		}
		
	}
	
	public void upSpeed2() {
		if(power) {
			if(speed >= 200) {
				speed = 200;
				System.out.println("최고 속도입니다.");
			} else {
				speed += 10;
			}
		} 	
	}
	
	public void  downSpeed() {
		if(power) {
			if(speed <= 0 ) {
				speed = 0;
				System.out.println("speed : " + speed);
			} else {
				speed -= 10;
				System.out.println("speed : " + speed);
			}			
		} else {
			System.out.println("시동이 꺼져있습니다.");
		}
		
	}
	
	public void  downSpeed2() {
		if(power) {
			if(speed <= 0 ) {
				speed = 0;
				System.out.println("차가 정지해있습니다.");
			} else {
				speed -= 10;
			}			
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	
	
}
