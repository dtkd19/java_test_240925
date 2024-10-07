package day06;

/* customerID : 고객아이디
 * customerName : 고객이름
 * customerGrade : 고객등급
 * bonusPoint
 * bonusRatio : 0.01 => 1% 
 * 
 * 기본 CustomerGrade = Silver
 * 
 * 메서드
 * 1. 보너스 적립 계산 메서드
 *    => 구매 금액을 주고 적립 보너스를 계산하여 bonusPoint 누적
 *    => 보너스 적립, 할인여부를 체크하여 구매금액을 리턴
 *    
 * 2. 출력메서드
 * 	  => 홍길동님은 VIP등급이며, 보너스 포인트는 5000점 입니다.
 * 	  	 전담 상담사 번호는 1111입니다. <- VIP만 추가 ( agentID )
 * 
 */


public class Customer {
	
	protected String customerID;
	protected String customerName;
	protected String customerGrade = "Silver";
	protected int bonusPoint;
	protected double bonusRatio;
	
	
	public Customer() {
	}

	public Customer(String customerID, String customerName) {
		this.customerID = customerID;
		this.customerName = customerName;
	}

	public int bonus(Customer customer, int price) {
		
		if(customer instanceof GoldCustomer) {
			bonusRatio = 0.02;
		} else if (customer instanceof VIPCustomer) {
			bonusRatio = 0.05;
		} else {
			bonusRatio = 0.01;
		}
		
		bonusPoint += price*bonusRatio;
			
		return price;
			
	}
	
	public void print(Customer customer) {
		
		if(customer instanceof GoldCustomer) {
			customerGrade = "Gold";
		} else if(customer instanceof VIPCustomer) {
			customerGrade = "VIP";
		}
		
		System.out.println(customerName + "님은 " + customerGrade + "등급이며, " + "보너스 포인트는 " + bonusPoint +"점 입니다." );
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public double getBonusRatio() {
		return bonusRatio;
	}

	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	
	
	
	
}
