package jhnMember;

import java.sql.Connection;

import jhnCommon.JDBCTemplate;

public class MemberService {
	
public int updatePwd(MemberVo vo) {
		
		String pwdCheck = new MemberController().login(vo);
		
		if(pwdCheck == null) {
			System.out.println("현재 비밀번호와 일치하지 않습니다.");
			return -1;
		}
		if(!vo.getPwd2().equals(vo.getPwd3())) {
			System.out.println("신규 비밀번호가 일치하지 않습니다.");
			return -2 ;
		}
		Connection conn = null;
		
		int result = 0;
		
		try {
			conn = JDBCTemplate.getConnection();
			result = new MemberDao().updatePwd(vo.getId(),vo.getPwd(),conn);
			
			if(result == 1) {
				System.out.println("비밀번호 변경을 완료하였습니다.");
				JDBCTemplate.commit(conn);
			}else {
				System.out.println("비밀번호 변경을 실패하였습니다.");
				JDBCTemplate.rollback(conn);
			}
		} 
			 catch (Exception e) {
			JDBCTemplate.rollback(conn);
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
			
		}
		return result;
	}
	public int updateNick(MemberVo vo) {
		
		String nickCheck = new MemberController().login(vo);
		if(nickCheck == null) {
			System.out.println("현재 닉네임과 일치하지 않습니다.");
			return -1;
		}
		Connection conn = null;
		int result = 0;
		try {
			conn = JDBCTemplate.getConnection();
			
			
				
			result = new MemberDao().updateNick(vo.getId(),vo.getNick2(),conn);
			
			if(result == 1) {
				System.out.println("닉네임 변경을 완료하였습니다.");
				JDBCTemplate.commit(conn);
			}else {
				System.out.println("닉네임 변경을 실패하였습니다.");
				JDBCTemplate.rollback(conn);
			}
			
			
			
		} catch (Exception e) {
			JDBCTemplate.rollback(conn);
			e.printStackTrace();
		}finally {
		 JDBCTemplate.close(conn);
	}
		
		
		return result;
	}
	
	
	public int updateWeight(MemberVo vo) {
		
		

		Connection conn = null;
		int result = 0;
		try {
			conn = JDBCTemplate.getConnection();
			
			result = new MemberDao().updateWeight(vo.getId(),vo.getWeight(),conn);
			
			if(result == 1) {
				System.out.println("몸무게 수정을 완료하였습니다.");
				JDBCTemplate.commit(conn);
			}else {
				System.out.println("몸무게 수정을 실패하였습니다.");
				JDBCTemplate.rollback(conn);
			}
		
			
		}catch(Exception e) {
			JDBCTemplate.rollback(conn);
			e.printStackTrace();
		}finally {
		JDBCTemplate.close(conn);
	}
			
		
		
		return result;
	}
	

}
