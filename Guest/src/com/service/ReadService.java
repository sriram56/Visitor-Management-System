package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.connect.ConectionDb;
import com.incture.Employee;
import com.incture.LinkGenerator;
import com.incture.Login;
import com.incture.Otp;
import com.incture.VisitorClient;
import com.incture.VisitorInterview;
import com.incture.VisitorInfo;

@Path("ReadService")
public class ReadService {

	@GET
	@Path("listOtp")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Otp> readData()
	{
		List<Otp> otp_list=new ArrayList<Otp>();
		try{
			Connection con =ConectionDb.getConnection();
			Statement st = con.createStatement();
			String query="SELECT * from OTP";
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				Otp o = new Otp();
				o.setMobile_Number(rs.getString(1));
				o.setotp_number(rs.getString(2));
				o.setStatus(rs.getString(3));
				o.setEmail(rs.getString(4));
				otp_list.add(o);
			}
			
			
		}
		catch(SQLException sql)
		{
			sql.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return otp_list;
	}
	
	@GET
	@Path("linkList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LinkGenerator> readLinkList()
	{
		Connection con=ConectionDb.getConnection();
		List<LinkGenerator> obj = new ArrayList<LinkGenerator>();
		try{
			Statement st=con.createStatement();
			String query="SELECT * from LinkTable";
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				LinkGenerator link = new LinkGenerator();
				link.setPoc(rs.getString(1));
				link.setType(rs.getString(2));
				//link.setPageid(rs.getString(3));
				link.setStatus(rs.getString(4));
				obj.add(link);
			}
			
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return obj;
	}
	
	@GET
	@Path("Client")
	@Produces(MediaType.APPLICATION_JSON)
	public List<VisitorClient> readClient()
	{
		Connection con = ConectionDb.getConnection();
		List<VisitorClient> obj = new ArrayList<VisitorClient>();
		try
		{
			Statement st=con.createStatement();
			String query="SELECT * from visitor_client";
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				VisitorClient data = new VisitorClient();
				data.setVid(rs.getString(1));
				data.setMobile_number(rs.getString(2));
				data.setFirst_Name(rs.getString(3));
				data.setLast_Name(rs.getString(4));
				data.setEmail(rs.getString(5));
				data.setPurpose(rs.getString(6));
				data.setPoc(rs.getString(7));
				data.setAddress(rs.getString(8));
				data.setOrg(rs.getString(9));
				data.setStatus(rs.getString(10));
				data.setDelegate_to(rs.getString(11));
				data.setDate(rs.getString(12));
				obj.add(data);
			}
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return obj;
	}
	
	
	@GET
	@Path("readVisitor")
	@Produces(MediaType.APPLICATION_JSON)
	public List<VisitorInterview> readVisitor()
	{
		Connection con = ConectionDb.getConnection();
		List<VisitorInterview> obj = new ArrayList<VisitorInterview>();
		try{
			
			Statement st=con.createStatement();
			String query="SELECT * from  Visitor_Interview";
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				VisitorInterview data = new VisitorInterview();
				data.setVid(rs.getString(1));
				data.setName(rs.getString(2));
				data.setAddress(rs.getString(3));
				data.setMobile_number(rs.getString(4));
				data.setPoc(rs.getString(5));
				data.setStatus(rs.getString(6));
				data.setRole(rs.getString(7));
				data.setExperience(rs.getString(8));
				data.setDelegate_to(rs.getString(9));
				data.setDate(rs.getString(10));
				obj.add(data);
			}
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return obj;
	}

	@POST
	@Path("VisitorDataByEmail")
	@Produces(MediaType.APPLICATION_JSON)
	public List<VisitorInfo> readvisitorByPoc(VisitorInfo visitor)
	{
		Connection con = ConectionDb.getConnection();
		List<VisitorInfo> obj = new ArrayList<VisitorInfo>();
		try
		{
			Statement st=con.createStatement();
			String query="SELECT * from visitor_info where Poc="+visitor.getEmail()+"";
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				VisitorInfo data = new VisitorInfo();
				data.setVid(rs.getString(1));
				data.setEmail(rs.getString(2));
				data.setFirst_name(rs.getString(3));
				data.setLast_name(rs.getString(4));
				data.setMobile_number(rs.getString(5));
				data.setAddress(rs.getString(6));
				data.setPoc(rs.getString(7));
				data.setDelegate_to(rs.getString(8));
				data.setDate(rs.getString(9));
				data.setType(rs.getString(10));
				data.setPurpose(rs.getString(11));
				data.setOrg(rs.getString(12));
				data.setRole(rs.getString(13));
				data.setStatus(rs.getString(14));
				data.setLogin(rs.getString(15));
				data.setLogout(rs.getString(16));
				
				obj.add(data);
			}
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return obj;
	}

	@GET
	@Path("Visitor")
	@Produces(MediaType.APPLICATION_JSON)
	public List<VisitorInfo> readvisitor()
	{
		Connection con = ConectionDb.getConnection();
		List<VisitorInfo> obj = new ArrayList<VisitorInfo>();
		try
		{
			Statement st=con.createStatement();
			String query="SELECT * from visitor_info";
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				VisitorInfo data = new VisitorInfo();
				data.setVid(rs.getString(1));
				data.setEmail(rs.getString(2));
				data.setFirst_name(rs.getString(3));
				data.setLast_name(rs.getString(4));
				data.setMobile_number(rs.getString(5));
				data.setAddress(rs.getString(6));
				data.setPoc(rs.getString(7));
				data.setDelegate_to(rs.getString(8));
				data.setDate(rs.getString(9));
				data.setType(rs.getString(10));
				data.setPurpose(rs.getString(11));
				data.setOrg(rs.getString(12));
				data.setRole(rs.getString(13));
				data.setStatus(rs.getString(14));
				data.setLogin(rs.getString(15));
				data.setLogout(rs.getString(16));
				
				obj.add(data);
			}
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return obj;
	}
	/******************/
	
	@POST
	@Path("VisitorByPoc")
	@Produces(MediaType.APPLICATION_JSON)
	public List<VisitorInfo> readvisitorByEmail(VisitorInfo visit)
	{
		Connection con = ConectionDb.getConnection();
		List<VisitorInfo> obj = new ArrayList<VisitorInfo>();
		System.out.println("entered the service read by poc ");
		try
		{
			Statement st=con.createStatement();
			String query="SELECT * from visitor_info where Poc='"+visit.getPoc()+"'";
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				VisitorInfo data = new VisitorInfo();
				data.setVid(rs.getString(1));
				data.setEmail(rs.getString(2));
				data.setFirst_name(rs.getString(3));
				data.setLast_name(rs.getString(4));
				data.setMobile_number(rs.getString(5));
				data.setAddress(rs.getString(6));
				data.setPoc(rs.getString(7));
				data.setDelegate_to(rs.getString(8));
				data.setDate(rs.getString(9));
				data.setType(rs.getString(10));
				data.setPurpose(rs.getString(11));
				data.setOrg(rs.getString(12));
				data.setRole(rs.getString(13));
				data.setStatus(rs.getString(14));
				data.setLogin(rs.getString(15));
				data.setLogout(rs.getString(16));
				
				obj.add(data);
			}
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return obj;
	}
	/******************/
	
	
	@POST
	@Path("readByDate")
	public List<VisitorInfo> readByDate(VisitorInfo visitor)
	{
		Connection con = ConectionDb.getConnection();
		List<VisitorInfo> obj = new ArrayList<VisitorInfo>();
		try
		{
			Statement st=con.createStatement();
			String query="SELECT * from visitor_info where Date=?";
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, visitor.getDate());
			ResultSet rs=pr.executeQuery();
			//=st.executeQuery(query);
			
			while(rs.next())
			{
				VisitorInfo data = new VisitorInfo();
				data.setVid(rs.getString(1));
				data.setEmail(rs.getString(2));
				data.setFirst_name(rs.getString(3));
				data.setLast_name(rs.getString(4));
				data.setMobile_number(rs.getString(5));
				data.setAddress(rs.getString(6));
				data.setPoc(rs.getString(7));
				data.setDelegate_to(rs.getString(8));
				data.setDate(rs.getString(9));
				data.setType(rs.getString(10));
				data.setPurpose(rs.getString(11));
				data.setOrg(rs.getString(12));
				data.setRole(rs.getString(13));
				data.setStatus(rs.getString(14));
				data.setLogin(rs.getString(15));
				data.setLogout(rs.getString(16));
				
				obj.add(data);
			}
			st.close();
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return obj;
	}
	
	/**Delegate Option */
	@GET
	@Path("delegateOption")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> delegateList()
	{
		Connection con = ConectionDb.getConnection();
		List<Employee> obj = new ArrayList<Employee>();
		try
		{
			Statement st=con.createStatement();
			String query="SELECT Email ,First_name ,Last_name from emp_table";
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				Employee data = new Employee();
				data.setEmail(rs.getString(1));
				data.setFirst_name(rs.getString(2));
				data.setLast_name(rs.getString(3));
				obj.add(data);
			}
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return obj;
	}
	
	@GET
	@Path("readLogin")
	public List<Login> readLogin()
	{
		Connection con = ConectionDb.getConnection();
		List<Login> obj = new ArrayList<Login>();
		try
		{
			Statement st=con.createStatement();
			String query="SELECT * from emp_table";
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				Login data = new Login();
				data.setEmail(rs.getString(2));
				data.setPassword(rs.getString(6));
				obj.add(data);
			}
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return obj;
	}
	/********************/
	@POST
	@Path("VisitorById")
	@Produces(MediaType.APPLICATION_JSON)
	public List<VisitorInfo> readVisitorById(VisitorInfo visitor)
	{
		Connection con = ConectionDb.getConnection();
		List<VisitorInfo> obj = new ArrayList<VisitorInfo>();
		try
		{
			Statement st=con.createStatement();
			String query="SELECT * from visitor_info where Vid=?";
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, visitor.getVid());
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				VisitorInfo data = new VisitorInfo();
				//data.setVid(rs.getString(1));
				data.setEmail(rs.getString(2));
				data.setFirst_name(rs.getString(3));
				data.setLast_name(rs.getString(4));
				data.setMobile_number(rs.getString(5));
				data.setAddress(rs.getString(6));
				data.setPoc(rs.getString(7));
				data.setDelegate_to(rs.getString(8));
				data.setDate(rs.getString(9));
				//data.setType(rs.getString(10));
				data.setPurpose(rs.getString(11));
				data.setOrg(rs.getString(12));
				data.setRole(rs.getString(13));
				data.setStatus(rs.getString(14));
				data.setLogin(rs.getString(15));
				data.setLogout(rs.getString(16));
				
				obj.add(data);
			}
			st.close();
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return obj;
	}
}
