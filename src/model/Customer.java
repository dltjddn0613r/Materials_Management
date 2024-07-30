package model;

public class Customer {

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
	
	public Customer(String customerCode, String customerName, String ceoName, String businessType, String industry,
			String phone, String fax, String searchContent, String mobile, String postalCode, String address1,
			String website, String responsibleEmployee, String email) {
		super();
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

	public String getCustomerCode() {
		return customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCeoName() {
		return ceoName;
	}

	public String getBusinessType() {
		return businessType;
	}

	public String getIndustry() {
		return industry;
	}

	public String getPhone() {
		return phone;
	}

	public String getFax() {
		return fax;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public String getMobile() {
		return mobile;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getAddress1() {
		return address1;
	}

	public String getWebsite() {
		return website;
	}

	public String getResponsibleEmployee() {
		return responsibleEmployee;
	}

	public String getEmail() {
		return email;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setResponsibleEmployee(String responsibleEmployee) {
		this.responsibleEmployee = responsibleEmployee;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
