package com.csot.csotoa.pocategory.mapper;

import com.csot.csotoa.pocategory.bean.CsotPoMain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IPoCategoryMapper {
    public CsotPoMain getCsotPoMain(@Param("fdId")String fdId);
}
