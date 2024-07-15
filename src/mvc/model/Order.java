package mvc.model;

public class Order {
    private int id;
    private String date;
    private String number;
    private String clientName;
    private String managerName;
    private String itemName;
    private String dueDate;
    private double totalAmount;
    private String status;
    private String createdVoucher;

    // 생성자, getter, setter

    public Order(int id, String date, String number, String clientName, String managerName, String itemName, String dueDate, double totalAmount, String status, String createdVoucher) {
        this.id = id;
        this.date = date;
        this.number = number;
        this.clientName = clientName;
        this.managerName = managerName;
        this.itemName = itemName;
        this.dueDate = dueDate;
        this.totalAmount = totalAmount;
        this.status = status;
        this.createdVoucher = createdVoucher;
    }

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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
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
