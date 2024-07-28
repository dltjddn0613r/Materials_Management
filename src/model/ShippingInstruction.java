package model;

import java.util.Date;

public class ShippingInstruction {

	private String InstructionID;
	private Date InstructionDate;
	private String ProductCode;
	private Integer Quantity;
	private String Status;
	
	public ShippingInstruction(String instructionID, Date instructionDate, String productCode, Integer quantity,
			String status) {
		
		this.InstructionID = instructionID;
		this.InstructionDate = instructionDate;
		this.ProductCode = productCode;
		this.Quantity = quantity;
		this.Status = status;
	}

	public String getInstructionID() {
		return InstructionID;
	}

	public Date getInstructionDate() {
		return InstructionDate;
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

	public void setInstructionID(String instructionID) {
		InstructionID = instructionID;
	}

	public void setInstructionDate(Date instructionDate) {
		InstructionDate = instructionDate;
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
