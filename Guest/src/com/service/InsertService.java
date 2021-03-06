package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.connect.ConectionDb;
import com.incture.Otp;
import com.incture.VisitorClient;
import com.incture.VisitorInfo;
import com.incture.VisitorInterview;

@Path("/InsertService")
public class InsertService {

	static Integer vid=145;
	String start="INCJN000";
	
	@POST
	@Path("/setClient")
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.TEXT_PLAIN)
	
public String insertClient(VisitorClient visitor_client)
	{
		System.out.println("Insert Table::");
		Connection con=ConectionDb.getConnection();
		try
		{
			Statement st=con.createStatement();
			String query="INSERT INTO visitor_client values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, visitor_client.getVid());
			stmt.setString(2, visitor_client.getMobile_number());
			stmt.setString(3, visitor_client.getFirst_Name());
			stmt.setString(4, visitor_client.getLast_Name());
			stmt.setString(5, visitor_client.getEmail());
			stmt.setString(6, visitor_client.getPurpose());
			stmt.setString(7, visitor_client.getPoc());
			stmt.setString(8, visitor_client.getAddress());
			stmt.setString(9, visitor_client.getOrg());
			stmt.setString(10, visitor_client.getStatus());
			stmt.setString(11, visitor_client.getDelegate_to());
			stmt.setString(12, visitor_client.getDate());
			stmt.executeUpdate();
			//st.close();
			//System.out.println("End of insertion...");
			
			//st.close();
			//return "success";
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
	@Path("setInterview")
	public String insertInterview(VisitorInterview obj)
	{
		
		System.out.println("Insert Table::");
		Connection con=ConectionDb.getConnection();
		try
		{
			Statement st=con.createStatement();
			String query="INSERT INTO visitor_interview values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, obj.getVid());
			stmt.setString(2, obj.getName());
			stmt.setString(3, obj.getAddress());
			stmt.setString(4, obj.getMobile_number());
			stmt.setString(5, obj.getPoc());
			stmt.setString(6, obj.getStatus());
			stmt.setString(7, obj.getRole());
			stmt.setString(8, obj.getExperience());
			stmt.setString(9, obj.getDelegate_to());
			stmt.setString(10, obj.getDate());
			
			stmt.executeUpdate();
			//st.close();
			
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
	@Path("setotp")
	public String insertOtp(Otp obj)
	{
		Connection con=ConectionDb.getConnection();
		try
		{
			Statement st=con.createStatement();
			String query="INSERT INTO otp values(?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, obj.getMobile_Number());
			stmt.setString(2, obj.getotp_number());
			stmt.setString(3, obj.getStatus());
			stmt.executeUpdate();
			//st.close();
			
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

	/*@POST
	@Path("setlink")
	public String insertLink(LinkGenerator obj)
	{
		Connection con=ConectionDb.getConnection();
		try
		{
			Statement st=con.createStatement();
			String query="INSERT INTO  linktable values(?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, obj.getPoc());
			stmt.setString(2, obj.getType());
			stmt.setString(3, obj.getPageid());
			stmt.setString(4, obj.getStatus());
			stmt.executeUpdate();
			//st.close();
			
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
*/
	@POST
	@Path("setvisitor")
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.TEXT_PLAIN)
	public String insertVisitor_Info(VisitorInfo visitor_client)
	{
		System.out.println("Insert Table::");
		Connection con=ConectionDb.getConnection();
		try
		{
			Statement st=con.createStatement();
			String findMax="Select max(Vid) from visitor_info";
			ResultSet rs=st.executeQuery(findMax);
			rs.next();
			Integer vid=rs.getInt(1)+1;
			String query="INSERT INTO visitor_info values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, vid.toString());
			stmt.setString(2, visitor_client.getEmail());
			stmt.setString(3, visitor_client.getFirst_name());
			stmt.setString(4, visitor_client.getLast_name());
			stmt.setString(5, visitor_client.getMobile_number());
			stmt.setString(6, visitor_client.getAddress());
			stmt.setString(7, visitor_client.getPoc());
			stmt.setString(8, visitor_client.getDelegate_to());
			stmt.setString(9, visitor_client.getDate());
			stmt.setString(10, visitor_client.getType());
			stmt.setString(11, visitor_client.getPurpose());
			stmt.setString(12, visitor_client.getOrg());
			stmt.setString(13, visitor_client.getRole());
			stmt.setString(14, visitor_client.getStatus());
			stmt.setString(15, visitor_client.getLogin());
			stmt.setString(16, visitor_client.getLogout());
			stmt.executeUpdate();
			//st.close();
			//System.out.println("End of insertion...");
			
			//st.close();
			//return "success";
			st.close();
			new OtpService().sendOTPEmail(visitor_client.getEmail(),"Your Vid Is:"+vid.toString());
			return "Success";
			
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			vid++;
		}
		return "Fail";
	}
	
	
	
	
}
