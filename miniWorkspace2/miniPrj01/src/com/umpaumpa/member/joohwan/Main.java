package com.umpaumpa.member.joohwan;

import java.util.Scanner;

import com.umpaumpa.member.MemberController;
import com.umpaumpa.member.MemberVo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("====== 환영합니다 수영 어플 음파음파입니다 ======");
		while(true) {
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		int input = sc.nextInt();
		switch(input) {
		case 1 : new MemberController().login(); break;
		case 2 : new MemberController().join(); break;
		case 3 : break;
			}
		}
	}

	public static MemberVo loginmember;

}
