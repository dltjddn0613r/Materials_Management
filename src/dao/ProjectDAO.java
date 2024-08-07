package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;

import model.Project;

public class ProjectDAO {
	public Project insert(Connection conn, Project project) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"INSERT INTO Project (ProjectCode, ProjectName, ProjectGroup, ProjectMemo) "
					+ "VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, project.getProjectCode());
			pstmt.setString(2, project.getProjectName());
			pstmt.setString(3, project.getProjectGroup());
			pstmt.setString(4, project.getProjectMemo());
			
			
			int insertedCount = pstmt.executeUpdate(); // SQL 문 실행 및 삽입된 행 수를 반환

			if (insertedCount > 0) { // 삽입이 성공한 경우
				rs = pstmt.getGeneratedKeys(); // 자동 생성된 키를 가져옵니다.
				if (rs.next()) {
					// 생성된 키를 사용하여 설정합니다.
					project.setProjectCode(rs.getString(1));
				}
				return project; // 삽입된 객체 반환
			}
			return null; // 삽입 실패 시 null 반환
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	 // 데이터베이스에 저장된 총 직원 수를 반환하는 메서드
    public int selectCount(Connection conn) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT COUNT(*) FROM Project");
            if (rs.next()) {
                return rs.getInt(1); // 총 행 수 반환
            }
            return 0; // 행이 없을 경우 0 반환
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(stmt);
        }
    }
    
    // 페이지에 따라 직원 리스트를 가져오는 메서드
    public List<Project> select(Connection conn, int firstRow, int endRow) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM (SELECT rownum as rnum, a.* FROM "
                    + "(SELECT * FROM Project ORDER BY ProjectCode DESC) a " + "WHERE rownum <= ?) WHERE rnum >= ?");
            pstmt.setInt(1, endRow); // 종료 행 번호 설정
            pstmt.setInt(2, firstRow); // 시작 행 번호 설정

            rs = pstmt.executeQuery(); // 쿼리 실행
            List<Project> result = new ArrayList<>(); // 결과를 담을 리스트 생성
            while (rs.next()) {
                result.add(convertProject(rs)); // 각 행을 객체로 변환하여 리스트에 추가
            }
            return result; // 결과 리스트 반환
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
    
    private Project convertProject(ResultSet rs) throws SQLException {
        return new Project(
            rs.getString("ProjectCode"),
            rs.getString("ProjectName"),
            rs.getString("ProjectGroup"),
            rs.getString("ProjectMemo")
        );
    }
    
    
    // 직원 코드로 특정 직원을 조회하는 메서드
    public Project selectByCode(Connection conn, String projectCode) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Project WHERE ProjectCode = ?");
            pstmt.setString(1, projectCode);

            rs = pstmt.executeQuery();
            Project project = null;
            if (rs.next()) {
            	project = convertProject(rs); // 결과를  객체로 변환하여 반환
            }
            return project; // 결과가 없으면 null 반환
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }


    public int searchCount(Connection conn, String searchQuery) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Project WHERE ProjectCode LIKE ? OR  ProjectName LIKE ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + searchQuery + "%");
            pstmt.setString(2, "%" + searchQuery + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
                return 0;
            }
        }
    }

    public List<Project> search(Connection conn, String searchQuery, int firstRow, int endRow) throws SQLException {
        String sql = "SELECT * FROM (SELECT rownum as rnum, a.* FROM (SELECT * FROM Project WHERE ProjectCode LIKE ? OR ProjectName LIKE  ? ORDER BY ProjectCode DESC) a WHERE rownum <= ?) WHERE rnum >= ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + searchQuery + "%");
            pstmt.setString(2, "%" + searchQuery + "%");
            pstmt.setInt(3, endRow);
            pstmt.setInt(4, firstRow);
            try (ResultSet rs = pstmt.executeQuery()) {
                List<Project> result = new ArrayList<>();
                while (rs.next()) {
                    result.add(convertProject(rs));
                }
                return result;
            }
        }
    }

  
}