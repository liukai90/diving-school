package com.drs.service;


import org.springframework.stereotype.Service;

import com.drs.pojo.TbAdministrator;

@Service
public interface Administrator {
	
	/**
	 * 本方法根据手机号（同时也是用户名）查询管理员信息
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	public boolean adminLogin(String phone,String password)throws Exception;
	
	/**
	 * 本方法根据手机号获得管理员个人信息
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	public TbAdministrator getAdminByPhone(String phone)throws Exception;
	
	/**
	 * 本方法用于更新管理员个人信息
	 * @param administrator
	 * @throws Exception
	 */
	public void updateAdminById(TbAdministrator administrator)throws Exception;
	
	/**
	 * 本方法用于修改个人密码
	 * @param phone
	 * @param password
	 * @param onePassword
	 * @param doublePassword
	 * @return
	 * @throws Exception
	 */
	public boolean modifyPassword(String phone,String password,String onePassword,String doublePassword)throws Exception;

}
