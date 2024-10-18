package day11;


class Counter{
	// 싱글톤으로 생성 
	
	private static Counter instance;
	
	private int count;
	
	private Counter() {
		
	}
	
	
	public static Counter getInstance() {
		if(instance == null) {
			instance = new Counter();
		}
		return instance;
	}

	// count 가 하나 올라가는 메서드 생성 countMethod()

	public void countMethod() {
		count++;
		System.out.println("count : " + count);
	}
	
	
	
}

public class Singleton02 {

	public static void main(String[] args) {
		// Counter 객체를 2개 생성하여 각각 countMethod() 호출
		// 1개의 객체가 공유되기 때문에 1개의 변수만 변화
		
		Counter ct = Counter.getInstance();
		Counter ct1 = Counter.getInstance();
		
		ct.countMethod();
		ct1.countMethod();
		ct.countMethod();
		ct1.countMethod();
		ct.countMethod();
		ct1.countMethod();
		
		
		
	}

}
