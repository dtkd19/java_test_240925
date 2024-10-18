package fishing;

import java.util.List; // 기빈

public class UserServiceImpl implements UserService {

	private UserDAO dao;
	
	public UserServiceImpl() {
		dao = new UserDAOImpl();
	}
	
	
	@Override
	public int signUp(User u) {
//		System.out.println(" 회원가입 서비스 에러 확인 성공 ");
		
		return dao.signUpUser(u);
	}


	@Override
	public User login(String id, String pw) {
//		System.out.println("로그인 서비스 에러 확인 성공");
		return dao.loginUser(id,pw);
	}
	
	@Override
	public boolean isUserIdExists(String id) {
		// TODO Auto-generated method stub
		return dao.userIdExists(id);
	}
	
	// 기빈 시작
	@Override
	public int updBait(User u) {
//		System.out.println("떡밥 구매 에러 확인 성공");
		return dao.userBait(u);
	}

	@Override
	public int updRod(User u) {
//		System.out.println("낚시대 구매 에러확인 성공");
		return dao.userRod(u);
	}

	@Override
	public int plusOneMoney(User u) {
//		System.out.println("금액 입금 에러확인 성공");
		return dao.userOneMoney(u);
	}

	@Override
	public int plusAllMoney(User u) {
//		System.out.println("금액 입금 에러확인 성공");
		return dao.userAllMoney(u);
	}

	@Override
	public User userInfo(int num) {
//		System.out.println("회원정보 출력 에러확인 성공");
		return dao.userInfo(num);
	}

	@Override
	public boolean compMoney(User u1) {
//		System.out.println("회원 잔고조회 에러확인 성공");
		return dao.compMoney(u1);
	}
	@Override
	public int sellOneFish(Inventory i) {
//		System.out.println("물고기 판매 에러확인 성공");
		return dao.sellOne(i);
	}

	@Override
	public int sellAllFish(Inventory i) {
//		System.out.println("물고기 판매 에러확인 성공");
		return dao.sellAll(i);
	}
	
	@Override
	public List<Inventory> getInven(int num) {
//		System.out.println("인벤리스트 서비스 에러 확인 성공");
		return dao.userInven(num);
	}
	
	@Override
    public boolean compRod(User u2) {
//        System.out.println("낚싯대 비교 에러확인 성공");
        return dao.compRod(u2);
    }


	@Override
	public List<Inventory> getRank(int num) {
//        System.out.println("랭킹 에러확인 성공.");
        return dao.userRank(num);
    }

	
	
	// 기빈 끝

}