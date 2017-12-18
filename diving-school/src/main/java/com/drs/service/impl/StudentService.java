package com.drs.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drs.mapper.SupplementStudentMapper;
import com.drs.mapper.TbStudentMapper;
import com.drs.pojo.TbAdministrator;
import com.drs.pojo.TbAdministratorExample;
import com.drs.pojo.TbStudent;
import com.drs.pojo.TbStudentExample;
import com.drs.pojo.TbStudentExample.Criteria;
import com.drs.service.Student;

@Service
public class StudentService implements Student {
	
	@Autowired
	private TbStudentMapper tbStudentMapper;
	
	@Autowired
	private SupplementStudentMapper supplementStudentMapper;

	public boolean studentLogin(String phone, String password) throws Exception {
		
		if(phone!=null&&phone!=""){
			
			TbStudentExample example=new TbStudentExample();
			
			Criteria criteria=example.createCriteria();
			
			criteria.andPhoneEqualTo(phone);
			
			List<TbStudent> students= tbStudentMapper.selectByExample(example);
			
			if(students!=null&&students.size()>0&&students.get(0).getPassword().equals(password)){
				
				return true;
			}
			
			
			
		}
		return false;
	}
	
	public TbStudent getStudentByPhone(String phone)throws Exception{
		
		if(phone!=null&&phone!=""){
			
			TbStudentExample example=new TbStudentExample();
			
			Criteria criteria=example.createCriteria();
			
			criteria.andPhoneEqualTo(phone);
			
			List<TbStudent> students= tbStudentMapper.selectByExample(example);
			
			if(students!=null&&students.size()>0){
				
				return students.get(0);
			}
		}	
		return null;
		
	}
	
	public void updateInformation(TbStudent student)throws Exception{
		
		student.setUpdateTime(new Date());
		
		supplementStudentMapper.updateByPrimaryKeySelective(student);
	}
	
	public boolean stuModifyPassword(String phone,String password,String onePassword,String doublePassword)throws Exception{
		
		if(phone!=""&&phone!=null){
			TbStudentExample example=new TbStudentExample();
			
			Criteria criteria=example.createCriteria();
			
			criteria.andPhoneEqualTo(phone);
			
			List<TbStudent> students= tbStudentMapper.selectByExample(example);
			
			if(students!=null&&students.size()>0){
				
				TbStudent student=students.get(0);
				
				if(student.getPassword().equals(password)&&onePassword.equals(doublePassword)){
					
					student.setPassword(onePassword);
					
					tbStudentMapper.updateByPrimaryKeySelective(student);
					
					return true;
				}
			}
		}
		return false;
		
	}
			
		
}
