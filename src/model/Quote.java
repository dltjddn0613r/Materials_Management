package model;

public class Quote {
    private int id;
    private String date;
    private String number;
    private String clientName;
    private String managerName;
    private String itemName;
    private String validityPeriod;
    private double totalAmount;
    private String status;
    private String createdVoucher;
    
    public Quote(int id, String date, String number, String clientName, String managerName, String itemName, String validityPeriod, double totalAmount, String status, String createdVoucher) {
        this.id = id;
        this.date = date;
        this.number = number;
        this.clientName = clientName;
        this.managerName = managerName;
        this.itemName = itemName;
        this.validityPeriod = validityPeriod;
        this.totalAmount = totalAmount;
        this.status = status;
        this.createdVoucher = createdVoucher;
    }
    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public String getManagerName() {
        return managerName;
    }
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getValidityPeriod() {
        return validityPeriod;
    }
    public void setValidityPeriod(String validityPeriod) {
        this.validityPeriod = validityPeriod;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCreatedVoucher() {
        return createdVoucher;
    }
    public void setCreatedVoucher(String createdVoucher) {
        this.createdVoucher = createdVoucher;
    }
}
