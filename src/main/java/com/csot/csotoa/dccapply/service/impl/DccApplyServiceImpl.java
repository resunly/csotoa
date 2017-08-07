package com.csot.csotoa.dccapply.service.impl;

import com.csot.csotoa.dccapply.bean.*;
import com.csot.csotoa.util.bean.AttMain;
import com.csot.csotoa.util.bean.SysOrgElement;
import com.csot.csotoa.dccapply.mapper.IDccApplyMapper;
import com.csot.csotoa.dccapply.service.IDccApplyService;
import com.csot.csotoa.util.mapper.ICsotUtilMapper;
import com.csot.csotoa.util.service.ICsotUtilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DccApplyServiceImpl implements IDccApplyService {
    private static final Logger logger = LoggerFactory.getLogger(DccApplyServiceImpl.class);

    @Autowired
    private IDccApplyMapper dccApplyMapper;

    @Autowired
    private ICsotUtilMapper utilMapper;

    @Autowired
    private ICsotUtilService utilService;

    @Override
    public Map getDccApplyInfo(String fdId,String tempId,String name){
        Map map = new HashMap();
        if("借阅申请".equals(name)){
            map = getCsotDccApplyBorrow(fdId,tempId,name);
        }else if("新增申请".equals(name)){
            map = getCsotDccApplyNew(fdId,tempId,name);
        }else if("改版申请".equals(name)){
            map = getCsotDccRevision(fdId,tempId,name);
        }
        return map;
    }

    //查询借阅申请
    private Map getCsotDccApplyBorrow(String fdId,String tempId,String name){
        Map map = new HashMap();
        map.put("docStatus", "");
        map.put("data", "");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + name + "信息出错!";
        try {
            DccApplyInfo dccApplyInfo = dccApplyMapper.getDccApplyById(fdId, tempId);
            if(null != dccApplyInfo) {
                if (null != dccApplyInfo.getDocCreator()) {
                    SysOrgElement sysOrgElement = dccApplyMapper.getSysOrgElement(dccApplyInfo.getDocCreator());
                    dccApplyInfo.setDocCreatorName(sysOrgElement.getFdName());//申请人
                }
                if (null != dccApplyInfo.getFdCreateDept()) {
                    dccApplyInfo.setFdCreateDeptName(getDeptName(dccApplyInfo.getFdCreateDept()));//申请人部门
                }

                if (null != dccApplyInfo.getDocApplicant()) {//制订人
                    SysOrgElement sysOrgElement = dccApplyMapper.getSysOrgElement(dccApplyInfo.getDocApplicant());
                    dccApplyInfo.setDocApplicantName(sysOrgElement.getFdName());
                }

                if (null != dccApplyInfo.getDocApplicantDept()) {//制订人部门
                    dccApplyInfo.setDocApplicantDepName(getDeptName(dccApplyInfo.getDocApplicantDept()));
                }

                if (null != dccApplyInfo.getFdId()) {
                    List<DccDocumentMain> list = dccApplyMapper.getDccDocumentMain(fdId, dccApplyInfo.getDccDocId());

                    map.put("docStatus", dccApplyInfo.getDocStatus());
                    if (null != list && list.size() > 0) {
                        dccApplyInfo.setDccDocumentMainList(list);
                    }
                }

                List<AttMain> fileList = utilMapper.getAttMain(fdId);
                if(null != fileList && fileList.size() > 0){
                    for(int i = 0; i < fileList.size(); i ++){
                        AttMain file = fileList.get(i);
                        String fdKey = file.getFdKey();
                        file.setFileDesc("审批补充附件");
                    }
                    dccApplyInfo.setFileList(fileList);
                }
                map.put("data", dccApplyInfo);
            }
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

    //查询新增申请信息
    private Map getCsotDccApplyNew(String fdId,String tempId,String name){
        Map map = new HashMap();
        map.put("docStatus", "");
        map.put("data", "");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + name + "信息出错!";
        try {
            DccApplyInfo dccApplyInfo = dccApplyMapper.getDccApplyAllById(fdId, tempId);
            if(null != dccApplyInfo) {
                if (null != dccApplyInfo.getDocCreator()) {
                    SysOrgElement sysOrgElement = dccApplyMapper.getSysOrgElement(dccApplyInfo.getDocCreator());
                    dccApplyInfo.setDocCreatorName(sysOrgElement.getFdName());//申请人
                }
                if (null != dccApplyInfo.getFdCreateDept()) {
                    dccApplyInfo.setFdCreateDeptName(getDeptName(dccApplyInfo.getFdCreateDept()));//申请人部门
                }

                if (null != dccApplyInfo.getDocApplicant()) {//制订人
                    SysOrgElement sysOrgElement = dccApplyMapper.getSysOrgElement(dccApplyInfo.getDocApplicant());
                    dccApplyInfo.setDocApplicantName(sysOrgElement.getFdName());
                }

                if (null != dccApplyInfo.getDocApplicantDept()) {//制订人部门
                    dccApplyInfo.setDocApplicantDepName(getDeptName(dccApplyInfo.getDocApplicantDept()));
                }

                DccApplyNew dccApplyNew = dccApplyMapper.getDccApplyNew(fdId);
                dccApplyInfo.setDocMediaType(dccApplyNew.getDocMediaType());

                List<String> deptList = dccApplyMapper.getRelationDept(fdId);
                String[] deptInfo = getDeptInfos(deptList);
                dccApplyInfo.setRelationDeptIds(deptInfo[0]);
                dccApplyInfo.setRelationDeptNames(deptInfo[1]);

                List<String> distributeDept = dccApplyMapper.getDistributeDept(fdId);
                String[] distributeInfo = getDeptInfos(distributeDept);
                dccApplyInfo.setDistributeDeptIds(distributeInfo[0]);
                dccApplyInfo.setDistributeDeptNames(distributeInfo[1]);

                List<AttMain> fileList = utilMapper.getAttMain(fdId);
                if(null != fileList && fileList.size() > 0){
                    for(int i = 0; i < fileList.size(); i ++){
                        AttMain file = fileList.get(i);
                        String fdKey = file.getFdKey();
                        if(null != fdKey && fdKey.trim().length() > 0) {
                            if ("pdf".equals(fdKey)) {
                                file.setFileDesc("转换后的PDF文件");
                            } else if ("attachment".equals(fdKey)) {
                                file.setFileDesc("附件");
                            } else if ("table".equals(fdKey)) {
                                file.setFileDesc("表单上传");
                            } else if ("document".equals(fdKey)) {
                                file.setFileDesc("文件上传");
                            } else {
                                file.setFileDesc("审批补充附件");
                            }
                        }
                    }
                    dccApplyInfo.setFileList(fileList);
                }
                dccApplyInfo.setReferenceFile(dccApplyMapper.getReferenceFile(fdId));
                dccApplyInfo.setReferenceTable(dccApplyMapper.getReferenceTable(fdId));
            }
            map.put("data", dccApplyInfo);
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

    //查询改版申请信息
    private Map getCsotDccRevision(String fdId,String tempId,String name){
        Map map = new HashMap();
        map.put("docStatus", "");
        map.put("data", "");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + name + "信息出错!";
        try {
            DccApplyInfo dccApplyInfo = dccApplyMapper.getDccApplyAllByIdNoTempId(fdId);
            if(null != dccApplyInfo) {
                if (null != dccApplyInfo.getDocCreator()) {
                    SysOrgElement sysOrgElement = dccApplyMapper.getSysOrgElement(dccApplyInfo.getDocCreator());
                    dccApplyInfo.setDocCreatorName(sysOrgElement.getFdName());//申请人
                }
                if (null != dccApplyInfo.getFdCreateDept()) {
                    dccApplyInfo.setFdCreateDeptName(getDeptName(dccApplyInfo.getFdCreateDept()));//申请人部门
                }

                if (null != dccApplyInfo.getDocApplicant()) {//制订人
                    SysOrgElement sysOrgElement = dccApplyMapper.getSysOrgElement(dccApplyInfo.getDocApplicant());
                    dccApplyInfo.setDocApplicantName(sysOrgElement.getFdName());
                }

                if (null != dccApplyInfo.getDocApplicantDept()) {//制订人部门
                    dccApplyInfo.setDocApplicantDepName(getDeptName(dccApplyInfo.getDocApplicantDept()));
                }

                List<String> deptList = dccApplyMapper.getRelationDept(fdId);
                String[] deptInfo = getDeptInfos(deptList);
                dccApplyInfo.setRelationDeptIds(deptInfo[0]);
                dccApplyInfo.setRelationDeptNames(deptInfo[1]);

                List<AttMain> fileList = utilMapper.getAttMain(fdId);

                if(null != fileList && fileList.size() > 0){
                    for(int i = 0; i < fileList.size(); i ++){
                        AttMain file = fileList.get(i);
                        String fdKey = file.getFdKey();
                        if(null != fdKey && fdKey.trim().length() > 0) {
                            if ("revisionDoc".equals(fdKey)) {
                                file.setFileDesc("新版履历");
                            } else if ("document".equals(fdKey)) {
                                file.setFileDesc("新版文件");
                            } else if ("attachment".equals(fdKey)) {
                                file.setFileDesc("新附件");
                            } else if ("table".equals(fdKey)) {
                                file.setFileDesc("新增表单");
                            } else {
                                file.setFileDesc("审批补充附件");
                            }
                        }
                    }
                    dccApplyInfo.setFileList(fileList);
                }

                dccApplyInfo.setReferenceFile(dccApplyMapper.getReferenceFile(fdId));
                dccApplyInfo.setReferenceTable(dccApplyMapper.getReferenceTable(fdId));
            }

            map.put("data", dccApplyInfo);
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
    //查询部门
    public String getDeptName(String fdId){
        String deptName = "";
        SysOrgElement sysOrgElement = dccApplyMapper.getSysOrgElement(fdId);
        SysOrgElement pOrgElement = dccApplyMapper.getSysOrgElement(sysOrgElement.getFdParentid());
        SysOrgElement ppOrgElement = dccApplyMapper.getSysOrgElement(pOrgElement.getFdParentid());
        deptName = sysOrgElement.getFdName() + "<<" + pOrgElement.getFdName() + "<<" + ppOrgElement.getFdName();
        return deptName;
    }

    public String[] getDeptInfos(List<String> list){
        String[] res = new String[2];
        String id = "";
        String name = "";
        for(int i = 0; i < list.size(); i++){
            String fdId = list.get(i);
            SysOrgElement sysOrgElement = dccApplyMapper.getSysOrgElement(fdId);
            if(id.length() == 0){
                id = fdId;
                name = sysOrgElement.getFdName();
            }else{
                id = id + ";" + fdId;
                name = name + ";" + sysOrgElement.getFdName();
            }
        }
        res[0] = id;
        res[1] = name;
        return res;
    }

}
