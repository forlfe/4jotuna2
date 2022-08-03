package khr.Test;

public class Main {

	public static void main(String[] args) {
		
		Menu menu = new Menu();
		
		while(true) {
			int input = Menu.showTeam();
			
			switch(input) {
			case 1 : 
				/*팀 순위 보기*/
				break;
			case 2 : 
				/*크루 추가 모집 여부*/
				break;
			case 9 : 
				/*프로그램 종료*/
				return;
			}
		}

	}

}
