package com.csot.csotoa.util.service.impl;

import com.csot.csotoa.util.bean.AttMain;
import com.csot.csotoa.util.bean.SysOrgElement;
import com.csot.csotoa.util.mapper.ICsotUtilMapper;
import com.csot.csotoa.util.service.ICsotUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CsotUtilServiceImpl implements ICsotUtilService{
    @Autowired
    private ICsotUtilMapper utilMapper;

    public SysOrgElement getSysOrgElement(String fdId){
        return utilMapper.getSysOrgElement(fdId);
    }

    public List<AttMain> getAttMain(String fdId){
        return utilMapper.getAttMain(fdId);
    }
}
