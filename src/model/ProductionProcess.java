package model;

public class ProductionProcess {

	private String ProcessCode;
	private String ProcessName;
	private Integer ProcessOrder;
	
	public ProductionProcess(String processCode, String processName, Integer processOrder) {
		
		this.ProcessCode = processCode;
		this.ProcessName = processName;
		this.ProcessOrder = processOrder;
	}

	public String getProcessCode() {
		return ProcessCode;
	}

	public String getProcessName() {
		return ProcessName;
	}

	public Integer getProcessOrder() {
		return ProcessOrder;
	}

	public void setProcessCode(String processCode) {
		ProcessCode = processCode;
	}

	public void setProcessName(String processName) {
		ProcessName = processName;
	}

	public void setProcessOrder(Integer processOrder) {
		ProcessOrder = processOrder;
	}
	
	
}
