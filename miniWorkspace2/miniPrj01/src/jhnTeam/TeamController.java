package jhnTeam;

import java.sql.Timestamp;
import java.util.List;

import jhnUtil.InputUtil;

public class TeamController {
	
	public void searchTeamInfo() {
		System.out.println("전체 팀 정보를 조회합니다.");
		
		List<TeamVo> teamVoList = new TeamDao().searchTeamInfo();
		
		System.out.println("------------- 팀 정 보------------");
		System.out.println("===================================");
		
		for(int i =0; i<teamVoList.size(); i++) {
			
			TeamVo temp = teamVoList.get(i);
			
			int code = temp.getCode();
			int num = temp.getNum();
			String teamName = temp.getTeamName();
			Timestamp tenrollDate = temp.getTenrollDate();
			int record = temp.getRecord();
			
			
			
			System.out.println(code+" | "+num+" | "+teamName+" | "+tenrollDate+" | "+record);
			
		}
			
		
	}

	public void searchTeamInfoDe() {
		
		System.out.println("상세 팀 정보를 조회합니다.");
		System.out.println("팀 번호를 입력하여 주십시오.: ");
		int code = InputUtil.getInt();
		
		TeamVo vo = new TeamDao().searchTeamInfoDe(code);
		
		System.out.println("------------- 팀 정 보------------");
		System.out.println("===================================");
		System.out.print("팀코드: "+ vo.getCode()+" | ");
		System.out.print("팀이름: "+vo.getTeamName()+" | ");
		System.out.print("팀생성날짜: "+vo.getTenrollDate()+" | ");
		System.out.println("최고기록: "+vo.getRecord());
		
		
	}

	public void insertTeam() {
		
		System.out.println("추가하실 팀이름을 입력하세요.: ");
		String newTeamName = InputUtil.sc.nextLine();
		
		
		
		TeamDao sd = new TeamDao();
		TeamVo vo = new TeamVo();
		vo.setTeamName(newTeamName);
		
		int result = sd.insertTeam(newTeamName);
		
		if(result == 1) {
			System.out.println("팀 추가 완료하였습니다.");
		}else {
			System.out.println("[ERROR: " +result+ "} 추가에 실패하였습니다!");
		}
		
		
	}

	public void updateTeam() {
		
		System.out.println("수정하실 현재 팀번호를 입력하세요.: ");
		int code = InputUtil.getInt();
		System.out.println("수정할 새로운 팀이름을 입력하세요.: ");
		String newTeamName= InputUtil.sc.nextLine();
		
		
		TeamDao sd = new TeamDao();
		TeamVo vo = new TeamVo();
		vo.setCode(code);
		vo.setTeamName(newTeamName);
		int result = sd.updateTeam(code,newTeamName);
		
		if(result == 1) {
			System.out.println("팀이름 수정을 완료하였습니다.");
		}else {
			System.out.println("[ERROR: " +result+ "} 수정에 실패하였습니다!");
		}
		
		
	}

	public void deleteTeam() {
		
		System.out.println("삭제할 팀을 입력하세요.: ");
		String teamName = InputUtil.sc.nextLine();
		
		
		TeamDao sd = new TeamDao();
		TeamVo vo = new TeamVo();
		vo.setTeamName(teamName);
		
		int result = sd.deleteTeam(teamName);
		
		if(result == 1) {
			System.out.println("영법 삭제 완료하였습니다.");
		}else {
			System.out.println("[ERROR: " +result+ "} 삭제에 실패하였습니다!");
		}
		
		
		
	}

}
