package sale;

import java.util.Objects;

public class Menu {

	/*
	 * menu Class 생성 제품ID 제품명 가격
	 */
	protected int productID;
	protected String productName;
	protected int price;
	
	
	public Menu() {
		
	}
	
	
	
	// equals용 생성자
	public Menu(String productName) {
		this.productName = productName;
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
		return "Menu [productID=" + productID + ", productName=" + productName + ", price=" + price + "]";
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


	@Override
	public int hashCode() {
		return Objects.hash(productID, productName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		return Objects.equals(productName, other.productName);
	}


	
	


	

	

	
	
	

}
