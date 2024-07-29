package model;

public class Employee {

	private String EmployeeCode;
	private String EmployeeName;
	private String SearchContent;
	private String MenuCodeUsage;
	private String Memo;
	private String ContactNumber;
	private String Email;
	
	public Employee(String employeeCode, String employeeName, String searchContent, String menuCodeUsage, String memo,
			String contactNumber, String email) {
		
		this.EmployeeCode = employeeCode;
		this.EmployeeName = employeeName;
		this.SearchContent = searchContent;
		this.MenuCodeUsage = menuCodeUsage;
		this.Memo = memo;
		this.ContactNumber = contactNumber;
		this.Email = email;
	}

	public String getEmployeeCode() {
		return EmployeeCode;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public String getSearchContent() {
		return SearchContent;
	}

	public String getMenuCodeUsage() {
		return MenuCodeUsage;
	}

	public String getMemo() {
		return Memo;
	}

	public String getContactNumber() {
		return ContactNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmployeeCode(String employeeCode) {
		EmployeeCode = employeeCode;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public void setSearchContent(String searchContent) {
		SearchContent = searchContent;
	}

	public void setMenuCodeUsage(String menuCodeUsage) {
		MenuCodeUsage = menuCodeUsage;
	}

	public void setMemo(String memo) {
		Memo = memo;
	}

	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	
}
