package fishing;

// 건희 것 복붙
public class StateServiceImpl implements StateService {
	private StateDAO dao;
	public StateServiceImpl() {
		dao = new StateDAOImpl();
	}

	@Override
	public State getSpot(String spot) {
//		System.out.println("Spot serviceImpl Success");
		return dao.printSpot(spot);
	}
	@Override
	public void calc(String spot, int num) {
//		System.out.println("Spot serviceImpl Success");
		dao.getCalc(spot, num);
	}

}