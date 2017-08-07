package com.csot.csotoa.tpm.mapper;

import com.csot.csotoa.tpm.bean.TpmMain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ITpmMainMapper {
    public TpmMain getTpmMain(@Param("fdId")String fdId);
}
