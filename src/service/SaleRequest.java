package service;

import java.util.Date;

public class SaleRequest {
	private String saleID;
	private Date saleDate;
	private String productCode;
	private Integer quantity;
	private Double totalAmount;
	private String paymentStatusID;
	
	public SaleRequest(String saleID, Date saleDate, String productCode, Integer quantity, Double totalAmount,
			String paymentStatusID) {
		
		this.saleID = saleID;
		this.saleDate = saleDate;
		this.productCode = productCode;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.paymentStatusID = paymentStatusID;
	}

	public String getSaleID() {
		return saleID;
	}

	public void setSaleID(String saleID) {
		this.saleID = saleID;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentStatusID() {
		return paymentStatusID;
	}

	public void setPaymentStatusID(String paymentStatusID) {
		this.paymentStatusID = paymentStatusID;
	}
	
}
