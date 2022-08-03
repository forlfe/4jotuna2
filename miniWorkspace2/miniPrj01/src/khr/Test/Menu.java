package khr.Test;

import jhnUtil.InputUtil;

public class Menu {
	
	public static int showTeam() {
		System.out.println("====================");
		System.out.println("----- 나의 팀 -------");
		System.out.println("====================");
		
		System.out.println("1. 나의 팀 순위 보기");
		System.out.println("2. 크루 추가 모집 여부");
		
		System.out.println("9. 프로그램 종료");
		
		return InputUtil.getInt();
	}
	

}
