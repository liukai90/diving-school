package com.drs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drs.mapper.SupplementTimeMapper;
import com.drs.mapper.TbTimeMapper;
import com.drs.pojo.TbTime;
import com.drs.pojo.TbTimeExample;
import com.drs.pojo.TbTimeExample.Criteria;
import com.drs.service.TimeManagement;

@Service
public class TimeManagementService implements TimeManagement {
	
	@Autowired
	private TbTimeMapper tbTimeMapper;
	
	@Autowired
	private SupplementTimeMapper supplementTimeMapper;

	public List<TbTime> findAllTime() throws Exception {
		
		return supplementTimeMapper.selectAllTime();
		
	}

	public TbTime getTimeById(Integer id) throws Exception {
		
		TbTimeExample example=new TbTimeExample();
		
		Criteria criteria=example.createCriteria();
		
		criteria.andIdEqualTo(id);
		
		List<TbTime> list=tbTimeMapper.selectByExample(example);
		
		if(list.size()<=1){
			
			return list.get(0);
			
		}
		
		return null;
	}

	public void deleteTime(Integer id) throws Exception {
		
		TbTimeExample example=new TbTimeExample();
		
		Criteria criteria=example.createCriteria();
		
		criteria.andIdEqualTo(id);
		
		tbTimeMapper.deleteByExample(example);

	}

	public void updateTime(TbTime time) throws Exception {
		
		tbTimeMapper.updateByPrimaryKeySelective(time);

	}

	public void insertTime(TbTime time) throws Exception {
		
		supplementTimeMapper.insertTime(time);

	}

}
