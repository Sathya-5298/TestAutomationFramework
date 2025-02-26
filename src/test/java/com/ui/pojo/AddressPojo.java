package com.ui.pojo;

public class AddressPojo 
{
	private String companyName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String postCode;
	private String homePhoneNumber;
	private String mobileNumber;
	private String additionalInformation;
	private String myAddress;
	private String state;
	public AddressPojo(String companyName, String addressLine1, String addressLine2, String city, String postCode,
			String homePhoneNumber, String mobileNumber, String additionalInformation, String myAddress, String state) 
	{
		super();
		this.companyName = companyName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.postCode = postCode;
		this.homePhoneNumber = homePhoneNumber;
		this.mobileNumber = mobileNumber;
		this.additionalInformation = additionalInformation;
		this.myAddress = myAddress;
		this.state = state;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public String getCity() {
		return city;
	}
	public String getPostCode() {
		return postCode;
	}
	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public String getAdditionalInformation() {
		return additionalInformation;
	}
	public String getMyAddress() {
		return myAddress;
	}
	public String getState() {
		return state;
	}
	@Override
	public String toString() {
		return "AddressPojo [companyName=" + companyName + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", postCode=" + postCode + ", homePhoneNumber=" + homePhoneNumber
				+ ", mobileNumber=" + mobileNumber + ", additionalInformation=" + additionalInformation + ", myAddress="
				+ myAddress + ", state=" + state + "]";
	}
	
	
	
}
