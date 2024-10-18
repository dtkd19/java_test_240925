package fishing;

public class Fish {
	/*
	 * create table fish (
	 * fish_no int auto_increment,
	 * fish_name varchar(20),
	 * price int not null,
	 * default_size int,
	 * primary key(fish_no)
	 * );
	 */
	private int fish_no;
	private String fish_name;
	private int price;
	private int default_size;
	
	// Constructor
	public Fish(int fish_no, String fish_name, int price, int default_size) {
		this.fish_no = fish_no;
		this.fish_name = fish_name;
		this.price = price;
		this.default_size = default_size;
	}
	
	public Fish(int fish_no) {
		this.fish_no = fish_no;
	}

	public int getFish_no() {
		return fish_no;
	}

	public void setFish_no(int fish_no) {
		this.fish_no = fish_no;
	}

	public String getFish_name() {
		return fish_name;
	}

	public void setFish_name(String fish_name) {
		this.fish_name = fish_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDefault_size() {
		return default_size;
	}

	public void setDefault_size(int default_size) {
		this.default_size = default_size;
	}
	
	
}