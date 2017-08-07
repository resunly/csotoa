package com.csot.csotoa.general.mapper;

import com.csot.csotoa.general.bean.GeneralMain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IGeneralMapper {

    public GeneralMain getGeneralMain(@Param("fdId")String fdId, @Param("tempId") String tempId);

    public List<String> getCaosong(@Param("fdId")String fdId);

    public List<String> getAduit1(@Param("fdId")String fdId);

    public List<String> getAduit2(@Param("fdId")String fdId);

    public List<String> getAduit3(@Param("fdId")String fdId);

    public List<String> getAduit4(@Param("fdId")String fdId);

    public List<String> getAduit5(@Param("fdId")String fdId);

    public List<String> getAduit6(@Param("fdId")String fdId);

    public List<String> getAduit7(@Param("fdId")String fdId);

    public List<String> getAduit8(@Param("fdId")String fdId);

    public List<String> getAduit9(@Param("fdId")String fdId);

    public List<String> getAduit10(@Param("fdId")String fdId);
}

