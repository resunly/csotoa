package com.csot.csotoa.revers.service;

import com.csot.csotoa.revers.bean.CsotReversMain;

import java.util.Map;

public interface ICsotReversMainService{
    public Map getCsotReversMainById(String fdId,String tempId,String serviceName);
}
