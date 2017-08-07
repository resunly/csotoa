package com.csot.csotoa.revers.mapper;

import com.csot.csotoa.revers.bean.AttrFile;
import com.csot.csotoa.revers.bean.CsotReversDetail;
import com.csot.csotoa.revers.bean.CsotReversMain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ICsotReversMainMapper {
    public CsotReversMain getCsotReversMainById(@Param("fdId")String fdId, @Param("tempId")String tempId);

    public List<AttrFile> getAttrFiles(@Param("fdId")String fdId);

    public List<CsotReversDetail> getReversDetails(@Param("fdMainId")String fdMainId);
}

