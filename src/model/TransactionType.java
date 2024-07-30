package model;

public class TransactionType {

	private String transactionTypeCode;
	private String transactionTypeName;
	
	public TransactionType(String transactionTypeCode, String transactionTypeName) {
		
		this.transactionTypeCode = transactionTypeCode;
		this.transactionTypeName = transactionTypeName;
	}

	public String getTransactionTypeCode() {
		return transactionTypeCode;
	}

	public String getTransactionTypeName() {
		return transactionTypeName;
	}

	public void setTransactionTypeCode(String transactionTypeCode) {
		this.transactionTypeCode = transactionTypeCode;
	}

	public void setTransactionTypeName(String transactionTypeName) {
		this.transactionTypeName = transactionTypeName;
	}
	
	
}
