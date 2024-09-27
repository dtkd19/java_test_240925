package day03;

/*
 * 카드 한 묶음을 나타내는 클래스
 *  ♠1~13 ♥1~13 ♣1~13 ◆1~13 => 52장의 카드로 구성
 *  52장의 카드를 담을 수 있는 배열 (카드 한 묶음 배열) - 멤버변수
 *  
 *  생성자 - 52장의 카드를 순서대로 생성되게 만들기.
 *  
 *  메서드 :
 *  - 카드 출력기능 : Card => print 사용
 *  - 카드 초기화 기능 
 *  - 카드 한장을 나눠주는 기능
 *  - 카드를 섞는 기능.
 *  
 */

public class CardPack {
	private Card pack[] = new Card[52];

	// 카드의 index를 체크하기 위한 변수
	private int cnt = 0;

	public CardPack() {
		// 52장의 카드를 생성하여 배열에 넣기
		// - num 1~13 shape ♠ ♥ ♣ ◆
		char shape = '♥';
		for (int i = 1; i <= 4; i++) {
			switch (i) {
			case 1:
				shape = '♠';
				break;
			case 2:
				shape = '♥';
				break;
			case 3:
				shape = '♣';
				break;
			case 4:
				shape = '◆';
				break;
			}
			for (int j = 1; j <= 13; j++) {
				Card c = new Card();
				c.setShape(shape);
				c.setNum(j);
				pack[cnt] = c;
				cnt++;
			}
		}

	}

	public void resetPack() {	
		cnt = 0;
		char shape = '♥';
		for (int i = 1; i <= 4; i++) {
			switch (i) {
			case 1:
				shape = '♠';
				break;
			case 2:
				shape = '♥';
				break;
			case 3:
				shape = '♣';
				break;
			case 4:
				shape = '◆';
				break;
		
			}
			for (int j = 1; j <= 13; j++) {
				Card c = new Card();
				c.setShape(shape);
				c.setNum(j);
				pack[cnt] = c;
				cnt++;
			}
		}
		
	}
	
	public void init() {
		cnt = 52;
	}
	
	
	public void sufCard(){
		
		for(int i=0; i < pack.length; i++) {
			int r = (int)(Math.random()*pack.length);
				Card tmp = pack[i];
				pack[i] = pack[r];
				pack[r] = tmp;
		}
		
	}
	
	public Card pickCard() {
		if(cnt == 0) {
			return null;
		} 
		cnt--;
		return pack[cnt];
	}
	
	
	public void print() {
			
		cnt = 0;
		for(int i=1; i<=4; i++) {
			for(int j=0; j<=12; j++) {
				pack[cnt].print();  
				cnt++;
			}
			System.out.println(); 
		}
		
		System.out.println();
	}
	
	
	


	public Card[] getPack() {
		return pack;
	}

	public void setPack(Card[] pack) {
		this.pack = pack;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	
}
