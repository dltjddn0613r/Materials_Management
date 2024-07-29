package model;

public class TransactionType {

	private String TransactionTypeCode;
	private String TransactionTypeName;
	
	public TransactionType(String transactionTypeCode, String transactionTypeName) {
		
		this.TransactionTypeCode = transactionTypeCode;
		this.TransactionTypeName = transactionTypeName;
	}

	public String getTransactionTypeCode() {
		return TransactionTypeCode;
	}

	public String getTransactionTypeName() {
		return TransactionTypeName;
	}

	public void setTransactionTypeCode(String transactionTypeCode) {
		TransactionTypeCode = transactionTypeCode;
	}

	public void setTransactionTypeName(String transactionTypeName) {
		TransactionTypeName = transactionTypeName;
	}
	
}
