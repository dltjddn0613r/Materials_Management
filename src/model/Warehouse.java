package model;

public class Warehouse {

	private String warehouseCode;
	private String warehouseName;
	private String warehouseCategory;
	
	public Warehouse(String warehouseCode, String warehouseName, String warehouseCategory) {
		
		this.warehouseCode = warehouseCode;
		this.warehouseName = warehouseName;
		this.warehouseCategory = warehouseCategory;
	}

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public String getWarehouseCategory() {
		return warehouseCategory;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public void setWarehouseCategory(String warehouseCategory) {
		this.warehouseCategory = warehouseCategory;
	}
	
	
	
}
