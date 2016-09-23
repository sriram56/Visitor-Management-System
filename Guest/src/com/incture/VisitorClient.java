package com.incture;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class VisitorClient {

	private String Vid; //By BackEnd
	private String Mobile_number;
	private String First_name;
	private String Last_name;
	private String Email;
	//Image
	private String Purpose;
	private String Poc;
	private String Address;
	private String Org;
	private String Status; // By bankEnd
	private String Delegate_to; // BAnkend
	private String Date;
	
	public String getLast_Name() {
		return Last_name;
	}
	public void setLast_Name(String Last_name) {
		this.Last_name = Last_name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getVid() {
		return Vid;
	}
	public void setVid(String Vid) {
		this.Vid = Vid;
	}
	public String getMobile_number() {
		return Mobile_number;
	}
	public void setMobile_number(String Mobile_number) {
		this.Mobile_number = Mobile_number;
	}
	public String getFirst_Name() {
		return First_name;
	}
	public void setFirst_Name(String First_name) {
		this.First_name = First_name;
	}
	public String getPurpose() {
		return Purpose;
	}
	public void setPurpose(String Purpose) {
		this.Purpose = Purpose;
	}
	public String getPoc() {
		return Poc;
	}
	public void setPoc(String Poc) {
		this.Poc = Poc;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public String getOrg() {
		return Org;
	}
	public void setOrg(String Org) {
		this.Org = Org;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String Status) {
		this.Status = Status;
	}
	public String getDelegate_to() {
		return Delegate_to;
	}
	public void setDelegate_to(String Delegate_to) {
		this.Delegate_to = Delegate_to;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String Date) {
		this.Date = Date;
	}
	
	
	
}
