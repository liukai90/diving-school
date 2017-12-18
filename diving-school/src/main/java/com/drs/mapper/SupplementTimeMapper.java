package com.drs.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.drs.pojo.TbTime;

public interface SupplementTimeMapper {
	
	void insertTime(TbTime time);
	
	List<TbTime> selectAllTime();
}
