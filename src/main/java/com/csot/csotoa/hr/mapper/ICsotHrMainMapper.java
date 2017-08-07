package com.csot.csotoa.hr.mapper;

import com.csot.csotoa.hr.bean.CsotHrMain;
import com.csot.csotoa.revers.bean.AttrFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ICsotHrMainMapper {
    public CsotHrMain getCsotHrMain(@Param("fdId") String fdId);

    public List<AttrFile> getAttrFiles(@Param("fdId") String fdId);
}

