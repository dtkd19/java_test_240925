package day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListEx02 {

	public static void main(String[] args) {
		
		// 두 배열을 하나의 리스트로 합치기 
		// 정렬하여 출력 ( 오름 , 내림 )
		
		// 직접 해당 값을 리스트로 옮기기
		// Arrays.asList() : 배열 => 리스트
		// toArray() : 리스트 => 배열
		
		
		String arr1[] = new String[] {"a","g","f","h","c"};
		String arr2[] = new String[] {"b","t","s","p","n","m"};

		
		List<String> strList = new ArrayList<String>();
		List<String> strList2 = Arrays.asList(arr1);
		
		System.out.println(strList2);
		// 배열과 list가 연결되어있는 상태 추가 불가능 / 수정 가능 
		// 리스트 ==  배열 원본 배열 변경  
//		strList2.add("z");
//		strList2.set(0,"z");
//		System.out.println(strList2);
		
		System.out.println("-- new ArrayList arr1 --");
		List<String> strList3 = new ArrayList<String>(Arrays.asList(arr1));
		System.out.println(strList3);
		strList3.add("z");
		System.out.println(strList3);
		System.out.println("-- new ArrayList arr2 --");
		List<String> strList4 = new ArrayList<String>(Arrays.asList(arr2));
		System.out.println(strList4);
		
		System.out.println("-- list addAll --");
		strList3.addAll(strList4);
		System.out.println(strList3);
		
		
		// List를 배열로 변환
		System.out.println("-- 리스트를 배열로 변환 --");
		int listSize = strList3.size();
		
		String[] arr = (String[]) strList3.toArray(new String[listSize]);
		System.out.println(Arrays.toString(arr));

		
		System.out.println(" -- 손수 옮기기 --");
		int cnt = arr1.length + arr2.length;
		int i=0, j = 0;
		
		while(cnt > strList.size()) {
			if(i<arr1.length) {
				strList.add(arr1[i]);
				i++;
			}
			if(j<arr2.length) {
				strList.add(arr2[i]);
				j++;
			}
		}
		System.out.println(strList);
		
		
		Collections.sort(strList);
		
		System.out.println(" ---------- 오름차순 --------- ");
		for(String tmp : strList) {
			System.out.print(tmp+ " ");
		}
		System.out.println();
		
		// 오름차순 
		System.out.println(strList);
		
		strList.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
			
		});
		
		System.out.println(" ---------- 내림차순 --------- ");
		for(String tmp : strList) {
			System.out.print(tmp+ " ");
		}
		System.out.println();
		
		// 내림차순
		System.out.println(strList);
		
		
		
	}

}
