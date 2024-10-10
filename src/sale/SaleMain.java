package sale;

import java.util.Scanner;

public class SaleMain {

	public static void main(String[] args) {
		// 키오스크
		/* menu
		 * 1.메뉴추가 | 2.메뉴삭제 | 3.메뉴수정(가격) | 4.메뉴보기(전체메뉴보기) | 5.주문 | 6.주문내역출력(영수증) | 7.전체판매내역 | 8.종료
		 * SaleController 
		 * Menu List => List<Menu> menu = new ArrayList<>();
		 * Order List => List<Order> order = new ArrayList<>();
		 * 
		 */

		Scanner scan = new Scanner(System.in);
		
		SaleController sc= new SaleController();
		
		int menu = 0;
		
		while(menu != 8 ) {
			
			System.out.println(" 메뉴를 선택해 주세요.");
			System.out.println("1.메뉴추가 | 2.메뉴삭제 | 3.메뉴수정(가격) | 4.메뉴보기(전체메뉴보기) | 5.주문 | 6.주문내역출력(영수증) | 7.전체판매내역 | 8.종료 >> " );
			
			menu = scan.nextInt();
			
			switch (menu) {
			case 1:
				sc.addMenu(scan);
				break;
			case 2:
				sc.delMenu(scan);
				break;
			case 3:
				sc.modifyMenu(scan);
				break;
			case 4:
				sc.printMenu();
				break;
			case 5:
				sc.orderMenu(scan);
				break;
			case 6:
				sc.orderPrint(scan);
				break;
			case 7:
				sc.salePrint();
				break;
			case 8:
				System.out.println("종료합니다.");
				break;
				
			default:
				System.out.println("잘못된 메뉴를 선택하셨습니다.");
				break;
			}
		}
		
		
		
		
		
	}

}
