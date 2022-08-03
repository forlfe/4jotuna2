package com.umpaumpa.member;

import java.sql.Connection;

public class MemberService {
	public static int join(MemberVo vo, Connection conn) {
		int result = 0;
		if(vo.getId().length()<4) {
			System.out.println("아이디 수가 너무 적습니다");
			result=-1;
		}
		if(vo.getPwd().length()<4) {
			System.out.println("비밀번호 수가 너무 적습니다");
			result=-2;
		}
		if(vo.getPwd().equals(vo.getPwd2())==false) {
			System.out.println("비밀번호가 서로 일치하지 않습니다");
			result=-3;
		}
		
		try {
			conn = JDBCTemplate.getConnection();
			result = new MemberDao().join(vo, conn);
			if(result==1) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JDBCTemplate.rollback(conn);
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
}
