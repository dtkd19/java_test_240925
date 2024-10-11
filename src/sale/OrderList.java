package sale;

import java.util.ArrayList;
import java.util.List;

public class OrderList {

	private int orderNum;
	private List<Order> orderList = new ArrayList<>();
	
	
	
	
	
	public OrderList(int orderNum) {
		this.orderNum = orderNum;
		
	}


	public void addOrder(Order order) {
		this.orderList.add(order);
	}

	
	
	@Override
	public String toString() {
		return "OrderList [주문번호=" + orderNum + ", 주문내역=" + orderList + "]";
	}


	public int getOrderNum() {
		return orderNum;
	}


	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}


	public List<Order> getOrderList() {
		return orderList;
	}


	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	
	
	
}
