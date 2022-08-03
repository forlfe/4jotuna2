package jhnMember;

import java.sql.Timestamp;
import java.util.List;

import jhnMain.Main;
import jhnMenu.Menu;
import jhnUtil.InputUtil;

public class MemberController {
	
public void adminPage() {
		
		adminLogin();
		Menu menu = new Menu();
		while(true) {
			int input = menu.showAdminMenu();
			switch(input) {
			case 1 :
				menu.memberSearchMenu();
				break;
			case 2 :
				menu.swimAdminMenu();
				break;
			case 3 :
				menu.teamAdminMenu();
				break;
			
			}
		}
		
	}
	public void adminLogin() {
		
		System.out.print("관리자 아이디를 입력하여 주십시오.:  ");
		String adminId = InputUtil.sc.nextLine();
		System.out.print("관리자 비밀번호를 입력하여 주십시오.: ");
		String adminPwd = InputUtil.sc.nextLine();
		
		try {
			MemberVo vo = new MemberDao().adminLogin(adminId,adminPwd);
			if(vo!=null) {
				System.out.println("관리자 님 안녕하세요.");
				Main.loginmember = vo;
			}else {
				System.out.println("관리자 로그인 실패하였습니다.");
			}
			
			
		} catch (Exception e) {
			System.out.println("[에러]관리자 로그인 실패하였습니다.");
			e.printStackTrace();
		}
	}
	public void memberSearch() {
		System.out.println("전체 회원 정보를 조회합니다.");
		List<MemberVo> memberVoList = new MemberDao().memberSearch();
		
		System.out.println("------------ 회 원 정 보------------");
		System.out.println("==================================");
		
		for(int i =0; i<memberVoList.size(); i++) {
			
			MemberVo temp = memberVoList.get(i);
			
			String no = temp.getNo();
			String id = temp.getId();
			String pwd = temp.getPwd();
			String name = temp.getName();
			String nick = temp.getNick();
			String weight = temp.getWeight();
			Timestamp enrollDate = temp.getEnrollDate();
			String quitYn = temp.getQuitYn();
			Timestamp editDate = temp.getEditDate();
			
			
			System.out.println(no+" | "+id+" | "+pwd+" | "+name+" | "+nick+" |\n "+weight+" | "
					+ enrollDate+" | "+quitYn+" | " + editDate);
			
		}
			
		
		
		
		
		
		
	}
	public void memberSearchDe() {
		System.out.println("회원 번호를 입력하여 조회하세요.: ");
		String no = InputUtil.sc.nextLine();
			
		MemberVo vo= new MemberVo();
		vo.setNo(no);
		
		new MemberDao().memberSearchDe(no);
			
		
	}
	
	public void login() {
		
		if(Main.loginmember != null) {
			System.out.println("이미 로그인 되어있습니다.");
			return;
		}
		
		System.out.println("----- 로그인 -----" );
		System.out.print("아이디");
		String id = InputUtil.sc.nextLine();
		System.out.print("비밀번호");
		String pwd = InputUtil.sc.nextLine();
		
		try {
			MemberVo vo = new MemberDao().login(id,pwd);
			if(vo!=null) {
				System.out.println("로그인 성공!\n\n");
				Main.loginmember = vo;
			}else {
				System.out.println("로그인 실패!\n\n");
			}
		} catch (Exception e) {
			System.out.println("[에러]로그인 실패!\n\n");
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public void myPage() {
		
		System.out.println("-----------------");
		System.out.println(" MY PAGE");
		System.out.println("=================");
		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 닉네임 변경");
		System.out.println("3. 몸무게 변경");
		
		
		int result=InputUtil.getInt();
		if(result == 1) {
			updatePwd();
		}else if(result == 2) {
			updateNick();
		}else if(result == 3) {
			updateWeight();
		}else {
			System.out.println("번호를 잘못 누르셨습니다. 다시 선택하여 주십시오.");
			
		}
		 
		
	}
	
	public void updateWeight() {
		if(Main.loginmember == null) {
			System.out.println("로그인을 먼저 해주세요.");
			return;
		}
		System.out.println("수정하실 몸무게를 입력하세요.: ");
		String newWeight = InputUtil.sc.nextLine();
		
		System.out.println("몸무게를 수정하시겠습니까?(Y/N)");
		
		String input = InputUtil.sc.nextLine();
		
		if(input.equalsIgnoreCase("Y")) {
			
			MemberVo vo = new MemberVo();
			vo.setId(Main.loginmember.getId());
			vo.setWeight(newWeight);
			
			int result = new MemberService().updateWeight(vo);
			
			
		}else {
			return;
		}
		
	
		
	}



	public void updatePwd() {
		if(Main.loginmember == null) {
			System.out.println("로그인을 먼저 해주세요.");
			return;
		}
		
		System.out.println("현재 비밀번호를 입력하세요.: ");
		String pwd = InputUtil.sc.nextLine();
		
		System.out.println("변경하실 비밀번호를 입력하세요.: ");
		String newPwd = InputUtil.sc.nextLine();
		
		System.out.println("변경하실 비밀번호를 다시 입력하세요.: ");
		String newPwd2 = InputUtil.sc.nextLine();
		
		MemberVo vo = new MemberVo();
		vo.setId(Main.loginmember.getId());
		vo.setPwd(pwd);
		vo.setPwd2(newPwd);
		vo.setPwd3(newPwd2);
		
		int result = new MemberService().updatePwd(vo);
		
		
	}
	public String login(MemberVo vo) {
		vo = new MemberVo();
		vo.setId(Main.loginmember.getId());
		vo.setPwd(Main.loginmember.getPwd());
		String x = "";
		
		return x;
	}
	public void updateNick() {
		
		if(Main.loginmember == null) {
			System.out.println("로그인을 먼저 해주세요.");
			return;
		}
		System.out.println("현재 사용하는 닉네임을 입력하세요.: ");
		String nick = InputUtil.sc.nextLine();
		
		System.out.println("변경하실 닉네임을 입력하세요.: ");
		String newNick = InputUtil.sc.nextLine();
		
		
		System.out.println("닉네임을 수정하시겠습니까?(Y/N)");
		
		String input = InputUtil.sc.nextLine();
		
		if(input.equalsIgnoreCase("Y")) {
			
			MemberVo vo = new MemberVo();
			vo.setId(Main.loginmember.getId());
			vo.setNick(nick);
			vo.setNick2(newNick);
			
			int result = new MemberService().updateNick(vo);
			
			
		}else {
			return;
		}
		
	}	

}
