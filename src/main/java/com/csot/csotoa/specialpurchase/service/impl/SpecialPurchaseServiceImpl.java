package com.csot.csotoa.specialpurchase.service.impl;

import com.csot.csotoa.specialpurchase.bean.SpecialPurchase;
import com.csot.csotoa.specialpurchase.mapper.ISpecialPurchaseMapper;
import com.csot.csotoa.specialpurchase.service.ISpecialPurchaseService;
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
public class SpecialPurchaseServiceImpl implements ISpecialPurchaseService{
    private static final Logger logger = LoggerFactory.getLogger(SpecialPurchaseServiceImpl.class);

    @Autowired
    ISpecialPurchaseMapper mapper;

    @Autowired
    ICsotUtilMapper utilMapper;

    @Override
    public Map getSpecialPurchase(String fdId,String name){
        Map map = new HashMap();
        map.put("data","");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + name + "信息出错!";
        try{
            SpecialPurchase purchase = mapper.getSpicialPurchase(fdId);
            if(purchase != null){
                String xml = XmlUtil.ClobToString((Clob)purchase.getExtendDataXml());
                Map xmlMap = (HashMap) XmlUtil.stringToMap(xml);
                purchase.setExtendDataXml(xmlMap);
                List<AttMain> fileList = utilMapper.getAttMain(fdId);
                for(int i = 0 ; i < fileList.size(); i ++){
                    AttMain file = fileList.get(i);
                    if(file.getFdKey().length() == 32){
                        file.setFileDesc("审批补充附件");
                    }else{
                        file.setFileDesc("附件（会议纪要及报告）");
                    }
                }
                purchase.setFileList(fileList);
                map.put("data",purchase);
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
