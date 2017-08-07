package com.csot.csotoa.managehkpay.service.impl;

import com.csot.csotoa.manageborrow.bean.CsotDictData;
import com.csot.csotoa.manageborrow.mapper.ICsotManageBorrowMainMapper;
import com.csot.csotoa.managehkpay.bean.*;
import com.csot.csotoa.managehkpay.mapper.ICsotManageHKPayMapper;
import com.csot.csotoa.managehkpay.service.ICsotManageHKPayService;
import com.csot.csotoa.util.bean.AttMain;
import com.csot.csotoa.util.bean.SysOrgElement;
import com.csot.csotoa.util.mapper.ICsotUtilMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CsotManageHKPayServiceImpl implements ICsotManageHKPayService {
    private Logger logger = LoggerFactory.getLogger(CsotManageHKPayServiceImpl.class);

    @Autowired
    ICsotManageHKPayMapper hkPayMapper;

    @Autowired
    ICsotUtilMapper utilMapper;

    @Autowired
    ICsotManageBorrowMainMapper borrowMainMapper;

    @Override
    public Map getHKPayServiceInfo(String fdId,String name){
        Map map = new HashMap();
        map.put("data","");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + name + "信息出错!";
        try{
            CsotManageHKPayMain hkPayMain = hkPayMapper.getHKPayMain(fdId) ;
            if(null != hkPayMain){
                if(null != hkPayMain.getDocCreatorId()){
                    SysOrgElement orgElement = utilMapper.getSysOrgElement(hkPayMain.getDocCreatorId());
                    if(null != orgElement){
                        hkPayMain.setDocCreatorName(orgElement.getFdName());
                        hkPayMain.setDocCreatorNo(orgElement.getFdNo());
                    }
                }

                if(null != hkPayMain.getFdProposerId()){
                    SysOrgElement orgElement = utilMapper.getSysOrgElement(hkPayMain.getFdProposerId());
                    if(null != orgElement){
                        hkPayMain.setFdProposerName(orgElement.getFdName());
                        hkPayMain.setFdProposerNo(orgElement.getFdNo());

                        SysOrgElement deptElement = utilMapper.getSysOrgElement(orgElement.getFdParentid());
                        hkPayMain.setFdProposerDeptName(deptElement.getFdName());
                    }
                }

                if(null != hkPayMain.getFdDeptId()){
                    SysOrgElement orgElement = utilMapper.getSysOrgElement(hkPayMain.getFdDeptId());
                    if(null != orgElement){
                        hkPayMain.setFdDeptName(orgElement.getFdName());
                    }
                }

                if(null != hkPayMain.getDocAlterId()){
                    SysOrgElement orgElement = utilMapper.getSysOrgElement(hkPayMain.getDocAlterId());
                    if(null != orgElement){
                        hkPayMain.setDocAlterName(orgElement.getFdName());
                        hkPayMain.setDocAlterNo(orgElement.getFdNo());
                    }
                }

                if(null != hkPayMain.getDocCategoryId()){
                    hkPayMain.setDocCategoryName(hkPayMapper.getCategoryName(hkPayMain.getDocCategoryId()));
                }

                if(null != hkPayMain.getFdPersonPositionId()){
                    SysOrgElement orgElement = utilMapper.getSysOrgElement(hkPayMain.getFdPersonPositionId());
                    if(null != orgElement){
                        hkPayMain.setFdPersonPositionName(orgElement.getFdName());
                    }
                }

                if(null != hkPayMain.getFdLedgerId()){
                    hkPayMain.setFdLedgerName(hkPayMapper.getFdLedgerName(hkPayMain.getFdLedgerId()));
                }

                if(null != hkPayMain.getFdCsf()) {
                    CsotDictData dictData = borrowMainMapper.getFdCs(hkPayMain.getFdCsf());
                    hkPayMain.setFdCsfName(dictData.getFdName());
                }

                if(null != hkPayMain.getFdChargeDetailId()){
                    hkPayMain.setFdChargeDetailName(hkPayMapper.getFdFeeDetailName(hkPayMain.getFdChargeDetailId()));
                }

                CsotSupplierInfo supplierInfo = hkPayMapper.getSupplierInfo(hkPayMain.getFdPayeeSupplier());
                hkPayMain.setSupplierInfo(supplierInfo);

                List<AttMain> fileList = utilMapper.getAttMain(fdId);
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
                hkPayMain.setFileList(fileList);

                //付款清单
                List<CsotManageHKPayList> hkPayLists = hkPayMapper.getHKPayList(fdId);
                hkPayMain.setHkPayLists(hkPayLists);

                //预付清单
                List<CsotManageHKPrePay> prePayList = hkPayMapper.getHKPrePayList(fdId);
                hkPayMain.setPrePays(prePayList);

                List<CsotmanageHKPayGysDetail> gysDetails = hkPayMapper.getHKPayGysList(fdId);
                hkPayMain.setGysDetails(gysDetails);
            }
            map.put("data",hkPayMain);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(errorMsg ,e);
            status = "1";
            desc = errorMsg;
        }
        map.put("status",status);
        map.put("desc",desc);
        return map;
    }
}
