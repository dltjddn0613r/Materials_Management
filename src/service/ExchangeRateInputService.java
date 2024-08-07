package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.ExchangeRateDAO;
import jdbc.connection.ConnectionProvider;
import model.ExchangeRate;

public class ExchangeRateInputService {

	private ExchangeRateDAO exchangeRateDao = new ExchangeRateDAO();
	
	public void addExchangeRate(ExchangeRateInputRequest req) {
		 try (Connection conn = ConnectionProvider.getConnection()) {
			 ExchangeRate exchangeRate = new ExchangeRate(
					 req.getExchangeRateCode(), req.getExchangeRateName(), req.getExchangeRate());
			 exchangeRateDao.insert(conn, exchangeRate);
		 } catch (SQLException e) {
	            throw new RuntimeException("통화 추가 중 오류가 발생했습니다.", e);
	        }
	    }
	}
