package shy;

import shy.Menu;

public class Main {
	
	public static MemberVo LoginMember;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Menu menu = new Menu();
		while(true) {
			//메뉴 보여주기
			int input = menu.showRecordMenu();
			
			
		case 5: 
			new RecordController.showList();
			break;
		case 6: //개인 기록 조회
			break;

	}

}
