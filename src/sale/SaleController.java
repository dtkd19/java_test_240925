package sale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaleController {

	private List<Menu> menuList = new ArrayList<>();
	private List<Order> orderList = new ArrayList<>();
	private int cnt;
	private int num;

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

		boolean have = false;

		System.out.println("삭제할 제품명을 입력해주세요.");

		name = scan.next();

//		Iterator<Menu> it = menuList.iterator();
//		while(it.hasNext()) {
//			Menu m = it.next();
//			if(m.getProductName().equals(name)) {
//				menuList.remove(m);
//			} else {
//				System.out.println("삭제할 상품이 없습니다.");
//			}
//		}

		for (Menu m : menuList) {
			if (m.getProductName().equals(name)) {
				menuList.remove(m);
				have = true;
				break;
			}
		}

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

		if (have == false) {
			System.out.println(" 삭제할 제품이 존재하지 않습니다.");
		}

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

		System.out.println(" 주문 할 제품넘버와, 갯수를 적어주세요 ");

		num2 = scan.nextInt();
		amount = scan.nextInt();

		for (Menu m : menuList) {
			if (m.getProductID() == num2) {
				name = m.getProductName();
				price = m.getPrice();
				have = true;
				break;
			}
		}

		if (have == false) {
			System.out.println(" 찾으신 제품넘버는 존재하지 않습니다.");
		} else {

			salePrice = price * amount;

			Order o = new Order(name, price, amount, salePrice);

			num++;

			o.setOrderNum(num);

			orderList.add(o);
		}

	}

	public void orderPrint(Scanner scan) {

		System.out.println(" 출력할 내역의 주문번호를 입력해주세요 ");

		int num2 = 0;

		num2 = scan.nextInt();

		for (Order o : orderList) {
			if (o.getOrderNum() == num2) {
				System.out.println(o);
			}
		}

	}

	public void salePrint() {

		System.out.println("-- 전체 판매 내역 --");

		for (Order o : orderList) {
			System.out.println(o);
		}

	}

}
