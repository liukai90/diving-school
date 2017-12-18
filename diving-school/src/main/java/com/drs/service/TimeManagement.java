package com.drs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.drs.pojo.TbTime;

@Service
public interface TimeManagement {
	
	/**
	 * 本方法查询全部的练车时间信息
	 * @return
	 * @throws Exception
	 */
	public List<TbTime> findAllTime()throws Exception;
	
	/**
	 * 本方法根据id查询时间信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public TbTime getTimeById(Integer id)throws Exception;
	
	/**
	 * 本方法根据id删除时间信息
	 * @param id
	 * @throws Exception
	 */
	public void deleteTime(Integer id)throws Exception;
	
	/**
	 * 本方法提交更改后的时间信息	
	 * @param time
	 * @throws Exception
	 */
	public void updateTime(TbTime time)throws Exception;
	
	/**
	 * 本方法提交时间信息
	 * @param time
	 * @throws Exception
	 */
	public void insertTime(TbTime time)throws Exception;

}
