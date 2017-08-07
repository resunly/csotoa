package com.csot.csotoa.dccmodapply.mapper;

import com.csot.csotoa.dccmodapply.bean.*;
import com.csot.csotoa.util.bean.AttMain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IDccModApplyMapper{
    public DccModApply getDccModApply(@Param("fdId")String fdId);
    public CsotDccmodApplyBorrow getDccModApplyBorrow(@Param("fdId")String fdId);
    public List<CsotDccmodBorrowList> getDccModBorrowList(@Param("fdId")String fdId);
    public CsotDccmodDocumentMain getDccModDcoMain(@Param("fdId")String fdId);
    public List<DccModDocumentMain> getRereferenceFiles(@Param("fdId")String fdId);
    public List<DccModDocumentMain> getRereferenceTables(@Param("fdId")String fdId);
    public List<String> getApplyBaseDept(@Param("fdId")String fdId);
    public List<String> getApplyRelDept(@Param("fdId")String fdId);
    public List<String> getApplyNewDist(@Param("fdId")String fdId);
    public List<String> getApplyMainDept(@Param("fdId")String fdId);
    public List<String> getApplyRedis(@Param("fdId")String fdId);
    public List<AttMain> getDocumentList(@Param("fdId")String fdId,@Param("fdKey") String fdKey);
    public String getDocMediaType(@Param("fdId")String fdId);
}
