package com.project.fyle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataBase {
private static final String username="root";
private static final String password="123456";
private static final String connect="jdbc:mysql://localhost:3306/bank";
Connection conn=null;
public DataBase()
{
	try {
	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection(connect,username,password);
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
	}
}
public JSONArray getIfsc(String ifsc)
{
	JSONArray ja=new JSONArray();
	try {
	PreparedStatement pst=conn.prepareStatement("SELECT * FROM bank_details WHERE bank_ifsc=?");
	pst.setString(1,ifsc);
	ResultSet rs=pst.executeQuery();
	while(rs.next()) {
		JSONObject json=new JSONObject();
		int bank_id=rs.getInt(1);
		String bank_name=rs.getString("bank_name");
		String bank_ifsc=rs.getString("bank_ifsc");
		String bank_branch=rs.getString("bank_branch");
		String bank_address=rs.getString("bank_address");
		String bank_city=rs.getString("bank_city");
		String bank_district=rs.getString("bank_district");
		String bank_state=rs.getString("bank_state");
		json.put("bankId",bank_id);
		json.put("bankName",bank_name);
		json.put("bankIfsc",bank_ifsc);
		json.put("bankBranch",bank_branch );
		json.put("bankAddress",bank_address);
		json.put("bankCity", bank_city);
		json.put("bankDistrict",bank_district);
		json.put("bankState",bank_state);
		ja.add(json);
	}
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
	}
	
	return ja;
}
public JSONArray getBank(String bname,String bcity)
{
	JSONArray ja=new JSONArray();
	try {
	PreparedStatement pst=conn.prepareStatement("SELECT * FROM bank_details WHERE bank_name=? AND bank_city=?");
	pst.setString(1,bname);
	pst.setString(2,bcity);
	ResultSet rs=pst.executeQuery();
	while(rs.next())
	{
		JSONObject json=new JSONObject();
		int bank_id=rs.getInt(1);
		String bank_name=rs.getString("bank_name");
		String bank_ifsc=rs.getString("bank_ifsc");
		String bank_branch=rs.getString("bank_branch");
		String bank_address=rs.getString("bank_address");
		String bank_city=rs.getString("bank_city");
		String bank_district=rs.getString("bank_district");
		String bank_state=rs.getString("bank_state");
		json.put("bankId",bank_id);
		json.put("bankName",bank_name);
		json.put("bankIfsc",bank_ifsc);
		json.put("bankBranch",bank_branch );
		json.put("bankAddress",bank_address);
		json.put("bankCity", bank_city);
		json.put("bankDistrict",bank_district);
		json.put("bankState",bank_state);
		ja.add(json);	
	}
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
	}
	return ja;
}

}
