package fishing;

import java.util.Map;

public class FishingServiceImpl implements FishingService {
	
	private FishingDAO dao;
	
	public FishingServiceImpl() {
		dao = new FishingDAOImpl();
	}
	

	@Override
	public int addFish(int num, String fish_name, int fish_size) {
//		System.out.println("Fishing service 접근 완료.");
		return dao.addFish(num, fish_name, fish_size);
	}


	@Override
	public Map<String, Integer> getResult(int num) {
//		System.out.println("Fishing service 접근 완료.");
		return dao.getResult(num);
	}


	@Override
	public int consumeBait(int num) {
//		System.out.println("Fishing service 접근 완료.");
		return dao.consumeBait(num);
	}


	@Override
	public boolean isBaitReady(int num) {
//		System.out.println("Fishing service 접근 완료.");
		return dao.isBaitReady(num);
	}


	@Override
	public User displayNicknameBait(int num) {
//		System.out.println("Fishing service 접근 완료.");
		return dao.displayNicknameBait(num);
	}


	@Override
	public User getUser(int num) {
//		System.out.println("Fishing service 접근 완료.");
		return dao.getUser(num);
	}

}
