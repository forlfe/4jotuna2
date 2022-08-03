package soyeoun;

import java.util.Scanner;

import com.kh.member.MemberVo;

import menu.Menu;
import recording.Recording;

public class Main {
	
	public static MemberVo loginMember;
	
	/*
	 * 영법 입력받기
	 * 운동시간 입력받기
	 * 
	 * 회원정보에서 몸무게 가져오기
	 * 가져온 몸무게 영법에 곱하고 나누기 60해주기(cal)
	 * 입력받은 운동시간에 cal 곱해주기 (burn_cal)
	 * 
	 * "SYSDATE+"의 소모칼로리는 "+burn_cal+"입니다."출력하기
	 */

	public static void main(String[] args) {

		
		Menu menu = new Menu();
		while(true) {
			//메뉴 보여주기
			int input = menu.showMenu();
			
			//선택한 값에 따라 동작
			switch(input) {
			case 1://오늘 소모 칼로리 확인
				new Recording().Calla(); 
				break;
			case 2: //이전 기록 조회
				new Recording().CheckKcal(); 
				break;
			case 3://첫화면으로 돌아가기 //로그인 회원가입있는 페이지로 돌아가기
				//+++++++++++이부분+++++++++++++//
				break;
			case 9: 
				//프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				return;
			}//switch
			
		}
		
		}
		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
}
