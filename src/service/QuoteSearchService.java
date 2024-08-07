
package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.QuoteDAO;
import jdbc.connection.ConnectionProvider;
import model.Quote;

public class QuoteSearchService {
    private QuoteDAO quoteDao = new QuoteDAO();
    private int size = 20; // 한 페이지에 표시할 견적서 수

    public QuotePage searchQuotes(String searchQuery, int pageNo) {
        try (Connection conn = ConnectionProvider.getConnection()) {
            int total = quoteDao.searchCount(conn, searchQuery); // 키워드에 따른 전체 게시글 수 가져오기

            List<Quote> content = null;
            if (total > 0) {
                int firstRow = (pageNo - 1) * size + 1;
                int endRow = firstRow + size - 1;
                content = quoteDao.search(conn, searchQuery, firstRow, endRow); // 키워드에 따른 게시글 가져오기
            }
            return new QuotePage(total, pageNo, size, content);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
