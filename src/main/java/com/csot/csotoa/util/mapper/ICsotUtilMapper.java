package com.csot.csotoa.util.mapper;


import com.csot.csotoa.util.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ICsotUtilMapper {

    public SysOrgElement getSysOrgElement(@Param("fdId")String fdId);

    public List<AttMain> getAttMain(@Param("fdId")String fdId);

    public String getIdByLoginName(@Param("loginName")String loginName);

    public Object getMetaDataXml(@Param("templateId")String templateId);

    public LbpmNode getLbpmNodeById(@Param("fdId")String fdId);
}

