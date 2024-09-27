package day02;

public class Lotto {

	public static void main(String[] args) {
		/*
		 * 로또 번호 생성
		 */

		int lotto[] = new int[7];
		int user[] = new int[6];
		
		Lotto l = new Lotto();
		
		l.lottoNum(lotto);
		l.lottoNum(user);
		
		
		l.NumPrint(lotto);
		l.NumPrint(user);
		
		l.resultPrint(lotto, user);
		
//		int count = 0;
		
//		while(!(l.result(lotto, user) == 6)) {
//			l.lottoNum(lotto);
//			l.lottoNum(user);
//			
//			
//			l.NumPrint(lotto);
//			l.NumPrint(user);
//			
//			l.resultPrint(lotto, user);
//			
//			count++;
//		} System.out.println(count);
			
		
	}

	/*
	 * 배열을 매개변수로 받아 1~45 까지의 랜덤수를 채워서 생성 ( 중복 불가능 - 메서드 호출로 구현)
	 * 리턴 할 필요가 없음. main에 있는 배열을 채우기.
	 */
	
	/*
	 * 배열과 값을 주고 같은지 아닌지 확인하는 메서드
	 * 배열에 값이 있으면 true / 없으면 false 
	 */
	
	/*
	 * 배열(매개변수) 의 값을 출력하는 메서드
	 * 1 2 3 4 5 6 [7] 당첨번호 출력방식
	 * 1 2 3 4 5 6 유저번호 출력방식
	 */
	
	/*
	 * 등수확인 메서드
	 * -- 당첨기준
	 * 6개일치 : 1등
	 * 5개일치 + 보너스번호 : 2등
	 * 5개일치 : 3등
	 * 4개일치 : 4등
	 * 3개일치 : 5등
	 * 나머지는 꽝
	 */
	
	
	public void lottoNum(int arr[]) {
		
		for (int i = 0 ; i < arr.length ; i++) {
		int random = (int)(Math.random() * 45) + 1;
			if ( setLottoNum(arr,random) == false) {
				arr[i] = random;
			} else {
				i--;
			}
		}
	
	}
	
	public boolean setLottoNum(int arr[] , int num) {
		for ( int i = 0 ; i < arr.length; i++) {
			if(arr[i] == num ) {
				return true;
			}
		}
		return false;
	}
	
	public void NumPrint(int arr[]) {
		for( int i = 0; i < arr.length; i ++) {
			if(arr.length > 6 ) {
				System.out.print( ( i == 6) ? "["+ arr[i] + "]" : arr[i] + " " );
			} else {				
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}
	
	public int result(int arr[],int arr2[]) {
		int count = 0;
		
		for( int i = 0; i < arr2.length ; i ++) {
			for ( int j = 0; j < arr2.length; j ++) {
				if ( arr[i] == arr2[j]) {
					count++;
				} 
			}
		}
		return count;
		
	}
	
	public int bonus(int arr[],int arr2[]) {
		int bonus = 0;
		for ( int n = 0; n < arr2.length; n ++) {
			if ( arr[arr2.length] == arr2[n]) {
				bonus++;
			}
		}
		return bonus;
	}
	
	public void resultPrint(int arr[], int arr2[]) {
		
		if(arr.length <= arr2.length) {
			System.out.println("배열 입력 error");
			return;
		}
		
		if( result(arr, arr2) == 6) {
			System.out.println("1등입니다.");
		} else if ( result(arr,arr2) == 5 && bonus(arr,arr2) == 1) {
			System.out.println("2등입니다.");
		} else if ( result(arr,arr2) == 5) {
			System.out.println("3등입니다.");
		} else if ( result(arr,arr2) == 4) {
			System.out.println("4등입니다.");
		} else if ( result(arr,arr2) == 3) {
			System.out.println("5등입니다.");
		} else {
			System.out.println("꽝입니다.~");
		}
	}
	
	
}
