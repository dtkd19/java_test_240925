package fishing;

import java.util.List; // 기빈

public interface UserDAO {


	int signUpUser(User u);

	User loginUser(String id, String pw);
	
	boolean userIdExists(String id);
	
	// 기빈 시작
	// 인벤 리스트
	List<Inventory> userInven(int num);
		
	// 떡밥
	int userBait(User u);
	
	// 낚시대
	int userRod(User u);

	// 물고기 선택판매
	int userOneMoney(User u);
	int sellOne(Inventory i);

	// 물고기 모두판매
	int userAllMoney(User u);
	int sellAll(Inventory i);

	User userInfo(int num);

	boolean compMoney(User u1);
	
	boolean compRod(User u2);
	
	List<Inventory> userRank(int num);
	// 기빈 끝
}