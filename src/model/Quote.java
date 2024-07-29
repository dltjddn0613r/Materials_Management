package model;

import java.util.Date;

public class Quote {
   private Integer quote_no;
   private String QuoteID;
   private Date QuoteDate;
   private String QuoteNumber;
   private String CustomerCode;
   private String EmployeeCode;
   private String ProductCode;
   private Date ValidityPeriod;
   private Double TotalAmount;
   private String Status;
   private String CreatedVoucher;

   public Quote(Integer quote_no, String quoteID, Date quoteDate, String quoteNumber, String customerCode,
         String employeeCode, String productCode, Date validityPeriod, Double totalAmount, String status,
         String createdVoucher) {
      this.quote_no = quote_no;
      this.QuoteID = quoteID;
      this.QuoteDate = quoteDate;
      this.QuoteNumber = quoteNumber;
      this.CustomerCode = customerCode;
      this.EmployeeCode = employeeCode;
      this.ProductCode = productCode;
      this.ValidityPeriod = validityPeriod;
      this.TotalAmount = totalAmount;
      this.Status = status;
      this.CreatedVoucher = createdVoucher;
   }

   public Integer getQuote_no() {
      return quote_no;
   }

   public String getQuoteID() {
      return QuoteID;
   }

   public Date getQuoteDate() {
      return QuoteDate;
   }

   public String getQuoteNumber() {
      return QuoteNumber;
   }

   public String getCustomerCode() {
      return CustomerCode;
   }

   public String getEmployeeCode() {
      return EmployeeCode;
   }

   public String getProductCode() {
      return ProductCode;
   }

   public Date getValidityPeriod() {
      return ValidityPeriod;
   }

   public Double getTotalAmount() {
      return TotalAmount;
   }

   public String getStatus() {
      return Status;
   }

   public String getCreatedVoucher() {
      return CreatedVoucher;
   }

   public void setQuoteID(String quoteID) {
      QuoteID = quoteID;
   }

   public void setQuoteDate(Date quoteDate) {
      QuoteDate = quoteDate;
   }

   public void setQuoteNumber(String quoteNumber) {
      QuoteNumber = quoteNumber;
   }

   public void setCustomerCode(String customerCode) {
      CustomerCode = customerCode;
   }

   public void setEmployeeCode(String employeeCode) {
      EmployeeCode = employeeCode;
   }

   public void setProductCode(String productCode) {
      ProductCode = productCode;
   }

   public void setValidityPeriod(Date validityPeriod) {
      ValidityPeriod = validityPeriod;
   }

   public void setTotalAmount(Double totalAmount) {
      TotalAmount = totalAmount;
   }

   public void setStatus(String status) {
      Status = status;
   }

   public void setCreatedVoucher(String createdVoucher) {
      CreatedVoucher = createdVoucher;
   }

}
