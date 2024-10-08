package day07;

import java.util.Random;

public class ExceptionEx01 {

	public static void main(String[] args) {
		// 리턴 받은 배열울 출력 
		
		int start = 1 , count = -1, size = 0;
		int arr[] = null;
		
		ExceptionEx01 ex01 = new ExceptionEx01();
		
		
		try {
			int arr2[] = new int [size];
			arr2 = ex01.cvArr(size, start, count);
			
		} catch(NegativeArraySizeException e) {
			System.out.println("사이즈 에러.");
			e.printStackTrace();
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 길이 범위 에러.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("에러발생");
			e.printStackTrace();
		}
		
		
//		int arr[] = new int[5];
		
		
		try {
			ex01.cvArr2(arr, start, count);
			
		} catch(NullPointerException e) {
			System.out.println("배열의 값이 null입니다.");
			e.printStackTrace();
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 길이 범위 에러.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("에러발생");
			e.printStackTrace();
		}
		
		
		
	}
	
	/* 메서드 생성
	 * 기능 : size를 입력받아(매개변수) size만큼의 길이를 가지는 배열을 생성하여 랜덤값을 채워 배열을 리턴
	 * 랜덤값은 범위를 매개변수를 받아 start(시작값), count(개수)
	 * - size가 0보다 작으면 예외발생
	 * - 랜덤값의 개수가 0이면 예외발생
	 */
	
	
	/* 메서드
	 * 기능 : 매개변수로 배열을 받아 랜덤값을 채우는 메서드 
	 * 랜덤값은 범위를 매개변수를 받아 start(시작값), count(개수)
	 * - 랜덤값의 개수가 0이면 예외발생
	 * - 배열이 null이면 예외발생
	 * - 배열의 길이가 0보다 작으면 예외발생
	 */

	public int[] cvArr(int size, int start, int count) {
		if( (size < 0 || count <= 0) || size < count ) {
			throw new RuntimeException("에러발생");
		}
		int arr[] = new int[size];
		int random = new Random().nextInt(count)+start;
		// RuntimeException이 아닌 Checked Exception 이었다면 이미 빨간밑줄이그어짐.
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random;
		}
		
		return arr;
		
	}
	
	public int[] cvArr2(int arr[], int start, int count) {
		if( arr.length <= 0 || count <= 0 || arr == null || arr.length < count ) {
			throw new RuntimeException("에러발생");
		}
		int random = new Random().nextInt(count)+start;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random;
		}
		
		return arr;
	}
	
	
}
