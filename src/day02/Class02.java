package day02;

public class Class02 {

	public static void main(String[] args) {
		
		Car c = new Car();
		
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
	
	public void carPrint() {
		System.out.println( name+ " (" + color + "/" + year + ") " );
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
