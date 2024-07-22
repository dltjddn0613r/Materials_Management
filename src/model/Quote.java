package model;

import java.sql.Date;

public class Quote {
    private int quoteID;
    private Date quoteDate;
    private String quoteNumber; // 사용하지 않더라도 필드 유지
    private String customerCode;
    private String employeeCode;
    private String productCode;
    private Date validityPeriod;
    private double totalAmount;
    private String status;
    private String createdVoucher; // 사용하지 않더라도 필드 유지

    // Getters and Setters
    public int getQuoteID() {
        return quoteID;
    }

    public void setQuoteID(int quoteID) {
        this.quoteID = quoteID;
    }

    public Date getQuoteDate() {
        return quoteDate;
    }

    public void setQuoteDate(Date quoteDate) {
        this.quoteDate = quoteDate;
    }

    public String getQuoteNumber() {
        return quoteNumber;
    }

    public void setQuoteNumber(String quoteNumber) {
        this.quoteNumber = quoteNumber;
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
}
