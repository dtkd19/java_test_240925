package day03;

public class StudentMain {

	public static void main(String[] args) {
		Student s = new Student("인천", "엄상훈", "JAVA", "010-0000-1111");
		
//		s.print();
		
		// toString이 없으면 객체의 주소가 출력
//		System.out.println(s); // 자동으로 toString 호출
		
		Student s1 =new Student("수원","이기연","AWS","010-2020-2020");
		
//		System.out.println(s1);
		Student s2 =new Student("인천","이승재","AWS","010-2020-2121");
		Student s3 =new Student("서울","김종현","JAVA","010-2020-3030");
		Student s4 =new Student("수원","이명종","AWS","010-2020-2333");
		Student s5 =new Student("서울","김정현","JAVA","010-2020-4567");
		
		Student[] studentArr = new Student[6];
		
		studentArr[0] = s;
		studentArr[1] = s1;
		studentArr[2] = s2;
		studentArr[3] = s3;
		studentArr[4] = s4;
		studentArr[5] = s5;
		
		//전체 학생명단 출력
		
		for(Student stemp : studentArr) {
			stemp.print();
		}
		
		
		// 엄상훈의 정보를 출력  equals() : String 값이 같은지 확인하는 메서드 
		String searchName = "엄상훈";
		
		for(int i = 0; i < studentArr.length; i++) {			
			if(studentArr[i].getName().equals(searchName)) {		
				System.out.println(studentArr[i]);
			}			
		}
		System.out.println("---------------------------");
		
		// 인천지점 학생들 명단 출력
		// 학생이 없다면 명단이 없습니다. 출력
		
		String searchSpot = "인천";
		int count = 0; 
		
		for(int i =0; i< studentArr.length; i++) {
			if(studentArr[i].getSpot().equals(searchSpot)) {
				System.out.println(studentArr[i]);
				count++;
			} 
		}
		if(count == 0) {
			System.out.println("명단이 없습니다.");
		}
		
		
		System.out.println("-----------------------");
		
		// 엄상훈의 Program 을 AWS로 변경 => 출력
		
		for(int i = 0; i <studentArr.length; i++) {
			if(studentArr[i].getName().equals(searchName)) {
				studentArr[i].setProgram("AWS");
				System.out.println(studentArr[i]);
			}
		}
	
		System.out.println("-------------------------");
		
		
	}

}
