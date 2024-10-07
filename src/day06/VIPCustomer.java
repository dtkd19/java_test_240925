package day06;

public class VIPCustomer extends Customer {
	private double discount;
	private String agentID;
	

	
	public VIPCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VIPCustomer(String customerID, String customerName) {
		super(customerID, customerName);
		// TODO Auto-generated constructor stub
	}
	
	public VIPCustomer(String customerID, String customerName, String agentID) {
		super(customerID, customerName);
		this.agentID = agentID;
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public int bonus(Customer customer, int price) {
		
		super.bonus(customer, price);
		
		if(customer instanceof VIPCustomer) {
			discount = 0.1;
			price = price - (int)((double)price * discount);
		}
		
		return price;
	}
	
	@Override
	public void print(Customer customer) {
		// TODO Auto-generated method stub
		
		super.print(customer);
		System.out.println("전담 상담사 번호는 " + agentID + "입니다.");
	}

	public String getAgentID() {
		return agentID;
	}

	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}
	
	
	
}
