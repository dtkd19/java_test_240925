package lotto;

import java.util.Arrays;

import java.util.Scanner;

public class LottoExtend extends Lotto {
	
	
	private int hitNumber[] = new int[6];
	
    private int bonusNum; // 보너스 번호
    
    private int count = 0;

    public LottoExtend() {
        
    }

  

    public LottoExtend(int[] hitNumber) {
		super();
		this.hitNumber = hitNumber;
	}



	public LottoExtend(int[] hitNumber, int bonusNum) {
		super();
		this.hitNumber = hitNumber;
		this.bonusNum = bonusNum;
	}
    
    


	public int[] creativeHitNumber(Scanner scan) {
 
		System.out.println(" 당첨 로또번호를 입력해주세요 (1~45 ,로 나눠서 6개 중복X)");
		String num = scan.next();
		String[] myNum = num.split(",");

		
		for (int i = 0; i < hitNumber.length; i++) {
						
			hitNumber[i] = Integer.parseInt(myNum[i]);
			
			
		}
		
		return hitNumber;
    }

	public int BonusNumber(Scanner scan) {
		
		System.out.println("보너스 넘버를 입력해주세요 (1~45)");
		this.bonusNum = scan.nextInt();
		
	    while (bonusNum < 1 || bonusNum > 45) {
	           System.out.println("잘못된 번호입니다. 1~45 사이의 숫자를 입력해주세요:");
	           bonusNum = scan.nextInt();
	        	}
		
		return bonusNum;
	}
	
	
    public void printBonusNum() {
        System.out.println("보너스 번호: " + bonusNum);
    }

    


    

	@Override
	public String toString() {
		return "LottoExtend [hitNumber=" + Arrays.toString(hitNumber) + ", bonusNum=" + bonusNum + "]";
	}



	public int[] getHitNumber() {
		return hitNumber;
	}

	public void setHitNumber(int[] hitNumber) {
		this.hitNumber = hitNumber;
	}

	public int getBonusNum() {
        return bonusNum;
    }

    public void setBonusNum(int bonusNum) {
        this.bonusNum = bonusNum;
    }



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}
    
    
}
