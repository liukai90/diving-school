package com.drs.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.drs.mapper.SupplementCarMapper;
import com.drs.mapper.TbCarMapper;
import com.drs.pojo.TbCar;
import com.drs.pojo.TbCarExample;
import com.drs.pojo.TbCarExample.Criteria;
import com.drs.service.VehicleManagement;
import com.drs.util.FileUpload;

@Service
public class VehicleManagementService implements VehicleManagement {
	
	@Autowired
	private TbCarMapper tbCarMapper;
	
	@Autowired
	private SupplementCarMapper supplementCarMapper;

	public List<TbCar> findAllCar() throws Exception {
		
		TbCarExample example=new TbCarExample();
		
		return tbCarMapper.selectByExample(example);
		
	}

	public TbCar findCarByMark(String mark) throws Exception {
		
		TbCarExample example=new TbCarExample();
		
		Criteria criteria=example.createCriteria();
		
		criteria.andMarkEqualTo(mark);
		
		List<TbCar> list=tbCarMapper.selectByExample(example);
		
		if(list.size()<=1){
			
			return list.get(0);
			
		}
		return null;
	}

	public TbCar getCarById(Integer id) throws Exception {
		
		TbCarExample example=new TbCarExample();
		
		Criteria criteria=example.createCriteria();
		
		criteria.andIdEqualTo(id);
		
		List<TbCar> list=tbCarMapper.selectByExample(example);
		
		if(list.size()<=1){
			
			return list.get(0);
		}
		
		return null;
	}

	public void deleteCar(Integer id) throws Exception {
		
		TbCarExample example=new TbCarExample();
		
		Criteria criteria=example.createCriteria();
		
		criteria.andIdEqualTo(id);
		
		tbCarMapper.deleteByExample(example);

	}

	public void insertCar(TbCar car,MultipartFile carPicture) throws Exception {
		
		String picturePath=FileUpload.pictureUpload(carPicture, "F:\\picture\\");
		
		car.setCarPicture(picturePath);
		
		car.setCreateTime(new Date());
		
		car.setUpdateTime(new Date());
		
		supplementCarMapper.insertCar(car);

	}

	public void updateCar(TbCar car,MultipartFile carPicture) throws Exception {
		
		String picturePath=FileUpload.pictureUpload(carPicture, "F:\\picture\\");
		
		car.setCarPicture(picturePath);
		
		car.setUpdateTime(new Date());
		
		supplementCarMapper.updateByPrimaryKeySelective(car);

	}

}
