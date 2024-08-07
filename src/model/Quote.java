package model;

import java.util.Date;

public class Quote {
	private Integer quote_no;
	private Date quoteDate; // 견적서 날짜
	private String customerCode; // 거래처 코드
	private String employeeCode; // 담당자 코드
	private String productCode; // 품목 코드
	private Date validityPeriod; // 유효 기간
	private double totalAmount; // 견적 금액 합계
	private String status; // 진행 상태
	private String createdVoucher; // 생성한 전표

	// 새로 추가된 필드
	private String warehouseCode; // 출하 창고 코드
	private String transactionTypeCode; // 거래 유형 코드
	private String exchangeRateCode; // 통화 코드
	private String projectCode; // 프로젝트 코드

	public Quote(Integer quote_no, Date quoteDate, String customerCode, String employeeCode, String productCode,
			Date validityPeriod, double totalAmount, String status, String createdVoucher, String warehouseCode,
			String transactionTypeCode, String exchangeRateCode, String projectCode) {

		this.quote_no = quote_no;
		this.quoteDate = quoteDate;
		this.customerCode = customerCode;
		this.employeeCode = employeeCode;
		this.productCode = productCode;
		this.validityPeriod = validityPeriod;
		this.totalAmount = totalAmount;
		this.status = status;
		this.createdVoucher = createdVoucher;
		this.warehouseCode = warehouseCode;
		this.transactionTypeCode = transactionTypeCode;
		this.exchangeRateCode = exchangeRateCode;
		this.projectCode = projectCode;
	}

	public Integer getQuote_no() {
		return quote_no;
	}

	public void setQuote_no(Integer quote_no) {
		this.quote_no = quote_no;
	}

	public Date getQuoteDate() {
		return quoteDate;
	}

	public void setQuoteDate(Date quoteDate) {
		this.quoteDate = quoteDate;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Date getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(Date validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedVoucher() {
		return createdVoucher;
	}

	public void setCreatedVoucher(String createdVoucher) {
		this.createdVoucher = createdVoucher;
	}

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public String getTransactionTypeCode() {
		return transactionTypeCode;
	}

	public void setTransactionTypeCode(String transactionTypeCode) {
		this.transactionTypeCode = transactionTypeCode;
	}

	public String getExchangeRateCode() {
		return exchangeRateCode;
	}

	public void setExchangeRateCode(String exchangeRateCode) {
		this.exchangeRateCode = exchangeRateCode;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	
}
