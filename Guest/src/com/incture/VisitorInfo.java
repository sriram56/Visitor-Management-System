package com.incture;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VisitorInfo {

	private String Vid;
	private String Email;
	private String First_name;
	private String Last_name;
	private String Mobile_number;
	private String Address;
	private String Poc;
	private String Delegate_to;
	private String Date;
	private String Type;
	private String Purpose;
	private String Role;
	private String Status;
	private String Login;
	private String Logout;
	private String Org;
	
	public String getOrg() {
		return Org;
	}
	public void setOrg(String org) {
		Org = org;
	}
	public String getFirst_name() {
		return First_name;
	}
	public void setFirst_name(String first_name) {
		First_name = first_name;
	}
	public String getLast_name() {
		return Last_name;
	}
	public void setLast_name(String last_name) {
		Last_name = last_name;
	}
	public String getVid() {
		return Vid;
	}
	public void setVid(String vid) {
		Vid = vid;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	public String getMobile_number() {
		return Mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		Mobile_number = mobile_number;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPoc() {
		return Poc;
	}
	public void setPoc(String poc) {
		Poc = poc;
	}
	public String getDelegate_to() {
		return Delegate_to;
	}
	public void setDelegate_to(String delegate_to) {
		Delegate_to = delegate_to;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getPurpose() {
		return Purpose;
	}
	public void setPurpose(String purpose) {
		Purpose = purpose;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getLogout() {
		return Logout;
	}
	public void setLogout(String logout) {
		Logout = logout;
	}
	
}