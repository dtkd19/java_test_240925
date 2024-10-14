package sale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaleController {

	private List<Menu> menuList = new ArrayList<>();
//	private List<Order> orderList = new ArrayList<>();
	private List<OrderList> order = new ArrayList<>();
	
	private int cnt;
	private int num;
	private int orderIndex;
	
	private int totalSum;

	
	
	public void insertMenu() { // 기본으로 존재하는 메뉴 5개
		
		Menu m = new Menu(++cnt,"햄버거", 7000);
		Menu m2 = new Menu(++cnt,"감자튀김", 2400);
		Menu m3 = new Menu(++cnt,"콜라", 2000);
		Menu m4 = new Menu(++cnt,"치킨", 20000);
		Menu m5 = new Menu(++cnt,"피자", 28000);
		
	
		menuList.add(m);
		menuList.add(m2);
		menuList.add(m3);
		menuList.add(m4);
		menuList.add(m5);
		
		
		
	}
	
	
	public void addMenu(Scanner scan) {

		String name = null;
		int price = 0;

		System.out.println("제품명과 가격을 입력해주세요.");

		name = scan.next();
		price = scan.nextInt();

		Menu m = new Menu(name, price);

		cnt++;

		m.setProductID(cnt);

		menuList.add(m);

	}

	public void delMenu(Scanner scan) {

		String name = null;

//		boolean have = false;

		System.out.println("삭제할 제품명을 입력해주세요.");

		name = scan.next();


		boolean ok = menuList.remove(new Menu(name));
		
		if(ok) {
			System.out.println("삭제완료");
		} else {
			System.out.println("삭제 할 상품이 없습니다.");
		}
		
		
		
		
		
//		for (Menu m : menuList) {
//			if (m.getProductName().equals(name)) {
//				menuList.remove(m);
//				have = true;
//				break;
//			}
//		}

//		Menu m = null;
//		
//		for(int i = 0; i < menuList.size(); i++) {
//			 m = menuList.get(i);
//			 
//			 if(m.getProductName().equals(name)) {
//				 menuList.remove(m);
//				 have = true;
//				 break;
//			 }
//		}

//		if (have == false) {
//			System.out.println(" 삭제할 제품이 존재하지 않습니다.");
//		}

	}

	public void modifyMenu(Scanner scan) {

		String modiName = null;

		boolean have = false;

		System.out.println(" 수정할 제품명믈 입력해주세요.");

		modiName = scan.next();

		for (Menu m : menuList) {
			if (m.getProductName().equals(modiName)) {
				System.out.println("수정할 가격을 입력해주세요");
				int modiPrice = scan.nextInt();
				m.setPrice(modiPrice);
				have = true;
				break;
			}
		}

		if (have == false) {
			System.out.println("수정할 제품이 존재하지 않습니다.");
		}

	}

	public void printMenu() {

		for (Menu m : menuList) {
			System.out.println(m);
		}

	}

	public void orderMenu(Scanner scan) {

		int num2 = 0;
		String name = null;
		int price = 0;
		int amount = 0;
		int salePrice = 0;
		boolean have = false;
		
		int index = 0;
		
		this.order.add(new OrderList((orderIndex+1)));

		int or = -1;
		
		
		do {
			
			System.out.println(" 주문 할 제품넘버와, 갯수를 적어주세요 ");
			
			num2 = scan.nextInt();
			amount = scan.nextInt();
			
			for (Menu m : menuList) {
				if (m.getProductID() == num2) {
					name = m.getProductName();
					price = m.getPrice();
					index = m.getProductID();
					have = true;
					break;
				}
			}
			
			if (have == false) {
				System.out.println(" 찾으신 제품넘버는 존재하지 않습니다.");
			} else {
				
				salePrice = price * amount;
				
				Order o = new Order( index ,name, price, amount, salePrice);
				
				num++;
				
				o.setOrderNum(num);
				
				this.order.get(orderIndex).addOrder(o);		
				
			}	
			
			System.out.println(" 계속 주문 진행 1/0  >>");
			
			or = scan.nextInt();
			
		} while (or == 1);
		
		
		orderIndex++;
				

	}

	public void orderPrint(Scanner scan) {
		

		System.out.println(" 주문내역 ");


		for (Order o : order.get(orderIndex-1).getOrderList()) {
			
			totalSum += o.getSalePrice();
			o.orderPrint();
		}
		
		System.out.println("총 지불금액 : " + totalSum);

	}

	public void salePrint() {

		System.out.println("-- 전체 판매 내역 --");

		for (OrderList o : order) {
			System.out.println(o);	
		}
		System.out.println("-------------");
		System.out.println("총 수입 : " + totalSum );
		
		
	}

}
