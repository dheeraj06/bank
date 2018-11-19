package com.project.fyle;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataBase
{
	
	private static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
        System.out.println(dbUrl);
        return DriverManager.getConnection(dbUrl,username,password);

	}
@SuppressWarnings("unchecked")
public JSONArray getIfsc(String ifsc)
{
	JSONArray ja=new JSONArray();
	try {
		
	Connection conn=getConnection();
	PreparedStatement pst=conn.prepareStatement("select * from bank_branches where ifsc=? ");
	pst.setString(1,ifsc);
	ResultSet rs=pst.executeQuery();
	while(rs.next()) {
		JSONObject json=new JSONObject();
		String bank_id=rs.getString("bank_id");
		String bank_name=rs.getString("bank_name");
		String bank_ifsc=rs.getString("ifsc");
		String bank_branch=rs.getString("branch");
		String bank_address=rs.getString("address");
		String bank_city=rs.getString("city");
		String bank_district=rs.getString("district");
		String bank_state=rs.getString("state");
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
	{	e.printStackTrace();
		System.out.println(e.toString() + "KKKKK");
	}
	
	return ja;
}
@SuppressWarnings("unchecked")
public JSONArray getBank(String bname,String bcity)
{
	Connection conn;
	
	JSONArray ja=new JSONArray();
	try {conn = getConnection();
	PreparedStatement pst=conn.prepareStatement(" select * from bank_branches where bank_name=? and city=?;");
	pst.setString(1,bname);
	pst.setString(2,bcity);
	ResultSet rs=pst.executeQuery();
	while(rs.next())
	{
		JSONObject json=new JSONObject();
		String bank_ifsc=rs.getString(1);
		int bank_id=rs.getInt(2);
		String bank_branch=rs.getString(3);
		String bank_address=rs.getString(4);
		String bank_city=rs.getString(5);
		String bank_district=rs.getString(6);
		String bank_state=rs.getString(7);
		String bank_name=rs.getString(8);
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
