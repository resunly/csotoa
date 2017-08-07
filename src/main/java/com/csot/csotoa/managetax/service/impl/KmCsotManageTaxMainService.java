package com.csot.csotoa.managetax.service.impl;

import com.csot.csotoa.managetax.bean.KmCsotmanageTaxDetail;
import com.csot.csotoa.managetax.bean.KmCsotmanageTaxMain;
import com.csot.csotoa.managetax.mapper.IKmCsotManageTaxMainMapper;
import com.csot.csotoa.managetax.service.IKmCsotManageTaxMainService;
import com.csot.csotoa.util.bean.AttMain;
import com.csot.csotoa.util.bean.SysOrgElement;
import com.csot.csotoa.util.service.impl.CsotUtilServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class KmCsotManageTaxMainService implements IKmCsotManageTaxMainService {
    private static final Logger logger = LoggerFactory.getLogger(KmCsotManageTaxMainService.class);
    @Autowired
    IKmCsotManageTaxMainMapper mapper;

    @Autowired
    CsotUtilServiceImpl utilService;

    @Override
    public Map getKmCostManageTaxMainInfo(String fdId,String name){
        Map map = new HashMap();
        map.put("docStatus","");
        map.put("data","");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + name + "信息出错!";
        try{
            KmCsotmanageTaxMain taxMain = mapper.getKmCostmanageTaxMain(fdId);
            if(taxMain != null){
                if(null != taxMain.getFdLedgerId()){
                    taxMain.setBankNumber(mapper.getBankNumber(taxMain.getFdLedgerId()));
                }
                List<KmCsotmanageTaxDetail> detailList = mapper.getDetailList(fdId);
                taxMain.setDetailList(detailList);

                taxMain.setProcessName(mapper.getProcessName(taxMain.getDocCategoryId()).getFdName());

                SysOrgElement deptElement = utilService.getSysOrgElement(taxMain.getDocDeptId());
                taxMain.setDocDeptName(deptElement.getFdName());

                SysOrgElement createElement = utilService.getSysOrgElement(taxMain.getDocCreatorId());
                taxMain.setDocCreatorName(createElement.getFdName());

                List<AttMain> fileList = utilService.getAttMain(fdId);
                taxMain.setFileList(fileList);
                if(null != fileList && fileList.size() > 0){
                    for(int i = 0 ; i < fileList.size(); i ++){
                        AttMain file = fileList.get(i);
                        if(file.getFdKey().length() == 32){
                            file.setFileDesc("审批补充附件");
                        }else{
                            file.setFileDesc("附件");
                        }
                    }
                }
                map.put("data",taxMain);
            }
        }catch (Exception e){
            logger.error(errorMsg ,e);
            status = "1";
            desc = errorMsg;
        }
        map.put("status",status);
        map.put("desc",desc);
        return map;
    }
}
