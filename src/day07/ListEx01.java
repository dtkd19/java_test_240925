package day07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ListEx01 {

	public static void main(String[] args) {
		/* 하루 일과를 저장하는 list를 생성 
		 * 출력 for / 향상된 for / Iterator 출력 
		 * import 단축키 : ctrl + shift + o
		 */
		
		List<String> dayList = new ArrayList<String>();
		
		
		dayList.add("wake up");
		dayList.add("study");
		dayList.add("eat");
		dayList.add("study");
		dayList.add("sleep");
		
		for(int i = 0; i < dayList.size(); i++) {
			System.out.println(dayList.get(i));
		}
		System.out.println("------------------------");
		
		for(String tmp : dayList) {
			System.out.println(tmp);
		}
		System.out.println("------------------------");
		
		Iterator<String> it = dayList.iterator(); 
		
		while(it.hasNext()) {
			String tmp = it.next();
			System.out.println(tmp);
		}
		System.out.println("------------------------");
		
		// 정렬 dayList.sort(Comparator 구현체);
		// 오름차순
		Collections.sort(dayList);
		
		System.out.println(dayList);
		
		dayList.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// compareTo 
				// 사전순으로 앞에 있으면 - 같으면 0 뒤에 있으면 + 
				// o1.compareTo(o2);  : 오름차순
				// o2.compareTo(o1);  : 내림차순
				return o2.compareTo(o1);
			}
			
		});
		
		System.out.println(dayList);
		List<String> ex = new ArrayList<String>();
		ex.add("study");
		dayList.removeAll(ex); // 같은 Object가 2개 이상이더라도 앞에있는 하나만 삭제
		System.out.println(dayList);
		
	}

}
