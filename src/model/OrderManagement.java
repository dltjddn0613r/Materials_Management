package model;

public class OrderManagement {

	private String OrderNumber;
	private String OrderName;
	private String OrderType;
	
	public OrderManagement(String orderNumber, String orderName, String orderType) {
		
		this.OrderNumber = orderNumber;
		this.OrderName = orderName;
		this.OrderType = orderType;
	}

	public String getOrderNumber() {
		return OrderNumber;
	}

	public String getOrderName() {
		return OrderName;
	}

	public String getOrderType() {
		return OrderType;
	}

	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}

	public void setOrderName(String orderName) {
		OrderName = orderName;
	}

	public void setOrderType(String orderType) {
		OrderType = orderType;
	}
	
	
}
