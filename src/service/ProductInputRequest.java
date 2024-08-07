package service;

import java.util.Map;

public class ProductInputRequest {
    private String productCode; // 품목코드
    private String productName; // 품목명
    private String productGroup; // 품목그룹
    private String standard; // 규격
    private String barcode; // 바코드
    private double purchasePrice; // 입고단가
    private double sellingPrice; // 출고단가
    private String productionProcess; // 생산공정

    // 생성자
    public ProductInputRequest(String productCode, String productName, String productGroup, String standard,
                               String barcode, double purchasePrice, double sellingPrice, String productionProcess) {
        this.productCode = productCode;
        this.productName = productName;
        this.productGroup = productGroup;
        this.standard = standard;
        this.barcode = barcode;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.productionProcess = productionProcess;
    }

    // 유효성 검사를 위한 메서드
    public void validate(Map<String, Boolean> errors) {
		
        if (purchasePrice < 0) {
            errors.put("purchasePrice", Boolean.TRUE);
        }
        if (sellingPrice < 0) {
            errors.put("sellingPrice", Boolean.TRUE);
        }
       
    }

    // Getters
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

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public String getProductionProcess() {
        return productionProcess;
    }
}
