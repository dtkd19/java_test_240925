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

	public Order(String productName, int price, int orderAmount, int salePrice) {
		super(productName, price);
		this.orderAmount = orderAmount;
		this.salePrice = price * orderAmount;
		
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
