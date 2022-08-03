package teamJoin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static teamJoin.JDBCTemplate.close;

public class TeamJoinDao {

	public int join(TeamJoinVo vo, Connection conn) throws Exception {
		int result = 0;
		PreparedStatement pstmt = null;

		try {
			// SQL 준비
			String sql = "INSERT INTO TEAM_JOIN(KEY, MEMBER_NUM, TEAM_CODE, ENROLL_DATE, TEAM_QUIT_YN) VALUES (SEQ_KEY_NO.NEXTVAL,?,?, SYSDATE, 'N')";

			// SQL 담을 객체 만들기
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMemberNum());
			pstmt.setInt(2, vo.getTeamCode());

			// SQL 실행 및 결과 저장
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	public List<TeamVo> teamShow(Connection conn) throws Exception {
		// SQL 준비
		String sql = "SELECT CODE, TEAM_NAME, TENROLL_DATE FROM TEAM";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TeamVo> teamVoList = new ArrayList<TeamVo>();

		try {
			// SQL 담을 객체 준비
			pstmt = conn.prepareStatement(sql);

			// SQL 실행 및 결과 저장
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int code = rs.getInt("CODE");
				String teamName = rs.getString("TEAM_NAME");
				Timestamp enrollDate = rs.getTimestamp("TENROLL_DATE");

				TeamVo vo = new TeamVo();
				vo.setCode(code);
				vo.setTeamName(teamName);
				vo.setTenrollDate(enrollDate);

				teamVoList.add(vo);

			}

		} finally {
			close(rs);
			close(pstmt);
		}

		// SQL 실행 결과 리턴

		return teamVoList;
	}

}
