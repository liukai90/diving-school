package com.drs.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.drs.pojo.TbStudent;

public interface SupplementStudentMapper {
	
	void insertStudent(TbStudent student);
	
	void updateByPrimaryKeySelective(TbStudent student);
	
	List<TbStudent> getStudentByName(String name);
	
	

	

}
