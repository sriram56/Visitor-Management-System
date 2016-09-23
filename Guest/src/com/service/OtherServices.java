package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.connect.ConectionDb;
import com.incture.Login;

@Path("otherService")
public class OtherServices {

	
	@POST
	@Path("loginService")
	public String loginService(Login obj)
	{
		Connection con = ConectionDb.getConnection();
		try
		{
			System.out.println("Login Pages Pankaj");
			Statement st=con.createStatement();
			System.out.println(obj.getEmail()+"  "+obj.getPassword());
			String query="SELECT * FROM emp_table WHERE Email='"+obj.getEmail()+"' AND Password='"+obj.getPassword()+"'";
			ResultSet rs=st.executeQuery(query);
			System.out.println("Pankaj");
			if(rs.next())
			{
				st.close();
				System.out.println("true");
				return "true";
			}
			else{
				st.close();
				return "false";
			}
			
			
		}catch(SQLException sql)
		{
			sql.printStackTrace();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "SQL Query Error";
	}
}
