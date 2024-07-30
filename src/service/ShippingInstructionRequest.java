package service;

import java.util.Date;

public class ShippingInstructionRequest {
	
	private String instructionID;
	private Date instructionDate;
	private String productCode;
	private Integer quantity;
	private String status;
	
	public ShippingInstructionRequest(String instructionID, Date instructionDate, String productCode, Integer quantity,
			String status) {
		this.instructionID = instructionID;
		this.instructionDate = instructionDate;
		this.productCode = productCode;
		this.quantity = quantity;
		this.status = status;
	}

	public String getInstructionID() {
		return instructionID;
	}

	public void setInstructionID(String instructionID) {
		this.instructionID = instructionID;
	}

	public Date getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
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
