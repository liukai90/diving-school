package com.drs.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.drs.pojo.TbCar;

@Service
public interface VehicleManagement {
	
	/**
	 * 本方法查询所有的车辆信息
	 * @return
	 * @throws Exception
	 */
	public List<TbCar> findAllCar()throws Exception;
	
	/**
	 * 本方法根据车牌号查询车辆信息
	 * @param mark
	 * @return
	 * @throws Exception
	 */
	public TbCar findCarByMark(String mark)throws Exception;
	
	/**
	 * 本方法根据车辆id查询车辆信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public TbCar getCarById(Integer id)throws Exception;
	
	/**
	 * 本方法根据车辆id删除车辆信息
	 * @param id
	 * @throws Exception
	 */
	public void deleteCar(Integer id)throws Exception;
	
	/**
	 * 本方法添加车辆信息
	 * @param car
	 * @throws Exception
	 */
	public void insertCar(TbCar car,MultipartFile carPicture)throws Exception;
	
	/**
	 * 本方法提交修改过的车辆信息
	 * @param car
	 * @throws Exception
	 */
	public void updateCar(TbCar car,MultipartFile carPicture)throws Exception;

}
