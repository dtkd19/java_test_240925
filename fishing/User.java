package fishing;

public class User {
	
	    private int num; // 자동생성
	    private String user_id;
	    private String passwd;
	    private String nickname;
	    private String fishrod;
	    private int money;
	    private int bait;
	    
	    // 기빈
		private int baitCnt;			// 떡밥구매 수량
		private int baitPrice;			// 떡밥구매 비용
		private int sellNum;			// 판매하려는 인벤 번호
		private int cost;				// 낚싯대 가격
		
		private long tmp;
	    public User() {}

	    // 회원가입 
		public User(String id, String pw, String nickname) {
			this.user_id = id;
			this.passwd = pw;
			this.nickname = nickname;
			this.fishrod = "normal";
			this.money = 10000;
			this.bait = 0;
		}
		
		public User(String nickname, int bait) { // 내가 추가한 생성자. 유저의 미끼 수 받을 때 필요함
			this.nickname = nickname;
			this.bait = bait;
		}
		
		// 기빈 시작
		// 회원정보
		public User(String user_id, String nickname, String fishrod, int money, int bait) {
			this.user_id = user_id;
			this.nickname = nickname;
			this.fishrod = fishrod;
			this.money = money;
			this.bait = bait;
		}
		// 떡밥 구매
		public User(int num, int baitCnt, int baitPrice) {
			this.num = num;
			this.baitCnt = baitCnt;
			this.baitPrice = baitPrice;
		}
		// 낚시대 구매
		public User(int num, String fishrod, int cost) {
			this.num = num;
			this.fishrod = fishrod;
			this.cost = cost;
		}
		// 낚싯대 비교
        public User(int num, String fishrod) {
            this.num = num;
            this.fishrod = fishrod;
        }
        // 기빈 끝
        // 낚싯대 구매
		public User(int num, long tmp, int cost) {
			this.num = num;
			this.cost = cost;
			this.tmp = tmp;
		}
		// 선택판매
		public User(int num, int sellNum) {
			this.num = num;
			this.sellNum = sellNum;
		}
		// 물고기 모두판매 후 금액입금, 잔고확인 후 낚시대 구매 메서드 참고
		public User(int num) {
			this.num = num;
		}
		// 기빈 끝

		
		// getter | setter
		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}

		public String getPasswd() {
			return passwd;
		}

		public void setPasswd(String passwd) {
			this.passwd = passwd;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public String getFishrod() {
			return fishrod;
		}

		public void setFishrod(String fishrod) {
			this.fishrod = fishrod;
		}

		public int getMoney() {
			return money;
		}

		public void setMoney(int money) {
			this.money = money;
		}

		public int getBait() {
			return bait;
		}

		public void setBait(int bait) {
			this.bait = bait;
		}
		
		// 엄씨 기빈 getter / setter 추가
		public int getBaitCnt() {
			return baitCnt;
		}

		public void setBaitCnt(int baitCnt) {
			this.baitCnt = baitCnt;
		}

		public int getBaitPrice() {
			return baitPrice;
		}

		public void setBaitPrice(int baitPrice) {
			this.baitPrice = baitPrice;
		}
		
		public int getSellNum() {
			return sellNum;
		}

		public void setSellNum(int sellNum) {
			this.sellNum = sellNum;
		}
		
		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}
		// 기빈 끝
		@Override
		public String toString() {
			return "닉네임 : " + nickname + "\t낚싯대 등급 : " + fishrod + "\t돈 : " + money + "\t소지한 미끼 : " + bait;
		}

		// 비번은 안나오게  일단 빼둿음
				
}