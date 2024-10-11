package day09;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stream03 {

	public static void main(String[] args) {
		/* Student 클래스로 리스트 구성
		 * Student 이름, 점수만 가지는 클래스
		 * 
		 * 학생 5명을 추가하고, 콘솔에 출력
		 * 홍길동 : 80
		 */
		
		List<Student> list = new ArrayList<>();
		
		list.add(new Student("홍길동",80));
		list.add(new Student("이영한",46));
		list.add(new Student("김성대",53));
		list.add(new Student("최윤환",74));
		list.add(new Student("김정현",90));
		
		list.stream().forEach(n -> {
			System.out.println(n);
		});
		
		list.stream()
		.forEach(n -> {
			String name = n.getName();
			int point = n.getPoint();
			System.out.println(name + " => " + point);
		});
		
		// list의 점수 합계 / 전체 인원수
		
		int sum = list.stream()
				.mapToInt(n -> n.getPoint())
				.sum();
		System.out.println("점수합계 : " + sum);
		long cnt = list.stream().count();
		System.out.println("인원수 : " + cnt);
		
		System.out.println("--------- 이름 내림차순 ---------");
		
		list.stream().sorted(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				
				return o2.getName().compareTo(o1.getName());
			}
		})
		.forEach(n -> System.out.println(n));
		
		
		
		
		
		
		
	}

}
