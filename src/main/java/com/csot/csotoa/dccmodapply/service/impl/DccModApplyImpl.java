package com.csot.csotoa.dccmodapply.service.impl;

import com.csot.csotoa.dccapply.service.impl.DccApplyServiceImpl;
import com.csot.csotoa.dccmodapply.bean.*;
import com.csot.csotoa.dccmodapply.mapper.IDccModApplyMapper;
import com.csot.csotoa.dccmodapply.service.IDccModApplyService;
import com.csot.csotoa.util.XmlUtil;
import com.csot.csotoa.util.bean.AttMain;
import com.csot.csotoa.util.bean.SysOrgElement;
import com.csot.csotoa.util.mapper.ICsotUtilMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Clob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DccModApplyImpl implements IDccModApplyService{
    private static final Logger logger = LoggerFactory.getLogger(DccModApplyImpl.class);

    @Autowired
    IDccModApplyMapper mapper;

    @Autowired
    ICsotUtilMapper utilMapper;

    @Autowired
    private DccApplyServiceImpl dccApplyService;

    public Map getDccModApply(String fdId,String tempId, String name){
        if("借阅申请".equals(name)){
            return getDccModApplyBorrowInfo(fdId, tempId, name);
        }else if("新增申请".equals(name)){
            return getDccModApplyNewInfo(fdId, tempId, name);
        }else if("改版申请".equals(name)){
            return getDccApplyRevisionInfo(fdId, tempId, name);
        }else{
            return new HashMap();
        }
    }

    //借阅申请
    private Map getDccModApplyBorrowInfo(String fdId,String tempId, String name){
        Map map = new HashMap();
        map.put("docStatus", "");
        map.put("data", "");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + name + "信息出错!";
        try {
            DccModApply dccModApplyInfo = mapper.getDccModApply(fdId);
            if(null != dccModApplyInfo) {
                if (null != dccModApplyInfo.getDocCreator()) {
                    SysOrgElement sysOrgElement = utilMapper.getSysOrgElement(dccModApplyInfo.getDocCreator());
                    dccModApplyInfo.setDocCreatorName(sysOrgElement.getFdName());//申请人
                }
                if (null != dccModApplyInfo.getFdCreateDept()) {
                    dccModApplyInfo.setFdCreateDeptName(dccApplyService.getDeptName(dccModApplyInfo.getDocCreator()));//申请人部门
                }

                if (null != dccModApplyInfo.getDocApplicant()) {//借阅人
                    SysOrgElement sysOrgElement = utilMapper.getSysOrgElement(dccModApplyInfo.getDocApplicant());
                    dccModApplyInfo.setDocApplicantName(sysOrgElement.getFdName());
                }

                if (null != dccModApplyInfo.getDocApplicantDept()) {//借阅人部门
                    dccModApplyInfo.setDocApplicantDeptName(dccApplyService.getDeptName(dccModApplyInfo.getDocApplicantDept()));
                }

                //归还信息
                CsotDccmodApplyBorrow borrow = mapper.getDccModApplyBorrow(fdId);
                dccModApplyInfo.setBorrow(borrow);

                //借阅文件列表
                List<CsotDccmodBorrowList> borrowList = mapper.getDccModBorrowList(fdId);
                if(null != borrowList && borrowList.size() > 0){
                    for(int i = 0 ; i < borrowList.size(); i++) {
                        CsotDccmodBorrowList borrowList1 = borrowList.get(i);
                        //文档信息
                        CsotDccmodDocumentMain documentMain = mapper.getDccModDcoMain(borrowList1.getFdDocId());
                        borrowList1.setDocumentMain(documentMain);
                    }
                }
                dccModApplyInfo.setBorrowLists(borrowList);

                //文件列表
                List<AttMain> fileList = utilMapper.getAttMain(fdId);
                if(null != fileList && fileList.size() > 0) {
                    for(int i = 0; i < fileList.size(); i++) {
                        AttMain file = fileList.get(i);
                        String fdKey = file.getFdKey();
                        if(null != fdKey && fdKey.trim().length() > 0) {
                            file.setFileDesc("审批补充附件");
                        }
                    }
                    dccModApplyInfo.setFileList(fileList);
                }
            }
            map.put("data", dccModApplyInfo);
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

    //新增申请
    public Map getDccModApplyNewInfo(String fdId,String tempId,String name){
        Map map = new HashMap();
        map.put("docStatus", "");
        map.put("data", "");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + name + "信息出错!";
        try {
            DccModApply dccModApplyInfo = mapper.getDccModApply(fdId);
            if(null != dccModApplyInfo) {
                dccModApplyInfo.setFdMemo(XmlUtil.ClobToString((Clob) dccModApplyInfo.getFdMemo()));
                if (null != dccModApplyInfo.getDocCreator()) {
                    SysOrgElement sysOrgElement = utilMapper.getSysOrgElement(dccModApplyInfo.getDocCreator());
                    dccModApplyInfo.setDocCreatorName(sysOrgElement.getFdName());//申请人
                }
                if (null != dccModApplyInfo.getFdCreateDept()) {
                    dccModApplyInfo.setFdCreateDeptName(dccApplyService.getDeptName(dccModApplyInfo.getDocCreator()));//申请人部门
                }

                if (null != dccModApplyInfo.getDocApplicant()) {//制订人
                    SysOrgElement sysOrgElement = utilMapper.getSysOrgElement(dccModApplyInfo.getDocApplicant());
                    dccModApplyInfo.setDocApplicantName(sysOrgElement.getFdName());
                }

                if (null != dccModApplyInfo.getDocApplicantDept()) {//制订人部门
                    dccModApplyInfo.setDocApplicantDeptName(dccApplyService.getDeptName(dccModApplyInfo.getDocApplicantDept()));
                }

                dccModApplyInfo.setDocMediaType(mapper.getDocMediaType(fdId));

                //适用单位
                List<String> baseDepts = mapper.getApplyBaseDept(fdId);
                List<SysOrgElement> baseDeptList = getOrgElementList(baseDepts);

                //会签部门
                List<String> relDepts = mapper.getApplyRelDept(fdId);
                List<SysOrgElement> relDeptList = getOrgElementList(relDepts);

                //分发阅览单位
                List<String> newDepts = mapper.getApplyNewDist(fdId);
                List<SysOrgElement> newDeptList = getOrgElementList(newDepts);

                //责任单位
                List<String> mainDepts = mapper.getApplyMainDept(fdId);
                List<SysOrgElement> mainDeptList = getOrgElementList(mainDepts);

                dccModApplyInfo.setBaseDeptList(baseDeptList);
                dccModApplyInfo.setRelDeptList(relDeptList);
                dccModApplyInfo.setNewDeptList(newDeptList);
                dccModApplyInfo.setMainDeptList(mainDeptList);

                //文件列表
                List<AttMain> fileList = utilMapper.getAttMain(fdId);
                if(null != fileList && fileList.size() > 0) {
                    for(int i = 0; i < fileList.size(); i++) {
                        AttMain file = fileList.get(i);
                        String fdKey = file.getFdKey();
                        if(null != fdKey && fdKey.trim().length() > 0) {
                            if("document".equals(fdKey)){
                                file.setFileDesc("文件上传");
                            }else if("attachment".equals(fdKey)){
                                file.setFileDesc("附件");
                            }else if("table".equals(fdKey)){
                                file.setFileDesc("表单上传");
                            }else {
                                file.setFileDesc("审批补充附件");
                            }
                        }
                    }
                    dccModApplyInfo.setFileList(fileList);
                }
                //参考文件
                List<DccModDocumentMain> refFileList = mapper.getRereferenceFiles(fdId);
                //参考表单
                List<DccModDocumentMain> refTableList = mapper.getRereferenceTables(fdId);

                dccModApplyInfo.setRefFileList(refFileList);
                dccModApplyInfo.setRefTableList(refTableList);
            }
            map.put("data", dccModApplyInfo);
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

    //改版申请
    private Map getDccApplyRevisionInfo(String fdId,String tempId,String name){
        Map map = new HashMap();
        map.put("docStatus", "");
        map.put("data", "");
        String status = "0";
        String desc = "";
        String errorMsg = "查询" + name + "信息出错!";
        try {
            DccModApply dccModApplyInfo = mapper.getDccModApply(fdId);
            if(null != dccModApplyInfo) {
                dccModApplyInfo.setFdMemo(XmlUtil.ClobToString((Clob) dccModApplyInfo.getFdMemo()));
                if (null != dccModApplyInfo.getDocCreator()) {
                    SysOrgElement sysOrgElement = utilMapper.getSysOrgElement(dccModApplyInfo.getDocCreator());
                    dccModApplyInfo.setDocCreatorName(sysOrgElement.getFdName());//申请人
                }
                if (null != dccModApplyInfo.getFdCreateDept()) {
                    dccModApplyInfo.setFdCreateDeptName(dccApplyService.getDeptName(dccModApplyInfo.getFdCreateDept()));//申请人部门
                }

                if (null != dccModApplyInfo.getDocApplicant()) {//制订人
                    SysOrgElement sysOrgElement = utilMapper.getSysOrgElement(dccModApplyInfo.getDocApplicant());
                    dccModApplyInfo.setDocApplicantName(sysOrgElement.getFdName());
                }

                if (null != dccModApplyInfo.getDocApplicantDept()) {//制订人部门
                    dccModApplyInfo.setDocApplicantDeptName(dccApplyService.getDeptName(dccModApplyInfo.getDocApplicantDept()));
                }

                //适用单位
                List<String> baseDepts = mapper.getApplyBaseDept(fdId);
                List<SysOrgElement> baseDeptList = getOrgElementList(baseDepts);
                dccModApplyInfo.setBaseDeptList(baseDeptList);

                //会签部门
                List<String> relDepts = mapper.getApplyRelDept(fdId);
                List<SysOrgElement> relDeptList = getOrgElementList(relDepts);
                dccModApplyInfo.setRelDeptList(relDeptList);

                //分发阅览单位
                List<String> newDepts = mapper.getApplyRedis(fdId);
                List<SysOrgElement> redisList = getOrgElementList(newDepts);
                dccModApplyInfo.setRedisDeptList(redisList);

                //参考文件
                List<DccModDocumentMain> refFileList = mapper.getRereferenceFiles(fdId);
                //参考表单
                List<DccModDocumentMain> refTableList = mapper.getRereferenceTables(fdId);

                dccModApplyInfo.setRefFileList(refFileList);
                dccModApplyInfo.setRefTableList(refTableList);

                //文件列表
                List<AttMain> fileList = utilMapper.getAttMain(fdId);
                if(null != fileList && fileList.size() > 0) {
                    for(int i = 0; i < fileList.size(); i++) {
                        AttMain file = fileList.get(i);
                        String fdKey = file.getFdKey();
                        if(null != fdKey && fdKey.trim().length() > 0) {
                            if("document".equals(fdKey)){
                                file.setFileDesc("新版表单");
                            }else if("revisionDoc".equals(fdKey)){
                                file.setFileDesc("新版履历");
                            }else {
                                file.setFileDesc("审批补充附件");
                            }
                        }
                    }
                    dccModApplyInfo.setFileList(fileList);
                }
            }
            map.put("data", dccModApplyInfo);
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

    private List<SysOrgElement> getOrgElementList(List<String> list){
        List<SysOrgElement> orgList = new ArrayList<>();
        if(null != list && list.size() > 0){
            for(int i = 0; i < list.size(); i ++) {
                String orgId = list.get(i);
                SysOrgElement org = utilMapper.getSysOrgElement(orgId);
                if(null != org){
                    orgList.add(org);
                }
            }
        }
        return orgList;
    }
}
