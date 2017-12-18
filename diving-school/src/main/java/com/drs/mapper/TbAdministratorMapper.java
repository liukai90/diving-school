package com.drs.mapper;

import com.drs.pojo.TbAdministrator;
import com.drs.pojo.TbAdministratorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAdministratorMapper {
    int countByExample(TbAdministratorExample example);

    int deleteByExample(TbAdministratorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbAdministrator record);

    int insertSelective(TbAdministrator record);

    List<TbAdministrator> selectByExample(TbAdministratorExample example);

    TbAdministrator selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbAdministrator record, @Param("example") TbAdministratorExample example);

    int updateByExample(@Param("record") TbAdministrator record, @Param("example") TbAdministratorExample example);

    int updateByPrimaryKeySelective(TbAdministrator record);

    int updateByPrimaryKey(TbAdministrator record);
}