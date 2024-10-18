package fishing;

import java.util.List; // 기빈

public interface UserService {
	
	int signUp(User u);

	User login(String id, String pw);
	
	boolean isUserIdExists(String id);
	
	// 기빈 시작
	// 가방 리스트 출력
	List<Inventory> getInven(int num);
	
	// 떡밥 구매
	int updBait(User u);
	
	// 낚시대 구매
	int updRod(User u);
	
	// 물고기 선택판매
	int plusOneMoney(User u);
	int sellOneFish(Inventory i);
	
	// 물고기 모두판매
	int plusAllMoney(User u);
	int sellAllFish(Inventory i);
	
	User userInfo(int num);

	boolean compMoney(User u1);
	
	boolean compRod(User u2);
	
	List<Inventory> getRank(int num);
	// 기빈 끝
	
}