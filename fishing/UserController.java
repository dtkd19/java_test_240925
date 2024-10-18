package fishing;

import java.util.Scanner;

public class UserController {

	private Scanner scan;
	private UserService svc;
	private boolean on;

	public UserController() {
        this.scan = new Scanner(System.in);
        this.svc = new UserServiceImpl(); // UserServiceImpl 객체 초기화
        this.on = true;
        printSignUp();
    }


	private void printSignUp() {

			while(on) {
				System.out.println();
				System.out.println("\r\n"
						+ " 	   _____                      ______  _       _      _               \r\n"
						+ "  	  |  ___|                     |  ___|(_)     | |    (_)  ><(((('> \" );      \r\n"
						+ "	  | |__   ____  ___  _ __     | |_    _  ___ | |__   _  _ __    __ _ \r\n"
						+ "	  |  __| |_  / / _ \\| '_ \\    |  _|  | |/ __|| '_ \\ | || '_ \\  / _` |  ><(((('> \" );\r\n"
						+ "	  | |___  / / |  __/| | | |   | |    | |\\__ \\| | | || || | | || (_| |\r\n"
						+ "	  \\____/ /___| \\___||_| |_|   \\_|    |_||___/|_| |_||_||_| |_| \\__, |\r\n"
						+ " 	       　                                                        __/ |\r\n"
						+ " 	                                        ><(((('> \\\" );         |___/ \r\n"
						+ "");
				System.out.println();
				System.out.println("		────────────────────────────────────────────────────────");
				System.out.println("	      　│                                                      　│");
				System.out.println("	      　│          1. 로그인  |  2. 회원가입  |  3. 게임종료        　　│");		
				System.out.println("	      　│                                                      　│");
				System.out.println("		────────────────────────────────────────────────────────");
				System.out.println();
				System.out.println("번호를 입력해주세요. ");
				int menu = scan.nextInt();
				
				switch (menu) {
				case 1:
					login();
					break;
				case 2:
					signUp();
					break;
				case 3:
					on = false;
					System.out.println(" 게임을 종료합니다. ");
					return;
				default:
					System.out.println(" 잘못된 메뉴를 선택하셨습니다. ");
					break;
				}
			}
		
	}


	private void signUp() {
		System.out.println("만들 아이디를 입력해주세요.");
		String id = scan.next();
		
		if (svc.isUserIdExists(id)) {
	        System.out.println("이미 존재하는 아이디입니다. 다른 아이디를 입력해주세요.");
	        return; // 아이디 중복 시 회원가입 종료
	    }
		
		System.out.println("만들 비밀번호를 입력해주세요.");
		String pw = scan.next();
		System.out.println("사용할 닉네임을 입력해주세요.");
		String nickname = scan.next();
		
		User u = new User(id,pw,nickname);
		
		int signOk = svc.signUp(u);
		System.out.println("회원가입 " + ((signOk > 0) ? "성공"  : "실패") );
		

	}


	private void login() {
		System.out.println("아이디를 입력하세요.");
		String id = scan.next();
		System.out.println("비밀번호를 입력하세요.");
		String pw = scan.next();
		
		User u = svc.login(id,pw);
		
		 if (u != null) {
		        System.out.println("로그인 성공! 반갑습니다, " + u.getNickname() + "님.");
		        System.out.println("소지 금액: " + u.getMoney() + "원");
		        System.out.println("보유 미끼 수: " + u.getBait() + "개");
		        on = false;
		        scan.nextLine();
//		        new FishingController(u.getNum()); // 낚시 파트에 사용자의 num을 넘김. 기빈 오빠와 나와 파트 동일
		        new StateController(u); // 건희 Controller에 유저 자체를 전달.
		    } else {
		        System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
		        return;
		    }
	}
}