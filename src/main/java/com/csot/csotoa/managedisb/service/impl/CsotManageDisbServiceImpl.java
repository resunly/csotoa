package com.csot.csotoa.managedisb.service.impl;

import com.csot.csotoa.managedisb.bean.*;
import com.csot.csotoa.managedisb.mapper.ICsotManageDisbMapper;
import com.csot.csotoa.managedisb.service.ICsotManageDisbService;
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
public class CsotManageDisbServiceImpl implements ICsotManageDisbService{
    Logger logger = LoggerFactory.getLogger(CsotManageDisbServiceImpl.class);

    @Autowired
    ICsotManageDisbMapper disbMapper;

    @Autowired
    ICsotUtilMapper utilMapper;

    @Override
    public Map getCsotManageDisbInfo(String fdId, String name){
        Map map = new HashMap();
        map.put("data","");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + name + "信息出错!";
        try{
            CsotManageDisbMain disbMain = disbMapper.getCostManageDisbMain(fdId);
            if(null != disbMain) {
                if (null != disbMain.getDocCreatorId()) {
                    SysOrgElement orgElement = utilMapper.getSysOrgElement(disbMain.getDocCreatorId());
                    if (null != orgElement) {
                        disbMain.setDocCreatorName(orgElement.getFdName());
                    }
                }

                if(null != disbMain.getFdPersonId()){
                    SysOrgElement orgElement = utilMapper.getSysOrgElement(disbMain.getFdPersonId());
                    if (null != orgElement) {
                        disbMain.setFdPersonName(orgElement.getFdName());
                    }
                }

                if (null != disbMain.getFdDeptId()) {
                    SysOrgElement orgElement = utilMapper.getSysOrgElement(disbMain.getFdDeptId());
                    if (null != orgElement) {
                        disbMain.setFdDeptName(orgElement.getFdName());
                    }
                }

                if (null != disbMain.getFdPersonPositionId()) {
                    SysOrgElement orgElement = utilMapper.getSysOrgElement(disbMain.getFdPersonPositionId());
                    if (null != orgElement) {
                        disbMain.setFdPersonPositionName(orgElement.getFdName());
                    }
                }
                //报销类别
                if(null != disbMain.getDocCategoryId()) {
                    String categoryName = disbMapper.getCategoryName(disbMain.getDocCategoryId());
                    disbMain.setDocCategoryName(categoryName);
                }

                //付款帐号
                if(null != disbMain.getFdPersonalAccount()){
                    String acccountName = disbMapper.getAccountName(disbMain.getFdPersonalAccount());
                    disbMain.setFdPersonalAccountName(acccountName);
                }

                //报销清单-差旅费
                List<CsotManageTravelDisbMain> disbMainList = disbMapper.getTravelDisbMainList(fdId);
                disbMain.setTravelDisbMainList(disbMainList);

                //报销清单-日常费用
                List<CsotManageDisbList> disbLists = disbMapper.getCsotManageDisbList(fdId);
                disbMain.setDisbLists(disbLists);

                //冲借支清单
                List<CsotManageBorrowMain> borrowMainList = disbMapper.getBorrowMainList(fdId);
                disbMain.setBorrowMainList(borrowMainList);

                //收款人账号
                List<CsotManagePayeeDetail> payeeDetail = disbMapper.getPayeeDetail(fdId);
                disbMain.setPayeeDetailList(payeeDetail);

                //附件
                List<AttMain> fileList = utilMapper.getAttMain(fdId);
                if(null != fileList && fileList.size() > 0){
                    for(int i = 0 ; i < fileList.size(); i ++){
                        AttMain file = fileList.get(i);
                        if(file.getFdKey().length() == 32){
                            file.setFileDesc("审批补充附件");
                        }else{
                            file.setFileDesc("相关说明（附件）");
                        }
                    }
                }
                disbMain.setFileList(fileList);
            }
            map.put("data",disbMain);
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
