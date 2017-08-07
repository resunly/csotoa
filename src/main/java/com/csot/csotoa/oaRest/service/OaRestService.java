package com.csot.csotoa.oaRest.service;

import java.util.Map;

/**
 * Created by liushiqi on 2017/6/16.
 */
public interface OaRestService {
    public String getTempletIdByfdId(String fdId);
    public String updateToDoFlowStatusCustom(String fdId,String fdFlowOpt,String fdFlowNote,String loginName,String toLoginNames,String extend) throws Exception;
    public Map<String,String> getPagePermit(String fdId,String templateId,String loginName) throws Exception;

    public boolean checkFlowNodeSet(String fdId, String userId);
}
