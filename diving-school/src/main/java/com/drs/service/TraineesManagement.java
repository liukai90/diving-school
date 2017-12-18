package com.drs.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.drs.pojo.DataGridResult;
import com.drs.pojo.TbStudent;
@Service
public interface TraineesManagement {
	
	/**
	 * 本方法用于查询全部的学员信息并且分页
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public DataGridResult findALlStudent(Integer page,Integer pageIndex)throws Exception;
	
	/**
	 * 本方法根据姓名或姓名的一部分来模糊查询学员并且分页
	 * @param name
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<TbStudent> findStudentByName(String name)throws Exception;
	
	/**
	 * 本方法根据学员id来查询学员
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public TbStudent getStudentById(Integer id)throws Exception;
	
	/**
	 * 本方法根据学员id删除学员
	 * @param id
	 * @throws Exception
	 */
	public void deleteStudent(Integer id)throws Exception;
	
	/**
	 * 本方法向数据库中插入一条学员信息
	 * @param student
	 * @throws Exception
	 */
	public void insertStudent(TbStudent student)throws Exception;
	
	/**
	 * 本方法提交修改过的学员信息
	 * @param student
	 * @throws Exception
	 */
	public void updateStudent(TbStudent student)throws Exception;
	
	

}
