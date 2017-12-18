package com.drs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.drs.pojo.TbTime;
import com.drs.service.TimeManagement;

@Controller
//@Configuration
//@ComponentScan("com.drs.service")
public class TimeController {
	
	@Autowired
	private TimeManagement timeManagementService;
	
	@RequestMapping("/findAllTimePage")
	public String findAllTimePage()throws Exception{
		
		return "WEB-INF/admin/findAllTime";
		
	}
	
	@RequestMapping("/findAllTime")
	@ResponseBody
	public List<TbTime> findAllTime()throws Exception{
		
		return timeManagementService.findAllTime();
		
	}
	
	@RequestMapping("/goAddTime")
	public String goAddTime()throws Exception{
		
		return "WEB-INF/admin/addTime";
		
	}
	
	@RequestMapping(value="/addTime",method = { RequestMethod.POST,RequestMethod.GET })
	public String addTime( TbTime time)throws Exception{
		
		
		timeManagementService.insertTime(time);
		
		return "redirect:findAllTimePage.action";
	}
	
	@RequestMapping("/deleteTime")
	public String deleteTime(Integer id)throws Exception{
		
		timeManagementService.deleteTime(id);
		
		return "redirect:findAllTimePage.action";
	}
	
	@RequestMapping("/goModifyTime")
	public ModelAndView goModifyTime(Integer id)throws Exception{
		
		ModelAndView modelAndView=new ModelAndView();
		
		TbTime time=timeManagementService.getTimeById(id);
		
		modelAndView.addObject("time", time).setViewName("WEB-INF/admin/modifyTime");
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="/modifyTime",method={RequestMethod.POST})
	public String modifyTime(TbTime time)throws Exception{
		
		timeManagementService.updateTime(time);
		
		return "redirect:findAllTimePage.action";
	}

}
