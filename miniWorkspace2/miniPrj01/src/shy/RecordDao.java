package shy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RecordDao {
	
public List<RecordVo> showList(Connection conn) throws Exception {
		
		//conn 준비
		
		//sql 준비
		String sql = "SELECT R.NUMREC, J.NICK, R.NUM, R.KCAL, S.S_NAME, R.MIN FROM RECORD R JOIN JOIN J ON R.NUM = J.NUM JOIN STROKE_INFO S ON S.STROKE_NO = R.STROKE_NO";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RecordVo> recordVoList = new ArrayList<RecordVo>();
		
		try {
			//sql 담을 객체 준비 및 sql 완성
			pstmt = conn.prepareStatement(sql);
			
			//sql 실행 및 결과 저장
			rs = pstmt.executeQuery();
		
		while (rs.next()) {
			int numrec = rs.getInt("NUMREC");
			String nick = rs.getString("NICK");
			double kcal = rs.getDouble("KCAL");
			String sNmae = rs.getString("S_NAME");
			int min = rs.getInt("MIN");
			int strokeNo = rs.getInt("STROKE_NO");
			
		RecordVo vo = new RecordVo();
		vo.setNumrec(numrec);
		vo.setNick(nick);
		vo.setKcal(kcal);
		vo.setStrokeNo(strokeNo);
		vo.setMin(min);
		
		
		}
		
		}finally {
			close(rs);
			close(pstmt)
;		}
	
		//sql 실행 결과 리턴
		return recordVoList;
		
	}//method

	
	//개인 기록 조회
	
	public RecordVo showPersonalRecord(Connection conn, int no) throws Exception {
		//conn
		
		//sql 준비
		String sql = "SELECT R.NUMREC, J.NICK, R.NUM, R.KCAL, S.S_NAME, R.MIN FROM RECORD R JOIN JOIN J ON R.NUM = J.NUM JOIN STROKE_INFO S ON S.STROKE_NO = R.STROKE_NO WHERE J.NUM = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RecordVo vo= null;
		
		
		try {
			//sql 객체에 담기 및 쿼리 완성하기
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			//sql 실행 및 결과 저장
			rs = pstmt.executeQuery();
			
			//resutset - > 자바 객체
			if(rs.next()) {
				int numrec = rs.getInt("NUMREC");
				String nick = rs.getString("NICK");
				int num = rs.getInt("NUM");
				int kcal = rs.getInt("KCAL");
				String sName = rs.getString("S_NAME");
				int min = rs.getInt("MIN");
				
				vo = new RecordVo();
				vo.setNumrec(numrec);
				vo.setNick(nick);
				//vo.setNick(num);
				vo.setKcal(kcal);
				vo.setMin(min);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			close(pstmt);
			close(rs);
		}
	 return vo;
	
}

}
