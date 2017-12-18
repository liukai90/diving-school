package com.drs.mapper;

import org.springframework.stereotype.Service;

import com.drs.pojo.TbCar;

public interface SupplementCarMapper {
	
	void insertCar(TbCar car);
	
	void updateByPrimaryKeySelective(TbCar car);
	
	

}
