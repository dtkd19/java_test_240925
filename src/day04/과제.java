package day04;

import java.util.Scanner;

/*
 * Product 클래스 생성 : 상품을 등록하는 클래스
 * 상품명(name), 가격(price) 을 멤버변수로 생성 
 * 상품 추가 메서드
 * 상품 출력 메서드 (toString 이용)
 * ex) 사탕 : 500
 * 과자 : 2000
 * 젤리 : 1000
 */

class Product{
	
	private String name;
	private String price;
	
	public Product() {
		
	}
	
	public Product(String name, String price) {
		this.name = name;
		this.price = price;
	}
	
	public void insertProduct(String name, String price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return name + ":" + price + "원" ;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
}


public class 과제 {

	public static void main(String[] args) {
		/*
		 * 상품 10개를 등록할 수 있는 배열 생성
		 * 스케너를 통해서 상품 등록
		 * 등록한 상품을 출력
		 * 
		 * 상품을 등록하시겠습니까? (y/n) y => 등록 / n => 그만
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		
		Product pdArr[] = new Product[10];
		
		String str1,str2,str3;
		
		int count = 0;
		while( true ) {		
			System.out.println("상품을 등록하시겠습니까? (y/n)");
			str1 = scan.next();
	        if(count >= 10) {
				System.out.println("더이상 추가하실 수 없습니다.");
				break;
			}

			if(str1.equals("y")) {
			
			System.out.println("상품 이름과 가격을 입력해주세요.");
			str2 =scan.next();	
			str3 =scan.next();	
			
			Product p = new Product();
			
            p.insertProduct(str2, str3);
			
			pdArr[count] = p;
			
			count++;
		
				
			} else if(str1.equals("n")) {
				System.out.println("종료합니다.");
				break;
			}
			
		}
		if(count == 0 ) {
			System.out.println("상품이 없습니다. 상품을 추가해주세요");
		} else {
			System.out.println("---- 상품목록 (이름/가격) ----");
			for(int i = 0 ; i < count; i++) {
				System.out.println(pdArr[i]);
			}	
		}
		
		
		scan.close();
	}
	
}


