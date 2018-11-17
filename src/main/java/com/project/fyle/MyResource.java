package com.project.fyle;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;


@Path("myresource")
public class MyResource {
               
	           @GET
               @Produces(MediaType.APPLICATION_JSON)
               public JSONArray getIfsc(@QueryParam("ifsc")String ifsc) {
                     DataBase db=new DataBase();
                     System.out.println(ifsc);
                     return db.getIfsc(ifsc);
                }
	           
	           @GET
	           @Path("/bank")
	           @Produces(MediaType.APPLICATION_JSON)
	          public JSONArray getBank(@QueryParam("bname")String bname,@QueryParam("bcity")String bcity) {
	        	   DataBase db=new DataBase();
	        	   
	        	   return db.getBank(bname,bcity);
	           }
	           
}
