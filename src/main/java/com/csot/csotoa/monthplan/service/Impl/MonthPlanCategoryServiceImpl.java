package com.csot.csotoa.monthplan.service.Impl;

import com.csot.csotoa.monthplan.bean.MonthlyPlanElseDetail;
import com.csot.csotoa.monthplan.bean.MonthlyPlanElseMain;
import com.csot.csotoa.monthplan.mapper.IMonthPlanCategoryMapper;
import com.csot.csotoa.monthplan.service.IMonthPlanCategoryService;
import com.csot.csotoa.util.bean.AttMain;
import com.csot.csotoa.util.bean.SysOrgElement;
import com.csot.csotoa.util.service.impl.CsotUtilServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MonthPlanCategoryServiceImpl implements IMonthPlanCategoryService {
    private static final Logger logger = LoggerFactory.getLogger(MonthPlanCategoryServiceImpl.class);
    @Autowired
    private IMonthPlanCategoryMapper mapper;

    @Autowired
    private CsotUtilServiceImpl utilService;

    @Override
    public Map getMonthPlanInfo(String fdId, String tempId, String name){
        Map map = new HashMap();
        map.put("docStatus","");
        map.put("data","");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + name + "信息出错!";
        try{
            MonthlyPlanElseMain planMain = mapper.getMonthPlanMain(fdId,tempId);
            if(planMain != null){
                SysOrgElement orgElement = utilService.getSysOrgElement(planMain.getDocCreatorId());
                planMain.setDocCreatorName(orgElement.getFdName());
                List<MonthlyPlanElseDetail> detailList = mapper.getMonthPlanDetail(fdId);

                List<AttMain> fileList = utilService.getAttMain(fdId);
                if(null != fileList && fileList.size() > 0){
                    for(int i = 0 ; i < fileList.size(); i ++){
                        AttMain file = fileList.get(i);
                        if(file.getFdKey().length() == 32){
                            file.setFileDesc("审批补充附件");
                        }else{
                            file.setFileDesc("附件");
                        }
                    }
                }

                if(null != planMain.getFdApplydeptId() && planMain.getFdApplydeptId().length() > 0){
                    SysOrgElement dept = utilService.getSysOrgElement(planMain.getFdApplydeptId());
                    if(null != dept){
                        planMain.setFdApplydeptName(dept.getFdName());
                    }
                }

                map.put("docStatus",planMain.getDocStatus());
                planMain.setDetailList(detailList);
                planMain.setFileList(fileList);
                map.put("data",planMain);
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
