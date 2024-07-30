package model;

import java.util.Date;

public class Quote {
	private Integer quote_no;
	private String quoteID;
	private Date quoteDate;
	private String quoteNumber;
	private String customerCode;
	private String employeeCode;
	private String productCode;
	private Date validityPeriod;
	private Double totalAmount;
	private String status;
	private String createdVoucher;

	public Quote(Integer quote_no, String quoteID, Date quoteDate, String quoteNumber, String customerCode,
			String employeeCode, String productCode, Date validityPeriod, Double totalAmount, String status,
			String createdVoucher) {

		this.quote_no = quote_no;
		this.quoteID = quoteID;
		this.quoteDate = quoteDate;
		this.quoteNumber = quoteNumber;
		this.customerCode = customerCode;
		this.employeeCode = employeeCode;
		this.productCode = productCode;
		this.validityPeriod = validityPeriod;
		this.totalAmount = totalAmount;
		this.status = status;
		this.createdVoucher = createdVoucher;
	}

	public Integer getQuote_no() {
		return quote_no;
	}

	public String getQuoteID() {
		return quoteID;
	}

	public Date getQuoteDate() {
		return quoteDate;
	}

	public String getQuoteNumber() {
		return quoteNumber;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public Date getValidityPeriod() {
		return validityPeriod;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public String getCreatedVoucher() {
		return createdVoucher;
	}

	public void setQuote_no(Integer quote_no) {
		this.quote_no = quote_no;
	}

	public void setQuoteID(String quoteID) {
		this.quoteID = quoteID;
	}

	public void setQuoteDate(Date quoteDate) {
		this.quoteDate = quoteDate;
	}

	public void setQuoteNumber(String quoteNumber) {
		this.quoteNumber = quoteNumber;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public void setValidityPeriod(Date validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCreatedVoucher(String createdVoucher) {
		this.createdVoucher = createdVoucher;
	}
	
}
