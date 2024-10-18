package fishing;

// 건희가 한 것 째로 복붙.
public class State {
	private String state_name;
	private int enter_fee;
	
	public State() {}
	
	public State(String state_name, int enter_fee) {
		this.state_name = state_name;
		this.enter_fee = enter_fee;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public int getEnter_fee() {
		return enter_fee;
	}

	public void setEnter_fee(int enter_fee) {
		this.enter_fee = enter_fee;
	}
	
}