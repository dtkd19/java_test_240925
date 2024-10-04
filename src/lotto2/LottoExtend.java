package lotto2;


public class LottoExtend extends Lotto {
	
	// Lotto 클래스를 상속받아서 보너스 처리만 함
	private int bonus;

	@Override
	protected void randomLotto() {
		// 기존 numbers 6자리 배열 채우기는 이미 완성
		// 기존 번호에 중복없이 보너스 번호 생성
		super.randomLotto();
		while(true) {
			int r = random();
			if(!isContain(r)) {
				bonus = r ;
				break;
			}
		}
		
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		super.init(); // numbers 배열을 새로 만들어 놓은 상태
		bonus = 0;
	}

	@Override
	protected void insertNumbers(int[] arr) {
		// 가져온 번호가 7자리일 경우...
		super.insertNumbers(arr);
		this.bonus = arr[numbers.length]; // 6번지 채우기 나머지는 버리기
	}
	protected void insertNumbers(int[] arr, int bonus) {
		// 가져온 번호는 6자리, 보너스를 별도로 가져오는 경우일 경우...
		super.insertNumbers(arr);
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+ "[" + bonus + "]";
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	

   
    
    
}
