package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ExchangeRateDAO;
import jdbc.connection.ConnectionProvider;
import model.ExchangeRate;

public class ExchangeRateSearchService {

	private ExchangeRateDAO exchangeRateDao = new ExchangeRateDAO();
	private int size = 10; //한 페이지당 표시할 개수
	
	public ExchangeRatePage searchExchangeRates(String searchQuery, int pageNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
            int total = exchangeRateDao.searchCount(conn, searchQuery);
            List<ExchangeRate> content = null;
            if (total > 0) {
                int firstRow = (pageNo - 1) * size + 1;
                int endRow = firstRow + size - 1;
                content = exchangeRateDao.search(conn, searchQuery, firstRow, endRow);
            }
            return new ExchangeRatePage(total, pageNo, size, content);
        } catch (SQLException e) {
            throw new RuntimeException("직원 검색 중 오류가 발생했습니다.", e);
        }
    }
}
