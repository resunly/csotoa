package com.csot.csotoa.managetax.mapper;

import com.csot.csotoa.managetax.bean.KmCsotmanageTaxDetail;
import com.csot.csotoa.managetax.bean.KmCsotmanageTaxMain;
import com.csot.csotoa.util.bean.SysOrgElement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IKmCsotManageTaxMainMapper {
    public KmCsotmanageTaxMain getKmCostmanageTaxMain(@Param("fdId")String fdId);

    public List<KmCsotmanageTaxDetail> getDetailList(@Param("fdId")String fdId);

    public SysOrgElement getProcessName(@Param("fdId")String fdId);

    public String getBankNumber(@Param("fdId")String fdId);
}
