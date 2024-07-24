package controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Quote;
import model.QuoteDAO;
import mvc.command.CommandHandler;

public class InsertQuoteHandler implements CommandHandler {

    @Override
    public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String quoteDateStr = req.getParameter("quoteDate");
        String quoteNumber = req.getParameter("quoteNumber");
        String customerCode = req.getParameter("customerCode");
        String employeeCode = req.getParameter("employeeCode");
        String productCode = req.getParameter("productCode");
        String validityPeriodStr = req.getParameter("validityPeriod");
        double totalAmount = Double.parseDouble(req.getParameter("totalAmount"));
        String status = req.getParameter("status");

        Date quoteDate = Date.valueOf(quoteDateStr);
        Date validityPeriod = validityPeriodStr.isEmpty() ? null : Date.valueOf(validityPeriodStr);

        Quote quote = new Quote();
        quote.setQuoteDate(quoteDate);
        quote.setQuoteNumber(quoteNumber);
        quote.setCustomerCode(customerCode);
        quote.setEmployeeCode(employeeCode);
        quote.setProductCode(productCode);
        quote.setValidityPeriod(validityPeriod);
        quote.setTotalAmount(totalAmount);
        quote.setStatus(status);

        QuoteDAO quoteDAO = new QuoteDAO();
        quoteDAO.insertQuote(quote);

        return "/views/quoteView.jsp";
    }
}
