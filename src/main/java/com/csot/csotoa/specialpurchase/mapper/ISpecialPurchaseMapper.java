package com.csot.csotoa.specialpurchase.mapper;

import com.csot.csotoa.prcategory.bean.CsotPrMain;
import com.csot.csotoa.specialpurchase.bean.SpecialPurchase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ISpecialPurchaseMapper {
    public SpecialPurchase getSpicialPurchase(@Param("fdId")String fdId);
}
