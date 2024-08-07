package model;

public class Product {

	private String productCode;//품목코드
	private String productName;//품목명
	private String productGroup;//품목그룹
	private String standard;//규격
	private String barcode;//바코드
	private Double purchasePrice;//입고단가
	private Double sellingPrice;//출고단가
	private String productionProcess;//생산공정
	
	
	public Product(String productCode, String productName, String productGroup, String standard, String barcode,
			Double purchasePrice, Double sellingPrice, String productionProcess) {
		
		this.productCode = productCode;
		this.productName = productName;
		this.productGroup = productGroup;
		this.standard = standard;
		this.barcode = barcode;
		this.purchasePrice = purchasePrice;
		this.sellingPrice = sellingPrice;
		this.productionProcess = productionProcess;
	
	}


	public String getProductCode() {
		return productCode;
	}


	public String getProductName() {
		return productName;
	}


	public String getProductGroup() {
		return productGroup;
	}


	public String getStandard() {
		return standard;
	}


	public String getBarcode() {
		return barcode;
	}


	public Double getPurchasePrice() {
		return purchasePrice;
	}


	public Double getSellingPrice() {
		return sellingPrice;
	}


	public String getProductionProcess() {
		return productionProcess;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}


	public void setStandard(String standard) {
		this.standard = standard;
	}


	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}


	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}


	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}


	public void setProductionProcess(String productionProcess) {
		this.productionProcess = productionProcess;
	}

	
	
}
