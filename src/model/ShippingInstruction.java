package model;

import java.util.Date;

public class ShippingInstruction {

	private String instructionID;
	private Date instructionDate;
	private String productCode;
	private Integer quantity;
	private String status;
	
	public ShippingInstruction(String instructionID, Date instructionDate, String productCode, Integer quantity,
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

	public Date getInstructionDate() {
		return instructionDate;
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

	public void setInstructionID(String instructionID) {
		this.instructionID = instructionID;
	}

	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
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
