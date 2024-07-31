package request;

import java.util.Date;
import java.util.Map;

public class ShipmentRequest {

	private String shipmentID;
	private Date shipmentDate;
	private String productCode;
	private Integer quantity;
	private String status;
	
	public ShipmentRequest(String shipmentID, Date shipmentDate, String productCode, Integer quantity, String status) {
		this.shipmentID = shipmentID;
		this.shipmentDate = shipmentDate;
		this.productCode = productCode;
		this.quantity = quantity;
		this.status = status;
	}

	public String getShipmentID() {
		return shipmentID;
	}

	public void setShipmentID(String shipmentID) {
		this.shipmentID = shipmentID;
	}

	public Date getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}