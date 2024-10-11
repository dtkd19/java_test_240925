package day09;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamEx01 {

	public static void main(String[] args) {
		/* 여행사 상품 
		 * 여행비용이 15세 이상은 100만원, 미만은 50만원으로 계산
		 * 고객 5명이 패키지 여행을 떠난다고 했을 경우
		 * 1. 비용계산 => 출력
		 * 2. 고객 명단 출력
		 * 고객 클래스를 생성하고, ArrayList로 고객 관리
		 * 
		 *  예) 
		 *  이름:이순신 나이:40 비용 100
		 *  이름:신사임당 나이:38 비용: 100
		 *  이름:홍길동 나이:30 비용 : 100
		 *  이름:이짱구 나이:10 비용 : 50
		 *  이름:이짱아 나이:5 비용 : 50
		 *  총 여행경비 : xxx
		 *  
		 *  20세 이상 고객명단 => 이름순으로 정렬 출력
		 */
		
		List<Customer> list = new ArrayList<>();
		
		list.add(new Customer("홍길동", 40));
		list.add(new Customer("이영한", 36));
		list.add(new Customer("김성대", 14));
		list.add(new Customer("박성균", 68));
		list.add(new Customer("김윤환", 8));
			
		list.stream().filter(n-> n.getAge() >= 15).forEach(n -> n.setPrice(100)); // 15세 이상 비용
		list.stream().filter(n-> n.getAge() < 15).forEach(n -> n.setPrice(50));  // 15세 미만 비용
		
		int sum = list.stream().mapToInt(n -> n.getPrice()).sum();
		
		System.out.println("총 비용 : " + sum );
		
		list.stream().forEach(n -> System.out.println(n)); // 총 고객명단
		
		 
		// 20세 이상 이름 내림차순 출력 
		System.out.println();
		
		list.stream().sorted(new Comparator<Customer>() {

			@Override
			public int compare(Customer o1, Customer o2) {
				// TODO Auto-generated method stub
				return o2.getName().compareTo(o1.getName());
			}
			
		}).filter(n -> n.getAge() >= 20)
		.forEach(n -> System.out.println(n));
		
		
	}

}
