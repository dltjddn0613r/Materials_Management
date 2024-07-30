package model;

import java.util.Date;

public class Shipment {

	private String shipmentID;
	private Date shipmentDate;
	private String productCode;
	private Integer quantity;
	private String status;
	
	public Shipment(String shipmentID, Date shipmentDate, String productCode, Integer quantity, String status) {
		
		this.shipmentID = shipmentID;
		this.shipmentDate = shipmentDate;
		this.productCode = productCode;
		this.quantity = quantity;
		this.status = status;
	}

	public String getShipmentID() {
		return shipmentID;
	}

	public Date getShipmentDate() {
		return shipmentDate;
	}

	public String getProductCode() {
		return productCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setShipmentID(String shipmentID) {
		this.shipmentID = shipmentID;
	}

	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
