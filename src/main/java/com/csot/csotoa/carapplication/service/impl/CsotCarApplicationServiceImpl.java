package com.csot.csotoa.carapplication.service.impl;

import com.csot.csotoa.carapplication.bean.CsotCarApplication;
import com.csot.csotoa.carapplication.bean.CsotCarInfo;
import com.csot.csotoa.carapplication.mapper.ICsotCarApplicationMapper;
import com.csot.csotoa.carapplication.service.ICsotCarApplicationService;
import com.csot.csotoa.util.bean.AttMain;
import com.csot.csotoa.util.service.ICsotUtilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CsotCarApplicationServiceImpl implements ICsotCarApplicationService {
    Logger logger = LoggerFactory.getLogger(CsotCarApplicationServiceImpl.class);
    @Autowired
    private ICsotCarApplicationMapper costCarMapper;

    @Autowired
    private ICsotUtilService utilService;

    @Override
    public Map getCostCarInfo(String fdId,String name){
        Map map = new HashMap();
        map.put("docStatus", "");
        map.put("data", "");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + name + "信息出错!";
        try {
            CsotCarApplication costCar = costCarMapper.getCsotCarApplication(fdId);
            if(null != costCar) {
                if (null != costCar.getDocDeptId()) {
                    costCar.setDocDeptName(costCarMapper.getOrgNameById(costCar.getDocDeptId()));
                }
                if (null != costCar.getDocCreatorId()) {
                    costCar.setDocCreatorName(costCarMapper.getOrgNameById(costCar.getDocCreatorId()));
                }
                List carUserList = costCarMapper.getCarUser(fdId);
                costCar.setCarUserList(carUserList);

                List<CsotCarInfo> carInfoList = costCarMapper.getCostCarInfo(fdId);
                costCar.setCarInfoList(carInfoList);

                List<AttMain> fileList = utilService.getAttMain(fdId);
                if(null != fileList && fileList.size() > 0) {
                    for(int i = 0; i < fileList.size(); i++){
                        AttMain file = fileList.get(i);
                        String fdKey = file.getFdKey();
                        file.setFileDesc("审批补充附件");
                    }
                    costCar.setFileList(fileList);
                }
            }

            map.put("data",costCar);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(errorMsg, e);
            status = "1";
            desc = errorMsg;
        }
        map.put("status", status);
        map.put("desc", desc);
        return map;

    }
}
