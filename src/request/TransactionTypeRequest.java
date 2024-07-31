package request;

public class TransactionTypeRequest {
	
	private String transactionTypeCode;
	private String transactionTypeName;
	
	public TransactionTypeRequest(String transactionTypeCode, String transactionTypeName) {
		this.transactionTypeCode = transactionTypeCode;
		this.transactionTypeName = transactionTypeName;
	}

	public String getTransactionTypeCode() {
		return transactionTypeCode;
	}

	public void setTransactionTypeCode(String transactionTypeCode) {
		this.transactionTypeCode = transactionTypeCode;
	}

	public String getTransactionTypeName() {
		return transactionTypeName;
	}

	public void setTransactionTypeName(String transactionTypeName) {
		this.transactionTypeName = transactionTypeName;
	}
	
}
