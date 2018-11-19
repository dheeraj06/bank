package com.project.fyle;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@Path("myresource")
public class MyResource {
               
	           @GET
               @Produces(MediaType.APPLICATION_JSON)
	           public JSONArray get_Ifsc(@QueryParam("ifsc")String ifsc) {
	        	   DataBase db=new DataBase();
                  
                   return db.getIfsc(ifsc);
              }
	           
	           @GET
	           @Path("/bank")
	           @Produces(MediaType.APPLICATION_JSON)
	           public JSONArray get_Bank(@QueryParam("bname")String bname,@QueryParam("bcity")String bcity) throws URISyntaxException, SQLException {
	        	   DataBase db=new DataBase();
	        	
	        	   return db.getBank(bname,bcity);
	           }
	           
	           
}