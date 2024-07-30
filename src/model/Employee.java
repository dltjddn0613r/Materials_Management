package model;

public class Employee {

	private String employeeCode;
	private String employeeName;
	private String searchContent;
	private String menuCodeUsage;
	private String memo;
	private String contactNumber;
	private String email;
	
	public Employee(String employeeCode, String employeeName, String searchContent, String menuCodeUsage, String memo,
			String contactNumber, String email) {
		
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
		this.searchContent = searchContent;
		this.menuCodeUsage = menuCodeUsage;
		this.memo = memo;
		this.contactNumber = contactNumber;
		this.email = email;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public String getMenuCodeUsage() {
		return menuCodeUsage;
	}

	public String getMemo() {
		return memo;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public void setMenuCodeUsage(String menuCodeUsage) {
		this.menuCodeUsage = menuCodeUsage;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
