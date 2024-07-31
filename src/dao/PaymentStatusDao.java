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
import model.PaymentStatus;



public class PaymentStatusDao {

	public PaymentStatus insert(Connection conn, PaymentStatus paymentStatus) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn
					.prepareStatement("insert into paymentStatus" + "(StatusID, StatusDescription)" + "values(?, ?)");
			pstmt.setString(1, paymentStatus.getStatusID());
			pstmt.setString(2, paymentStatus.getStatusDescription());

			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(
						"SELECT*FROM(SELECT StatusID FROM PaymentStatus ORDER BY ROWNUM DESC) WHERE ROWNUM = 1");
				if (rs.next()) {
					return new PaymentStatus(paymentStatus.getStatusID(), paymentStatus.getStatusDescription());
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
			rs = stmt.executeQuery("select count(*) from PaymentStatus");
			if (rs.next()) {
				return rs.getInt(1); // 조회된 행 수 반환
			}
			return 0; // 행이 없으면 0 반환
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
		public List<PaymentStatus> select(Connection conn, int firstRow, int endRow) throws SQLException {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement("SELECT * FROM (SELECT rownum as rnum, a.* FROM "
						+ "(SELECT * FROM PaymentStatus ORDER BY StatusID DESC) a " + "WHERE rownum <= ?) WHERE rnum >= ?");
				// SQL 쿼리에 데이터 바인딩
				pstmt.setInt(1, endRow);
				pstmt.setInt(2, firstRow);
				
				rs = pstmt.executeQuery();
				List<PaymentStatus> result = new ArrayList<>();
				while (rs.next()) {
					result.add(convertPaymentStatus(rs));
				}
				return result;
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}
		
		 private PaymentStatus convertPaymentStatus(ResultSet rs) throws SQLException {
		        return new PaymentStatus(rs.getString("StatusID"),rs.getString("StatusDescription"));
		        
		 }

		 private Date toDate(Timestamp timestamp) {
		        return new Date(timestamp.getTime());
		    }
		   
		public PaymentStatus selectById(Connection conn, int no) throws SQLException {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement("select * from PaymentStatus where StatusID = ?");
				pstmt.setInt(1, no);

				// SQL 쿼리 실행
				rs = pstmt.executeQuery();
				PaymentStatus paymentStatus = null;
				if (rs.next()) {
					paymentStatus = convertPaymentStatus(rs);
				}
				return paymentStatus;
			} finally {
				// 자원 해제
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}
		
	}