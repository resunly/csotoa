package com.csot.csotoa.prcategory.mapper;

import com.csot.csotoa.prcategory.bean.CsotPrMain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IPrCategoryMapper {
    public CsotPrMain getCsotPrMain(@Param("fdId")String fdId);
}
