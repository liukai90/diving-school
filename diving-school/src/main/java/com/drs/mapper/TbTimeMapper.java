package com.drs.mapper;

import com.drs.pojo.TbTime;
import com.drs.pojo.TbTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbTimeMapper {
    int countByExample(TbTimeExample example);

    int deleteByExample(TbTimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbTime record);

    int insertSelective(TbTime record);

    List<TbTime> selectByExample(TbTimeExample example);

    TbTime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbTime record, @Param("example") TbTimeExample example);

    int updateByExample(@Param("record") TbTime record, @Param("example") TbTimeExample example);

    int updateByPrimaryKeySelective(TbTime record);

    int updateByPrimaryKey(TbTime record);
}