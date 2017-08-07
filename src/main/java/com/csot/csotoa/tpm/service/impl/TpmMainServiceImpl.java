package com.csot.csotoa.tpm.service.impl;

import com.csot.csotoa.tpm.bean.TpmMain;
import com.csot.csotoa.tpm.mapper.ITpmMainMapper;
import com.csot.csotoa.tpm.service.ITpmMainService;
import com.csot.csotoa.util.XmlUtil;
import com.csot.csotoa.util.bean.AttMain;
import com.csot.csotoa.util.bean.SysOrgElement;
import com.csot.csotoa.util.mapper.ICsotUtilMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Clob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TpmMainServiceImpl implements ITpmMainService{
    Logger logger = LoggerFactory.getLogger(TpmMainServiceImpl.class);

    @Autowired
    private ITpmMainMapper tpmMainMapper;

    @Autowired
    private ICsotUtilMapper utilMapper;

    @Override
    public Map getTpmMainInfo(String fdId,String templateId,String name){
        Map map = new HashMap();
        map.put("data","");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + name + "信息出错!";
        try{
            TpmMain tpmMain = tpmMainMapper.getTpmMain(fdId);
            if(null != tpmMain){
                if(null != tpmMain.getDocCreatorId()){
                    SysOrgElement sysOrgElement = utilMapper.getSysOrgElement(tpmMain.getDocCreatorId());
                    if(null != sysOrgElement){
                        tpmMain.setDocCreatorName(sysOrgElement.getFdName());
                    }
                }

                if(null != tpmMain.getFdDepartmentId()){
                    SysOrgElement sysOrgElement = utilMapper.getSysOrgElement(tpmMain.getFdDepartmentId());
                    if(null != sysOrgElement){
                        tpmMain.setFdDepartmentName(sysOrgElement.getFdName());
                    }
                }

                String xml = XmlUtil.ClobToString((Clob)tpmMain.getExtendDataXml());
                tpmMain.setExtendDataXml("");
                Map xmlMap = (HashMap) XmlUtil.stringToMap(xml);
                List<AttMain> fileList = utilMapper.getAttMain(fdId);
                if(null != fileList && fileList.size() > 0){
                    String metaDataXml = XmlUtil.ClobToString((Clob)utilMapper.getMetaDataXml(templateId));
                    Map attMap = XmlUtil.getNodeAttMap(metaDataXml, "attachmentProperty");
                    for(int i = 0 ; i < fileList.size(); i ++){
                        AttMain file = fileList.get(i);
                        if(file.getFdKey().length() == 32){
                            file.setFileDesc("审批补充附件");
                        }else{
                            String fileDesc = String.valueOf(attMap.get(file.getFdKey()));
                            file.setFileDesc(fileDesc);
                        }
                    }
                }

                tpmMain.setFileList(fileList);
                tpmMain.setExtendDataXml(xmlMap);
                map.put("data",tpmMain);
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
