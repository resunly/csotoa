package com.csot.csotoa.managepay.service.impl;

import com.csot.csotoa.manageborrow.bean.CsotDictData;
import com.csot.csotoa.manageborrow.mapper.ICsotManageBorrowMainMapper;
import com.csot.csotoa.managepay.bean.*;
import com.csot.csotoa.managepay.mapper.ICsotManagePayMapper;
import com.csot.csotoa.managepay.service.ICsotManagePayService;
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
public class CsotManagePayServiceImpl implements ICsotManagePayService {
    Logger logger = LoggerFactory.getLogger(CsotManagePayServiceImpl.class);

    @Autowired
    ICsotManagePayMapper payMapper;

    @Autowired
    ICsotUtilMapper utilMapper;

    @Autowired
    ICsotManageBorrowMainMapper mapper;

    @Override
    public Map getCostManagePayInfo(String fdId,String name){
        Map map = new HashMap();
        map.put("docStatus","");
        map.put("data","");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + name + "信息出错!";
        try{
            CsotManagePayMain payMain = payMapper.getCostManagePayMain(fdId);
            if(null != payMain){
                if(null != payMain.getProjectApplicant()){
                    SysOrgElement orgElement = utilMapper.getSysOrgElement(payMain.getProjectApplicant());
                    if(null != orgElement){
                        payMain.setProjectApplicantName(orgElement.getFdName());
                    }
                }
                if(null != payMain.getFdProposerId()){
                    SysOrgElement orgElement = utilMapper.getSysOrgElement(payMain.getFdProposerId());
                    if(null != orgElement){
                        payMain.setFdProposerName(orgElement.getFdName());
                        payMain.setFdProposerNo(orgElement.getFdNo());
                    }
                }

                if(null != payMain.getDocCreatorId()){
                    SysOrgElement orgElement = utilMapper.getSysOrgElement(payMain.getDocCreatorId());
                    if(null != orgElement){
                        payMain.setDocCreatorName(orgElement.getFdName());
                        payMain.setDocCreatorNo(orgElement.getFdNo());
                    }
                }

                if(null != payMain.getFdCsf() && payMain.getFdCsf().length() > 0) {
                    CsotDictData dictData = mapper.getFdCs(payMain.getFdCsf());
                    payMain.setDictData(dictData);
                }

                if(null != payMain.getFdPayeeSupplier()){
                    String supplierName = payMapper.getSupplierName(payMain.getFdPayeeSupplier());
                    payMain.setFdPayeeSupplierName(supplierName);

                }

                if(null != payMain.getFdPersonPositionId()){
                    SysOrgElement orgElement = utilMapper.getSysOrgElement(payMain.getFdPersonPositionId());
                    if(null != orgElement){
                        payMain.setFdPersonPositionName(orgElement.getFdName());
                    }
                }

                if(null != payMain.getFdChargeDetailId()){
                    String chargeName = payMapper.getChargeDetailName(payMain.getFdChargeDetailId());
                    payMain.setFdChargeDetailName(chargeName);
                }

                List<CsotManageFeeDetail> details = payMapper.getDetailList(fdId);
                payMain.setDetail(details);

                List<CsotManagePrePay> prePayList = payMapper.getPrePayList(fdId);
                payMain.setPrePayList(prePayList);

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
                payMain.setFileList(fileList);

                List<CsotManagePayPatDetail> payPatDetails = payMapper.getPayPatDetail(fdId);
                payMain.setPayPatDetailList(payPatDetails);

                List<CsotManagePayEquipment> payEquipmentList = payMapper.getPayEquipment(fdId);
                payMain.setPayEquipmentList(payEquipmentList);

                List<CsotManagePayGysDz> payGysDzList = payMapper.getPayGysDzList(fdId);
                payMain.setPayGysDzList(payGysDzList);

                map.put("data",payMain);
            }
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
