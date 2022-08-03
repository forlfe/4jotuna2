package teamJoin;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;


public class TeamJoinController {
	
	Scanner sc = new Scanner(System.in);

	public void join() {
		
		System.out.println("----- 팀 가입 -----");
		System.out.print("원하는 팀번호 : ");
		int teamCode = sc.nextInt();
		
		TeamJoinVo vo = new TeamJoinVo();
		vo.setTeamCode(teamCode);
		
		int result = new TeamJoinService().join(vo);
		
	}
	
	public void teamShow() {
		
		List<TeamVo> teamVoList = new TeamJoinService().teamShow();
		
		for(int i = 0 ; i < teamVoList.size(); ++i) {
			TeamVo temp = teamVoList.get(i);
			
			int code = temp.getCode();
			String teamName = temp.getTeamName();
			Timestamp enrollDate = temp.getTenrollDate();
			
			System.out.println(code+ " | " + teamName + "| 팀 생성날짜 : " + enrollDate);
			
		}
		
		System.out.println("팀선택창은 0번");
		
		int num = sc.nextInt();
		
		if(num == 0) {
			System.out.println("전 메뉴로 돌아갑니다");
			return;
		}else {
			
		}
		
	}

}
