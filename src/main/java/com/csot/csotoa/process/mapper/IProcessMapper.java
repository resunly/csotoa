package com.csot.csotoa.process.mapper;

import com.csot.csotoa.process.bean.WorkItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IProcessMapper {
    public List getCurrentNode(@Param("processId")String processId,@Param("loginId")String loginId);

    public Object getFdContent(@Param("processId")String processId,@Param("fdFactId")String fdFactId);

    public List getOperationList(@Param("fdOperatorId")String fdOperatorId);

    public List getRejectNodes(@Param("processId")String processId);

    public List<WorkItem> getWorkItem(@Param("processId")String processId,
                                      @Param("expectedId")String expectedId,
                                      @Param("fdParentId")String fdParentId,
                                      @Param("fdActivityType")String fdActivityType,
                                      @Param("fdId")String fdId);

    public String getProxyId(@Param("processId")String processId,@Param("byProxyId")String byProxyId);

    public String getAuthorizer(@Param("processId")String processId,@Param("loginId")String loginId);
}

