package service;

import java.util.Map;

public class EmployeeInputRequest {
    private String employeeCode;
    private String employeeName;
    private String searchContent;
    private String menuCodeUsage;
    private String memo;
    private String contactNumber;
    private String email;

    public EmployeeInputRequest(String employeeCode, String employeeName, String searchContent,
                                String menuCodeUsage, String memo, String contactNumber, String email) {
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.searchContent = searchContent;
        this.menuCodeUsage = menuCodeUsage;
        this.memo = memo;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public void validate(Map<String, Boolean> errors) {
        checkEmpty(errors, employeeCode, "employeeCode");
        checkEmpty(errors, employeeName, "employeeName");
        // 필요한 다른 필드들에 대한 검증 추가
    }

    private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
        if (value == null || value.isEmpty()) {
            errors.put(fieldName, Boolean.TRUE);
        }
    }

    // Getter 및 Setter 메서드
    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

    public String getMenuCodeUsage() {
        return menuCodeUsage;
    }

    public void setMenuCodeUsage(String menuCodeUsage) {
        this.menuCodeUsage = menuCodeUsage;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
