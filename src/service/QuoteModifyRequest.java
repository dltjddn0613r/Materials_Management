package service;

import java.util.Date;

public class QuoteModifyRequest {
    private int quoteNo; // 견적서 번호
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

    public QuoteModifyRequest(int quoteNo, Date quoteDate, String customerCode, String employeeCode, String productCode,
                              Date validityPeriod, double totalAmount, String status, String createdVoucher,
                              String warehouseCode, String transactionTypeCode, String exchangeRateCode, String projectCode) {
        this.quoteNo = quoteNo;
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

    public int getQuoteNo() {
        return quoteNo;
    }

    public Date getQuoteDate() {
        return quoteDate;
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public String getCreatedVoucher() {
        return createdVoucher;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public String getTransactionTypeCode() {
        return transactionTypeCode;
    }

    public String getExchangeRateCode() {
        return exchangeRateCode;
    }

    public String getProjectCode() {
        return projectCode;
    }
}
