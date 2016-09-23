package com.incture;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SendLink {
	private String url;
	private String emailid;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
}
