package com.drs.mapper;

import com.drs.pojo.TbReservation;
import com.drs.pojo.TbReservationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbReservationMapper {
    int countByExample(TbReservationExample example);

    int deleteByExample(TbReservationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbReservation record);

    int insertSelective(TbReservation record);

    List<TbReservation> selectByExample(TbReservationExample example);

    TbReservation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbReservation record, @Param("example") TbReservationExample example);

    int updateByExample(@Param("record") TbReservation record, @Param("example") TbReservationExample example);

    int updateByPrimaryKeySelective(TbReservation record);

    int updateByPrimaryKey(TbReservation record);
}