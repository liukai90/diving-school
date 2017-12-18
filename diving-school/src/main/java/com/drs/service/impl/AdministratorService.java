package com.drs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drs.mapper.TbAdministratorMapper;
import com.drs.pojo.TbAdministrator;
import com.drs.pojo.TbAdministratorExample;
import com.drs.pojo.TbAdministratorExample.Criteria;
import com.drs.service.Administrator;

@Service
public class AdministratorService implements Administrator {
	
	@Autowired
	private TbAdministratorMapper tbAdministratorMapper;

	public boolean adminLogin(String phone,String password) throws Exception {
		
		if(phone!=""&&phone!=null){
			TbAdministratorExample example=new TbAdministratorExample();
			
			Criteria criteria=example.createCriteria();
			
			criteria.andPhoneEqualTo(phone);
			
			List<TbAdministrator> administrators= tbAdministratorMapper.selectByExample(example);
			
			if(administrators!=null&&administrators.size()>0&&administrators.get(0).getPassword().equals(password)){
				
				return true;
			}
		}
		
		return false;
		
	}
	
	public TbAdministrator getAdminByPhone(String phone)throws Exception{
		
		if(phone!=""&&phone!=null){
			TbAdministratorExample example=new TbAdministratorExample();
			
			Criteria criteria=example.createCriteria();
			
			criteria.andPhoneEqualTo(phone);
			
			List<TbAdministrator> administrators= tbAdministratorMapper.selectByExample(example);
			
			if(administrators!=null&&administrators.size()>0){
				
				return administrators.get(0);
				
			}
			
		}
		return null;
	}

	public void updateAdminById(TbAdministrator administrator) throws Exception {
		
		tbAdministratorMapper.updateByPrimaryKeySelective(administrator);
		
	}
	
	public boolean modifyPassword(String phone,String password,String onePassword,String doublePassword)throws Exception{
		
		if(phone!=""&&phone!=null){
			TbAdministratorExample example=new TbAdministratorExample();
			
			Criteria criteria=example.createCriteria();
			
			criteria.andPhoneEqualTo(phone);
			
			List<TbAdministrator> administrators= tbAdministratorMapper.selectByExample(example);
			
			if(administrators!=null&&administrators.size()>0){
				
				TbAdministrator administrator=administrators.get(0);
				
				if(administrator.getPassword().equals(password)&&onePassword.equals(doublePassword)){
					
					administrator.setPassword(onePassword);
					
					tbAdministratorMapper.updateByPrimaryKeySelective(administrator);
					
					return true;
				}
			}
		}
		return false;
		
	}
	


}
