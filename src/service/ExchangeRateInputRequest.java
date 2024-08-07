package service;

import java.util.Map;

public class ExchangeRateInputRequest {

	private String exchangeRateCode;
	private String exchangeRateName;
	private Double exchangeRate;
	
	public ExchangeRateInputRequest(String exchangeRateCode, String exchangeRateName, Double exchangeRate) {
		
		this.exchangeRateCode = exchangeRateCode;
		this.exchangeRateName = exchangeRateName;
		this.exchangeRate = exchangeRate;
	}
	
	public void validate(Map<String, Boolean> errors) {
        checkEmpty(errors, exchangeRateCode, "exchangeRateCode");
        checkEmpty(errors, exchangeRateName, "exchangeRateName");
        // 필요한 다른 필드들에 대한 검증 추가
    }

    private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
        if (value == null || value.isEmpty()) {
            errors.put(fieldName, Boolean.TRUE);
        }
    }

	public String getExchangeRateCode() {
		return exchangeRateCode;
	}

	public void setExchangeRateCode(String exchangeRateCode) {
		this.exchangeRateCode = exchangeRateCode;
	}

	public String getExchangeRateName() {
		return exchangeRateName;
	}

	public void setExchangeRateName(String exchangeRateName) {
		this.exchangeRateName = exchangeRateName;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	
	
}
