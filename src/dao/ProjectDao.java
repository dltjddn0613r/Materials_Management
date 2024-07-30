package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jdbc.JdbcUtil;
import model.Project;
import model.Quote;

public class ProjectDao {

    public Project insert(Connection conn, Project project) throws SQLException {
    	PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
        	 pstmt = conn.prepareStatement(
                     "INSERT INTO Project (ProjectCode, ProjectName, ProjectMenu, ProjectMemo) "
                     + "VALUES (?, ?, ?, ?)");
                 pstmt.setString(1, project.getProjectCode());
                 pstmt.setString(2, project.getProjectName());
                 pstmt.setString(3, project.getProjectMenu());
                 pstmt.setString(4, project.getProjectMemo());

            
            int insertedCount = pstmt.executeUpdate();

            if (insertedCount > 0) {
            	stmt =conn.createStatement();//아래 쿼리문은 가장 최근에 추가된 견적서 번호를 알고 싶다는 뜻
                rs =stmt.executeQuery("SELECT quote_no FROM (SELECT quote_no FROM Quote ORDER BY quote_no DESC) WHERE ROWNUM = 1;");
                //SELECT quote_no FROM Quote WHERE ROWNUM = 1 ORDER BY quote_no DESC; 이것도 가능할듯?
                if(rs.next()) {
                	Integer newNo = rs.getInt(1);
                	return new Project(project.getProjectCode(),project.getProjectName(),project.getProjectMenu(),project.getProjectMemo());
                }
            }
            return null;
        }catch (SQLException e) {
            e.printStackTrace(); // 예외 발생 시 로그를 남길 수 있습니다.
            throw e;
        } finally {
        	JdbcUtil.close(rs);
            JdbcUtil.close(stmt);
            JdbcUtil.close(pstmt);
        }
    }

    private Timestamp toTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }
    public int selectCount(Connection conn) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT COUNT(*) FROM Project");
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(stmt);
        }
    }

	public List<Project> select(Connection conn, int firstRow, int endRow) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM (SELECT rownum AS rnum, a.* FROM (SELECT * FROM Project ORDER BY ProjectCode DESC) a WHERE rownum <= ?) WHERE rnum >= ?");
			// SQL 쿼리에 데이터 바인딩
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, firstRow);
			
			rs = pstmt.executeQuery();
			List<Project> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertProject(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
    private Project convertProject(ResultSet rs) throws SQLException {
        return new Project(
            rs.getString("ProjectCode"),
            rs.getString("ProjectName"),
            rs.getString("ProjectMenu"),
            rs.getString("ProjectMemo")
        );
	    }

	 private Date toDate(Timestamp timestamp) {
	        return new Date(timestamp.getTime());
	    }
	   
	public Project selectById(Connection conn, String projectCode) throws SQLException {
		  PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try {
	            pstmt = conn.prepareStatement("SELECT * FROM Project WHERE ProjectCode = ?");
	            pstmt.setString(1, projectCode);
	            rs = pstmt.executeQuery();
	            if (rs.next()) {
	                return convertProject(rs);
	            }
	            return null;
	        } finally {
	            JdbcUtil.close(rs);
	            JdbcUtil.close(pstmt);
	        }
	}
	
}