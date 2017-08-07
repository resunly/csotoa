package com.csot.csotoa.managepay.mapper;

import com.csot.csotoa.managepay.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ICsotManagePayMapper {
    public CsotManagePayMain getCostManagePayMain(@Param("fdId")String fdId);

    public List<CsotManageFeeDetail> getDetailList(@Param("fdId")String fdId);

    public List<CsotManagePrePay> getPrePayList(@Param("fdId")String fdId);

    public String getSupplierName(@Param("fdId")String fdId);

    public String getChargeDetailName(@Param("fdId")String fdId);

    public List<CsotManagePayPatDetail> getPayPatDetail(@Param("fdId")String fdId);

    public List<CsotManagePayEquipment> getPayEquipment(@Param("fdId")String fdId);

    public List<CsotManagePayGysDz> getPayGysDzList(@Param("fdId")String fdId);
}
