package model;

public class ExchangeRate {

	private String ExchangeRateCode;
	private String ExchangeRateName;
	private Double ExchangeRate;
	
	public ExchangeRate(String exchangeRateCode, String exchangeRateName, Double exchangeRate) {
		
		this.ExchangeRateCode = exchangeRateCode;
		this.ExchangeRateName = exchangeRateName;
		this.ExchangeRate = exchangeRate;
	}

	public String getExchangeRateCode() {
		return ExchangeRateCode;
	}

	public String getExchangeRateName() {
		return ExchangeRateName;
	}

	public Double getExchangeRate() {
		return ExchangeRate;
	}

	public void setExchangeRateCode(String exchangeRateCode) {
		ExchangeRateCode = exchangeRateCode;
	}

	public void setExchangeRateName(String exchangeRateName) {
		ExchangeRateName = exchangeRateName;
	}

	public void setExchangeRate(Double exchangeRate) {
		ExchangeRate = exchangeRate;
	}
	
	
}
