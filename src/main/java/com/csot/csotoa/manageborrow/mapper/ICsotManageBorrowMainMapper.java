package com.csot.csotoa.manageborrow.mapper;

import com.csot.csotoa.manageborrow.bean.CsotManageBorrow;
import com.csot.csotoa.manageborrow.bean.CsotManageBorrowMain;
import com.csot.csotoa.manageborrow.bean.CsotDictData;
import com.csot.csotoa.manageborrow.bean.KmCsotmanageSapBankaccsub;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ICsotManageBorrowMainMapper {
    public CsotManageBorrowMain getCostManageBorrowMain(@Param("fdId")String fdId);
    public List<CsotManageBorrow> getBorrowList(@Param("fdId")String fdId);
    public CsotDictData getFdCs(@Param("fdId")String fdId);
    public KmCsotmanageSapBankaccsub getFdledger(@Param("fdId")String fdId);
}
