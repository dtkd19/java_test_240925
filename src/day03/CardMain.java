package day03;

public class CardMain {

	public static void main(String[] args) {
		// Card 클래스 생성 출력
			
		CardPack cp = new CardPack();
		
		
		cp.print();
		
		cp.sufCard();
		
		cp.print();
		
		cp.resetPack();
		
		cp.print();
		
		cp.sufCard();
		
		cp.print();
				
		System.out.println("---------- p1 ---------");
		Card p1Card1 = cp.pickCard();
		Card p1Card2 = cp.pickCard();
		
		Card p2Card1 = cp.pickCard();
		Card p2Card2 = cp.pickCard();
		
		p1Card1.print();
		p1Card2.print();
		System.out.println();
		System.out.println("---------- p2 ---------");
		p2Card1.print();
		p2Card2.print();
	
		Card baseCard1 = cp.pickCard();
		Card baseCard2 = cp.pickCard();
		Card baseCard3 = cp.pickCard();
		Card baseCard4 = cp.pickCard();
		Card baseCard5 = cp.pickCard();
		
		System.out.println();
		System.out.println("------- base --------");
		baseCard1.print();
		baseCard2.print();
		baseCard3.print();
		baseCard4.print();
		baseCard5.print();
		System.out.println();
		
		
		System.out.println();
		
		cp.init();
		
		cp.print();

		
		
	}

}
