package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.*;

import com.connect.ConectionDb;
import com.incture.LinkGenerator;

@Path("GenerateLink")
public class GenerateLink {

	@POST
	@Path("setlink")
	public String generateLink(LinkGenerator linkobj)
	{
		Connection con=ConectionDb.getConnection();
		System.out.println(linkobj.getCommanUrl());
		String url=linkobj.getCommanUrl();
		//clientsform
		//interview
		String arr[]=url.split("/");
		if(arr[4].contains("formi"))
		{
			arr[4]=new String("interview");
		}else
		{
			arr[4]=new String("clientsform");
		}
		Integer pageid=0;	
		try {
				
				Statement st=con.createStatement();
				String findMax="Select max(Pageid) from linktable";
				ResultSet rs=st.executeQuery(findMax);
				rs.next();
				pageid=rs.getInt(1)+1;
				System.out.println("Page Id::"+pageid.toString()+" "+linkobj.getCommanUrl()+linkobj.getPoc());
				String query= "INSERT INTO linktable values(?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, linkobj.getPoc());
				stmt.setString(2, linkobj.getType());
				stmt.setString(3, pageid.toString());
				stmt.setString(4, "false");
				
				stmt.executeUpdate();
				st.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			String url1=arr[0]+"/"+arr[1]+"/"+arr[2]+"/"+arr[3]+"/"+arr[4]+".html?"+"Poc:"+linkobj.getPoc()+":"+pageid.toString();
			return url1;
		
	}
	


}