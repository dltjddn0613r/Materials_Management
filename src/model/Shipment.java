package model;

import java.util.Date;

public class Shipment {

	private String ShipmentID;
	private Date ShipmentDate;
	private String ProductCode;
	private Integer Quantity;
	private String Status;
	
	public Shipment(String shipmentID, Date shipmentDate, String productCode, Integer quantity, String status) {
		
		this.ShipmentID = shipmentID;
		this.ShipmentDate = shipmentDate;
		this.ProductCode = productCode;
		this.Quantity = quantity;
		this.Status = status;
	}

	public String getShipmentID() {
		return ShipmentID;
	}

	public Date getShipmentDate() {
		return ShipmentDate;
	}

	public String getProductCode() {
		return ProductCode;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public String getStatus() {
		return Status;
	}

	public void setShipmentID(String shipmentID) {
		ShipmentID = shipmentID;
	}

	public void setShipmentDate(Date shipmentDate) {
		ShipmentDate = shipmentDate;
	}

	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	
}
