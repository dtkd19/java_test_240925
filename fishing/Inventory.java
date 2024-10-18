package fishing;

public class Inventory {

	private int inven_id;
	private int num;
	private int fish_no;
	private int fish_size;
	private String fish_name; // 기빈
	private int sellno; // 기빈
	
	public Inventory(int inven_id, int num, int fish_no, int fish_size) {
		this.inven_id = inven_id;
		this.num = num;
		this.fish_no = fish_no;
		this.fish_size = fish_size;
	}
	
	
	// 기빈 start
	// 인벤 불러오기
		public Inventory(int inven_id, String fish_name, int fish_size) {
			this.inven_id = inven_id;
			this.fish_name = fish_name;
			this.fish_size = fish_size;
		}
	// 물고기 선택 판매
	public Inventory(int num, int sellno) {
		this.num = num;
		this.sellno = sellno;
	}
	
	// 물고기 모두 판매
	public Inventory(int num) { // Inventory(int fish_size)와 중복
		this.num = num;
	}
	//
	public Inventory(String fish_name, int fish_size) {
		this.fish_name = fish_name;
		this.fish_size = fish_size;
	}
	
	public String invenList() {
		return "인벤토리 번호 : " + inven_id + " 물고기 이름 : " + fish_name +" 물고기 크기 : " + fish_size;
	}
	// 기빈 Finish
	
//	public Inventory(int fish_size) {
//		this.fish_size = fish_size;
//	}
	
	public String rankList() {
        return "물고기 : " + fish_name +"\t 크기 : " + fish_size;
    }

	public int getInven_id() {
		return inven_id;
	}

	public void setInven_id(int inven_id) {
		this.inven_id = inven_id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getFish_no() {
		return fish_no;
	}

	public void setFish_no(int fish_no) {
		this.fish_no = fish_no;
	}

	public int getFish_size() {
		return fish_size;
	}

	public void setFish_size(int fish_size) {
		this.fish_size = fish_size;
	}
	
	// 기빈 시작
	public int getSellno() {
		return sellno;
	}

	public void setSellno(int sellno) {
		this.sellno = sellno;
	}
	// 기빈 끝
	
	
	
}
