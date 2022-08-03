package teamJoin;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);


		while (true) {
			System.out.println("======팀가입 신청=======");
			
			System.out.println("1. 팀가입 신청");
			System.out.println("2. 팀 목록 보기");
			System.out.println("3. 돌아가기");
			int input = sc.nextInt();
			
			if (input == 1) {
				new TeamJoinController().join();
			} else if (input == 2) {
				new TeamJoinController().teamShow();
			} else {
				return;
			}
		}

	}
}
