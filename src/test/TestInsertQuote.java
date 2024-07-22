package test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import model.Quote;
import model.QuoteDAO;

public class TestInsertQuote {
    public static void main(String[] args) {
        QuoteDAO quoteDAO = new QuoteDAO();

        Quote quote = new Quote();
        
        // 현재 날짜와 유효기간 날짜 설정
        Date currentDate = new Date(Calendar.getInstance().getTimeInMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date validityPeriodDate = new Date(calendar.getTimeInMillis());
        
        quote.setQuoteDate(currentDate);
        quote.setQuoteNumber("Q12345");
        quote.setCustomerCode("C001");
        quote.setEmployeeCode("E001");
        quote.setProductCode("P001");
        quote.setValidityPeriod(validityPeriodDate);
        quote.setTotalAmount(1000.00);
        quote.setStatus("진행중");
        quote.setCreatedVoucher("V001");

        try {
            int result = quoteDAO.insertQuote(quote);
            if (result > 0) {
                System.out.println("데이터 삽입 성공!");
            } else {
                System.out.println("데이터 삽입 실패!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
