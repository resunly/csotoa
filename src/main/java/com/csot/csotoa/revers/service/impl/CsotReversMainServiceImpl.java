package com.csot.csotoa.revers.service.impl;

import com.csot.csotoa.revers.bean.CsotReversDetail;
import com.csot.csotoa.revers.bean.CsotReversMain;
import com.csot.csotoa.revers.mapper.ICsotReversMainMapper;
import com.csot.csotoa.revers.service.ICsotReversMainService;
import com.csot.csotoa.util.XmlUtil;
import com.csot.csotoa.util.bean.AttMain;
import com.csot.csotoa.util.mapper.ICsotUtilMapper;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CsotReversMainServiceImpl implements ICsotReversMainService {
    private static final Logger logger = LoggerFactory.getLogger(CsotReversMainServiceImpl.class);

    @Autowired
    private ICsotReversMainMapper csotReversMainMapper;

    @Autowired
    private ICsotUtilMapper utilMapper;

    @Override
    public Map getCsotReversMainById(String fdId,String tempId,String name){
        if(name.equals("Cell资料出库预留单") || name.equals("预留单")){
            return getCsotReversMainAndDetail(fdId,tempId,name);
        }else{
            return getCsotReversMain(fdId,tempId,name);
        }
    }

    private Map getCsotReversMain(String fdId,String tempId,String name){
        Map map = new HashMap();
        map.put("docStatus","");
        map.put("data","");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + name + "信息出错!";
        try{
            CsotReversMain reversMain = csotReversMainMapper.getCsotReversMainById(fdId,tempId);
            if(reversMain != null){
                String xml = XmlUtil.ClobToString((Clob)reversMain.getXml());

                map.put("docStatus",reversMain.getDocStatus());
                map.put("fdId",reversMain.getFdId());
                map.put("docCreatorId",reversMain.getDocCreatorId());
                map.put("docCreatorName",reversMain.getDocCreatorName());
                map.put("docSubject",reversMain.getDocSubject());

                Map xmlMap = (HashMap)XmlUtil.stringToMap(xml);
                List fileList = getFileList(fdId,tempId,map);
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

    //预留单
    private Map getCsotReversMainAndDetail(String fdId,String tempId,String name){
        Map map = new HashMap();
        map.put("docStatus","");
        map.put("data","");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + name + "出错!";
        try{
            CsotReversMain reversMain = csotReversMainMapper.getCsotReversMainById(fdId,tempId);
            if(reversMain != null){
                String xml = XmlUtil.ClobToString((Clob)reversMain.getXml());

                map.put("docStatus",reversMain.getDocStatus());
                map.put("fdId",reversMain.getFdId());
                map.put("docCreatorId",reversMain.getDocCreatorId());
                map.put("docCreatorName",reversMain.getDocCreatorName());
                map.put("docSubject",reversMain.getDocSubject());

                Map xmlMap = (HashMap)XmlUtil.stringToMap(xml);
                List<CsotReversDetail> detailList = getDetailList(fdId);
                xmlMap.put("fdItemDetails",detailList);
                List fileList = getFileList(fdId,tempId,map);
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

    //查询明细表信息
    private List<CsotReversDetail> getDetailList(String fdMainId){
        List<CsotReversDetail> list = csotReversMainMapper.getReversDetails(fdMainId);
        if(null == list) {
            list = new ArrayList<CsotReversDetail>();
        }
        return list;
    }

    private List getFileList(String fdId,String templateId,Map map)throws DocumentException,IOException,SQLException{
        List<AttMain> fileList = utilMapper.getAttMain(fdId);
        if(null != fileList && fileList.size() > 0){
            String metaDataXml = XmlUtil.ClobToString((Clob)utilMapper.getMetaDataXml(templateId));
            Map attMap = XmlUtil.getNodeAttMap(metaDataXml,"attachmentProperty");
            for(int i = 0 ; i < fileList.size(); i ++){
                AttMain file = fileList.get(i);
                if("fd_waste_att".equals(file.getFdKey())){//备品备件退库至备件常规报废、非常规报废
                    file.setFileDesc("危废物相关附件上传");
                }else if(file.getFdKey().length() == 32){
                    file.setFileDesc("审批补充附件");
                }else{
                    String fileDesc = String.valueOf(attMap.get(file.getFdKey()));
                    file.setFileDesc(fileDesc);
                }
            }
        }
        return fileList;
    }
}
