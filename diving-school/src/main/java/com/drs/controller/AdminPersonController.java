package com.drs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.drs.pojo.TbAdministrator;
import com.drs.service.Administrator;
import com.drs.service.impl.AdministratorService;

@Controller
//@Configuration
//@ComponentScan("com.drs.service")
public class AdminPersonController {
	
	@Autowired
	private Administrator administratorService;
	
	@RequestMapping("/getPersonInformation")
	public 	ModelAndView getPersonInformation(HttpServletRequest req)throws Exception{
		
		ModelAndView modelAndView=new ModelAndView();
		
		String phone=(String) req.getSession().getAttribute("phone");
		
		TbAdministrator administrator=administratorService.getAdminByPhone(phone);
		
		modelAndView.addObject("administrator", administrator).setViewName("WEB-INF/admin/personInformation");
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="/submitInformation",method={RequestMethod.POST})
	public String submitInformation(TbAdministrator administrator)throws Exception{
		
		administratorService.updateAdminById(administrator);
		
		return "redirect:adminMainPage.action";
		
	}
	
	@RequestMapping("/goModifyPassword")
	public String goModifyPassword()throws Exception{
		
		return "WEB-INF/admin/modifyPassword";
	}
	
	@RequestMapping("/checkPassword")
	@ResponseBody
	public boolean checkPassword(HttpServletRequest req,String password)throws Exception{
		
		String phone=(String) req.getSession().getAttribute("phone");
		
		return administratorService.adminLogin(phone, password);
	}
	
	@RequestMapping("/submitPassword")
	public ModelAndView submitPassword(HttpServletRequest req,String oldPassword,String onePassword,String doublePassword)
			throws Exception{
		
		ModelAndView modelAndView=new ModelAndView();
		
		String phone=(String) req.getSession().getAttribute("phone");
		
		boolean state=administratorService.modifyPassword(phone, oldPassword, onePassword, doublePassword);
		
		if(state){
			
			req.getSession().invalidate();
			
			modelAndView.addObject("success","修改密码成功，请重新登录！").setViewName("index");
			
		}else{
			
			modelAndView.addObject("defeat","修改密码失败！").setViewName("WEB-INF/admin/modifyPassword");
		}
		
		return modelAndView;
	}

}
