package com.packt.webstore.service;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class writeToJSON {
	
	public String addDistributor(String data){
		
		 org.json.JSONObject details = new org.json.JSONObject(data);
		  String name= details.getString("distributor");
		  String include= details.getString("include");
		  String exclude = details.getString("exclude");
		  String parent = details.getString("parent");
		  
		  JSONObject obj = new JSONObject();
	        
		  JSONObject list = new JSONObject();
	        list.put("include",include);
	        list.put("exclude",exclude);
	        list.put("parent",parent);  
	        
	        obj.put(name.toLowerCase(), list);
	        
	        //System.out.println(obj);
	        try (FileWriter file = new FileWriter("C:\\Users\\Temp\\workspace\\sample\\src\\main\\webapp\\assets\\JSON\\distributor.json",true)) 
	        {

	            file.write(obj.toJSONString());
	            file.flush();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

		
		return "hey";
		
		
	}

}
