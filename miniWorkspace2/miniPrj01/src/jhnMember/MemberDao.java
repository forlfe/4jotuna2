package jhnMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jhnCommon.JDBCTemplate;
import jhnMain.Main;
import jhnUtil.InputUtil;

public class MemberDao {
	
public MemberVo adminLogin(String adminId, String adminPwd) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		String sql="SELECT ADMIN_ID, ADMIN_NAME FROM ADMIN WHERE ADMIN_ID = ? AND ADMIN_PWD = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, adminId);
		pstmt.setString(2, adminPwd);
		
		ResultSet rs = pstmt.executeQuery();
		MemberVo vo = null;
		
		
		if(rs.next()) {
			
			
			String id = rs.getString("ADMIN_ID");
			String name = rs.getString("ADMIN_NAME");
			
			vo = new MemberVo();
			
			vo.setAdminId(id);
			vo.setAdminName(name);
			
		}
		
		return vo;
	}

	public List<MemberVo> memberSearch(){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVo> memberVoList = new ArrayList<MemberVo>();
		try {
			conn = JDBCTemplate.getConnection();
			
			String sql="SELECT * FROM JOIN ";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				String no = rs.getString("NUM");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String nick = rs.getString("NICK");
				String weight = rs.getString("WEIGHT");
				String gender = rs.getString("GENDER");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				String quitYn = rs.getString("QUIT_YN");
				Timestamp editDate = rs.getTimestamp("EDIT_DATE");
				
				
				
				MemberVo vo = new MemberVo();
				vo.setNo(no);
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setNick(nick);
				vo.setWeight(weight);
				vo.setGender(gender);
				vo.setEnrollDate(enrollDate);
				vo.setQuitYn(quitYn);
				vo.setEditDate(editDate);
				
				
				memberVoList.add(vo);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		
		return memberVoList;
		
		
		
		
	}
	
	public List<MemberVo> memberSearchDe(String memberNo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVo> memberVoList = new ArrayList<MemberVo>();
		try {
			conn = JDBCTemplate.getConnection();
			String sql="SELECT * FROM MEMBER WHERE NO = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberNo);
			
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String nick = rs.getString("NICK");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");
				String quitYn = rs.getString("QUIT_YN");
				
				
				MemberVo vo = new MemberVo();
				vo.setNo(no);
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setNick(nick);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
				vo.setQuitYn(quitYn);
				
				memberVoList.add(vo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return memberVoList;
		
		
	}
	public MemberVo login(String inputId, String inputPwd) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		String sql ="SELECT NUM, ID, NICK FROM JOIN WHERE ID = ? AND PWD = ? AND QUIT_YN = 'N'";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, inputId);
		pstmt.setString(2, inputPwd);
		
		ResultSet rs = pstmt.executeQuery();
		MemberVo vo = null;
		
		
		if(rs.next()) {
			String no = rs.getString("NUM");
			String id = rs.getString("ID");
			String nick = rs.getString("NICK");
			
			vo = new MemberVo();
			vo.setNo(no);
			vo.setId(id);
			vo.setNick(nick);
			
		}
		return vo;
		
	}
	
	public int updatePwd(String id, String newPwd,Connection conn) throws Exception {
		
		PreparedStatement pstmt= null;
		
		int result = 0;
		try {
			
			
			
			String sql = "UPDATE JOIN SET PWD = ? WHERE ID = ?";
			
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, id);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			throw e;
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	public int updateNick(String id, String newNick, Connection conn) throws Exception {
		
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			
			
			String sql = "UPDATE JOIN SET NICK = ? WHERE ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newNick);
			pstmt.setString(2, id);
			
			result = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			throw e;
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
		
	}
	
	public int updateWeight(String id, String newWeight, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			
			
			String sql = "UPDATE JOIN SET WEIGHT = ? WHERE ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newWeight);
			pstmt.setString(2, id);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw e;
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}

}
