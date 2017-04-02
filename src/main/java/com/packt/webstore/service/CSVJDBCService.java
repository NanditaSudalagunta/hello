package com.packt.webstore.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.relique.jdbc.csv.CsvDriver;

public class CSVJDBCService
{
  public int processCSV(String data) throws Exception
  {
	  String filePath = CSVJDBCService.class.getClassLoader().getResource("").getPath();
	  
	  org.json.JSONObject details = new org.json.JSONObject(data);
	  String region= details.getString("region");
    // Load the driver.
    Class.forName("org.relique.jdbc.csv.CsvDriver");

    // Create a connection. The first command line parameter is
    // the directory containing the .csv files.
    // A single connection is thread-safe for use by several threads.
    Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + filePath+"/csv");

    // Create a Statement object to execute the query with.
    // A Statement is not thread-safe.
    Statement stmt = conn.createStatement();

    
    // Select the ID and NAME columns from sample.csv
    ResultSet results = stmt.executeQuery("SELECT Country_Name,Province_Name,City_Name FROM cities");

    // Dump out the results to a CSV file with the same format
    // using CsvJdbc helper function
    /*boolean append = true;
    CsvDriver.writeToCsv(results, System.out, append);*/
    /*int i=0;
    Map<String, Set<String>> stateJSON = new HashMap<String, Set<String>>();
    
    Map<String, Set<String>> cityJSON = new HashMap<String, Set<String>>();
*/    
    
   /* ArrayList<String> placesList = new ArrayList<String>();*/
    int count=0;
    String[] inputList = region.split("-");
    
    while(results.next()){
    	
    	//System.out.println(i++ +": "+results.getString(1)+" "+results.getString(2));
    	
    	 String country = results.getString(1);
    	  String province = results.getString(2);
    	  String city = results.getString(3);
    	  	  
    	  
    	  if(inputList.length==1 && country.replaceAll("\\s+","").equalsIgnoreCase(inputList[0].replaceAll("\\s+","")))
    	  {
    		count++;
    		break;
    	  
    	  }
    	  else if(inputList.length==2 && country.replaceAll("\\s+","").equalsIgnoreCase(inputList[1].replaceAll("\\s+","")) && province.replaceAll("\\s+","").equalsIgnoreCase(inputList[0].replaceAll("\\s+","")))
    	  {
    		 count++;
      		break;
    	  }
    	  else if(inputList.length==3 && country.replaceAll("\\s+","").equalsIgnoreCase(inputList[2].replaceAll("\\s+","")) && province.replaceAll("\\s+","").equalsIgnoreCase(inputList[1].replaceAll("\\s+","")) && city.replaceAll("\\s+","").equalsIgnoreCase(inputList[0].replaceAll("\\s+","")))
    	  {
    		 count++;
      		break;
    	  }
    	 /* if(list.equalsIgnoreCase(region))
    	  {
    		  count++;
    		  break;
    	  }*/
    	/*  if (!stateJSON.containsKey(key)) {
    		  stateJSON.put(key, new HashSet<String>());
    	    }
    	  stateJSON.get(key).add(value);
    	
    	  
    	  String key_new = value;
    	  String value_new = results.getString(3);
    	    
    	  if (!cityJSON.containsKey(key_new)) {
    		  cityJSON.put(key_new, new HashSet<String>());
    	    }
    	  cityJSON.get(key_new).add(value_new);
    	  */
    	
    }
    
    /*List<Map<String,Set<String>>> temp = new ArrayList<Map<String, Set<String>>>();
       
    temp.add(stateJSON);
    temp.add(cityJSON);*/
     // System.out.println(cityJSON);
   // System.out.println(cityJSON.size());
    conn.close();
    //System.out.println(placesList);
    return count;
  }
}



