package day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListEx03 {

	public static void main(String[] args) {
		/*  num의 값을 숫자 List를 생성하여 추가  => 출력
		 * 합계를 출력
		 * 70점 이상인 인원 수 출력
		 * 3/8명
		 */
		String num = "45,78,98,65,84,52,64,31";
		
		String[] myNum = num.split(",");
				
		
		List<String> list = new ArrayList<String>(Arrays.asList(myNum));
		
		System.out.println(list);
		
		System.out.println(" -- 출력 -- ");
		for(String tmp : list) {
			System.out.println(tmp);
		}
		
		
		int sum = 0;
		
		for(int i =0; i < list.size(); i++) {
			sum += Integer.parseInt(list.get(i));
		}
		
		System.out.println(" -- 합계 --");
		System.out.println(sum);
		
		System.out.println(" -- 70점 이상인 인원 수 출력 -- ");

		int cnt = 0;
		for(int i = 0; i< list.size(); i++) {
			if(Integer.parseInt(list.get(i)) >= 70){
				cnt++;
			}
		}
		System.out.println(cnt + " / " + list.size());
	}

}
