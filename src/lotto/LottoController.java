package lotto;

import java.util.Arrays;
import java.util.Scanner;

public class LottoController {

	private LottoExtend[] l = new LottoExtend[10];
	private int userCnt = 0;
	private int comCnt = 0;
	private int hitCnt = 0;

	public void cvUserLotto(Scanner scan) {

		LottoExtend newLotto = new LottoExtend();

		newLotto.creativeNum(scan);

		l[userCnt] = newLotto;

		userCnt++;

		System.out.println("수동 로또 번호 목록:");
		for (int i = 0; i < userCnt; i++) {
			if (l[i] != null) {
				System.out.println((i + 1) + "번" + ": " + Arrays.toString(l[i].getUserNum()));
			}
		}

	}

	public void cvComLotto() {

		LottoExtend newLotto = new LottoExtend();

		newLotto.creativeComNum();
		newLotto.comNumPrint();

		l[comCnt] = newLotto;

		comCnt++;

		System.out.println("자동 로또 번호 목록:");
		for (int i = 0; i < comCnt; i++) {
			if (l[i] != null) {
				System.out.println((i + 1) + "번" + ": " + Arrays.toString(l[i].getComNum()));
			}
		}
	}

	public void cvhitLotto(Scanner scan) {

		LottoExtend newLotto = new LottoExtend();
		newLotto.creativeHitNumber(scan);
		newLotto.BonusNumber(scan);
		newLotto.setCount(hitCnt + 1);
		l[hitCnt] = newLotto;

		hitCnt++;
	}

	public void hitLotto() {

		if (hitCnt == 0) {
			System.out.println("당첨 번호가 없습니다.");
			return;
		}
		for (int i = 0; i < hitCnt; i++) {
			if (l[i] != null) {
				int matchCount = 0;
				boolean bonus = false;
				
				for(int j = 0 ; j < userCnt; j++) {
					
				}

			}
		}

	}

	public void hitLottoList() {

		if (hitCnt == 0) {
			System.out.println("저장된 로또 번호가 없습니다.");
			return;
		}

		for (int i = 0; i < hitCnt; i++) {
			if (l[i] != null) {
				System.out.println(l[i].getCount() + "회차" + " 당첨로또 번호: " + Arrays.toString(l[i].getHitNumber())
						+ " 보너스번호 : " + l[i].getBonusNum());
			} else {
				System.out.println("로또 번호가 null입니다.");
			}
		}

	}

}
