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
import model.ProductionProcess;


public class ProductionProcessDao {

	public ProductionProcess insert(Connection conn, ProductionProcess productionProcess) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"INSERT INTO ProductionProcess (ProcessCode, ProcessName, ProcessOrder) " + "VALUES (?, ?, ?)");
			pstmt.setString(1, productionProcess.getProcessCode());
			pstmt.setString(2, productionProcess.getProcessName());
			pstmt.setInt(3, productionProcess.getProcessOrder());

			int insertedCount = pstmt.executeUpdate();
			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(
						"SELECT ProcessCode FROM (SELECT ProcessCode FROM ProductionProcess ORDER BY ProcessCode DESC) WHERE ROWNUM = 1;");
				if (rs.next()) {
					Integer newNo = rs.getInt(1);
					return new ProductionProcess(productionProcess.getProcessCode(), productionProcess.getProcessName(),
							productionProcess.getProcessOrder());
				}
			}
			return null;
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
			rs = stmt.executeQuery("select count(*) from ProductionProcess");
			if (rs.next()) {
				return rs.getInt(1); // 조회된 행 수 반환
			}
			return 0; // 행이 없으면 0 반환
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public List<ProductionProcess> select(Connection conn, int firstRow, int endRow) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"SELECT * FROM (SELECT rownum AS rnum, a.* FROM (SELECT * FROM ProductionProcess ORDER BY ProcessCode DESC) a WHERE rownum <= ?) WHERE rnum >= ?");
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, firstRow);

			rs = pstmt.executeQuery();
			List<ProductionProcess> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertProductionProcess(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private ProductionProcess convertProductionProcess(ResultSet rs) throws SQLException {
		return new ProductionProcess(rs.getString("ProcessCode"), rs.getString("ProcessName"),
				rs.getInt("ProcessOrder"));
	}

	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	 public ProductionProcess selectById(Connection conn, String ProcessCode) throws SQLException {
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try {
	            pstmt = conn.prepareStatement("SELECT * FROM ProductionProcess WHERE ProcessCode = ?");
	            pstmt.setString(1, ProcessCode);

	            rs = pstmt.executeQuery();
	            if (rs.next()) {
	                return convertProductionProcess(rs);
	            }
	            return null;
	        } finally {
	            JdbcUtil.close(rs);
	            JdbcUtil.close(pstmt);
	        }
	    }
	}
