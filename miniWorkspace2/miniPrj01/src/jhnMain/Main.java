package jhnMain;

import jhnMember.MemberController;
import jhnMember.MemberVo;
import jhnMenu.Menu;

public class Main {

	public static MemberVo loginmember;

	public static void main(String[] args) {
		
		
		
		Menu menu = new Menu();
		
		while(true) {
			int input = menu.showMenu();
			
			switch(input) {
			case 1: 
				new MemberController().adminPage(); 
				break;
			case 2: 
				new MemberController().login(); 
				break;
			case 3: 
				
			case 4: 
				new MemberController().myPage(); 
				break;
			}
			
			
		}

	}
}
