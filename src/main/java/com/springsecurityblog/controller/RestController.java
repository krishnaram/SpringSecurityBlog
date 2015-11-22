package com.springsecurityblog.controller;

/**
 * Author: Ramakrishna Panni
 * Class: RestController
 * Details: Created to control all request coming to application
 */


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	
	 //Just begining of Project to check whether set up is working
	@RequestMapping(value = "/hello/{name}", method=RequestMethod.GET)
	public String renderHello(@PathVariable String name,Model model)
	{
		model.addAttribute(name);
		return "Hello";
		
	}
	
	//Home page request by after Login
	@RequestMapping(value = { "/homePage"}, method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("homePage");
        return model;
    }
	
	//Login Failure Error handling and Logout handling 
    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
    @RequestParam(value = "logout", required = false) String logout) {
         
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid Credentials provided.");
        }
 
        if (logout != null) {
            model.addObject("message", "Logged out  successfully.");
        }
 
        model.setViewName("loginPage");
        return model;
    }
}