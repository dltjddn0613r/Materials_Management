package model;

import java.util.Date;

public class Sale {

	private String SaleID;
	private Date SaleDate;
	private String ProductCode;
	private Integer Quantity;
	private Double TotalAmount;
	private String PaymentStatusID;
	
	public Sale(String saleID, Date saleDate, String productCode, Integer quantity, Double totalAmount,
			String paymentStatusID) {
		
		this.SaleID = saleID;
		this.SaleDate = saleDate;
		this.ProductCode = productCode;
		this.Quantity = quantity;
		this.TotalAmount = totalAmount;
		this.PaymentStatusID = paymentStatusID;
	}

	public String getSaleID() {
		return SaleID;
	}

	public Date getSaleDate() {
		return SaleDate;
	}

	public String getProductCode() {
		return ProductCode;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public Double getTotalAmount() {
		return TotalAmount;
	}

	public String getPaymentStatusID() {
		return PaymentStatusID;
	}

	public void setSaleID(String saleID) {
		SaleID = saleID;
	}

	public void setSaleDate(Date saleDate) {
		SaleDate = saleDate;
	}

	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public void setTotalAmount(Double totalAmount) {
		TotalAmount = totalAmount;
	}

	public void setPaymentStatusID(String paymentStatusID) {
		PaymentStatusID = paymentStatusID;
	}
	
	
}
