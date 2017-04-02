package com.packt.webstore.service;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DistributorService {

	  public String checkDistributor(String data){
		  org.json.JSONObject details = new org.json.JSONObject(data);
		  String name= details.getString("distributor");
		  String region= details.getString("region");
		
	    JSONParser parser = new JSONParser();
	    try {
	    	 
	    	String filePath = DistributorService.class.getClassLoader().getResource("").getPath();
	    	//System.out.println (filePath);
	    	
            Object obj = parser.parse(new FileReader(filePath+"/JSON/distributor.json"));
	    	
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject actual_details = (JSONObject)jsonObject.get(name.toLowerCase());
             
            
            JSONArray includeList = (JSONArray)actual_details.get("include");
            JSONArray excludeList = (JSONArray)actual_details.get("exclude");
            JSONArray parent = (JSONArray)actual_details.get("parent");
            
            if(!parent.isEmpty())
            {
            	Iterator p = parent.iterator();
            	
            	while (p.hasNext()) 
                { 
            		String temp_var = (String)p.next();
            		JSONObject parent_details = (JSONObject)jsonObject.get(temp_var.toLowerCase());
            		JSONArray parentexcludeList = (JSONArray)parent_details.get("exclude");
            		
            		for (int i = 0; i < parentexcludeList.size(); i++) {
            			excludeList.add(parentexcludeList.get(i));
            	    }
            		
            		//System.out.println(excludeList);
                }
            	
            }
            
            String[] regionList = region.split("-");
            int regLength=regionList.length;
            
            Iterator i = includeList.iterator(); 
            int countInclude=0;
            int noCheck =0;
            while (i.hasNext()) 
            { 
            	  String temp = (String)i.next();
            	  String tempArray[] = temp.split("-");
            	  
            	  
            	  int actualLength = tempArray.length;
            	 
            	  if(region.replaceAll("\\s+","").equalsIgnoreCase(temp.replaceAll("\\s+","")))
            		  {
            		    countInclude++;
            		   if(regLength==3)
            		      noCheck++;
            		    break;
            		    
            		  }            	  
            	  else if(regionList[regLength-1].replaceAll("\\s+","").equalsIgnoreCase(tempArray[actualLength-1].replaceAll("\\s+","")))
            	  {
            		  if(regLength<=actualLength)
            			 continue;
            		  else 
            		  {
            			  //System.out.println("here");
            			  
            			  if(actualLength==1)
            				  countInclude++;
            			  else if(actualLength==2 && regionList[1].replaceAll("\\s+","").equalsIgnoreCase(tempArray[0].replaceAll("\\s+","")))
            				  countInclude++;
            			  else
            				  continue;        				  
            			  
            		  }
            			  
            	  }
            	 	  
            
            }
            if(noCheck==1)
            	return "yes";
            
        	//System.out.println("count " + countInclude); 
        	
        if(countInclude==1)	
        {	
        	i = excludeList.iterator(); 
            
            
            while (i.hasNext()) 
            { 
            	  String temp = (String)i.next();
            	  String tempArray[] = temp.split("-");
            	  
            	  int actualLength = tempArray.length;
            	  
            	  if(region.replaceAll("\\s+","").equalsIgnoreCase(temp.replaceAll("\\s+","")))
            		  return "no";
        		  else if(regionList[regLength-1].replaceAll("\\s+","").equalsIgnoreCase(tempArray[actualLength-1].replaceAll("\\s+","")) && actualLength>1)
            	 {
        			  //System.out.println("here1");
        			  
            		 if(actualLength==2)
            		 {
            			 //System.out.println("here2");
            			 if(regLength==1 && tempArray[1].replaceAll("\\s+","").equalsIgnoreCase(regionList[0].replaceAll("\\s+","")))
            				 return "no";
            			 /*else if(regLength==2 && temp.equalsIgnoreCase(region))
            				 return "no";*/
            			 else if(regLength==3 && tempArray[1].replaceAll("\\s+","").equalsIgnoreCase(regionList[2].replaceAll("\\s+","")) &&  tempArray[0].replaceAll("\\s+","").equalsIgnoreCase(regionList[1].replaceAll("\\s+","")))
            				 return "no";
            				 
            		 }
            		 else if(actualLength==3)
            		 { 
            			 //System.out.println("here3");
            			 if(regLength==1 && tempArray[2].replaceAll("\\s+","").equalsIgnoreCase(regionList[0].replaceAll("\\s+","")))
            				 return "no";
            			/* else if(regLength==3 && tempArray.equals(regionList))
            				 return "no";*/
            			 else if(regLength==2 && tempArray[2].replaceAll("\\s+","").equalsIgnoreCase(regionList[1].replaceAll("\\s+","")) &&  tempArray[1].replaceAll("\\s+","").equalsIgnoreCase(regionList[0].replaceAll("\\s+","")))
            				 return "no";
            			 
            		 }
            	 }
            	
            	 	  
            
            }
        } 
        
        else
          return "no";
        } catch (Exception e) {
            e.printStackTrace();
        }
		//System.out.println(details.getString("region"));
		  
		  
		  return "yes";
	  }
	  
	  
	  public Set getDistributor(){
		
	    JSONParser parser = new JSONParser();	    
	    try {
	    	 
	    	String filePath = DistributorService.class.getClassLoader().getResource("").getPath();
	    	//System.out.println (filePath);
	    	
            Object obj = parser.parse(new FileReader(filePath+"/JSON/distributor.json"));
 
            JSONObject jsonObject = (JSONObject) obj;
            Set keyset = jsonObject.keySet();
            return keyset;
        } catch (Exception e) {
            e.printStackTrace();
        }
		//System.out.println(details.getString("region"));
		  
		  
		  return null;
	  }
}
