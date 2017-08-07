package com.csot.csotoa.managedisb.mapper;

import com.csot.csotoa.managedisb.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ICsotManageDisbMapper {
    public CsotManageDisbMain getCostManageDisbMain(@Param("fdId")String fdId);

    public List<CsotManagePayeeDetail> getPayeeDetail(@Param("fdId")String fdId);

    public String getCategoryName(@Param("fdId")String fdId);

    public String getAccountName(@Param("fdId")String fdId);

    public List<CsotManageTravelDisbMain>getTravelDisbMainList(@Param("fdId")String fdId);

    public List<CsotManageBorrowMain> getBorrowMainList(@Param("fdId")String fdId);

    public List<CsotManageDisbList> getCsotManageDisbList(@Param("fdId")String fdId);
}
