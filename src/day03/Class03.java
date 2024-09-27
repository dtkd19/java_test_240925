package day03;

public class Class03 {

	public static void main(String[] args) {
		
		Tv t = new Tv("white");
		
		t.print();
		t.power();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.power();
		t.power();		
		t.volUp();
		t.volUp();
		t.volDown();
		t.volDown();
		t.volDown();
		t.volDown();
		t.volDown();
		t.volDown();
		t.chUp();
		t.chUp();
		t.chUp();
		t.chUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.power();
		t.power();
		t.power();
		t.power();
	}

}

// Tv 클래스 생성

/*
 * 멤버변수 : brand , color ,power , ch , vol
 * 메서드 :
 * power() : 
 * chUp() / chDown() : 1씩증가 20까지 있음. 20이넘어가면 다시 0번 순환
 * volUp() / volDown() :  1씩증가 / 감소 10까지있음 10넘어가면 10, 0이면 음소거
 * 
 */


// final : 변경할 수 없는 값을 지정 대문자로 쓰는 것을 원칙으로 함.

class Tv{
	private final String BRAND = "삼성";
	private String color;
	private boolean power;
	private int ch;
	private int vol;
	
	
	public Tv() {
		
	}
	
	public Tv(String color) {
		this.color = color;
		this.vol = 3;
	}
	
//	public Tv(String brand, String color) {
//		this.brand = brand;
//		this.color = color;
//		this.vol = 3;
//	}
	
	
	public void printCv() {
		if(power) {
			System.out.println("ch : " + ch);
			System.out.println("vol : " + vol);
		}
	}
	
	
	
	public void print() {
		System.out.println( BRAND + "TV (" + color + ")");
	}
	
	public void power() {
		power = !power;
		if(power) {
			System.out.println("전원이 켜졌습니다.");
			System.out.println("ch : " + ch);
			System.out.println("vol : " + vol);
		} else {
			System.out.println("전원이 꺼졌습니다.");
		}
	}
	
	public void chUp() {
		if(power) {
			if(ch >= 20) {
				ch = 0;
				System.out.println("ch : " + ch);
			} else {
				ch++;
				System.out.println("ch : " + ch);
			}
		}
	}
	
	public void chDown() {
		if(power) {
			if(ch <= 0) {
				ch = 20;
				System.out.println("ch : " + ch);
			} else {
				ch--;
				System.out.println("ch : " + ch);
			}
		}
	}
	
	
	public void volUp() {
		if(power) {
			if(vol >= 10) {
				vol = 10;
				System.out.println("vol : " + vol);
			} else {
				vol++;
				System.out.println("vol : " + vol);
			}
		}
	}
	
	public void volDown() {
		if(power) {
			if(vol <= 1) {
				vol = 0;
				System.out.println("음소거");
			} else {
				vol--;
				System.out.println("vol : " + vol);
			}
		}
	}

	public String getBrand() {
		return BRAND;
	}

//	public void setBrand(String brand) {
//		this.brand = brand;
//	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public int getCh() {
		return ch;
	}

	public void setCh(int ch) {
		this.ch = ch;
	}

	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}
	

	
	
	
	
}