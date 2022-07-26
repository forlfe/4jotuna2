package jhnMenu;

import jhnMain.Main;
import jhnMember.MemberController;
import jhnSwim.SwimController;
import jhnTeam.TeamController;
import jhnUtil.InputUtil;

public class Menu {
	
public int showMenu() {
		
		if(Main.loginmember != null) {
			System.out.println(Main.loginmember.getNick()+"님 안녕하세요.");
			System.out.println("=======================================");
			System.out.println("1. 관리페이지");
			System.out.println("4. 마이페이지");
			
		}else {
			System.out.println("=========================");
			System.out.println("1. 관리페이지");
			System.out.println("2. 로그인");
			System.out.println("3. 회원가입");
			System.out.println("4. 마이페이지");
			System.out.println("5. 게시글 목록 조회");
			
		}
		return InputUtil.getInt();
		
		
		
	}
	
	public int showAdminMenu() {
		
		if(Main.loginmember != null) {
			System.out.println(Main.loginmember.getAdminId()+" 님 안녕하세요.");
			System.out.println("==========================================");
			System.out.println("1. 회원 관리");
			System.out.println("2. 영법 관리");
			System.out.println("3. 팀 관리");
			
			
		}else {
			System.out.println("===========================================");
			System.out.println("1. 회원 관리");
			System.out.println("2. 영법 관리");
			System.out.println("3. 팀 관리");
			
		}
		
		return InputUtil.getInt();
		
	}
	public void memberSearchMenu() {
		
		System.out.println("   회 원 관 리  ");
		System.out.println("==============");
		System.out.println("1. 전체 회원 조회");
		System.out.println("2. 특정 회원 조회");
		
		MemberController mc = new MemberController();
		
		int a = InputUtil.getInt();
		if(a == 1) {
			mc.memberSearch();
		}else if(a == 2) {
			mc.memberSearchDe();
		}else {
			System.out.println("다시 선택하여 주십시오.");
			return;
		}
		
		
	}

	public void swimAdminMenu() {
		System.out.println("   영 법 관 리  ");
		System.out.println("==============");
		System.out.println("1. 전체 영법조회");
		System.out.println("2. 특정 영법조회");
		System.out.println("3. 영법 추가하기");
		System.out.println("4. 영법 수정하기");
		System.out.println("5. 영법 삭제하기");
		
		
		SwimController sc = new SwimController();
		
		int a = InputUtil.getInt();
		if(a == 1) {
			sc.searchSfInfo();
		}else if(a == 2) {
			sc.searchSfInfoDe();
		}else if(a == 3) {
			sc.insertSf();
		}else if(a == 4) {
			sc.updateSf();
		}else if(a == 5) {
			sc.deleteSf();
		}else {
			System.out.println("번호를 잘못 선택하였습니다. 다시 선택하여 주십시오.");
			return;
		}
		
	}

	public void teamAdminMenu() {
		System.out.println("   팀 관 리  ");
		System.out.println("==============");
		System.out.println("1. 전체 팀 조회");
		System.out.println("2. 특정 팀 조회");
		System.out.println("3. 팀 추가하기");
		System.out.println("4. 팀 수정하기");
		System.out.println("2. 팀 삭제하기");
		
		TeamController tc = new TeamController();
		
		int a = InputUtil.getInt();
		if(a == 1) {
			tc.searchTeamInfo();
		}else if(a == 2) {
			tc.searchTeamInfoDe();
		}else if(a == 3) {
			tc.insertTeam();
		}else if(a == 4) {
			tc.updateTeam();
		}else if(a == 5) {
			tc.deleteTeam();
		}else {
			System.out.println("번호를 잘못 선택하였습니다. 다시 선택하여 주십시오.");
			return;
		}
		
	}

}
