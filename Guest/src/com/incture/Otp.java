package com.incture;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Otp {

	private String Mobile_Number;
	private String otp_number;
	private String Status;
	private String Email;
	
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMobile_Number() {
		return Mobile_Number;
	}
	public void setMobile_Number(String Mobile_Number) {
		this.Mobile_Number = Mobile_Number;
	}
	public String getotp_number() {
		return otp_number;
	}
	public void setotp_number(String otp_number) {
		this.otp_number = otp_number;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String Status) {
		this.Status = Status;
	}
	
}
