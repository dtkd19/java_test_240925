package day06;

public class GoldCustomer extends Customer {
	private double discount; // 할인율
	
	

	public GoldCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GoldCustomer(String customerID, String customerName) {
		super(customerID, customerName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int bonus(Customer customer, int price) {
		
		super.bonus(customer, price);
		
		if(customer instanceof GoldCustomer) {
			discount = 0.1;
			price = price - (int)((double)price * discount);
		}
		
		return price;
		
		
	}

	
}
