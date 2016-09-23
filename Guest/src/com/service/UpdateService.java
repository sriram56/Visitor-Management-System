package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.connect.ConectionDb;
import com.incture.Employee;
import com.incture.LinkGenerator;
import com.incture.Otp;
import com.incture.VisitorClient;
import com.incture.VisitorInterview;
import com.incture.VisitorInfo;

@Path("UpateService")
public class UpdateService {

	@POST
	@Path("LinkList")
	public String updateLinkTable(LinkGenerator linklist)
	{
		Connection con=ConectionDb.getConnection();
		try
		{
			Statement st=con.createStatement();
			String query= "UPDATE linktable set Status=? where Pageid=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, "true");
			//stmt.setString(2, linklist.getPageid());
			stmt.executeUpdate();
			//st.close();
			//System.out.println("End of insertion...");
			
			st.close();
			//return "success";
			return "Success";
			
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Failure";
	}

	@POST
	@Path("Client")
	public String updateClient(VisitorClient obj)
	{
		Connection con= ConectionDb.getConnection();
		System.out.println(obj.getStatus());
		try
		{
			Statement st=con.createStatement();
			String query="UPDATE visitor_client set Status=? where Vid=?";
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, "ACCEPT");
			pr.setString(2, obj.getVid());
			pr.executeUpdate();
			st.close();
			return "Success";
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Fail";
	}
	
	@POST
	@Path("Interview")
	public String updateInterview(VisitorInterview obj)
	{
			System.out.println("Interview---->>");
		Connection con= ConectionDb.getConnection();
		System.out.println(obj.getStatus());
		try
		{
			Statement st=con.createStatement();
			System.out.println(obj.getVid());
			String query="UPDATE visitor_interview set Status=? where Vid=?";
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, "REJECT");
			pr.setString(2, obj.getVid());
			pr.executeUpdate();
			st.close();
			return "Success";
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Fail";
	}
	@POST
	@Path("OtpUpdate")
	public String updateOtp(Otp obj)
	{
		System.out.println("OTP Tab");
		Connection con= ConectionDb.getConnection();
		try
		{
			Statement st=con.createStatement();
			//System.out.println(obj.getVid());
			String query="UPDATE otp set Status=? where Mobile_Number=?";
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, "true");
			pr.setString(2, obj.getMobile_Number());
			pr.executeUpdate();
			st.close();
			return "Success";
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Fail";
	}
	
	@POST
	@Path("VisiterUpdateLogin")
	public String updateVisitorLogin(VisitorInfo obj)
	{
		System.out.println("Visitor Tab");
		Date dNow = new Date( );
	      SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	       String d[]=ft.format(dNow).split(" ");
	       String date_visit=d[3]+" "+d[4];
	
		Connection con= ConectionDb.getConnection();
		try
		{
			Statement st=con.createStatement();
			//System.out.println(obj.getVid());
			String query="UPDATE visitor_info set Status=? , Login=? where Vid=?";
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, "OnGoing");
			pr.setString(2,date_visit );
			pr.setString(3, obj.getVid());
			pr.executeUpdate();
			st.close();
			return "Success";
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Fail";
	}
	
	@POST
	@Path("VisiterUpdateLogout")
	public String updateVisitorLogout(VisitorInfo obj)
	{
		System.out.println("Visitor Tab");
		Date dNow = new Date( );
	      SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	       String d[]=ft.format(dNow).split(" ");
	       String date_visit=d[3]+" "+d[4];
	
		Connection con= ConectionDb.getConnection();
		try
		{
			Statement st=con.createStatement();
			//System.out.println(obj.getVid());
			String query="UPDATE visitor_info set Status=? , Logout=? where Vid=?";
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, "Completed");
			pr.setString(2,date_visit );
			pr.setString(3, obj.getVid());
			pr.executeUpdate();
			st.close();
			return "Success";
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Fail";
	}
	
	@POST
	@Path("VisitorDelegate")
	public String visitorDelegate(VisitorInfo obj)
	{
		System.out.println("Visitor Delegate Tab");
		Connection con= ConectionDb.getConnection();
		try
		{
			Statement st=con.createStatement();
			//System.out.println(obj.getVid());
			String query="UPDATE visitor_info set Delegate_to=? where Vid=?";
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, obj.getDelegate_to());
			pr.setString(2, obj.getVid());
			pr.executeUpdate();
			st.close();
			return "Success";
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Fail";
	}
	
	@POST
	@Path("forgetPassword")
	public String forgetPassword(Employee obj)
	{
		System.out.println("Employee Forget Password");
		Connection con= ConectionDb.getConnection();
		try
		{
			Statement st=con.createStatement();
			String query="SELECT Password from emp_table where Email=?";
			System.out.println(obj.getEmail());
			PreparedStatement pr=con.prepareStatement(query);
			
			pr.setString(1, obj.getEmail());
			ResultSet rs=pr.executeQuery();
			rs.next();
			
			
			/*Send Using Mail */
			sendPasswordEmail(obj.getEmail(),rs.getString(1));
			st.close();
			return "Success";
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Fail";
	}
	public void sendPasswordEmail(String emailId, String pass) {
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
			message.setSubject("Password Recovery Mail");

			// Now set the actual message
			message.setText("Your Passwork is : " + pass
					+ " Please do not share it with anyone.");
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
