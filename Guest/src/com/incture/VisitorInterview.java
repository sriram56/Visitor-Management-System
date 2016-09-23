package com.incture;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VisitorInterview {

	private String Vid;
	private String Name;
	private String Address;
	private String Mobile_number;
	private String Poc;
	//Image
	private String Status;
	private String Role;	
	private String Experience;	
	private String Delegate_to;
	private String Date;
	
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
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String Role) {
		this.Role = Role;
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
	public String getExperience() {
		return Experience;
	}
	public void setExperience(String Experience) {
		this.Experience = Experience;
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
