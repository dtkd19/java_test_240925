package day01;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 국어 영어 수학 세 점수의 합계와 평균을 출력
		 * */
		int kor = 78;
		int math = 71;
		int eng = 97;
		int sum = kor + math + eng;
		double avg = (double)sum / 3 ;
		
		if( avg >= 80) {
			System.out.printf("합계 : %d , 평균 : %.2f , 합격여부 : pass " , sum , avg);
		} else {
			System.out.println("합계 : " + sum +  " 평균 : " + avg + " 합격여부 : " +  "fail");
		}
		
	}

}
