package com.drs.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drs.mapper.SupplementStudentMapper;
import com.drs.mapper.TbStudentMapper;
import com.drs.pojo.DataGridResult;
import com.drs.pojo.TbStudent;
import com.drs.pojo.TbStudentExample;
import com.drs.pojo.TbStudentExample.Criteria;
import com.drs.service.TraineesManagement;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TraineesManagementService implements TraineesManagement{

	@Autowired
	private TbStudentMapper tbStudentMapper;
	
	@Autowired
	private SupplementStudentMapper supplementStudentMapper;
	
	public DataGridResult findALlStudent(Integer page, Integer pageSize) throws Exception {
		
		TbStudentExample example=new TbStudentExample();
		
		PageHelper.startPage(page, pageSize);
		
		List<TbStudent> list=tbStudentMapper.selectByExample(example);
		
		DataGridResult result=new DataGridResult();
		
		result.setRows(list);
		
		PageInfo<TbStudent> pageInfo=new PageInfo<TbStudent>(list);
		
		result.setTotal(pageInfo.getTotal());
		
		return result;
		
	}

	public List<TbStudent> findStudentByName(String name) 
			throws Exception {
		
		TbStudentExample example=new TbStudentExample();
		
		Criteria criteria=example.createCriteria();
		
		criteria.andNameEqualTo(name);
		
		List<TbStudent> students=tbStudentMapper.selectByExample(example);
		
		return students;
		
		
	}

	public TbStudent getStudentById(Integer id) throws Exception {
		
		return tbStudentMapper.selectByPrimaryKey(id);
		
	}

	public void deleteStudent(Integer id) throws Exception {
		
		tbStudentMapper.deleteByPrimaryKey(id);
		
	}

	public void insertStudent(TbStudent student) throws Exception {
		
		String startPassword=student.getIdcard().substring(student.getIdcard().length()-4, student.getIdcard().length())
				+student.getPhone().substring(student.getPhone().length()-4, student.getPhone().length());
		
		student.setPassword(startPassword);
		student.setCreateTime(new Date());
		student.setUpdateTime(new Date());
		supplementStudentMapper.insertStudent(student);
		
	}

	public void updateStudent(TbStudent student) throws Exception {
		
		supplementStudentMapper.updateByPrimaryKeySelective(student);
		
	}

}
