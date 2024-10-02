package day04;

public class StudentMain {

	public static void main(String[] args) {

		

		Student s = new Student("엄상훈","990118","010-2222-3333", 26 , "인천") ;
		
		
		s.addProgram2("AWS", "3개월");	
		s.addProgram2("JAVA", "6개월");	
		s.addProgram2("개발자", "6개월");	
		s.addProgram2("디자인", "9개월");
		s.addProgram2("건축", "12개월");
		
		s.infoPrint2();
		
		
		Student s1 = new Student("hong","981018","010-4444-3333", 27 , "인천") ;
		
		s1.addProgram2("개발자", "3개월");
		s1.addProgram2("개발자2", "3개월");
		s1.stPrint();
		s1.ePrint();
		s1.infoPrint2();
		
		Student s2 = new Student("이기연","020318","010-1434-7777", 23 , "서울") ;
		
		
		Student[] std = new Student[8];
		
		std[0] = s;
		std[1] = s1;
		std[2] = s2;
		
		// 5명의 정보를 추가
		std[3] = new Student("Kim","011124" ,"010-0000-1111", 24, "인천");
		std[3].addProgram2("JAVA", "9개월");
		std[4] = new Student("choi","980421" ,"010-0000-2222", 27, "인천");
		std[4].addProgram2("JAVA", "9개월");
		std[4].addProgram2("HTML", "6개월");
		std[4].addProgram2("REACT", "12개월");
		std[5] = new Student("park","021024" ,"010-0000-5555", 23, "서울");
		std[5].addProgram2("HTML", "6개월");
		std[5].addProgram2("REACT", "12개월");
		std[6] = new Student("lee","031102" ,"010-0000-6666", 22, "서울");
		std[6].addProgram2("JAVA", "9개월");
		std[6].addProgram2("HTML", "6개월");
		std[6].addProgram2("REACT", "12개월");
		std[6].addProgram2("PYTHON", "3개월");
		std[7] = new Student("kang","050404" ,"010-0000-9999", 20, "인천");
		
		
		// 학생 전체 명단 출력 ( 학생 정보만..)
		
		System.out.println();
		System.out.println("----------- 전체 학생명단 --------------");
		for(Student tmp : std) {
			tmp.stPrint();
		}
		
		System.out.println();
		
		// hong 학생의 학생정보, 학원정보, 수강정보 출력
		
		System.out.println("-------- hong 학생의 정보 ----------");
		
		for(int i = 0; i < std.length; i++) {
			if(std[i].getName().equals("hong")) {
				std[i].stPrint();
				std[i].ePrint();
				std[i].infoPrint2();
			}
		}
		
		
		System.out.println();
		
		// incheon 지점의 학생 명단 출력 ( 학생정보만..)
		
		System.out.println(" ------ 인천지점 학생 명단 -------");
		
		for(int i =0; i< std.length; i++) {
			if(std[i].getGigum() != null) {				
				if(std[i].getGigum().equals("인천")) {
					std[i].stPrint();
				}
			}
		}
		
		System.out.println();
		
		// java 과목을 수강하는 학생명단 출력 ( 학생정보, 학원정보, 수강정보 전부 출력)
		
		System.out.println("------- JAVA 과목을 수강하는 학생명단 ---------");
		for(int i = 0; i <std.length; i++) {
			boolean contains = false;
			
			for(int j = 0; j < std[i].getCnt(); j++) {
				if(std[i].getProgram()[j].equals("JAVA")){
					contains = true;
				}
			}		
			if(contains) {
				std[i].stPrint();
				std[i].ePrint();
				std[i].infoPrint2();
				System.out.println();
			}
		}
		
		System.out.println();
		
		// 수강하지 않는 학생 명단 출력 (학생정보만..)
		
		System.out.println("--------- 수강하지 않는 학생 -----------");
		
		for(int i =0; i<std.length; i++) {
			if(std[i].getCnt() == 0) {
				std[i].stPrint();
			}
		}
		
		System.out.println();
		
	}

}
