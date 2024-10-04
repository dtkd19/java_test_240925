package lotto;

import java.util.Arrays;
import java.util.Scanner;

public class Lotto {

	protected int userNum[] = new int[6];
	protected int comNum[] = new int[6];

	public int[] creativeNum(Scanner scan) {
		

		System.out.println("당신의 로또번호를 입력해주세요 (1~45 ,로 나눠서 6개 중복X)");
		String num = scan.next();
		String[] myNum = num.split(",");

		
		for (int i = 0; i < userNum.length; i++) {
						
			userNum[i] = Integer.parseInt(myNum[i]);
			
		}
		
		return userNum;
		
	}
	
	public Lotto() {}
	
	

	public Lotto(int[] userNum) {
		this.userNum = userNum;
	}
	
	
	public Lotto(int[] userNum, int[] comNum) {
		this.userNum = userNum;
		this.comNum = comNum;
	
	}
	
	
	public void insertUserLotto(int[] userNum) {
		this.userNum = userNum;
	}
	public void insertComLotto(int[] comNum) {
		this.comNum = comNum;
	}
	
	

	public int[] creativeComNum() {
		for (int i = 0; i < comNum.length; i++) {
			int random = (int) (Math.random() * 45) + 1;
			if (setLottoNum(comNum, random) == false) {
				comNum[i] = random;
			} else {
				i--;
			}
		}
		
		return comNum;
	}

	public boolean setLottoNum(int arr[], int num) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				return true;
			}
		}
		return false;
	}

	public void userNumPrint() {
		for (int i = 0; i < userNum.length; i++) {
			System.out.print(userNum[i] + " ");
		}
		System.out.println();
	}
	
	public void comNumPrint() {
		for (int i = 0; i < comNum.length; i++) {
			System.out.print(comNum[i] + " ");
		}
		System.out.println();
	}

	

	@Override
	public String toString() {
		return "Lotto [userNum=" + Arrays.toString(userNum) + ", comNum=" + Arrays.toString(comNum) 
				+ "]";
	}

	public int[] getUserNum() {
		return userNum;
	}

	public void setUserNum(int[] userNum) {
		this.userNum = userNum;
	}


	public int[] getComNum() {
		return comNum;
	}

	public void setComNum(int[] comNum) {
		this.comNum = comNum;
	}

}
