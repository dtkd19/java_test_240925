package day02;

public class Method02 {

	
	public void sum(int num1, int num2) {
		System.out.println(num1 + "+" + num2 + "=" + (num1+num2));
	}
	public void sub(int num1, int num2) {
		System.out.println(num1 + "-" + num2 + "=" + (num1-num2));
	}
	public void mul(int num1, int num2) {
		System.out.println(num1 + "*" + num2 + "=" + (num1*num2));
	}
	public void div(double num1, int num2) {
		if(num2 == 0) {
			System.out.println("0으로 나눌 수 없습니다.");
		} else {			
			System.out.println(num1 + "/" + num2 + "=" + (num1/num2));
		}
	}
	public void mod(int num1, int num2) {
		if(num2 == 0) {
			System.out.println("0으로 나눌 수 없습니다.");
		} else {
			System.out.println(num1 + "%" + num2 + "=" + (num1%num2));
		}
	}
	
	
	
	public static void main(String[] args) {
		// 사칙연산 (+ - * % / ) 각각의 메서드 생성
		
		Method02 m = new Method02();
		
		m.sum(10, 20);
		m.sub(10, 20);
		m.mul(10, 58);
		m.div(20, 0);
		m.mod(20, 3);
		m.mod(20, 0);
		m.mod(20, -3);
	}

}
