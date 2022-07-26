package jhnTeam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jhnCommon.JDBCTemplate;
import jhnSwim.SwimVo;
import jhnUtil.InputUtil;

public class TeamDao {

	public List<TeamVo> searchTeamInfo() {
		
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		List<TeamVo> teamVoList = new ArrayList<TeamVo>();
		try {
			conn = JDBCTemplate.getConnection();
			String sql="SELECT * FROM TEAM ";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int code = rs.getInt("CODE");
				int num = rs.getInt("NUM");
				String teamName = rs.getString("TEAM_NAME");
				Timestamp tenrollDate = rs.getTimestamp("TENROLL_DATE");
				int record = rs.getInt("RECORD");
				
				TeamVo vo = new TeamVo();
				vo.setCode(code);
				vo.setNum(num);
				vo.setTeamName(teamName);
				vo.setTenrollDate(tenrollDate);
				vo.setRecord(record);
				
				teamVoList.add(vo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return teamVoList;
		
		
		
	}

	public TeamVo searchTeamInfoDe(int code) {
		
		
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		TeamVo vo = null;
		try {
			conn = JDBCTemplate.getConnection();
			String sql="SELECT * FROM TEAM WHERE CODE = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				
				
				int code1 = rs.getInt("CODE");
				String teamName = rs.getString("TEAM_NAME");
				Timestamp tenrollDate = rs.getTimestamp("TENROLL_DATE");
				int record = rs.getInt("RECORD");
				
				
				vo = new TeamVo();
				vo.setCode(code1);
				vo.setTeamName(teamName);
				vo.setTenrollDate(tenrollDate);
				vo.setRecord(record);
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		
		
		return vo;
		
	}

	public int insertTeam(String newTeamName) {
		
		Connection conn = null;
		PreparedStatement pstmt = null; 
		int result = 0;
		
		try {
			conn = JDBCTemplate.getConnection();
			String sql="INSERT INTO TEAM(CODE, TEAM_NAME, STATUS, RECORD) VALUES (SEQ_TEAM_CODE.NEXTVAL, ?, 'Y', '0')";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,newTeamName);
			
			
			result = pstmt.executeUpdate();
			
			if(result>0) {
				JDBCTemplate.commit(conn);
				
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			
		} catch (Exception e) {
			JDBCTemplate.rollback(conn);
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
		
		
	}

	public int updateTeam(int code,String newTeamName) {
		
		Connection conn = null;
		PreparedStatement pstmt = null; 
		int result = 0;
		
		try {
			conn = JDBCTemplate.getConnection();
			String sql="UPDATE TEAM SET TEAM_NAME = ? WHERE CODE = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,newTeamName);
			pstmt.setInt(2,code);
			
			
			result = pstmt.executeUpdate();
			
			if(result>0) {
				JDBCTemplate.commit(conn);
				
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			
		} catch (Exception e) {
			JDBCTemplate.rollback(conn);
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
		
	}

	public int deleteTeam(String teamName) {
		
		Connection conn = null;
		PreparedStatement pstmt = null; 
		int result = 0;
		
		try {
			conn = JDBCTemplate.getConnection();
			String sql="DELETE FROM TEAM WHERE TEAM_NAME = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,teamName);
			
			
			result = pstmt.executeUpdate();
			
			if(result>0) {
				JDBCTemplate.commit(conn);
				
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			
		} catch (Exception e) {
			JDBCTemplate.rollback(conn);
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

}
