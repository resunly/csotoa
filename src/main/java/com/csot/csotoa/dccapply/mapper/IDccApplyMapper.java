package com.csot.csotoa.dccapply.mapper;

import com.csot.csotoa.dccapply.bean.*;
import com.csot.csotoa.util.bean.SysOrgElement;
import com.csot.csotoa.util.bean.AttMain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IDccApplyMapper {
    public DccApplyInfo getDccApplyById(@Param("fdId") String fdId,@Param("tempId") String tempId);

    public List<DccDocumentMain> getDccDocumentMain(@Param("borrowId")String borrowId,@Param("docId")String docId);

    public SysOrgElement getSysOrgElement(@Param("fdId")String fdId);

    public DccApplyInfo getDccApplyAllById(@Param("fdId") String fdId,@Param("tempId") String tempId);

    public DccApplyNew getDccApplyNew(@Param("fdId")String fdId);

    public List<String> getRelationDept(@Param("fdId")String fdId);

    public List<String> getDistributeDept(@Param("fdId")String fdId);

    public List<AttMain> getAttMain(@Param("fdId")String fdId);

    public List<DccDocumentMain> getReferenceFile(@Param("fdId")String fdId);

    public List<DccDocumentMain> getReferenceTable(@Param("fdId")String fdId);

    public DccApplyInfo getDccApplyAllByIdNoTempId(@Param("fdId") String fdId);



}

