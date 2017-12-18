package com.drs.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@Configuration
//@ComponentScan("com.drs.service")
public class MainPageController {
	
	@RequestMapping("/stuMainPage")
	public String stuMainPage()throws Exception{
		
		return "WEB-INF/student/stuMainPage";
		
	}
	
	@RequestMapping("/adminMainPage")
	public String adminMainPage()throws Exception{

		return "WEB-INF/admin/adminMainPage";
		
	}

}
