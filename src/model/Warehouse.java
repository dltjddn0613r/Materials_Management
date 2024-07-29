package model;

public class Warehouse {

	private String WarehouseCode;
	private String WarehouseName;
	private String WarehouseCategory;
	
	public Warehouse(String warehouseCode, String warehouseName, String warehouseCategory) {
		
		this.WarehouseCode = warehouseCode;
		this.WarehouseName = warehouseName;
		this.WarehouseCategory = warehouseCategory;
	}

	public String getWarehouseCode() {
		return WarehouseCode;
	}

	public String getWarehouseName() {
		return WarehouseName;
	}

	public String getWarehouseCategory() {
		return WarehouseCategory;
	}

	public void setWarehouseCode(String warehouseCode) {
		WarehouseCode = warehouseCode;
	}

	public void setWarehouseName(String warehouseName) {
		WarehouseName = warehouseName;
	}

	public void setWarehouseCategory(String warehouseCategory) {
		WarehouseCategory = warehouseCategory;
	}
	
	
}
