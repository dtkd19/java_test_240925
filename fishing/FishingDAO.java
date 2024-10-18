package fishing;

import java.util.Map;

public interface FishingDAO {

	int addFish(int num, String fish_name, int fish_size);

	Map<String, Integer> getResult(int num);

	int consumeBait(int num);

	boolean isBaitReady(int num);
	
	User displayNicknameBait(int num);

	User getUser(int num);
}
