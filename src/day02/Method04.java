package day02;

public class Method04 {

	public static void main(String[] args) {
		/*
		 * 메서드 오버로딩
		 * - 동일한 이름의 메서드를 여러개 만드는 케이스
		 * - 오버로딩의 조건
		 * 1. 매개변수의 개수가 달라야 함.
		 * 2. 매개변수의 타입이 달라야 함.
		 * - 리턴타입은 상관없음. 매개변수의 이름도 상관없음.
		 */
		
		/*
		 * 가변인자 메서드
		 * - ... 배열처럼 받을 수 있는 메서드
		 * - 매개변수의 개수가 고정되어 있지 않은 경우 사용
		 * 
		 */
		Method04 m4 = new Method04();

		System.out.println( m4.sum(10, 20, 30));
		System.out.println( m4.sum(10, 20));
		System.out.println( m4.sum2(1,2,3,4,5,6,6,7,7,8));
		
		Test1 t = new Test1();
		t.print();

	}
	
	public int sum(int num1, int num2) {
		return num1 + num2;
	}
	public int sum(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
	public int sum2(int ...num) {
		int result = 0;
		for(int a : num) {
			result += a;
		}
		return result;
	}
	
	
	
}
