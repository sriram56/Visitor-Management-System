package com.incture;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

	private String Emp_Id;
	private String Email;
	private String First_name;
	private String Last_name;
	private String Mobile_no;
	private String Password;
	public String getEmp_Id() {
		return Emp_Id;
	}
	public void setEmp_Id(String emp_Id) {
		Emp_Id = emp_Id;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
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
	public String getMobile_no() {
		return Mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		Mobile_no = mobile_no;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
}
