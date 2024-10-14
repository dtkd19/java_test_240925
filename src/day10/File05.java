package day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class File05 {

	public static void main(String[] args) throws IOException {
		// test.text 파일을 읽어들여 map에 저장
		// 명단, 합계, 평균 출력
		// 읽어 들이는 파일은 모두 String
		// 계산을 위해선 int로 변환이 필요 
		// Interger.parseInt();
		// 80점 이상인 학생 명단 
		
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		
		Map<String,Integer> map = new HashMap<>();
		int sum = 0;
		while(true) {
			String line = br.readLine();
			if(line == null) {
				break;
			}
//			String[] line2 = line.split(" ");
			
			String name = line.substring(0,line.indexOf(" "));
			int score = Integer.parseInt(line.substring(line.indexOf(" ")+1));
			
			sum += score;
			map.put(name, score);
//			map.put(line2[0], Integer.parseInt(line2[1]));	
		}
		br.close();
		
		double avg = 0;
		
		
		// 명단
		System.out.println(" -- 명단 -- ");
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + " : " + map.get(key));
//			sum += map.get(key); // 합계
		}
		avg = sum / (double)map.size();
		
		
		System.out.println(" -- 합계 -- ");
		System.out.println(sum);
		
		System.out.println(" -- 평균 --");
		System.out.println((double)Math.round(avg * 100) / 100);
		
		System.out.println(" -- 80점 이상인 명단 -- ");
		
		Iterator<String> it2 = map.keySet().iterator();
		while(it2.hasNext()) {
			String key = it2.next();
			if(map.get(key) >= 80 ) {				
				System.out.println(key + " : " + map.get(key));
			}
		}

	}

}
