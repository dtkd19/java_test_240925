package fishing;

public class User {
	
	    private int num; // 자동생성
	    private String user_id;
	    private String passwd;
	    private String nickname;
	    private String fishrod;
	    private int money;
	    private int bait;
		 
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

		@Override
		public String toString() {
			return "User [num=" + num + ", user_id=" + user_id + ", nickname=" + nickname
					+ ", fishrod=" + fishrod + ", money=" + money + ", bait=" + bait + "]";
		}

		// 비번은 안나오게  일단 빼둿음
				
}
