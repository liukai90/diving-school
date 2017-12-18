package com.drs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.drs.pojo.TbCar;
import com.drs.service.VehicleManagement;
import com.drs.service.impl.VehicleManagementService;

@Controller
//@Configuration
//@ComponentScan("com.drs.service")
public class CarController {
	
	@Autowired
	private VehicleManagement vehicleManagementService;
	
	@RequestMapping("/findAllCarPage")
	public String findAllCarPage()throws Exception{
		
		return "WEB-INF/admin/findAllCar";
	}
	
	@RequestMapping("/findAllCar")
	@ResponseBody
	public List<TbCar> findAllCar()throws Exception{
		
		return vehicleManagementService.findAllCar();
	}
	
	@RequestMapping("/findCarByMark")
	@ResponseBody
	public TbCar findCarByMark(String mark)throws Exception{
		
		return vehicleManagementService.findCarByMark(mark);
		
	}
	
	@RequestMapping("/goAddCar")
	public String goAddCar()throws Exception{
		
		return "WEB-INF/admin/addCar";
		
	}
	
	@RequestMapping("/addCar")
	public String addCar(TbCar car,MultipartFile car_picture)throws Exception{
		
		vehicleManagementService.insertCar(car,car_picture);
		
		return "redirect:findAllCarPage.action";
	}
	
	@RequestMapping("/getCarDetails")
	public ModelAndView getCarDetails(Integer id)throws Exception{
		
		ModelAndView modelAndView=new ModelAndView();
		
		TbCar car=vehicleManagementService.getCarById(id);
		
		modelAndView.addObject("car",car);	
		
		modelAndView.setViewName("WEB-INF/admin/carDetails");
		
		return modelAndView;
		
	}
	
	@RequestMapping("/goModifyCar")
	public ModelAndView goModifyCar(Integer id)throws Exception{
		
		ModelAndView modelAndView=new ModelAndView();
		
		TbCar car=vehicleManagementService.getCarById(id);
		
		modelAndView.addObject("car", car);
		
		modelAndView.setViewName("WEB-INF/admin/modifyCar");
		
		return modelAndView;
		
	}
	
	@RequestMapping("/modifyCar")
	public String modifyCar(TbCar car,MultipartFile car_picture)throws Exception{
		
		vehicleManagementService.updateCar(car,car_picture);
		
	    return "redirect:findAllCarPage.action";
	}
	@RequestMapping("/deleteCar")
	public String deleteCar(Integer id)throws Exception{
		
		vehicleManagementService.deleteCar(id);
		
		return "redirect:findAllCarPage.action";
	}
}
