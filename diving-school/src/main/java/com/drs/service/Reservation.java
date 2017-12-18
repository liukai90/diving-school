package com.drs.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.drs.pojo.OrderDateMessage;
import com.drs.pojo.OrderQueryVo;
import com.drs.pojo.TbCar;
import com.drs.pojo.TbReservation;
import com.drs.pojo.TbStudent;

@Service
public interface Reservation {
	
	/**
	 * 本方法用于判断用户选择的日期是不是第一次预约
	 * @param phone
	 * @param submitDate
	 * @return
	 * @throws Exception
	 */
	public OrderDateMessage isAlreadyOrder(String phone,Date submitDate)throws Exception;
	
	/**
	 * 本方法用于检测用户选择的信息是否有人已预约
	 * @param carId
	 * @param submitDate
	 * @param timeId
	 * @return
	 * @throws Exception
	 */
	public OrderDateMessage checkOrder(Integer studentId,Integer carId,Date submitDate,Integer timeId)throws Exception;
	
	/**
	 * 本方法用于判用户选择的日期有没有预约过
	 * @param studentId
	 * @param submitDate
	 * @return
	 * @throws Exception
	 */
	public boolean checkSelf(Integer studentId,Date submitDate)throws Exception;
	
	/**
	 * 本方法用于判断这个汽车，日期，时间段别人有没有占用
	 * @param carId
	 * @param timeId
	 * @param submitDate
	 * @return
	 * @throws Exception
	 */
	public boolean checkOther(Integer carId,Integer timeId,Date submitDate)throws Exception;
	
	/**
	 * 本方法用于保存预约的信息
	 * @param studentId
	 * @param carId
	 * @param timeId
	 * @param submitDate
	 * @return
	 * @throws Exception
	 */
	public boolean submitOrder (Integer studentId,Integer carId,Integer timeId,Date submitDate)throws Exception; 
	
	/**
	 * 本方法用于获取自己的预约信息
	 * @param studentId
	 * @return
	 * @throws Exception
	 */
	public OrderQueryVo getOrderInformation(Integer studentId)throws Exception;
	
	/**
	 * 本方法根据id取消预约
	 * @param id
	 * @throws Exception
	 */
	public void cancelOrder(Integer id)throws Exception;
	
	/**
	 * 本方法根据预约日期查询预约信息
	 * @param submitDate
	 * @return
	 * @throws Exception
	 */
	public OrderQueryVo getReservations(Date submitDate)throws Exception;
	
	/**
	 * 本方法根据日期和汽车Id获取预约信息
	 * @param submitDate
	 * @param carId
	 * @return
	 * @throws Exception
	 */
	public OrderQueryVo getReservations(Date submitDate,Integer carId)throws Exception;
	
	/**
	 * 本方法用于把返回预约信息包装成orderQueryVo对象
	 * @param reservations
	 * @return
	 * @throws Exception
	 */
	public OrderQueryVo getOrderQueryVo(List<TbReservation> reservations)throws Exception;
}
