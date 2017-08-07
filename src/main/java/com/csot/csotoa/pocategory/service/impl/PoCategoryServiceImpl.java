package com.csot.csotoa.pocategory.service.impl;

import com.csot.csotoa.pocategory.bean.CsotPoMain;
import com.csot.csotoa.pocategory.mapper.IPoCategoryMapper;
import com.csot.csotoa.pocategory.service.IPoCategoryService;
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
public class PoCategoryServiceImpl implements IPoCategoryService {
    private static final Logger logger = LoggerFactory.getLogger(PoCategoryServiceImpl.class);
    @Autowired
    private IPoCategoryMapper mapper;

    @Autowired
    private ICsotUtilMapper utilMapper;

    public Map getCsotPoMain(String fdId,String templateId,String name){
        Map map = new HashMap();
        map.put("docStatus","");
        map.put("data","");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + name + "信息出错!";
        try{
            CsotPoMain poMain = mapper.getCsotPoMain(fdId);
            if(poMain != null){
                String xml = XmlUtil.ClobToString((Clob)poMain.getExtendDataXml());
                map.put("docStatus",poMain.getDocStatus());
                map.put("docContent",poMain.getDocContent());
                Map xmlMap = (HashMap) XmlUtil.stringToMap(xml);
                map.put("data",xmlMap);

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
