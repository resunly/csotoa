package com.csot.csotoa.manageborrow.service.impl;

import com.csot.csotoa.manageborrow.bean.CsotManageBorrow;
import com.csot.csotoa.manageborrow.bean.CsotManageBorrowMain;
import com.csot.csotoa.manageborrow.bean.CsotDictData;
import com.csot.csotoa.manageborrow.bean.KmCsotmanageSapBankaccsub;
import com.csot.csotoa.manageborrow.mapper.ICsotManageBorrowMainMapper;
import com.csot.csotoa.manageborrow.service.ICsotManageBorrowMainService;
import com.csot.csotoa.util.bean.AttMain;
import com.csot.csotoa.util.bean.SysOrgElement;
import com.csot.csotoa.util.mapper.ICsotUtilMapper;
import com.csot.csotoa.util.service.impl.CsotUtilServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CsotManageBorrowMainSercviceImpl implements ICsotManageBorrowMainService {
    private static Logger logger = LoggerFactory.getLogger(CsotManageBorrowMainSercviceImpl.class);

    @Autowired
    ICsotManageBorrowMainMapper mapper;

    @Autowired
    ICsotUtilMapper utilMapper;

    @Override
    public Map getCostManageBorrowMainInfo(String fdId, String name){
        Map map = new HashMap();
        map.put("docStatus","");
        map.put("data","");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + name + "信息出错!";
        try{
            CsotManageBorrowMain borrowMain = mapper.getCostManageBorrowMain(fdId);
            if(borrowMain != null){
                SysOrgElement orgElement = utilMapper.getSysOrgElement(borrowMain.getFdPersonPositionId());
                borrowMain.setFdPersonPositionName(orgElement.getFdName());

                if(null != borrowMain.getFdCsf() && borrowMain.getFdCsf().length() > 0) {
                    CsotDictData dictData = mapper.getFdCs(borrowMain.getFdCsf());
                    borrowMain.setCsotDictData(dictData);
                }

                if(null != borrowMain.getDocBorrowId()) {
                    SysOrgElement borrowElement = utilMapper.getSysOrgElement(borrowMain.getDocBorrowId());
                    borrowMain.setDocBorrowName(borrowElement.getFdName());
                }

                if(null != borrowMain.getDocAlterId()){
                    SysOrgElement alterElement = utilMapper.getSysOrgElement(borrowMain.getDocAlterId());
                    borrowMain.setDocAlterName(alterElement.getFdName());
                }

                if(null != borrowMain.getDocCreatorId()){
                    SysOrgElement alterElement = utilMapper.getSysOrgElement(borrowMain.getDocCreatorId());
                    borrowMain.setDocCreatorName(alterElement.getFdName());
                }

                KmCsotmanageSapBankaccsub bankaccsub = mapper.getFdledger(borrowMain.getFdLedgerId());
                borrowMain.setBankaccsub(bankaccsub);

                List<CsotManageBorrow> borrowList = mapper.getBorrowList(fdId);
                borrowMain.setBorrowList(borrowList);

                List<AttMain> fileList = utilMapper.getAttMain(fdId);
                for(int i = 0 ; i < fileList.size(); i ++){
                    AttMain file = fileList.get(i);
                    if("kmCostmanageBorrow".equals(file.getFdKey())){
                        file.setFileDesc("附件");
                    }else if(file.getFdKey().length() == 32){
                        file.setFileDesc("审批补充附件");
                    }
                }
                borrowMain.setFileList(fileList);
            }
            map.put("data",borrowMain);
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
