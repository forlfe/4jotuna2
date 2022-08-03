package shy;

import java.sql.Connection;
import java.util.List;

import jhnCommon.JDBCTemplate;

public class RecordService {
	
	public List<RecordVo> showList() {
		Connection conn = null;
		List<RecordVo> recordVoList = null;
		
		try {
			conn = JDBCTemplate.getConnection();
			recordVoList = new RecordDao().showList(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return recordVoList;
		
	}
	
	
	/* 개인별 조회
	 * 
	 */
	public RecordVo showPersonalRecord(int no) {
		
		Connection conn = null;
		RecordVo vo = null;
		
		try {
			conn = JDBCTemplate.getConnection();
			vo = new RecordDao().showPersonalRecord(conn, no);
		}catch (Exception e) {
			System.out.println("[에러] 개인별 기록 조회 중 에러발생");
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return vo;
	}

}
