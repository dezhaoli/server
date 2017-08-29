package com.weipai.mapper;

import com.weipai.model.Techargerecord;

public interface TechargerecordMapper {
    int deleteByPrimaryKey(Integer id);

    int save(Techargerecord record);

    int saveSelective(Techargerecord record);

    Techargerecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Techargerecord record);

    int updateByPrimaryKey(Techargerecord record);
}