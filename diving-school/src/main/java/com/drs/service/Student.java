package com.drs.service;


import org.springframework.stereotype.Service;

import com.drs.pojo.TbStudent;

@Service
public interface Student {
	
	/**
	 * 本方法用于判断验证学员登录
	 * @param phone
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public boolean studentLogin(String phone,String password)throws Exception;

	public TbStudent getStudentByPhone(String phone)throws Exception;

	public void updateInformation(TbStudent student)throws Exception;

	public boolean stuModifyPassword(String phone, String password, String onePassword, String doublePassword)throws Exception;


}
