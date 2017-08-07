package com.csot.csotoa.general.service;

import com.csot.csotoa.general.bean.GeneralMain;
import com.csot.csotoa.general.mapper.IGeneralMapper;
import com.csot.csotoa.util.bean.AttMain;
import com.csot.csotoa.util.bean.SysOrgElement;
import com.csot.csotoa.util.service.impl.CsotUtilServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GeneralServiceImpl implements IGeneralService {
    private static final Logger logger = LoggerFactory.getLogger(GeneralServiceImpl.class);
    @Autowired
    IGeneralMapper generalMapper;

    @Autowired
    private CsotUtilServiceImpl utilService;

    public Map getGeneralInfo(String fdId, String tempId, String label){
        Map map = new HashMap();
        map.put("docStatus","");
        map.put("data","");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + label + "信息出错!";
        try{
            GeneralMain generalMain = generalMapper.getGeneralMain(fdId,tempId);
            map.put("data","");
            if(null != generalMain){
                map.put("docStatus",generalMain.getDocStatus());
                map.put("docSubject",generalMain.getDocSubject());

                List<AttMain> fileList = utilService.getAttMain(fdId);

                if(null != fileList && fileList.size() > 0){
                    for(int i = 0; i < fileList.size(); i ++){
                        AttMain file = fileList.get(i);
                        String fdKey = file.getFdKey();
                        if(null != fdKey && fdKey.trim().length() > 0) {
                            if ("attachment".equals(fdKey)) {
                                file.setFileDesc("附件");
                            }else {
                                file.setFileDesc("审批补充附件");
                            }
                        }
                    }
                    generalMain.setFileList(fileList);
                }

                List caoSongList = generalMapper.getCaosong(fdId);
                generalMain.setCaoSongList(getOrgElementList(caoSongList));

                List aduitList1 = generalMapper.getAduit1(fdId);
                generalMain.setAduitList1(getOrgElementList(aduitList1));

                List aduitList2 = generalMapper.getAduit2(fdId);
                generalMain.setAduitList2(getOrgElementList(aduitList2));

                List aduitList3 = generalMapper.getAduit3(fdId);
                generalMain.setAduitList3(getOrgElementList(aduitList3));

                List aduitList4 = generalMapper.getAduit4(fdId);
                generalMain.setAduitList4(getOrgElementList(aduitList4));

                List aduitList5 = generalMapper.getAduit5(fdId);
                generalMain.setAduitList5(getOrgElementList(aduitList5));

                List aduitList6 = generalMapper.getAduit6(fdId);
                generalMain.setAduitList6(getOrgElementList(aduitList6));

                List aduitList7 = generalMapper.getAduit7(fdId);
                generalMain.setAduitList7(getOrgElementList(aduitList7));

                List aduitList8 = generalMapper.getAduit8(fdId);
                generalMain.setAduitList8(getOrgElementList(aduitList8));

                List aduitList9 = generalMapper.getAduit9(fdId);
                generalMain.setAduitList9(getOrgElementList(aduitList9));

                List aduitList10 = generalMapper.getAduit10(fdId);
                generalMain.setAduitList10(getOrgElementList(aduitList10));

                map.put("data", generalMain);
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

    private List<SysOrgElement> getOrgElementList(List list){
        List<SysOrgElement> resultList = new ArrayList<SysOrgElement>();
        if(list != null && list.size() > 0){
            for(int i = 0; i < list.size(); i++){
                String elementId = list.get(i).toString();
                SysOrgElement orgElement = utilService.getSysOrgElement(elementId);
                if(null != orgElement) {
                    resultList.add(orgElement);
                }
            }
        }
        return resultList;
    }
}
