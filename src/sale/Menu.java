package sale;



public class Menu {

	/*
	 * menu Class 생성 제품ID 제품명 가격
	 */
	protected int productID;
	protected String productName;
	protected int price;
	
	
	public Menu() {
		
	}
	
	
	
	public Menu(String productName, int price) {
		
		this.productName = productName;
		this.price = price;
	}




	public Menu(int productID, String productName, int price) {
		this.productID = productID;
		this.productName = productName;
		this.price = price;
	}
	
	

	
	@Override
	public String toString() {
		return "Menu [productName=" + productName + ", price=" + price + "]";
	}




	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	

}
