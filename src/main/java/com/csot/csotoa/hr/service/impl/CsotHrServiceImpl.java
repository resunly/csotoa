package com.csot.csotoa.hr.service.impl;

import com.csot.csotoa.hr.bean.CsotHrMain;
import com.csot.csotoa.hr.mapper.ICsotHrMainMapper;
import com.csot.csotoa.hr.service.ICsotHrService;
import com.csot.csotoa.util.XmlUtil;
import com.csot.csotoa.util.bean.AttMain;
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
public class CsotHrServiceImpl implements ICsotHrService{
    private static final Logger logger = LoggerFactory.getLogger(CsotHrServiceImpl.class);

    @Autowired
    private ICsotHrMainMapper csotHrMainMapper;

    @Autowired
    private ICsotUtilMapper utilMapper;

    @Override
    public Map getCsotHrInfo(String fdId, String tempId, String name){
        Map map = new HashMap();
        map.put("docStatus","");
        map.put("data","");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + name + "信息出错!";
        try{
            CsotHrMain hrMain = csotHrMainMapper.getCsotHrMain(fdId);
            if(hrMain != null){
                String xml = XmlUtil.ClobToString((Clob)hrMain.getExtendDataXml());

                map.put("docStatus",hrMain.getDocStatus());
                map.put("fdId",hrMain.getFdId());
                map.put("docCreatorId",hrMain.getDocCreatorId());
                map.put("docCreatorName",hrMain.getDocCreatorName());
                map.put("docSubject",hrMain.getDocSubject());

                Map xmlMap = (HashMap) XmlUtil.stringToMap(xml);
                map.put("data",xmlMap);

                List<AttMain> fileList = utilMapper.getAttMain(fdId);
                if(null != fileList && fileList.size() > 0){
                    String metaDataXml = XmlUtil.ClobToString((Clob)utilMapper.getMetaDataXml(tempId));
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
                map.put("fileList",fileList);
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
