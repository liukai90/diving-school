package com.drs.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.drs.pojo.DataGridResult;
import com.drs.pojo.TbStudent;
import com.drs.service.TraineesManagement;
import com.drs.service.impl.TraineesManagementService;

@Controller
//@Configuration
//@ComponentScan("com.drs.service")
public class StudentController {
	
	@Autowired
	private TraineesManagement traineesManagementService;
	
	@RequestMapping("/findAllStudent")
	public String findAllStudent()throws Exception{
		
		return "WEB-INF/admin/findAllStudent";
		
	}
	
	@RequestMapping("/pagingFindStudent")
	@ResponseBody
	public DataGridResult pagingFindStudent(HttpServletRequest req,Integer page,Integer pageSize)throws Exception{
		
		req.getSession().setAttribute("pageIndex", page);
		
		return traineesManagementService.findALlStudent(page, pageSize);
		
	}
	
	@RequestMapping(value="/findStudentByName")
	@ResponseBody
	public List<TbStudent> findStudentByName(String name)throws Exception{
		
		System.out.println(name);
		
		return traineesManagementService.findStudentByName(name);
	}
	
	@RequestMapping("/deleteStudentById")
	public String deleteStudentById(Integer id)throws Exception{
		
		traineesManagementService.deleteStudent(id);
		
		return "redirect:findAllStudent.action";
	}
	
	@RequestMapping("/modifyStudentById")
	public ModelAndView modifyStudentById(Integer id)throws Exception{
		
		ModelAndView modelAndView=new ModelAndView();
		
		TbStudent student=traineesManagementService.getStudentById(id);
		
		modelAndView.addObject("student", student);
		
		modelAndView.setViewName("WEB-INF/admin/modifyStudent");
		
		return modelAndView;
		
		
	}
	
	@RequestMapping("/updateStudent")
	public String updateStudent(TbStudent student)throws Exception{
		
		traineesManagementService.updateStudent(student);
		
		return "redirect:findAllStudent.action";
	}
	
	@RequestMapping("/addStudent")
	public String addStudent(TbStudent student)throws Exception{
		
		traineesManagementService.insertStudent(student);
		
		return "redirect:findAllStudent.action";
	}
	
	@RequestMapping("/goAddStudent")
	public String goAddStudent()throws Exception{
		
		return "WEB-INF/admin/addStudent";
	}
}
