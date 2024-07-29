package model;

public class Customer {

	private String CustomerCode;
	private String CustomerName;
	private String CEOName;
	private String BusinessType;
	private String Industry;
	private String Phone;
	private String Fax;
	private String SearchContent;
	private String Mobile;
	private String PostalCode;
	private String Address1;
	private String Website;
	private String ResponsibleEmployee;
	private String Email;
	
	public Customer(String customerCode, String customerName, String cEOName, String businessType, String industry,
			String phone, String fax, String searchContent, String mobile, String postalCode, String address1,
			String website, String responsibleEmployee, String email) {
		
		this.CustomerCode = customerCode;
		this.CustomerName = customerName;
		this.CEOName = cEOName;
		this.BusinessType = businessType;
		this.Industry = industry;
		this.Phone = phone;
		this.Fax = fax;
		this.SearchContent = searchContent;
		this.Mobile = mobile;
		this.PostalCode = postalCode;
		this.Address1 = address1;
		this.Website = website;
		this.ResponsibleEmployee = responsibleEmployee;
		this.Email = email;
	}

	public String getCustomerCode() {
		return CustomerCode;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public String getCEOName() {
		return CEOName;
	}

	public String getBusinessType() {
		return BusinessType;
	}

	public String getIndustry() {
		return Industry;
	}

	public String getPhone() {
		return Phone;
	}

	public String getFax() {
		return Fax;
	}

	public String getSearchContent() {
		return SearchContent;
	}

	public String getMobile() {
		return Mobile;
	}

	public String getPostalCode() {
		return PostalCode;
	}

	public String getAddress1() {
		return Address1;
	}

	public String getWebsite() {
		return Website;
	}

	public String getResponsibleEmployee() {
		return ResponsibleEmployee;
	}

	public String getEmail() {
		return Email;
	}

	public void setCustomerCode(String customerCode) {
		CustomerCode = customerCode;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public void setCEOName(String cEOName) {
		CEOName = cEOName;
	}

	public void setBusinessType(String businessType) {
		BusinessType = businessType;
	}

	public void setIndustry(String industry) {
		Industry = industry;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public void setFax(String fax) {
		Fax = fax;
	}

	public void setSearchContent(String searchContent) {
		SearchContent = searchContent;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}

	public void setAddress1(String address1) {
		Address1 = address1;
	}

	public void setWebsite(String website) {
		Website = website;
	}

	public void setResponsibleEmployee(String responsibleEmployee) {
		ResponsibleEmployee = responsibleEmployee;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	
}
