package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.*;

import com.incture.SendLink;

@Path("SendLinkMail")
public class SendMailService {

	@POST
	@Path("MailService")
	public String MailService(SendLink obj)
	{
		sendLink( obj.getEmailid(),obj.getUrl());
		return "true";
	}
	
	public void sendLink(String emailId, String otp) {
		// Recipient's email ID needs to be mentioned.
		String to = emailId;

		// Sender's email ID needs to be mentioned
		String from = "pankaj.sharma@incture.com";
		final String username = "pankaj.sharma@incture.com";
		final String password = "9784261079";// change accordingly

		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "25");

		// Get the Session object.
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("Link For Magic");

			// Now set the actual message
			message.setText("Welcome to Atithi::" + otp
					+ "\n Please do not share it with anyone.");
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	@GET
	@Path("ReadMail")
	public List<SendLink> readMail()
	{
		List<SendLink> obj=new ArrayList<SendLink>();
		SendLink ob=new SendLink();
		ob.setEmailid("internal.sure@gmail.com");
		ob.setUrl("http://localhost:8080/Guest/formc.html");
		obj.add(ob);
		return obj;
	}
}
