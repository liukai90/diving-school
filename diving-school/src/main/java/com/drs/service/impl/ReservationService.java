package com.drs.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drs.mapper.TbCarMapper;
import com.drs.mapper.TbReservationMapper;
import com.drs.mapper.TbStudentMapper;
import com.drs.mapper.TbTimeMapper;
import com.drs.pojo.OrderDateMessage;
import com.drs.pojo.OrderQueryVo;
import com.drs.pojo.TbCar;
import com.drs.pojo.TbCarExample;
import com.drs.pojo.TbReservation;
import com.drs.pojo.TbReservationExample;
import com.drs.pojo.TbReservationExample.Criteria;
import com.drs.pojo.TbStudent;
import com.drs.pojo.TbStudentExample;
import com.drs.pojo.TbTime;
import com.drs.service.Reservation;
import com.drs.util.DateFormat;

@Service
public class ReservationService implements Reservation {
	
	@Autowired
	private TbStudentMapper tbStudentMapper;
	
	@Autowired
	private TbCarMapper tbCarMapper;
	
	@Autowired
	private TbReservationMapper tbReservationMapper;
	
	@Autowired
	private TbTimeMapper tbTimeMapper;
	
	

	public OrderDateMessage isAlreadyOrder(String phone, Date submitDate) throws Exception {
		
		TbStudent student = null;
		
		if(phone!=null&&phone!=""){
			
			TbStudentExample stuExample=new TbStudentExample();
			
			com.drs.pojo.TbStudentExample.Criteria stuCriteria=stuExample.createCriteria();
			
			stuCriteria.andPhoneEqualTo(phone);
			
			List<TbStudent> students= tbStudentMapper.selectByExample(stuExample);
			
			if(students!=null&&students.size()>0){
				
				student=students.get(0);
			}
		}
		
	   Integer studentId=student.getId();
	   
	   boolean flag=this.checkSelf(studentId, submitDate);
	    
	    String message="";
	    
	    if(flag){

	    	message=DateFormat.dateToString(submitDate)+"可以预约";
	    	
	    	return new OrderDateMessage(message);
	    	
	    }else{

	    	message=DateFormat.dateToString(submitDate)+"您已预约过，暂不可预约";
	    	
	    	return new OrderDateMessage(message);
	    }
	}



	public OrderDateMessage checkOrder(Integer studentId,Integer carId, Date submitDate, Integer timeId) throws Exception {
		
		boolean flag=this.checkSelf(studentId, submitDate);
		
		if(flag){
			
			 flag=this.checkOther(carId, timeId, submitDate);
			 
		}
				
		if(flag){
			
			return new OrderDateMessage("您选择的车辆，日期，时间段，可以预约");
			
		}else{
			
			return new OrderDateMessage("您选择的车辆，日期，时间段，已有人预约");
		}
				
	}



	public boolean submitOrder(Integer studentId, Integer carId, Integer timeId, Date submitDate) throws Exception {

		boolean flag=this.checkSelf(studentId, submitDate);
		
		if(flag==false){
			
			return false;
			
		}
		
		flag=this.checkOther(carId, timeId, submitDate);
		
		if(flag){
			
			TbReservation reservation=new TbReservation();
			
			reservation.setStudentId(studentId);
			
			reservation.setCarId(carId);
			
			reservation.setTimeId(timeId);
			
			reservation.setSubmitDate(submitDate);
			
			reservation.setCreateTime(new Date());
			
			Integer count=tbReservationMapper.insert(reservation);
			
			if(count>0){
				
				return true;
			}
			
		}
		return false;
	}



	public boolean checkSelf(Integer studentId, Date submitDate) throws Exception {

		TbReservationExample resExample=new TbReservationExample();
	    
	    Criteria resCriteria=resExample.createCriteria();
	    
	    if(studentId!=null&&submitDate!=null){
	    	
	    	resCriteria.andStudentIdEqualTo(studentId).andSubmitDateEqualTo(submitDate);
	    }
	    	    	    
	    Integer count=tbReservationMapper.countByExample(resExample);
	    
	    if(count>0){
	    	
		return false;
	    }
	    
	    return true;
	}



	public boolean checkOther(Integer carId, Integer timeId, Date submitDate) throws Exception {

		TbReservationExample example=new TbReservationExample();
		
		Criteria criteria=example.createCriteria();
		
		if(carId!=null&&timeId!=null&&submitDate!=null){
		
		criteria.andCarIdEqualTo(carId).andTimeIdEqualTo(timeId).andSubmitDateEqualTo(submitDate);
		}
		
		Integer count=tbReservationMapper.countByExample(example);
		
		if(count>0){
			
			return false;
		}
		
		return true;
	}



	public OrderQueryVo getOrderInformation(Integer studentId) throws Exception {
		
		TbReservationExample example=new TbReservationExample();
		
		Criteria criteria=example.createCriteria();
		
		criteria.andStudentIdEqualTo(studentId);
		
		List<TbReservation> reservations=tbReservationMapper.selectByExample(example);
		
		List<Integer> ids=new ArrayList<Integer>();
		
		List<TbCar> cars=new ArrayList<TbCar>();
		
		List<TbTime> times=new ArrayList<TbTime>();
		
		List<Date> submitDates=new ArrayList<Date>();
		
		for(TbReservation reservation:reservations){
			
			ids.add(reservation.getId());
			
			submitDates.add(reservation.getSubmitDate());
			
			TbCar car=tbCarMapper.selectByPrimaryKey(reservation.getCarId());
			
			TbTime time=tbTimeMapper.selectByPrimaryKey(reservation.getTimeId());
			
			cars.add(car);
			
			times.add(time);
		}
		
		OrderQueryVo orderQueryVo=new OrderQueryVo();
		
		orderQueryVo.setIds(ids);
		
		orderQueryVo.setCars(cars);
		
		orderQueryVo.setTimes(times);
		
		orderQueryVo.setSubmitDates(submitDates);
		
		return orderQueryVo;
	}



	public void cancelOrder(Integer id) throws Exception {
		
		tbReservationMapper.deleteByPrimaryKey(id);
		
	}



	public OrderQueryVo getReservations(Date submitDate) throws Exception {
		
		TbReservationExample example=new TbReservationExample();
		
		Criteria criteria=example.createCriteria();
		
		criteria.andSubmitDateEqualTo(submitDate);
		
		List<TbReservation> reservations=tbReservationMapper.selectByExample(example);
		
		return this.getOrderQueryVo(reservations);
	}



	public OrderQueryVo getReservations(Date submitDate, Integer carId) throws Exception {

		TbReservationExample example=new TbReservationExample();
		
		Criteria criteria=example.createCriteria();
		
		criteria.andSubmitDateEqualTo(submitDate).andCarIdEqualTo(carId);
		
		List<TbReservation> reservations=tbReservationMapper.selectByExample(example);
		
		return this.getOrderQueryVo(reservations);
	}



	public OrderQueryVo getOrderQueryVo(List<TbReservation> reservations) throws Exception {

		List<Integer> ids=new ArrayList<Integer>();
		
		List<TbStudent> students=new ArrayList<TbStudent>();
		
		List<TbCar> cars=new ArrayList<TbCar>();
		
		List<TbTime> times=new ArrayList<TbTime>();
		
		List<Date> submitDates=new ArrayList<Date>();
		
		for(TbReservation reservation:reservations){
			
			ids.add(reservation.getId());
			
			submitDates.add(reservation.getSubmitDate());
			
			TbStudent student=tbStudentMapper.selectByPrimaryKey(reservation.getStudentId());
			
			TbCar car=tbCarMapper.selectByPrimaryKey(reservation.getCarId());
			
			TbTime time=tbTimeMapper.selectByPrimaryKey(reservation.getTimeId());
			
			students.add(student);
			
			cars.add(car);
			
			times.add(time);
		}
		
		OrderQueryVo orderQueryVo=new OrderQueryVo();
		
		orderQueryVo.setIds(ids);
		
		orderQueryVo.setStudents(students);
		
		orderQueryVo.setCars(cars);
		
		orderQueryVo.setTimes(times);
		
		orderQueryVo.setSubmitDates(submitDates);
		
		return orderQueryVo;

	}
	


}
