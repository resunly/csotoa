package com.csot.csotoa.util.service;

import com.csot.csotoa.util.bean.AttMain;
import com.csot.csotoa.util.bean.SysOrgElement;

import java.util.List;

public interface ICsotUtilService {
    public SysOrgElement getSysOrgElement(String fdId);

    public List<AttMain> getAttMain(String fdId);
}
