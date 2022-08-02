package shy;

public class RecordController {
	
	/*
	 * 내 기록 보여주기
	 * 
	 * 입력받을 데이터 : x
	 *  -> 컨트롤러에서 데이터 받을 필요 없음
	 *  조회 결과(List<RecordVo>) 보여주기
	 *  
	 *  서비스 : 특별히 할 일 x
	 *  
	 *  dao : sql 실행
	 */
	
	public void showList() {
		
		//로그인 멤버 받으신 분으로 수정..!
		String memberNick = Main.Loginmember.getNick();
		
		List<RecordVo> recordVoList = new RecordService().showList();
		
		RecordVo vo = new RecordVo();
		vo.setNick(memberNick); // 닉네임을 가져오고 싶음....
		
		
		System.out.println("------- 기록 확인하기 -------");
		
		for(int i = 0; i <recordVoList.size(); ++i) {
		
		RecordVo temp = recordVoList.get(i);
	
		
		int no = temp.getNumrec();
		int min = temp.getMin();
		Timestamp date = temp.getDate();
		int num = temp.getNum();
		int strokeNo = temp.getStrokeNo();
		double kcal = temp.getKcal();
		//String nick = temp.getNick();
		
		System.out.println(no + /*" | " + nick +*/ "| "+ date + " | " + min + " | " + kcal + " | " );
		
		}
		
		
		//개인 기록 확인하기
		
		int no = new Menu().showPersonalRecordMenu();
		
		//0번 입력받으면 -> 메인메뉴로 리턴하기
		if(no == 0) {
			System.out.println("메인 메뉴로 돌아갑니다.");
			return;
		}
		//멤버번호 받아서 개인 기록 조회하기
		RecordVo vo = new RecordService().showPersonalRecord(no);
		
		//실행 결과 보여주기 -> 개인 총 결과 보여주고 싶은데...? 이게 어떻게 결과 나올지 모르겠음..ㅠㅠ
		
		System.out.println("\n------ 개인 기록 조회 ------");
		System.out.print("운동기록번호: " + vo.getNumrec() + " | ");
		System.out.print("닉네임 : " + vo.getNick() + " | ");
		System.out.print("영법코드 : " + vo.getStrokeNo() + " | ");
		System.out.print("소모칼로리 : " + vo.getKcal() + " | ");
		System.out.println("운동시간 : " + vo.getMin() + " | ");
		
	}//method

}
