package com.csot.csotoa.managehkpay.mapper;

import com.csot.csotoa.managehkpay.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ICsotManageHKPayMapper {
    public CsotManageHKPayMain getHKPayMain(@Param("fdId") String fdId);

    public String getCategoryName(@Param("fdId")String fdId);

    public String getFdLedgerName(@Param("fdId")String fdId);

    public String getFdFeeDetailName(@Param("fdId")String fdId);

    public CsotSupplierInfo getSupplierInfo(@Param("fdId")String fdId);

    public List<CsotManageHKPrePay> getHKPrePayList(@Param("fdId")String fdId);

    public List<CsotManageHKPayList> getHKPayList(@Param("fdId")String fdId);

    public List<CsotmanageHKPayGysDetail> getHKPayGysList(@Param("fdId")String fdId);
}
