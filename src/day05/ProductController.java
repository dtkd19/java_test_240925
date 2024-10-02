package day05;

import java.util.Scanner;

public class ProductController {
	// Product 배열생성
	// 추가 , 삭제 , 수정 , 리스트보기

	private Product[] menu = new Product[10];
	private int cnt = 0;

	public void printProduct() {

		if (cnt == 0) {
			System.out.println("상품이 없습니다. 추가해주세요");
		} else {
			for (int i = 0; i < cnt; i++) {
				System.out.println(menu[i] + " 상품번호: " + menu[i].getNum());
			}
		}

	}

	public void insertProduct(Scanner scan) {

		// 배열이 다 찼다면... 배열 늘려주기.
		// 배열은 길이를 한번 정하면
		// 배열은 길이를 한번 정하면 변경 불가능.
		// 더 긴 길이의 배열을 생성하여 배열 복사 후 배열 교체

		if (cnt == menu.length) {
			// 5개 더 많은 길이의 배열을 생성
			Product[] tmp = new Product[menu.length + 5];
			// 배열 복사 기존배열의 0 번지부터 새배열으ㅏ 0번지부터 복사 cnt 개수만큼
			System.arraycopy(menu, 0, tmp, 0, cnt);
			menu = tmp;
		}

		System.out.println("상품명과 가격을 입력해주세요");
		String name = scan.next();
		String price = scan.next();

		Product p = new Product();
		p.insertProduct(name, price);
		p.setNum(cnt + 1);
		menu[cnt] = p;
		cnt++;

	}

	public void deleteProdcut(Scanner scan) {
		System.out.println("삭제할 상품번호를 입력해주세요.");
		int delNum = scan.nextInt();
		boolean found = false;

		for (int i = 0; i < cnt; i++) {
			if (menu[i].getNum() == delNum) {
				for (int j = i; j < cnt - 1; j++) {
					menu[j] = menu[j + 1];
					menu[j].setNum(j + 1);
				}
				menu[cnt - 1] = null;
				cnt--;
				found = true;
				break;
			}

		}

		if (!found) {
			System.out.println("해당 상품이 목록에 없습니다.");
		}
		
		printProduct();
	}

	public void deleteProdcut2(Scanner scan) {
		System.out.println("삭제할 상품명을 입력해주세요.");
		String delName = scan.next();
		int index = -1; // 없는 번지를 기본값으로 설정

		for (int i = 0; i < cnt; i++) {
			if (menu[i].getName() == delName) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			System.out.println("해당 상품이 목록에 없습니다.");
		}
		
		//삭제: 찾은 위치부터 뒷번지를 앞번지로 옮기는 작업
//		for(int i = index; i < cnt-1; i++) {
//			menu[i] = menu[i+1]; // 덮어쓰기
//		}
//		
		
		
		// arraycopy를 이용한 방법 => 속도가 빠름
		// 배열복사 기존배열의 0번지부터 새배열의 0번지부터 복사 cnt 개수만큼 복사
		
		int copyCnt = menu.length - index - 1;
		System.arraycopy(menu, index+1, menu, index, copyCnt);
		
		
		// 끝번지는 null
		menu[cnt-1] = null;
		cnt--;
		
		printProduct(); // 삭제후 출력
		
	}

	public void modifyProduct(Scanner scan) {
		System.out.println("수정할 상품번호를 입력해주세요");
		int modifyNum = scan.nextInt();
		boolean found = false;

		for (int i = 0; i < cnt; i++) {
			if (menu[i].getNum() == modifyNum) {
				System.out.println("바꿀 상품을 입력해주세요");
				String name = scan.next();
				String price = scan.next();
				menu[i].insertProduct(name, price);
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("해당 상품이 목록에 없습니다.");
		}
	}

	public void modifyProduct2(Scanner scan) {

		// 상품수정 : 이름을 검색하여 금액만 수정

		System.out.println("수정할 상품명을 입력해주세요");
		String searchName = scan.next();
		boolean found = false;

		for (int i = 0; i < cnt; i++) {
			if (menu[i].getName() == searchName) {
				System.out.println("수정 금액을 입력해주세요");
				String price = scan.next();
				menu[i].setPrice(price);
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("해당 상품이 목록에 없습니다.");
		}
	}

	public Product[] getMenu() {
		return menu;
	}

	public void setMenu(Product[] menu) {
		this.menu = menu;
	}

}
