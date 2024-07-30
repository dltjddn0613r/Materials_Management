package request;

import java.util.Map;

public class PaymentStatusRequest {

	private String statusID;
	private String statusDescription;
	
	public PaymentStatusRequest(String statusID, String statusDescription) {
		
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
	
	public void validate(Map<String, Boolean> errors) {
		if(statusID == null||statusID.trim().isEmpty()) {
			errors.put("statusID", Boolean.TRUE);
		}
	}
}
