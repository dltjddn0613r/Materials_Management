package service;

public class ProductionProcessRequest {
	private String processCode;
	private String processName;
	private Integer processOrder;
	
	public ProductionProcessRequest(String processCode,String processName, Integer processOrder) {
		this.processCode = processCode;
		this.processName = processName;
		this.processOrder = processOrder;
	}

	public String getProcessCode() {
		return processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public Integer getProcessOrder() {
		return processOrder;
	}

	public void setProcessOrder(Integer processOrder) {
		this.processOrder = processOrder;
	}
	
	
}
