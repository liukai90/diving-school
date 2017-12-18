package com.drs.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drs.pojo.OrderDateMessage;
import com.drs.pojo.OrderQueryVo;
import com.drs.pojo.TbCar;
import com.drs.pojo.TbReservationExample;
import com.drs.pojo.TbReservationExample.Criteria;
import com.drs.pojo.TbStudent;
import com.drs.pojo.TbTime;
import com.drs.service.Reservation;
import com.drs.service.Student;
import com.drs.service.TimeManagement;
import com.drs.service.VehicleManagement;
import com.drs.service.impl.StudentService;
import com.drs.service.impl.TimeManagementService;
import com.drs.service.impl.VehicleManagementService;

@Controller
//@Configuration
//@ComponentScan("com.drs.service")
public class ReservationController {
	
	@Autowired
	private Reservation reservationService;
	
	@Autowired 
	private TimeManagement timeManagementService;
	
	@Autowired
	private VehicleManagement vehicleManagementService;
	
	@Autowired
	private Student studentService;
	
	@RequestMapping("/getAllMark")
	@ResponseBody
	public List<TbCar> getAllMark()throws Exception{
		
		return vehicleManagementService.findAllCar();
	}
	
	@RequestMapping("/getAllTime")
	@ResponseBody
	public List<TbTime> getAllTime()throws Exception{
		
		return timeManagementService.findAllTime();
	}
	
	@RequestMapping("/isHaveOrder")
	@ResponseBody
	public OrderDateMessage isHaveOrder(HttpServletRequest req,Date submitDate)throws Exception{
		
		String phone=(String) req.getSession().getAttribute("phone");
		
		return reservationService.isAlreadyOrder(phone, submitDate);
		
		
	}
	
	@RequestMapping("/checkCar")
	@ResponseBody
	public TbCar checkCar(Integer id)throws Exception{
		
		return vehicleManagementService.getCarById(id);
	}
	
	@RequestMapping(value="/checkOrder",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public OrderDateMessage checkOrder(HttpServletRequest req,Integer carId,Date submitDate,Integer timeId)throws Exception{
		

		String phone=(String) req.getSession().getAttribute("phone");
		
		Integer studentId=studentService.getStudentByPhone(phone).getId();
			
		return reservationService.checkOrder(studentId,carId, submitDate, timeId);
		
	}
	
	@RequestMapping("/submitOrder")
	public String submitDate(HttpServletRequest req,Integer carId,Date submitDate,Integer timeId)
			throws Exception{
		
		ModelMap modelMap=new ModelMap();
		
		String phone=(String) req.getSession().getAttribute("phone");
		
		Integer studentId=studentService.getStudentByPhone(phone).getId();
		
		boolean flag=reservationService.submitOrder(studentId, carId, timeId, submitDate);
		
		if(flag){
		
		return "redirect:stuMainPage.action";
		
		}else{
			modelMap.addAttribute("orderInformation", "预约失败");
			
			return "WEB-INF/student/studyCar";
		}
		
		
	}
	
	@RequestMapping("/myOrderPage")
	public String myOrderPage()throws Exception{
		
		return "WEB-INF/student/myOrder";
		
	}
	
	@RequestMapping("/myOrderInformation")
	@ResponseBody
	public OrderQueryVo myOrderInformation(HttpServletRequest req)throws Exception{
		
		String phone=(String) req.getSession().getAttribute("phone");
		
		Integer studentId=studentService.getStudentByPhone(phone).getId();
		
		return reservationService.getOrderInformation(studentId);
		
	}
	
	@RequestMapping("/cancelOrder")
	public String cancelOrder(Integer id)throws Exception{
		
		reservationService.cancelOrder(id);
			
			return "redirect:myOrderPage.action";
	
	}
	
	@RequestMapping("/bookingManagement")
	public String bookingManagement()throws Exception{
		
		return "WEB-INF/admin/bookingManagement";
		
	}
	
	@RequestMapping("/findOrderBySubmitDate")
	@ResponseBody
	public OrderQueryVo findOrderBySubmitDate(Date submitDate)throws Exception{
		
		return reservationService.getReservations(submitDate);
	}
	
	@RequestMapping("/findOrderByCar")
	@ResponseBody
	public OrderQueryVo findOrderByCar(Date submitDate,Integer carId)throws Exception{
		
		return reservationService.getReservations(submitDate, carId);
	}

}
