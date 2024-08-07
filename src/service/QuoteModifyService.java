package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import dao.QuoteDAO;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import model.Quote;

public class QuoteModifyService {
    private QuoteDAO quoteDao = new QuoteDAO();

    public void modifyQuote(QuoteModifyRequest req) {
        Connection conn = null;
        try {
            conn = ConnectionProvider.getConnection();
            conn.setAutoCommit(false);

            Quote quote = toQuote(req);
            quoteDao.update(conn, req.getQuoteNo(), req.getQuoteDate(), req.getCustomerCode(), req.getEmployeeCode(),
                            req.getProductCode(), req.getValidityPeriod(), req.getTotalAmount(), req.getStatus(),
                            req.getCreatedVoucher(), req.getWarehouseCode(), req.getTransactionTypeCode(),
                            req.getExchangeRateCode(), req.getProjectCode());

            conn.commit();
        } catch (SQLException e) {
            JdbcUtil.rollback(conn);
            throw new RuntimeException("견적서 수정 중 오류가 발생했습니다.", e);
        } catch (RuntimeException e) {
            JdbcUtil.rollback(conn);
            throw e;
        } finally {
            JdbcUtil.close(conn);
        }
    }

    private Quote toQuote(QuoteModifyRequest req) {
        return new Quote(
            req.getQuoteNo(),
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
