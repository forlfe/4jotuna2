package com.umpaumpa.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDao {

	public int join(MemberVo vo, Connection conn) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;
		try {
//		String sql = "INSERT INTO JOIN(NUM, ID, PWD,NICK,WEIGHT,GENDER,ENROLL_DATE,QUIT_YN,EDIT_DATE)"
//				+ " VALUES('SEQ_JOIN_NO.NEXTVAL','admin','admin22','admin',60,'M',SYSDATE,'Y',TIMESTAMP)";
//		String sql = "INSERT INTO JOIN(NUM, ID, PWD,NICK,WEIGHT,GENDER)"
//				+ " VALUES('SEQ_JOIN_NO.NEXTVAL','admin','admin22','admin',60,'M')";
//		String sql = "INSERT INTO JOIN(ID, PWD,NAME,NICK,WEIGHT,GENDER)"
//				+ " VALUES('admin','admin22','NICK','admin',60,'M')";
//		String sql = "INSERT INTO JOIN(NUM, ID, PWD,NAME,NICK,WEIGHT,GENDER)"
//				+ " VALUES(SEQ_JOIN_NO.NEXTVAL,'admin','admin22','NICK','admin',60,'M')";
//		String sql = "INSERT INTO JOIN(NUM, ID, PWD,NAME,NICK,WEIGHT,GENDER,ENROLL_DATE,QUIT_YN,EDIT_DATE)"
//		+ " VALUES(SEQ_JOIN_NO.NEXTVAL,'admin','admin22','admin','NICK',60,'M',SYSDATE,'Y',SYSDATE)";
		String sql = "INSERT INTO JOIN(NUM, ID, PWD,NAME,NICK,WEIGHT,GENDER,ENROLL_DATE,QUIT_YN,EDIT_DATE)"
				+ " VALUES(SEQ_JOIN_NO.NEXTVAL,?,?,?,?,?,?,SYSDATE,'N',SYSDATE)";
		
		//SQL 담을 객체 만듦
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getName());
		pstmt.setString(4, vo.getNick());
		pstmt.setString(5, vo.getWeight());
		pstmt.setString(6, vo.getGender());
		
		//결과 실행 및 저장
		result = pstmt.executeUpdate();
		
			
		} catch (Exception e) {
			throw e;
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public static MemberVo login(String input_id, String input_pwd) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		// TODO Auto-generated method stub
		String sql = "SELECT NUM, ID, NAME, NICK, WEIGHT, GENDER FROM JOIN WHERE ID=? AND PWD=? AND QUIT_YN='N'";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, input_id);
		pstmt.setString(2, input_pwd);
		//System.out.println(input_id+input_pwd);
		//SQL 실행
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo vo = null;
		//rs.next();
		
		if(rs.next()) {
			String num = rs.getString("NUM");
			String id = rs.getString("ID");
			String name = rs.getString("NAME");
			String nick = rs.getString("NICK");
			String weight = rs.getString("WEIGHT");
			String gender = rs.getString("GENDER");
			//String enroll_date=rs.getString("ENROLL_DATE");
			//String edit_date=rs.getString("EDIT_DATE");
			
			vo = new MemberVo();
			vo.setNo(num);
			vo.setId(id);
			vo.setName(name);
			vo.setNick(nick);
			vo.setWeight(weight);
			vo.setGender(gender);
			//vo.seten
			
			
			
		}
		
		
		return vo;
	}
}
