package com.drs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.drs.service.Student;
import com.drs.service.impl.AdministratorService;
import com.drs.service.impl.StudentService;

@Controller
//@Configuration
//@ComponentScan("com.drs.service")
public class LoginController {
	
	@Autowired
	private Student studentService;
	
	@Autowired 
	private AdministratorService administratorService;
	
	@RequestMapping("/login")
	public ModelAndView login(HttpSession session,ModelAndView modelAndView,String phone,String password,String loginType)
			throws Exception{
		
		if(loginType.equals("1")){
			
			if(studentService.studentLogin(phone, password)){
				
				session.setAttribute("phone", phone);
				
				session.setAttribute("loginType", loginType);
				
				modelAndView.addObject("phone", phone);
				
				modelAndView.setViewName("WEB-INF/student/stuMainPage");
				
				return modelAndView;
			}
		}else if(loginType.equals("0")){
			
			if(administratorService.adminLogin(phone, password)){
				
				session.setAttribute("phone", phone);
				
				session.setAttribute("loginType", loginType);
				
				modelAndView.addObject("phone",phone);
				
				modelAndView.setViewName("WEB-INF/admin/adminMainPage");
				
				return modelAndView;
			}
		}
		
		modelAndView.addObject("error", "用户名或密码错误");
		
		modelAndView.setViewName("index");
		
		return modelAndView;
		
	}
	
	@RequestMapping("/exit")
	public String exit(HttpServletRequest req)throws Exception{
		
		req.getSession().invalidate();
		
		return "index";
	}

}
