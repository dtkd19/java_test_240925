package fishing;

public interface StateService {

	State getSpot(String spot);

	void calc(String rod, int num);

}