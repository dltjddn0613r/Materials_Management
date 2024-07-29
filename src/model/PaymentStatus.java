package model;

public class PaymentStatus {

	private String StatusID;
	private String StatusDescription;
	
	public PaymentStatus(String statusID, String statusDescription) {
		
		StatusID = statusID;
		StatusDescription = statusDescription;
	}

	public String getStatusID() {
		return StatusID;
	}

	public String getStatusDescription() {
		return StatusDescription;
	}

	public void setStatusID(String statusID) {
		StatusID = statusID;
	}

	public void setStatusDescription(String statusDescription) {
		StatusDescription = statusDescription;
	}
	
	
}
