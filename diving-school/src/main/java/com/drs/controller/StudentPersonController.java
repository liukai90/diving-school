package com.drs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.drs.pojo.TbStudent;
import com.drs.service.Student;
import com.drs.service.impl.StudentService;

@Controller
//@Configuration
//@ComponentScan("com.drs.service")
public class StudentPersonController {
	
	@Autowired
	private Student studentService;
	
	@RequestMapping("/goStuModifyPersonInformation")
	public ModelAndView gostuModifyPersonInformation(HttpServletRequest req)throws Exception{
		
		ModelAndView modelAndView=new ModelAndView();
		
		String phone=(String) req.getSession().getAttribute("phone");
		
		TbStudent student=studentService.getStudentByPhone(phone);
		
		modelAndView.addObject("student", student).setViewName("WEB-INF/student/stuPersonInformation");
		
		return modelAndView;
		
	}
	
	@RequestMapping("/submitStuInformation")
	public String submitStuInformation(TbStudent student)throws Exception{
		
		studentService.updateInformation(student);
		
		return "redirect:stuMainPage.action";
	}
	
	@RequestMapping("/stuModifyPassword")
	public String stuModifyPassword()throws Exception{
		
		return "WEB-INF/student/stuModifyPassword";
	}
	
	@RequestMapping("/stuCheckPassword")
	@ResponseBody
	public boolean checkPassword(HttpServletRequest req,String password)throws Exception{
		
		String phone=(String) req.getSession().getAttribute("phone");
		
		return studentService.studentLogin(phone, password);
		
	}
	
	@RequestMapping("/stuSubmitPassword")
	public ModelAndView stuSubmitPassword(HttpServletRequest req,
			String password,String onePassword,String doublePassword)throws Exception{
		
		ModelAndView modelAndView=new ModelAndView();
		
		String phone=(String) req.getSession().getAttribute("phone");
		
		boolean state=studentService.stuModifyPassword(phone,password, onePassword, doublePassword);
		
		if(state){
			
			req.getSession().invalidate();
			
			modelAndView.addObject("success","修改密码成功，请重新登录！").setViewName("index");
			
		}else{
			
			modelAndView.addObject("defeat","修改密码失败！").setViewName("WEB-INF/student/stuModifyPassword");
		}
		
		return modelAndView;
	}
	
	@RequestMapping("/orderStudyCar")
	public ModelAndView orderStudyCar(HttpServletRequest req)throws Exception{
		
		ModelAndView modelAndView=new ModelAndView();
		
		String phone=(String) req.getSession().getAttribute("phone");
		
		TbStudent student=studentService.getStudentByPhone(phone);
		
		modelAndView.addObject("student",student).setViewName("WEB-INF/student/studyCar");
		
		return modelAndView;
	}
	
}
