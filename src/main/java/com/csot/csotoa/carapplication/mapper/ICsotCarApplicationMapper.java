package com.csot.csotoa.carapplication.mapper;

import com.csot.csotoa.carapplication.bean.CsotCarApplication;
import com.csot.csotoa.carapplication.bean.CsotCarInfo;
import com.csot.csotoa.util.bean.SysOrgElement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ICsotCarApplicationMapper {

    public CsotCarApplication getCsotCarApplication(String fdId);

    public List<SysOrgElement> getCarUser(String fdId);

    public List<CsotCarInfo> getCostCarInfo(String fdId);

    public String getOrgNameById(String orgId);
}
