package day08;

import java.util.HashMap;
import java.util.Iterator;

public class Map01 {

	public static void main(String[] args) {
		/* Map
		 * - 값을 2개 쌍으로 저장. key / value 
		 * - key : 중복불가능, value : 중복가능 
		 * - key가 index 대용
		 * - index가 없으면 정렬X, 중복X
		 * - HashMap을 가장 많이 사용
		 * 홍길동 70 
		 * 김영이 87
		 * 
		 * Map <클래스,클래스> map = new HashMap<클래스, 클래스>();
		 * map은 값이 2개이기 때문에 향상된 for문 / iterator 사용불가 
		 * map => key만 분리 후 set으로 구성 후 출력
		 * 
		 * list, set => add() : 추가
		 * map => put() : 추가
		 * keySet() : 키를 기준으로 값을 가져오는 것이 가능
		 * get(key) : key에 해당하는 value를 리턴
		 * 
		 */
		
		HashMap<String, Integer> map = new HashMap<>();
		
		map.put("길동", 70);
		map.put("영이", 87);
		map.put("철수", 56);
		map.put("영철", 40);
		map.put("순이", 98);
		System.out.println(map);
		System.out.println(map.keySet());
		System.out.println(map.values());
		
		// - get(key) : value 리턴
		String name = "길동";
		System.out.println(map.get(name));
		System.out.println(map.get("영이"));
		
		// remove(Object key) : key의 값을 삭제하면서 value를 리턴
		// remove(Object key, Object value) : true / false 리턴
		System.out.println(map.remove(name));
		System.out.println(map);
		System.out.println(map.remove("영이", 87));
		System.out.println(map);
		System.out.println(map.remove(name)); // null
		System.out.println(map);
		
		
		int sum = 0;
		
		for(String key : map.keySet()) {
			sum += map.get(key); // value 합산 
			System.out.println(key + ":" + map.get(key));
		}
		System.out.println(sum);
		
		System.out.println("---------------");
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + ":" + map.get(key));
		}
		
		
	}

}
