package request;

public class WarehouseRequest {
	
	private String warehouseCode;
	private String warehouseName;
	private String warehouseCategory;
	
	public WarehouseRequest(String warehouseCode, String warehouseName, String warehouseCategory) {
		this.warehouseCode = warehouseCode;
		this.warehouseName = warehouseName;
		this.warehouseCategory = warehouseCategory;
	}

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getWarehouseCategory() {
		return warehouseCategory;
	}

	public void setWarehouseCategory(String warehouseCategory) {
		this.warehouseCategory = warehouseCategory;
	}
	
}
