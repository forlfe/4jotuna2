package shy;

import jhnUtil.InputUtil;
import main.Main;

public class Menu {
	
	
	public int showRecordMenu() {
		System.out.println();
		System.out.println("\n ------- 메인 메뉴 -------");
		
		if(Main.loginMember != null) {
			//로그인 O
			System.out.println(Main.loginMember.getNick()+" 님 환영합니다.");
			System.out.println("5. 전체 회원 운동 기록 조회하기");
			System.out.println("6. 특정 회원 운동 기록 조회하기");
			
		}
		
		return InputUtil.getInt()
	}

	public int showPersonalRecordMenu() {
		System.out.println("");
		System.out.println("조회할 회원번호를 입력하세요 (0번을 누르면 종료");
		
		return InputUtil.getInt();
	}
}
