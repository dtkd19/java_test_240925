package day08;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class WordController {
	
	
	private Map<String, String> map = new HashMap<>();
	private String word;
	private String mean;
	
	
	
	public void insertWord() {
		map.put("고양이","cat");
		map.put("강아지","dog");
		map.put("호랑이","tiger");
		map.put("사자","lion");
		map.put("독수리","egale");
	}
	
	
	public void addWord(Scanner scan) {
		
		System.out.println("단어와 뜻을 입력해주세요");
		word = scan.next();
		mean = scan.next();
		
		map.put(word, mean);
		
	}

	public void searchWord(Scanner scan) {
		
		String searchName = null;
		
		System.out.println(" 검색할 단어를 검색해주세요 ");
		
		searchName = scan.next();
		
		if(map.containsKey(searchName) == false) {
			System.out.println(" 검색한 단어가 없습니다. ");
		} else {
			System.out.println(" -- 검색한 단어 --");
			System.out.println(searchName + " : " + map.get(searchName));
		}
		
		
		
		
//		Iterator<String> it = map.keySet().iterator();
//		while(it.hasNext()) {
//			String key = it.next();
//			if(searchName.equals(key)) {
//				System.out.println(key + " : " + map.get(key));
//			}
//		}
		
	}

	public void modifyWord(Scanner scan) {
		
		String searchName = null;
		String modifyMean = null;
		
		System.out.println(" 수정할 단어를 입력해주세요. ");
		
		searchName = scan.next();
		
		if(map.containsKey(searchName) == false) {
			System.out.println(" 수정할 단어가 없습니다. ");
		} else {
			System.out.println(" 수정의미를 입력해주세요 ");
			
			modifyMean = scan.next();			
		}
		
		
		
		map.replace(searchName, modifyMean);
		
//		Iterator<String> it = map.keySet().iterator();
//		while(it.hasNext()) {
//			String key = it.next();
//			if(searchName.equals(key)) {
//				System.out.println("수정 의미를 입력해주세요.");
//				modifyMean = scan.next();
//				map.put(key, modifyMean);
//			}
//		}
		
		
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
		
		if(map.containsKey(searchName) == false) {
			System.out.println(" 지울 단어가 없습니다. ");
		}
		
		map.remove(searchName);
		
		
	}

	
}
