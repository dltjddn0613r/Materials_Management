package model;

public class ExchangeRate {

	private String exchangeRateCode;
	private String exchangeRateName;
	private Double exchangeRate;
	
	public ExchangeRate(String exchangeRateCode, String exchangeRateName, Double exchangeRate) {
		
		this.exchangeRateCode = exchangeRateCode;
		this.exchangeRateName = exchangeRateName;
		this.exchangeRate = exchangeRate;
	}

	public String getExchangeRateCode() {
		return exchangeRateCode;
	}

	public String getExchangeRateName() {
		return exchangeRateName;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRateCode(String exchangeRateCode) {
		this.exchangeRateCode = exchangeRateCode;
	}

	public void setExchangeRateName(String exchangeRateName) {
		this.exchangeRateName = exchangeRateName;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	
	
	
}
