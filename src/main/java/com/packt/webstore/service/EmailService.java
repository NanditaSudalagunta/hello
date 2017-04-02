package com.packt.webstore.service;

import org.json.JSONObject;

public class EmailService {
	public String sendComment(String comment) {
		try {
			//String[] comments= comment.split("//s");
			  Object comments =  comment;
			  
			//EmailAgent email = new EmailAgent("sudalagunta.n@listertechnologies.com",comments.getString("comment"),comments.getString("title"));
			//email.sendMail();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return "success";		
	}
	
}
