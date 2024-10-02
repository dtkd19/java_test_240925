package day05;

public class Product {
	
	private String name;
	private String price;
	private int num;
	
	public Product() {
		
	}
	
	public Product(String name, String price) {
		this.name = name;
		this.price = price;
	}
	
	public void insertProduct(String name, String price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return name + ":" + price + "원" ;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
