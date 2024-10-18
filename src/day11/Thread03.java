package day11;

public class Thread03 {

	public static void main(String[] args) {
		// 1~50, 51~100 까지의 합을 두개의 Thread를 생성 
		// 그 결과를 확인
		// Thread.sleep() : 기다렸다가 실행
		// millisecond 단위 1초 = 1000
		
		// 두개의 Thread가 실행되고 난 후 
		// Thread-0  1~50 까지의 합계 출력
		// Thread-1 51~100 까지의 합계 출력
		// Thread-0 + Thread-1 의 합계 출력 
		
		JoinTest jt = new JoinTest(1,50);
		JoinTest jt2 = new JoinTest(51,100);
		
		jt.start();

		
		try {
			jt.join();
			Thread.sleep(1000); // millisecond 단위 1초 = 1000;

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(jt.start + "~" + jt.end + "까지의 합: "  + jt.total);
		
		jt2.start();
		
		
		try {
			jt2.join();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(jt2.start + "~" + jt2.end + "까지의 합: "  + jt2.total);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(jt.start + "~" + jt2.end + "까지의 합: " + (jt.total + jt2.total));
		
		
	}

}


class JoinTest extends Thread{
	
	int start;
	int end;
	int total;
	
	
	public JoinTest(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	
	@Override
	public void run() {
		
		for(int i = start; i <= end; i++) {
			System.out.print(i + " ");
			this.total += i;
		}
		System.out.println();
	}
	
	
}