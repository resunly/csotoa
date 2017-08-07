package com.csot.csotoa.process.service;

import java.util.List;
import java.util.Map;

public interface IProcessService {
    public String getOperationStr(String processId,String loginName);

    public List getRejectNodes(String processId);
}
