package day02;

public class Method03 {

	public void dan(int num1) {
		for(int i  = 1; i <= 9 ; i ++) {
			System.out.print( num1 + "*" + i + "=" + (num1*i) + "  ");
		}
		System.out.println();
	}
	
	
	
	
	
	public static void main(String[] args) {
		// 정수 하나를 주면 
		// 해당 정수의 구구단 출력하는 메서드
		
		Method03 m3 = new Method03();
		
		m3.dan(12);
		
		for(int i =2; i<=9; i++) {
			m3.dan(i);
		}

	}

}
