package day03;


/*
 * 1장의 카드를 생성하기 위한 클래스
 * - 숫자 : 1~13 1(A) 11(J) 12(Q) 13(K)
 * - 모양 : ♠ ♥ ♣ ◆ 
 * - 한장의 카드를 출력하는 print() =>  ♥A  ◆3
 * - ♣11 => ♣J ♣12 => ♣Q
 * - #1 => ♥A / #25 => ♥A / ♣15 = ♣A
 */

/*
 * 클래스 구성
 * - 멤버변수 : 모양(shape) , 숫자(num) => private gatter / setter 
 * - 메서드 : print()
 * - 생성자 : 기본생성자만 생성 = > ♥A
 * - setShape() / setNum() : 설정할 수 있는 숫자와 모양을 제한
 */

public class Card {
	
	private char shape;
	private int num;
	
	public Card() {
		this.shape = '♥';
		this.num = 1;
	}
	
	
	
	
	public void print() {
		System.out.print(shape);
		switch(this.num) {
		case 1 :
			System.out.print("A ");
			break;
		case 11 :
			System.out.print("J ");
			break;
		case 12 :
			System.out.print("Q ");
			break;
		case 13 :
			System.out.print("K ");
			break;
		default :
			System.out.print(this.num+" ");
		}
	}

	public char getShape() {
		return shape;
	}

	public void setShape(char shape) {
		if(shape != '♠' && shape != '♣' && shape != '♥' && shape != '◆') {
			shape = '♥';
		} else {			
			this.shape = shape;
		}
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		if(num < 1 || num > 13 ) {
			this.num = 1;
		} else {
			this.num = num;
		}
	}
	
	
	
}
