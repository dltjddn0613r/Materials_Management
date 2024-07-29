package model;

import java.sql.Blob;

public class Product {

	private String ProductCode;
	private String ProductName;
	private String ProductGroup;
	private Double Price;
	private String Barcode;
	private Double PurchasePrice;
	private Double SellingPrice;
	private String ProductionProcess;
	private Blob Image;
	
	public Product(String productCode, String productName, String productGroup, Double price, String barcode,
			Double purchasePrice, Double sellingPrice, String productionProcess, Blob image) {
		
		this.ProductCode = productCode;
		this.ProductName = productName;
		this.ProductGroup = productGroup;
		this.Price = price;
		this.Barcode = barcode;
		this.PurchasePrice = purchasePrice;
		this.SellingPrice = sellingPrice;
		this.ProductionProcess = productionProcess;
		this.Image = image;
	}

	public String getProductCode() {
		return ProductCode;
	}

	public String getProductName() {
		return ProductName;
	}

	public String getProductGroup() {
		return ProductGroup;
	}

	public Double getPrice() {
		return Price;
	}

	public String getBarcode() {
		return Barcode;
	}

	public Double getPurchasePrice() {
		return PurchasePrice;
	}

	public Double getSellingPrice() {
		return SellingPrice;
	}

	public String getProductionProcess() {
		return ProductionProcess;
	}

	public Blob getImage() {
		return Image;
	}

	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public void setProductGroup(String productGroup) {
		ProductGroup = productGroup;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public void setBarcode(String barcode) {
		Barcode = barcode;
	}

	public void setPurchasePrice(Double purchasePrice) {
		PurchasePrice = purchasePrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		SellingPrice = sellingPrice;
	}

	public void setProductionProcess(String productionProcess) {
		ProductionProcess = productionProcess;
	}

	public void setImage(Blob image) {
		Image = image;
	}
	
	
}
