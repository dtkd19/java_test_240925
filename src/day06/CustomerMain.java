package day06;

/* Silver 고객 / Gold 고객(할인) / VIP 고객(할인)
 * - Silver 고객
 * 	=> 제품을 구매할 때 0% 할인 / 보너스 포인트 1% 적립
 * - Gold 고객
 * 	=> 제품을 구매할 때 10% 할인 / 보너스 포인트 2% 적립
 * - VIP 고객
 * 	=> 제품을 구매할 때 10% 할인 / 보너스 포인트 5% 적립
 * 	=> 전담 상담사 
 * 
 *  Customer / GoldCustomer / VipCustomer 클래스 생성
 *  GoldCustomer , ViPCustomer => Customer 클래스 상속
 * 
 */



public class CustomerMain {

	public static void main(String[] args) {
		// 업캐스팅 : 부모의 객체 배열에 자식 객체의 값을 넣을 수 있는 것은 업캐스팅이 가능해서..
		// 업캐스팅은 형변환을 자동으로 해줌.

		Customer[] customerList = new Customer[10];
		Customer cLee = new Customer("1001", "이정혁");
		Customer cHong = new Customer("1002", "홍정혁");
		Customer cKim = new GoldCustomer("1003", "김정혁");
		Customer cHan = new GoldCustomer("1004", "한정혁");
		Customer cChoi = new VIPCustomer("1005", "최정혁","1111");
		int cnt = 0;
		customerList[cnt] = cLee;
		cnt++;
		customerList[cnt] = cHong;
		cnt++;
		customerList[cnt] = cKim;
		cnt++;
		customerList[cnt] = cHan;
		cnt++;
		customerList[cnt] = cChoi;
		cnt++;
		customerList[cnt] = new VIPCustomer("1006","박정혁" , "2222");
		cnt++;
		customerList[cnt] = new VIPCustomer("1007","유정혁" , "1111");
		cnt++;
		customerList[cnt] = new VIPCustomer("1008","배정혁" , "1111");
		cnt++;
		System.out.println(" -- 할인율과 포인트 계산 --");
		int price = 100000;
		
		for(int i = 0; i<cnt; i++) {
			// 모든 손님 대상
			// 홍길동님의 지불금액은 100000 / 포인트는 1000입니다.
			int salePrice = customerList[i].bonus(customerList[i], price);
			System.out.println(customerList[i].getCustomerName() + "님의 지불금액은 " + salePrice + " / 포인트는 " + customerList[i].getBonusPoint() + "입니다.");
			System.out.println("-------------------------------------");
		}
		
		// 모든 고객정보 출력
		
		System.out.println(" -- 모든 고객정보 출력 --");
		
		for(int i = 0;  i <cnt; i++) {
			customerList[i].print(customerList[i]);
		}
		
		// agentID = 1111 => 3333로 변경
		// 다운캐스팅 : 부모의 공유되는 멤버변수나 메서드가 아닌 지식 고융의 멤버변수나 메서드를 호출하고자 할 경우 사용
		// 다운캐스팅 시 반드시 명사적으로 형변환 해야함.
		
		for(int i = 0; i < cnt; i ++) {
			if(customerList[i] instanceof VIPCustomer) {
				if(((VIPCustomer) customerList[i]).getAgentID().equals("1111")) {
					((VIPCustomer) customerList[i]).setAgentID("3333");
				}
			}
		}
		
		// 모든 고객정보 출력
		
		System.out.println(" -- 모든 고객정보 출력 --");
		
		for(int i = 0;  i <cnt; i++) {
			customerList[i].print(customerList[i]);
		}
		
		
	}

}
