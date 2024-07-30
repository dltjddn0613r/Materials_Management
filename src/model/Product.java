package model;

import java.sql.Blob;

public class Product {

	private String productCode;
	private String productName;
	private String productGroup;
	private Double price;
	private String barcode;
	private Double purchasePrice;
	private Double sellingPrice;
	private String productionProcess;
	private Blob image;
	
	public Product(String productCode, String productName, String productGroup, Double price, String barcode,
			Double purchasePrice, Double sellingPrice, String productionProcess, Blob image) {
		
		this.productCode = productCode;
		this.productName = productName;
		this.productGroup = productGroup;
		this.price = price;
		this.barcode = barcode;
		this.purchasePrice = purchasePrice;
		this.sellingPrice = sellingPrice;
		this.productionProcess = productionProcess;
		this.image = image;
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

	public Double getPrice() {
		return price;
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

	public Blob getImage() {
		return image;
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

	public void setPrice(Double price) {
		this.price = price;
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

	public void setImage(Blob image) {
		this.image = image;
	}
	
	
	
}
