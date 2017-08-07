package com.csot.csotoa.process.service.impl;

import com.csot.csotoa.process.bean.LbpmProcess;
import com.csot.csotoa.process.bean.WorkItem;
import com.csot.csotoa.process.mapper.IProcessMapper;
import com.csot.csotoa.process.service.IProcessService;
import com.csot.csotoa.util.XmlUtil;
import com.csot.csotoa.util.bean.LbpmNode;
import com.csot.csotoa.util.bean.SysOrgElement;
import com.csot.csotoa.util.mapper.ICsotUtilMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
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
public class ProcessServiceImpl implements IProcessService{
    Logger logger = LoggerFactory.getLogger(ProcessServiceImpl.class);
    @Autowired
    IProcessMapper processMapper;

    @Autowired
    ICsotUtilMapper utilMapper;

    @Override
    public String getOperationStr(String processId,String loginName){
        String result = "";
        String begin = "<return><dataList><status>";
        String status = "0";
        String end = "</handle></dataList></return>";
        String review = "reviewWorkitem";
        String communicat = "communicateWorkitem";

        String loginId = utilMapper.getIdByLoginName(loginName);
        List<WorkItem> workItemList = processMapper.getWorkItem(processId,loginId,"","","");
        //查询代理
        if(null == workItemList || workItemList.size() == 0){
            String proxyLoginId = processMapper.getProxyId(processId,loginId);
            if(null != proxyLoginId) {
                workItemList = processMapper.getWorkItem(processId, proxyLoginId, "", "","");
                if(workItemList.size() > 0){
                    loginId = proxyLoginId;
                }
            }
        }
        //查询授权
        if(null == workItemList || workItemList.size() == 0){
            String authorizer = processMapper.getAuthorizer(processId,loginId);
            if(null != authorizer) {
                workItemList = processMapper.getWorkItem(processId, authorizer, "", "","");
                if(workItemList.size() > 0){
                    loginId = authorizer;
                }
            }
        }
        try{
            if(null != workItemList && workItemList.size() > 0){
                String operStr = "";
                for(int i = 0; i < workItemList.size(); i ++){
                    WorkItem workItem = workItemList.get(i);
                    String activityType = workItem.getFdActivityType();

                    if(review.equals(activityType)){
                        List<WorkItem> childWorkItemList = processMapper.getWorkItem(processId,"",workItem.getFdId(),communicat,"");
                        if(childWorkItemList.size() > 0){
                            //result = "handler_communicate;handler_cancelCommunicate";
                            //operStr = "handler_cancelCommunicate";
                            operStr = "取消沟通";
                        }else{
                            List list = new ArrayList();
                            List currentNodeList = processMapper.getCurrentNode(processId,loginId);
                            if(currentNodeList.size() > 0){
                                Object fdContent = processMapper.getFdContent(processId,currentNodeList.get(0).toString());
                                String xml = XmlUtil.ClobToString((Clob)fdContent);
                                String operationId = XmlUtil.getNodeAttValue(xml,"operations","refId");
                                if(null != operationId && operationId.length() > 0){
                                    list = processMapper.getOperationList(operationId);
                                }else{
                                    operStr = XmlUtil.getOperationStr(xml,"operations");
                                }
                            }
                            if(list.size() > 0){
                                for(int j = 0; j < list.size(); j++){
                                    LbpmProcess process = (LbpmProcess)list.get(j);
                                    if(operStr.length() > 0){
                                        //operStr = operStr + ";" + process.getOperType();
                                        operStr = operStr + ";" + process.getOperName();
                                    }else{
                                        //operStr = process.getOperType();
                                        operStr = process.getOperName();
                                    }
                                }
                            }
                        }
                    }else if(communicat.equals(activityType)){
                        List<WorkItem> parentWorkItem = processMapper.getWorkItem(processId,"","","",workItem.getFdParentId());
                        //operStr = "handler_returnCommunicate";
                        operStr = "回复沟通";
                    }
                    if(result.length() > 0){
                        result = result + ";" + operStr;
                    }else {
                        result = operStr;
                    }
                }
            }
        }catch (Exception e){
            status = "1";
            logger.error("查询流程操作列表出错!" ,e);
        }
        return begin + status + "</status><handle>" + result + end;
    }

    @Override
    public List getRejectNodes(String processId){
        return processMapper.getRejectNodes(processId);
    }
}
