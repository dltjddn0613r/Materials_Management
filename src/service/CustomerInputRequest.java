package service;

import java.util.Map;

public class CustomerInputRequest {
    private String customerCode;
    private String customerName;
    private String ceoName;
    private String businessType;
    private String industry;
    private String phone;
    private String fax;
    private String searchContent;
    private String mobile;
    private String postalCode;
    private String address1;
    private String website;
    private String responsibleEmployee;
    private String email;

    public CustomerInputRequest(String customerCode, String customerName, String ceoName,
                                String businessType, String industry, String phone, String fax,
                                String searchContent, String mobile, String postalCode,
                                String address1, String website, String responsibleEmployee,
                                String email) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.ceoName = ceoName;
        this.businessType = businessType;
        this.industry = industry;
        this.phone = phone;
        this.fax = fax;
        this.searchContent = searchContent;
        this.mobile = mobile;
        this.postalCode = postalCode;
        this.address1 = address1;
        this.website = website;
        this.responsibleEmployee = responsibleEmployee;
        this.email = email;
    }

    public void validate(Map<String, Boolean> errors) {
        checkEmpty(errors, customerCode, "customerCode");
        checkEmpty(errors, customerName, "customerName");
        // 필요한 다른 필드들에 대한 검증 추가
    }

    private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
        if (value == null || value.isEmpty()) {
            errors.put(fieldName, Boolean.TRUE);
        }
    }

    // Getter 및 Setter 메서드
    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCeoName() {
        return ceoName;
    }

    public void setCeoName(String ceoName) {
        this.ceoName = ceoName;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getResponsibleEmployee() {
        return responsibleEmployee;
    }

    public void setResponsibleEmployee(String responsibleEmployee) {
        this.responsibleEmployee = responsibleEmployee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
