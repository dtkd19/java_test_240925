package fishing;

import java.util.List; // 기빈
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class FishingController {
	
	private Scanner scan;
	private FishingService fsv;
	private boolean run;
	private int num;
	private String spot; // 건희가 작업하는 구역에서 가져올 것.
	private UserService svc; // 기빈
	private User u;
	// private boolean flag; // 기빈. 나의 run과 역할이 일치하여 제외함.
//	private int usernum; // 기빈
	
	public FishingController(Scanner scan, FishingService fsv, boolean run) {
		this.scan = new Scanner(System.in);
		this.fsv = new FishingServiceImpl();
		this.run = true;
		svc = new UserServiceImpl();
		printFishing(num);
	}
	
	public FishingController(int num) {
		this.scan = new Scanner(System.in);
		this.fsv = new FishingServiceImpl();
		this.run = true;
		this.num = num;
		// 기빈
//		usernum = num;
		svc = new UserServiceImpl();
		printFishing(num);
	}
	
	// 장소(문자열 이름), 사용자 num. 건희 것과 맞추며 만든 생성자.
	public FishingController(User u, String spot, int num) {
		this.u = u;
		this.spot = spot;
		this.num = num;
		this.scan = new Scanner(System.in);
		this.fsv = new FishingServiceImpl();
		this.run = true;
		svc = new UserServiceImpl();
		printFishing(num);
	}
	
	// 기빈
	private void userInfo(int num) {
		User u = svc.userInfo(num);
		System.out.println(u);
	}
	
	private void printFishing(int num) {
		while(run) {
			userInfo(num);
			// 한글이 영어/빈칸과 차지하는 공간이 다름...
			System.out.println("		────────────────────────────────────────────────────────");
			System.out.println("	      　│                                                       │");
			System.out.println("	      　│    1.낚시 | 2.가방 | 3.상점 | 4.랭킹 | 5.장소이동 | 6.종료    │");		
			System.out.println("	      　│                                                       │");
			System.out.println("		────────────────────────────────────────────────────────");
			System.out.println("번호를 입력해주세요. ");
			int userChoice = scan.nextInt();
			scan.nextLine();

			switch(userChoice) {
				case 1: fishing(num); break;
				case 2: inventory(num); break;
				case 3: store(num); break;
				case 4: ranking(num); break;
				case 5: returnToState();
				case 6: finish(num); run = false; break;
				default: System.out.println("유효한 옵션이 아닙니다. 다시 입력하세요.");
			}
		}
	}

	public void fishing(int num) {
		boolean isBaitOkay = fsv.isBaitReady(num);
		
		if(isBaitOkay) {
			FishingMotion.getInstance().fishingAni();
			FishingMotion.getInstance().fishingFinishAni();
			String fish_name = getFish();
			int fish_size = getFishSize(fish_name);
			System.out.println("물고기를 잡았습니다! " + fish_name + " 크기: " + fish_size);
			
			fsv.addFish(num, fish_name, fish_size);
			int consumeBaitFinish = fsv.consumeBait(num);
			
			if(consumeBaitFinish == 1) {
				User u = fsv.displayNicknameBait(num);
				System.out.println(u.getNickname() + "님의 남은 먹이 수: " + u.getBait());
			} else {
				System.out.println("플레이어 정보 배치 실패");
			}
		} else {
			System.out.println("남은 먹이가 없습니다! 물고기를 판매하시거나 게임을 종료하세요.");
			// 낚시 시작 이전의 메인 메뉴로 나가야 한다.
		}
		
	}
	
	private String getFish() {
		Random rand = new Random();	
		int randNum = 0;
		String fish_name="";
		
		switch(spot) {
		case "물웅덩이":
			randNum = rand.nextInt(100);
			if(randNum <= 10) {
				fish_name = "장화";
			} else if (10 < randNum && randNum <= 40) {
				fish_name = "멸치";
			} else if (40 < randNum && randNum <= 65) {
				fish_name = "쭈꾸미";
			} else if (65 < randNum && randNum <= 85) {
				fish_name = "전어";
			} else if (85 < randNum && randNum <= 95) {
				fish_name = "갑오징어";
			} else if (95 < randNum && randNum <= 100) {
				fish_name = "광어";
			} else {
				System.out.println("유효한 범위가 아닙니다.");
			}
			break;
		case "해변가":
			randNum = rand.nextInt(120);
			if(randNum <= 10) {
				fish_name = "장화";
			} else if (10 < randNum && randNum <= 40) {
				fish_name = "멸치";
			} else if (40 < randNum && randNum <= 65) {
				fish_name = "쭈꾸미";
			} else if (65 < randNum && randNum <= 85) {
				fish_name = "전어";
			} else if (85 < randNum && randNum <= 95) {
				fish_name = "갑오징어";
			} else if (95 < randNum && randNum <= 100) {
				fish_name = "광어";
			} else if (100 < randNum && randNum <= 120) {
				fish_name = "우럭";
			} else {
				System.out.println("유효한 범위가 아닙니다.");
			}
			break;
		case "바다":
			randNum = rand.nextInt(110);
			if(randNum <= 10) {
				fish_name = "장화";
			} else if (10 < randNum && randNum <= 40) {
				fish_name = "멸치";
			} else if (40 < randNum && randNum <= 65) {
				fish_name = "쭈꾸미";
			} else if (65 < randNum && randNum <= 85) {
				fish_name = "전어";
			} else if (85 < randNum && randNum <= 95) {
				fish_name = "갑오징어";
			} else if (95 < randNum && randNum <= 100) {
				fish_name = "광어";
			} else if (100 < randNum && randNum <= 110) {
				fish_name = "참치";
			} else {
				System.out.println("유효한 범위가 아닙니다.");
			}
			break;
		case "깊은 바다":
			randNum = rand.nextInt(105);
			if(randNum <= 10) {
				fish_name = "장화";
			} else if (10 < randNum && randNum <= 40) {
				fish_name = "멸치";
			} else if (40 < randNum && randNum <= 65) {
				fish_name = "쭈꾸미";
			} else if (65 < randNum && randNum <= 85) {
				fish_name = "전어";
			} else if (85 < randNum && randNum <= 95) {
				fish_name = "갑오징어";
			} else if (95 < randNum && randNum <= 100) {
				fish_name = "광어";
			} else if (100 < randNum && randNum <= 110) {
				fish_name = "개복치";
			} else {
				System.out.println("유효한 범위가 아닙니다.");
			}
			break;
		default:
			System.out.println("유효한 장소가 아닙니다.");
			break;
		}
		return fish_name;
	}


	private int getFishSize(String fish_name) {
		Random rand = new Random();	
		int addSize = rand.nextInt(100);
		int fish_size = 0;
		
		switch (fish_name) {
			case "장화":
				fish_size = 0;
				break;
			case "멸치":
				fish_size = 10 + addSize;
				break;
			case "쭈꾸미":
				fish_size = 20 + addSize;
				break;
			case "전어":
				fish_size = 25 + addSize;
				break;
			case "갑오징어":
				fish_size = 20 + addSize;
				break;
			case "광어":
				fish_size = 45 + addSize;
				break;
			case "우럭":
				fish_size = 30 + addSize;
				break;
			case "참치":
				fish_size = 55 + addSize;
				break;
			case "개복치":
				fish_size = 180 + addSize;
				break;
		}

		return fish_size;
	}

	
// 기빈 시작
	
	private void inventory(int num) {
		
//		System.out.println("유저 번호 : "+num);
		List<Inventory> list = svc.getInven(num);
		
		for(Inventory i : list) {
			System.out.println(i.invenList());
		}
		
	}
	
	private void store(int num) {
		System.out.println("상점에 오신걸 환영합니다.");
		System.out.println("1. 떡밥 구매 | 2. 낚싯대 구매 | 3. 물고기 판매");
		int sel = scan.nextInt();
		
		switch(sel) {
		case 1:					// 떡밥 구매 
			buyBait(num);
			
			break;
		case 2: 				// 낚싯대 구매
			buyFishrod(num);
			break;
		case 3: 				// 물고기 판매
			sellFish(num);
			break;
		default:
			System.out.println("어허 손버릇.");
		}
		System.out.println();
	}
	
	private void buyBait(int num) {
		System.out.println("구매할 떡밥 개수를 입력하세요. (떡밥 비용 : 500원)");
		
		int baitCnt = scan.nextInt();//	떡밥 구매
		int baitPrice = baitCnt * 500;				// 총 떡밥구매량
		
		User u = new User(num, baitCnt, baitPrice);		// num : 회원번호
		int isOk = svc.updBait(u);
		
		System.out.println("떡밥 구매 " + (isOk > 0? "완료":"실패"));
	}

	private void buyFishrod(int num) {
        System.out.println("구매할 낚시대를 선택하세요.");
        System.out.println("1. 스탠다드 낚시대 : 100000원");
        System.out.println("2. 프리미엄 낚시대 : 500000원");
        System.out.println("3. 엘리트 낚시대 : 1000000원");
        int rodnum = scan.nextInt();
        
        String fishrod = "";
        int cost = 0;
        switch(rodnum) {
        case 1:
            fishrod = "Standard";
            cost = 100000;
            break;
        case 2:
            fishrod = "Premium";
            cost = 500000;
            break;
        case 3:
            fishrod = "Elite";
            cost = 1000000;
            break;
        }
        // 이거 낚시대 금액 잡아서 처리
        User u1 = new User(num, cost);
        User u2 = new User(num, fishrod);
        
        boolean isOk1 = svc.compMoney(u1);
        boolean isOk2 = svc.compRod(u2);
        
        System.out.println(isOk1);
        if(isOk1) {
            if(isOk2) {
                User u = new User(num, fishrod, cost);
                int isOk3 = svc.updRod(u);
                System.out.println("낚시대 구매 " + (isOk3 > 0? "완료":"실패"));
            } else {
                System.out.println("이미 같은 낚싯대가 있습니다.");
            }
        } else {
            System.out.println("응 낚싯대 못사~~~");
        }
        
    }
	
	private void sellFish(int num) {
		System.out.println("하나만 파시겠습니까 모두 파시겠습니까? : (1 : 하나 / 2 : 모두)");
		int oneOrAll = scan.nextInt();
		
		switch(oneOrAll) {
		case 1: sellOneFish(num); break;
		case 2: sellAllFish(num); break;
		default:
			System.out.println("팔기 싫어?");
		}
		
	}

	private void sellOneFish(int num) {
		inventory(num);
		System.out.println("판매하려는 인벤토리 번호를 입력하세요.");
		int sellNum = scan.nextInt();
		System.out.println(num + " - " + sellNum);
		User u = new User(num, sellNum);
		Inventory i = new Inventory(num, sellNum);
		
		int isOk1 = svc.plusOneMoney(u);
		int isOk2 = svc.sellOneFish(i);
		
		System.out.println("금액 입금 " + (isOk1 > 0? "완료":"실패"));
		System.out.println("물고기 판매 " + (isOk2 > 0? "완료":"실패"));
	}
	private void sellAllFish(int num) {
		User u = new User(num);
		Inventory i = new Inventory(num);
		
		int isOk1 = svc.plusAllMoney(u);
		int isOk2 = svc.sellAllFish(i);
		
		System.out.println("금액 입금 " + (isOk1 > 0? "완료":"실패"));
		System.out.println("물고기 판매 " + (isOk2 > 0? "완료":"실패"));
	}
	
	private void ranking(int num) {
        List<Inventory> rank = svc.getRank(num);
        
        for(Inventory i : rank) {
            System.out.println(i.rankList());
        }
    }
	
	// 기빈 끝
	
	public void returnToState() {
		System.out.println("항구로 돌아갑니다...");
		run = false;
		User u = fsv.getUser(num);
		new StateController(u);
	}
	
	public void finish(int num) {
		System.out.println("낚시 결과를 공개합니다.");
		Map<String, Integer> resultMap = fsv.getResult(num);
		for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
			String fishName = entry.getKey();
			Integer fishAmount = entry.getValue();
			System.out.println(fishName + ": " + fishAmount + "마리");
		}
	}
	
}
