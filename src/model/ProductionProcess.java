package model;

public class ProductionProcess {

	private String processCode;
	private String processName;
	private Integer processOrder;
	
	public ProductionProcess(String processCode, String processName, Integer processOrder) {
		
		this.processCode = processCode;
		this.processName = processName;
		this.processOrder = processOrder;
	}

	public String getProcessCode() {
		return processCode;
	}

	public String getProcessName() {
		return processName;
	}

	public Integer getProcessOrder() {
		return processOrder;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public void setProcessOrder(Integer processOrder) {
		this.processOrder = processOrder;
	}
	
	
}
