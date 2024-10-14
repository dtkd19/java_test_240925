package word;

//import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordController {
	
	private Map<String, List> map = new HashMap<>();
	
	

	public void addWord(Scanner scan) {
		
		System.out.println("단어를 입력해주세요");
		
		String name = scan.next();
				
		List<String> list = new ArrayList<>();
		
		
		int num = -1;
		
		while(num != 0) {
			System.out.println("뜻을 입력해주세요");
			String mean = scan.next();
			list.add(mean);

			System.out.println("뜻을 더 추가하시겠습니까? ( 종료 0 / 계속 1");
			
			num = scan.nextInt();
		}
					
		map.put(name, list);
		
		
	}

	public void searchWord(Scanner scan) {
		
		String name = null;

		System.out.println("검색할 단어를 입력해주세요.");

		name = scan.next();

		if(map.containsKey(name) == false) {
			System.out.println(" 검색한 단어가 없습니다. ");
		} else {
			System.out.println(" -- 검색한 단어 --");
			System.out.println(name + " : " + map.get(name));
		}
		
		
	}

	public void modifyWord(Scanner scan) {
		
		List<String> list = new ArrayList<>();
		
		String searchName = null;
		String modifyMean = null;
		
		System.out.println(" 수정할 단어를 입력해주세요. ");
		
		searchName = scan.next();
		
		if(map.containsKey(searchName) == false) {
			System.out.println(" 수정할 단어가 없습니다. ");
		} else {
			
			int num = -1;
			
			while(num != 0) {
				System.out.println(" 수정 의미를 입력해주세요 ");
				modifyMean = scan.next();
				list.add(modifyMean);

				System.out.println("뜻을 더 추가하시겠습니까? ( 종료 0 / 계속 1");
				
				num = scan.nextInt();
				
				
//				System.out.println("몇번째 의미를 수정하시겠습니까?");	
//				int i = scan.nextInt();
//				System.out.println(" 수정 의미를 입력해주세요 ");
//				modifyMean = scan.next();
//				map.get(searchName).set(i, modifyMean);			
				
			}
		}
		
		map.replace(searchName, list);
		
	}

	public void printWord() {
		
		System.out.println(" -- 단어장 -- ");
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + " : " + map.get(key));
		}
		
	}

	public void delWord(Scanner scan) {
		
		String searchName = null;
		
		System.out.println(" 지울 단어를 입력해주세요. ");
		
		searchName = scan.next();
				
		boolean ok = map.remove(searchName,map.get(searchName));
		
		if(ok) {
			System.out.println("삭제완료");
		} else {
			System.out.println("삭제 할 단어가 없습니다.");
		}
		
//		if(map.containsKey(searchName) == false) {
//			System.out.println(" 지울 단어가 없습니다. ");
//		}
//		
//		map.remove(searchName);
	}

	public void filePrint() throws IOException {
		
		FileWriter fw = new FileWriter("word.txt");		
			Iterator<String> it = map.keySet().iterator();
			while(it.hasNext()) {
				String key = it.next();
				fw.write((key + " : " + map.get(key) + "\r\n"));
			}							
		fw.close();
		
		
//		FileWriter fw = new FileWriter("word.txt");		
//		BufferedWriter bw = new BufferedWriter(fw);
//		
//		StringBuffer sb = new StringBuffer();
//		String data = null;
//		sb.append("-- 단어장 -- \r\n");
//		
//		Iterator<String> it = map.keySet().iterator();
//		while(it.hasNext()) {
//			String key = it.next();
//			sb.append((key + " : " + map.get(key)));
//			sb.append("\r\n");
//		}		
//	
//		bw.close();
//		fw.close();
		
	}
	
	

}
