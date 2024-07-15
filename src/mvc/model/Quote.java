package mvc.model;

import java.util.Date;

public class Quote {
    private int id;
    private Date date; // Date 타입으로 변경
    private String number;
    private String clientName;
    private String managerName;
    private String itemName;
    private Date validityPeriod; // Date 타입으로 변경
    private double totalAmount;
    private String status;
    private String createdVoucher;

    public Quote(int id, Date date, String number, String clientName, String managerName, String itemName, Date validityPeriod, double totalAmount, String status, String createdVoucher) {
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
    public Date getDate() { // 반환 타입을 Date로 수정
        return date;
    }
    public void setDate(Date date) { // 파라미터 타입도 Date로 수정
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
    public Date getValidityPeriod() { // 반환 타입을 Date로 수정
        return validityPeriod;
    }
    public void setValidityPeriod(Date validityPeriod) { // 파라미터 타입도 Date로 수정
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
