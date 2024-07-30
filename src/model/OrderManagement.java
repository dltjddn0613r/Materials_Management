package model;

public class OrderManagement {

	private String orderNumber;
	private String orderName;
	private String orderType;
	
	public OrderManagement(String orderNumber, String orderName, String orderType) {
		
		this.orderNumber = orderNumber;
		this.orderName = orderName;
		this.orderType = orderType;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public String getOrderName() {
		return orderName;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	
	
}
