package com.csot.csotoa.prcategory.service.impl;

import com.csot.csotoa.pocategory.bean.CsotPoMain;
import com.csot.csotoa.prcategory.bean.CsotPrMain;
import com.csot.csotoa.prcategory.mapper.IPrCategoryMapper;
import com.csot.csotoa.prcategory.service.IPrCategoryService;
import com.csot.csotoa.util.XmlUtil;
import com.csot.csotoa.util.bean.AttMain;
import com.csot.csotoa.util.mapper.ICsotUtilMapper;
import com.csot.csotoa.util.service.impl.CsotUtilServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Clob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PrCategoryServiceImpl implements IPrCategoryService {
    private static final Logger logger = LoggerFactory.getLogger(PrCategoryServiceImpl.class);

    @Autowired
    private IPrCategoryMapper mapper;

    @Autowired
    private ICsotUtilMapper utilMapper;

    public Map getCsotPrMain(String fdId,String templateId,String name){
        Map map = new HashMap();
        map.put("docStatus","");
        map.put("data","");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + name + "信息出错!";
        try{
            CsotPrMain prMain = mapper.getCsotPrMain(fdId);
            if(prMain != null){
                String xml = XmlUtil.ClobToString((Clob)prMain.getExtendDataXml());
                map.put("docStatus",prMain.getDocStatus());
                map.put("docContent",prMain.getDocContent());
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
                xmlMap.put("fileList",fileList);
                map.put("data",xmlMap);
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
