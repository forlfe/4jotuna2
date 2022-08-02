package shy;

public class Menu {

	public int showPersonalRecordMenu() {
		System.out.println("");
		System.out.println("조회할 회원번호를 입력하세요 (0번을 누르면 종료");
		
		return InputUtil.getInt();
	}
}
