package com.csot.csotoa.monthplan.mapper;

import com.csot.csotoa.hr.bean.CsotHrMain;
import com.csot.csotoa.monthplan.bean.MonthlyPlanElseDetail;
import com.csot.csotoa.monthplan.bean.MonthlyPlanElseMain;
import com.csot.csotoa.revers.bean.AttrFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IMonthPlanCategoryMapper {
    public MonthlyPlanElseMain getMonthPlanMain(@Param("fdId") String fdId, @Param("tempId") String tempId);

    public List<MonthlyPlanElseDetail> getMonthPlanDetail(@Param("fdId") String fdId);
}

