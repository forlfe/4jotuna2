package com.umpaumpa.member.joohwan;

import java.sql.Connection;
import java.util.Scanner;

import main.Main;

public class MemberController {
	
	/*로그인
	 * 
	 */
	public void login() {
		//Connection conn = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		System.out.println("비밀번호 : ");
		String pwd = sc.nextLine();
		
		
		//MemberVo vo=null;
		try {
			new MemberDao();
			//new MemberDao();
			MemberVo vo = MemberDao.login(id, pwd);
			if(vo != null) {
				System.out.println("로그인에 성공하였습니다\n");
				Main.loginmember = vo;
			} else {
				System.out.println("로그인에 실패하였습니다\n");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("에러가 발생해 로그인에 실패하였습니다");
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 회원가입
	 * 
	 * 데이터 입력받기 MemberController
	 * - 아이디 유효성 검사 MemberService
	 * - 비밀번호 유효성 검사 MemberService
	 * - 아이디 중복 검사 MemberService -> 실제로는 안함
	 * 
	 * DB에 insert -> MemberDao
	 * insert 결과에 따라 다음 작업을 진행->MemberController에서 리턴받아서..
	 * 
	 * MemberController : 데이터 주고받고 전달받는
	 * MemberService : 서비스의 비즈니스 로직 처리(비밀번호 4자리여야한다)
	 * MemberDao : 커넥션을 가지고 db에 갔다옴
	 * c가 데이터전달받고 s에서 데이터 유효성검사 후 d로 넘기고 d는 전발받고 insert하고
	 * 
	 */
	public void join() {
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 :");
		String id = sc.nextLine();
		System.out.println("비밀번호 : ");
		String pwd = sc.nextLine();
		System.out.println("비밀번호 확인 : ");
		String pwd2 = sc.nextLine();
		System.out.println("이름 :");
		String name = sc.nextLine();
		System.out.println("닉네임 : ");
		String nick = sc.nextLine();
		System.out.println("몸무게 :");
		String weight = sc.nextLine();
		System.out.println("성별 : ");
		String gender = sc.nextLine();
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setPwd2(pwd2);
		vo.setName(name);
		vo.setNick(nick);
		vo.setWeight(weight);
		vo.setGender(gender);
		
		Connection conn = null;
		int result=0;
		
		result = MemberService.join(vo, conn);
		
		
		if(result==1) {
			System.out.println("회원가입 성공~");
		} else {
			System.out.println("회원가입 실패");
		}
	}

}
