package service;

public class QuoteSearchDetail {
    private String searchQuery;
    private String startDate;
    private String endDate;
    private String warehouse;
    private String project;
    private String customer;
    private String productCode;
    private String productStandard;
    private String employee;

    public QuoteSearchDetail(String searchQuery, String startDate, String endDate, String warehouse, String project, String customer, String productCode, String productStandard, String employee) {
        this.searchQuery = searchQuery;
        this.startDate = startDate;
        this.endDate = endDate;
        this.warehouse = warehouse;
        this.project = project;
        this.customer = customer;
        this.productCode = productCode;
        this.productStandard = productStandard;
        this.employee = employee;
    }

    // Getters and Setters
    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductStandard() {
        return productStandard;
    }

    public void setProductStandard(String productStandard) {
        this.productStandard = productStandard;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }
}
