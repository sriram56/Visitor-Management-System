package com.incture;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Login {

	private String Email;
	private String Password;
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
}
