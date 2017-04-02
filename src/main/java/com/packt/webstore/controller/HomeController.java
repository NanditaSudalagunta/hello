package com.packt.webstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.packt.webstore.service.CSVJDBCService;
import com.packt.webstore.service.DistributorService;
import com.packt.webstore.service.writeToJSON;



@Controller
//@Scope("session")

public class HomeController {
	CSVJDBCService csvQuery =  new CSVJDBCService();
	DistributorService distributorCheck = new DistributorService();
	writeToJSON write = new writeToJSON();
@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
public String welcome(ModelMap modelMap,HttpSession session) 
   {
      
	 /*try {
		 List<Map<String, Set<String>>> combineJson = csvQuery.processCSV();
		 //session.setAttribute("state", combineJson.get(0));
		 //session.setAttribute("city", combineJson.get(1));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
       return "welcome";
    }


@RequestMapping(value = "/link", method = RequestMethod.POST)
@ResponseBody
public String commentPost(ModelMap map,@RequestBody String data) throws Exception{
  //System.out.println("controller "+data);
   //email.sendComment(data);
	
		int count = csvQuery.processCSV(data);
	if(count==0)
		return "invalid";
	else
	    return distributorCheck.checkDistributor(data);
};

@RequestMapping(value = "/add", method = RequestMethod.POST)
@ResponseBody
public String addCheck(ModelMap map,@RequestBody String data) {
  //System.out.println("controller "+data);
   //email.sendComment(data);
  String output = write.addDistributor(data);
	//return distributorCheck.checkDistributor(data);
	return "success";
};


@RequestMapping(value = { "/success" }, method = RequestMethod.GET)
public String thanku(Model model) 
   {
      /* model.addAttribute("greeting", "Welcome to Web Store!");
       model.addAttribute("tagline", "The one and only amazing webstore");*/
       return "thanku";
    }

@RequestMapping("/home")
public String welcome1(Model model,HttpSession session) 
   {
	 //  Map<String, Set<String>> stateJson = (Map<String, Set<String>>)session.getAttribute("state");
	   //Map<String, Set<String>> cityJson = (Map<String, Set<String>>)session.getAttribute("city");
	   //System.out.println("hey "+stateJson.get("India"));
       /*model.addAttribute("greeting", "Welcome to Web Store!");
       model.addAttribute("tagline", "The one and only amazing webstore");*/
	 try {
		
		Set list = distributorCheck.getDistributor();
		//System.out.println(dropdownList);
		model.addAttribute("dropdownList",list);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       return "menu";
    }

@RequestMapping(value = { "/addDistributor" }, method = RequestMethod.GET)
public String admin(Model model) 
   {
      /* model.addAttribute("greeting", "Welcome to Web Store!");
       model.addAttribute("tagline", "The one and only amazing webstore");*/
       return "admin";
    }



/*@RequestMapping(value = "/test", method = RequestMethod.GET)
@ResponseBody
public Object  menu(Model map,@RequestParam("data") String valueOne,@RequestParam("phint") String phint, @RequestParam("callback") String jsonpCallback) {
	System.out.println("hey..."+phint);
	
	System.out.println("callback..."+jsonpCallback);
	
	return order.getData(phint,jsonpCallback);
	//return jsonpCallback + "(" + value + ")";
}


@RequestMapping("/menu")
public String welcome1(Model model) 
   {
	 
       model.addAttribute("greeting", "Welcome to Web Store!");
       model.addAttribute("tagline", "The one and only amazing webstore");
       return "welcome";
    }

@RequestMapping("/home")
public String welcome2(Model model) 
   {
       model.addAttribute("greeting", "Welcome to Web Store!");
       model.addAttribute("tagline", "The one and only amazing webstore");
       return "home";
    }

@RequestMapping(value = "/link")
@ResponseBody
public String  link(Model model,@RequestParam("data") String valueOne) {
	System.out.println("hey...");	
	String status = order.getStatus(valueOne);
	//return jsonpCallback + "(" + value + ")";
	model.addAttribute("greeting",status);
	return "check";
}
*/


 }