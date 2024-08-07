package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.QuoteDAO;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import model.Quote;

public class QuoteInputService {
    private QuoteDAO quoteDao = new QuoteDAO(); // QuoteDAO 객체 생성

    public Integer quoteInput(QuoteInputRequest req) { // handler에서 호출
        Connection conn = null;
        try {
            conn = ConnectionProvider.getConnection();
            conn.setAutoCommit(false); // 트랜잭션을 비활성화

            Quote quote = toQuote(req); // QuoteInputRequest를 Quote 객체로 변환
            Quote savedQuote = quoteDao.insert(conn, quote); // 데이터베이스에 삽입

            if (savedQuote == null) { // 삽입 실패 시 예외 발생
                throw new RuntimeException("Fail to insert quote");
            }

            conn.commit(); // 트랜잭션 커밋
            return savedQuote.getQuote_no(); // 생성된 Quote 번호 반환

        } catch (SQLException e) { // SQLException 발생 시 롤백
            JdbcUtil.rollback(conn);
            throw new RuntimeException(e);
        } catch (RuntimeException e) { // RuntimeException 발생 시 롤백
            JdbcUtil.rollback(conn);
            throw e;
        } finally {
            JdbcUtil.close(conn); // 연결 닫기
        }
    }

    private Quote toQuote(QuoteInputRequest req) { // QuoteInputRequest를 Quote로 변환
       
        return new Quote(
            null,
            req.getQuoteDate(),
            req.getCustomerCode(),
            req.getEmployeeCode(),
            req.getProductCode(),
            req.getValidityPeriod(),
            req.getTotalAmount(),
            req.getStatus(),
            req.getCreatedVoucher(),
            req.getWarehouseCode(),
            req.getTransactionTypeCode(),
            req.getExchangeRateCode(),
            req.getProjectCode()
        );
    }
}
