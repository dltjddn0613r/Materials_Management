package model;

public class PaymentStatus {

	private String statusID;
	private String statusDescription;
	
	public PaymentStatus(String statusID, String statusDescription) {
		
		this.statusID = statusID;
		this.statusDescription = statusDescription;
	}

	public String getStatusID() {
		return statusID;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusID(String statusID) {
		this.statusID = statusID;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	
	
	
}
