package sale;

public class Order extends Menu {

	/*
	 * order Class 생성 Menu 상속 주문번호 제품ID 제품명 수량 가격 총금액
	 */
	
	private int orderNum;
	private int orderAmount;
	private int salePrice;
	
	public Order() {
		
	}
	
	
	

	public Order(int productID ,String productName, int price, int orderAmount, int salePrice) {
		super(productID ,productName, price);
		this.orderAmount = orderAmount;
		this.salePrice = price * orderAmount;
		
	}
	
	
	
	// super.toString(); // 부모의 toString 호출
	
	public void orderPrint() {
		System.out.println(super.toString());
		System.out.println(orderAmount + "개 주문 => 금액 : " + salePrice  );
	}
	

	@Override
	public String toString() {
		return "Order [orderNum=" + orderNum + " productName=" + productName + ", orderAmount=" + orderAmount + ", salePrice=" + salePrice + "]";
	}
	
	

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}


	
	
	
	
}
