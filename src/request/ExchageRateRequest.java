package request;

public class ExchageRateRequest {

		private String exchangeRateCode;
		private String exchangeRateName;
		private Double exchangeRate;
		
		public void exchangeRateRequest() {}
		
		public void exchangeRate(String exchangeRateCode, String exchangeRateName, Double exchangeRate) {
			
			this.exchangeRateCode = exchangeRateCode;
			this.exchangeRateName = exchangeRateName;
			this.exchangeRate = exchangeRate;
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
