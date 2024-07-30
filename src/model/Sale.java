package model;

import java.util.Date;

public class Sale {

	private String saleID;
	private Date saleDate;
	private String productCode;
	private Integer quantity;
	private Double totalAmount;
	private String paymentStatusID;
	
	public Sale(String saleID, Date saleDate, String productCode, Integer quantity, Double totalAmount,
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

	public Date getSaleDate() {
		return saleDate;
	}

	public String getProductCode() {
		return productCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public String getPaymentStatusID() {
		return paymentStatusID;
	}

	public void setSaleID(String saleID) {
		this.saleID = saleID;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setPaymentStatusID(String paymentStatusID) {
		this.paymentStatusID = paymentStatusID;
	}
	
	
	
}
