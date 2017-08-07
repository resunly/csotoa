package com.csot.csotoa.oaRest.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.csot.csotoa.oaRest.mapper.IOaRestMapper;
import com.csot.csotoa.oaRest.process.OaSZWFCommitProcess;
import com.csot.csotoa.oaRest.process.ProcessProcessor;
import com.csot.csotoa.oaRest.service.OaRestService;
import com.csot.csotoa.util.mapper.ICsotUtilMapper;
import com.csot.csotoa.utils.ObjectXML;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Created by liushiqi on 2017/6/16.
 */
@Component
public class OaRestServiceImpl implements OaRestService {

    private static final Logger logger = LoggerFactory.getLogger(OaRestServiceImpl.class);

    private static final String REVIEW_NODE = "reviewNode";
    private static final String MUST_MODIFY_HANDLER_NODE = "mustModifyHandlerNodeIds";

    @Autowired
    private IOaRestMapper oaRestMapper;

    @Autowired
    private ICsotUtilMapper csotUtilMapper;

    // 提交审批接口地址
    public static String Url = "http://10.108.29.17/mas-api/proxy?alias=oa.csot.updateToDoFlowStatus&SOAPAction=/ESB_MAS_MAS_UpdateToDoFlowStatusSrv/v1/process";

    // 驳回接口地址
    public static String Url2 = "http://10.108.29.17/mas-api/proxy?alias=oa.csot.updateToDoFlowStatusCustom&SOAPAction=/ESB_MAS_MAS_UpdateToDoFlowStatusCustomSrv/v1/process";

    @Override
    public String getTempletIdByfdId(String fdId) {
        String templateId = oaRestMapper.getTempletIdByfdId(fdId);
        if (null == templateId || templateId.length() == 0) {
            List list = oaRestMapper.getTemplateId(fdId);
            if (list.size() == 1) {
                templateId = String.valueOf(list.get(0));
            } else {
                templateId = "";
            }
        }
        return templateId;
    }

    @Override
    public String updateToDoFlowStatusCustom(String fdId, String fdFlowOpt, String fdFlowNote, String loginName,
                                             String toLoginNames, String extend) throws Exception {

        String url = null;
        if ("handler_refuse".equals(fdFlowOpt)) {// 驳回
            url = getRequestUrl1(Url2, fdId, fdFlowOpt, fdFlowNote, loginName, toLoginNames, extend);
        } else {// 其他
            url = getRequestUrl1(Url, fdId, fdFlowOpt, fdFlowNote, loginName, toLoginNames, extend);
        }

        // 1.判断流程是否支持移动端校验//移動到明細相中
        Map<String, String> maps = getCustomInfo(extend);
        /*
         * if (isMoblieEdit(fdId, maps.get("templateId"))) { return
		 * getReturnResult("当前流程节点不支持移动端编辑审批", "1"); }
		 */

        // 2.接口提交时参数必填校验
        String errorMsg = checkIsEmpty(fdId, fdFlowOpt, loginName, toLoginNames, extend);
        if (!StringUtils.isEmpty(errorMsg)) {
            return errorMsg;
        }


        // Map<String, String> map = setValue(fdId, fdFlowOpt, fdFlowNote,
        // loginName, toLoginNames, extend);
        //Map<String, String> customAttrMaps = getCustomInfo(extend);

        String result = "";
        // 是否需要编辑
        if (isEdit(maps)) {
            // 3.自定义必填校验,maps
            String checkMsg = checkCustomIsNotEmpty(fdId, maps);
            if (StringUtils.isNotEmpty(checkMsg)) {
                return getReturnResult(checkMsg, "1");
            }
            result = updateAndCommit(fdId, url, maps);
        } else {
            result = WebServicesClient(url);
        }
        return result;
    }

    /**
     * @param fdId       表单ID
     * @param templateId 表单对应的模板ID
     * @return 权限信息
     * @author hank.he 获得表单流程节点上的权限信息
     */
    @Override
    public Map<String, String> getPagePermit(String fdId, String templateId, String loginName) throws Exception {
        String html = oaRestMapper.getTemplatePage(templateId);
        // logger.info("html--->>" + html);
        if (StringUtils.isBlank(html)) {
            logger.info("--流程沒有对应的表单模板页面");
            return new HashMap<>();
        }

        String userId = csotUtilMapper.getIdByLoginName(loginName);
        if (StringUtils.isBlank(userId)) {
            logger.info("--查询不到登陆用户名称");
            return new HashMap<>();
        }

        //流程当前节点
        String node = getCurrentNode(fdId,userId);
        /*List<Map<String, String>> nodeItems = oaRestMapper.getSignFlowCurrentNode(fdId);
        if (nodeItems != null && nodeItems.size() != 0) {
            Map<String, String> nodeMap = new HashMap<>();
            if (nodeItems.size() == 1) {
                nodeMap = nodeItems.get(0);
                node = nodeMap.get("NODEID");
            }
            if (nodeItems.size() > 1) {
                Map<String, String> param = new HashMap<>();
                param.put("fdId", fdId);
                param.put("userId", userId);
                nodeMap = oaRestMapper.getFlowCurrentNode(param);
                if (nodeMap != null && !nodeMap.isEmpty()) {
                    node = nodeMap.get("NODEID");
                } else {
                    logger.info("--当前登陆人没有对应的当前节点！");
                    return new HashMap<>();
                }
            }
        } else {
            logger.info("--查询流程当前节点异常！");
            return new HashMap<>();
        }*/
        if (StringUtil.isBlank(node)) {
            logger.info("--没有查询到流程的当前节点！");
            return new HashMap<>();
        }
        Map<String, String> map = getWorkPermit(html, node);
        return map;
    }

    /**
     * 流程当前节点
     * @param fdId 流程id
     * @param userId 当前登陆人
     * @return node
     */
    private String getCurrentNode(String fdId, String userId) {
        String node = "";
        List<Map<String, String>> nodeItems = oaRestMapper.getSignFlowCurrentNode(fdId);
        if (nodeItems != null && nodeItems.size() != 0) {
            Map<String, String> nodeMap = new HashMap<>();
            if (nodeItems.size() == 1) {
                nodeMap = nodeItems.get(0);
                node = nodeMap.get("NODEID");
            }
            if (nodeItems.size() > 1) {
                Map<String, String> param = new HashMap<>();
                param.put("fdId", fdId);
                param.put("userId", userId);



                nodeMap = oaRestMapper.getFlowCurrentNode(param);
                if (nodeMap != null && !nodeMap.isEmpty()) {
                    node = nodeMap.get("NODEID");
                } else {
                    logger.info("--当前登陆人没有对应的当前节点！");
                }
            }
        } else {
            logger.info("--查询流程当前节点异常！");
        }
        return node;
    }

    /**
     * 检测流程当前结点是否要设置修改节点审核人
     *
     * @param fdId 流程id
     * @return true:未設置移動化需要攔截 or false:設置移動化，不需要攔截
     */
    @Override
    public boolean checkFlowNodeSet(String fdId, String userName) {
        // 1.检测流程当前结点是否要设置修改节点审核人
        boolean result = false;
        //current node
        String userId = csotUtilMapper.getIdByLoginName(userName);
        String crrentNode = getCurrentNode(fdId,userId);
        // 查询流程节点设置的属性
        Map<String, String> param = new HashMap<>();
        param.put("fdId", fdId); // 查詢參數
        param.put("node",crrentNode);
        //String noteStr = oaRestMapper.getFlowNodeSet(fdId);
        String noteStr = oaRestMapper.getFllowNodeSetByNode(param);

        // 解析xml,只解析含有<reviewNode 的节点信息
        if (StringUtils.isNotBlank(noteStr)) {
            if (noteStr.contains(REVIEW_NODE) && noteStr.contains(MUST_MODIFY_HANDLER_NODE)) {
                // 解析xml
                String node = checkXml(noteStr);
                String[] nodeArray = node.split(";");
                for (int i = 0; i < nodeArray.length; i++) {
                    String flowNode = nodeArray[i];
                    param.put("flowNodeId", flowNode);
                    List handList = oaRestMapper.getFlowNodeHandel(param);
                    if (handList != null && handList.size() > 0) {
                        result = true;
                    } else {
                        result = false;
                        break;
                    }
                }

            }
        }
        // 2.檢測13只流程，以及流程節點是否移動化
        String templateId = getTempletIdByfdId(fdId);
        if (!isMoblieEdit(fdId, templateId,userId) && !result) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 解析节点的xml,返回mustModifyHandlerNodeIds的属性值
     *
     * @param xml
     * @return
     */
    private String checkXml(String xml) {
        String node = "";
        org.dom4j.Document document = null;
        try {
            document = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        org.dom4j.Element root = document.getRootElement();
        String nodeString = root.attribute("mustModifyHandlerNodeIds").getStringValue();
        return nodeString;
    }

    /**
     * 截取jsp页面上在建立流程模板的时候的设置的权限部分
     *
     * @param html    流程模板设置的jsp
     * @param nodeStr 单据当前的流程节点
     * @return list
     */
    private Map<String, String> getWorkPermit(String html, String nodeStr) {
        // List<Map<String, String>> result = new ArrayList<>();
        Document doc = Jsoup.parse(html);
        Elements elements = doc.getElementsByTag("xform:right");
        ListIterator<Element> listIterator = (ListIterator<Element>) elements.listIterator();

        // 权限信息
        Map<String, String> attrMap = new HashMap<>();
        Map<String, String> node = new HashMap<>();

        while (listIterator.hasNext()) {

            Element element = listIterator.next();
            Attributes attributes = element.attributes();
            Iterator<Attribute> aIterator = attributes.iterator();
            boolean flag = false;
            String attr = "";

            while (aIterator.hasNext()) {
                Attribute attribute = aIterator.next();
                if (attribute.getKey().toLowerCase().equals("mode_" + nodeStr.toLowerCase())) {
                    if (attribute.getValue().equals("hidden") || attribute.getValue().equals("edit")) {
                        // node.put("node", attribute.getKey());
                        attr = attribute.getValue();
                        flag = true;
                    }
                }
            }
            // 字段信息
            if (flag) {
                Elements fieldItems = element.getAllElements();
                for (Element fieldItem : fieldItems) {
                    String property = fieldItem.attr("property");
                    if (property != null && property.startsWith("extendDataFormInfo.value(")) {
                        property = property.replace("extendDataFormInfo.value(", "").replace(")", "");
                        int lastDot = property.lastIndexOf(".");
                        if (lastDot > -1 && property.length() > (lastDot + 1)) {
                            property = property.substring(lastDot + 1);
                        }
                        node.put(property.toString(), attr);
                        // node.putAll(attrMap);
                    }
                    String propertyId = fieldItem.attr("propertyId");
                    if (propertyId != null && propertyId.startsWith("extendDataFormInfo.value(")) {
                        propertyId = propertyId.replace("extendDataFormInfo.value(", "").replace(")", "");
                        int lastDot = propertyId.lastIndexOf(".");
                        if (lastDot > -1 && propertyId.length() > (lastDot + 1)) {
                            propertyId = propertyId.substring(0, lastDot);
                        }
                        node.put(propertyId.toString(), attr);
                        // node.putAll(attrMap);
                    }
                }
            }
            // if (!node.isEmpty()) {
            // result.add(node);
            // }
        }
        return node;
    }

    public boolean succeed(String returnObj) {
        if (returnObj == null) {
            return false;
        }
        if (returnObj.indexOf("status&gt;0&lt;/status") > -1) {
            return true;
        }
        return false;
    }

    /**
     * 更新、提交自定义审批提交
     *
     * @param fdId
     * @param url
     * @param eidtMap
     * @return
     * @throws Exception
     */
    private String updateAndCommit(String fdId, String url, Map<String, String> eidtMap) throws Exception {
        logger.debug("Enter in updateFroms...");
        boolean isCommit = true;
        boolean isUpdate = true;
        // 处理自定义审批提交字符串，封装为xml格式
        String dateXml = modifyDateXml(fdId, eidtMap);
        String result = "";
        if (StringUtils.isEmpty(dateXml)) {
            isUpdate = false;
        } else {
            result = WebServicesClient(url);
        }
        // 发起提交审批 ???Todo:dateXml什么情况下是true？？
       /* if ("true".equals(dateXml)) {
            return WebServicesClient(url);
        }*/
        if (!succeed(result)) {
            JSONObject json = JSONObject.fromObject(result);
            return json.getString("data");
        }
        // 审批成功修改表单信息
        if (isCommit && isUpdate) {
            String tableName = getTableName(fdId);
            oaRestMapper.updateDateXml(tableName, dateXml, fdId);
            return getReturnResult("流程审批成功", "0");
        }
        return getReturnResult("流程提交失败", "1");
    }

    /**
     * 是否支持移动端编辑审批提交
     *
     * @param fdId
     * @return
     */
    public boolean isMoblieEdit(String fdId, String templateId,String userId) {
        // logger.info("Enter in isMoblieEdit...");
        boolean isEdit = false;
        List<String> lists = getEditNode(templateId);
        //String userId = csotUtilMapper.getIdByLoginName(userName);
        String currNode = getCurrentNode(fdId,userId);
        if (StringUtils.isEmpty(currNode)) {
            return true;
        }
        if (!CollectionUtils.isEmpty(lists)) {
            if (lists.contains(currNode)) {
                return true;
            }
        }
        return isEdit;
    }

    /**
     * 获取接口地址
     *
     * @param fdId
     * @param fdFlowOpt
     * @param fdFlowNote
     * @param loginName
     * @param toLoginNames
     * @param extend
     * @return
     */
    public static Map<String, String> setValue(String fdId, String fdFlowOpt, String fdFlowNote, String loginName,
                                               String toLoginNames, String extend) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("fdId", fdId);
        map.put("fdFlowOpt", fdFlowOpt);
        map.put("fdFlowNote", fdFlowNote);
        map.put("loginName", loginName);

        // 转办人
        if (!StringUtils.isEmpty(toLoginNames)) {
            map.put("toLoginNames", toLoginNames);
        }
        // 自定义处理
        if (!StringUtils.isEmpty(extend)) {
            map.put("extend", extend);
        }
        return map;
    }

    /**
     * 获取审批提交接口地址
     *
     * @param map
     * @return
     */
    public static String getRequestUrl(Map<String, String> map) {

        // logger.info("Enter in getUrl...");

        if (!CollectionUtils.isEmpty(map)) {
            StringBuffer urlBuffer = new StringBuffer(Url);
            urlBuffer.append("&fdId=");
            urlBuffer.append(map.get("fdId"));
            urlBuffer.append("&fdFlowOpt=");
            urlBuffer.append(map.get("fdFlowOpt"));
            urlBuffer.append("&fdFlowNote=");
            urlBuffer.append(map.get("fdFlowNote"));
            urlBuffer.append("&loginName=");
            urlBuffer.append(map.get("loginName"));
            urlBuffer.append("&extend=");
            urlBuffer.append(map.get("extend"));

            if (!StringUtils.isEmpty(map.get("toLoginNames"))) {
                urlBuffer.append("&toLoginNames=");
                urlBuffer.append(map.get("toLoginNames"));
            }
            String url = urlBuffer.toString();
            // logger.info("getUrl:" + url);
            return url;
        }
        return null;
    }

    /**
     * 获取审批提交接口地址
     *
     * @param fdId
     * @param fdFlowOpt
     * @param loginName
     * @param toLoginNames
     * @param extend
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getRequestUrl1(String url, String fdId, String fdFlowOpt, String fdFlowNote, String loginName,
                                        String toLoginNames, String extend) throws UnsupportedEncodingException {

        StringBuffer urlBuffer = new StringBuffer(url);
        urlBuffer.append("&fdId=").append(URLEncoder.encode(fdId, "UTF-8"));
        urlBuffer.append("&fdFlowOpt=").append(URLEncoder.encode(fdFlowOpt, "UTF-8"));
        urlBuffer.append("&fdFlowNote=").append(URLEncoder.encode(fdFlowNote, "UTF-8"));
        urlBuffer.append("&loginName=").append(URLEncoder.encode(loginName, "UTF-8"));
        urlBuffer.append("&toLoginNames=").append(URLEncoder.encode(toLoginNames, "UTF-8"));
        urlBuffer.append("&extend=").append(URLEncoder.encode(extend, "UTF-8"));
        return urlBuffer.toString();
    }

    /**
     * <<<<<<< .mine======= * 获取驳回接口地址
     *
     * @param fdId
     * @param fdFlowOpt
     * @param loginName
     * @param toLoginNames
     * @param extend
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getRequestUrl2(String fdId, String fdFlowOpt, String fdFlowNote, String loginName,
                                        String toLoginNames, String extend) throws UnsupportedEncodingException {

        StringBuffer urlBuffer = new StringBuffer(Url2);
        urlBuffer.append("&fdId=").append(URLEncoder.encode(fdId, "UTF-8"));
        urlBuffer.append("&fdFlowOpt=").append(URLEncoder.encode(fdFlowOpt, "UTF-8"));
        urlBuffer.append("&fdFlowNote=").append(URLEncoder.encode(fdFlowNote, "UTF-8"));
        urlBuffer.append("&loginName=").append(URLEncoder.encode(loginName, "UTF-8"));
        urlBuffer.append("&toLoginNames=").append(URLEncoder.encode(toLoginNames, "UTF-8"));
        urlBuffer.append("&extend=").append(URLEncoder.encode(extend, "UTF-8"));

        return urlBuffer.toString();
    }

    /**
     * >>>>>>> .theirs * 获取自定义信息
     *
     * @param extend
     * @return
     */
    public static Map<String, String> getCustomInfo(String extend) {
        // logger.info("Enter in updateFromInfo...");
        Map<String, String> infoMap = new HashMap<String, String>();
        // logger.info("extend:" + extend);
        if (StringUtils.isEmpty(extend)) {
            return infoMap;
        }
        JSONObject obj = JSONObject.fromObject(extend);
        if (obj == null) {
            return infoMap;
        }
        String templateId = obj.optString("templateId");
        infoMap.put("templateId", templateId);

        String editList = obj.optString("editList");
        infoMap.put("editList", editList);

        String resultParam = obj.optString("resultParam");
        infoMap.put("resultParam", resultParam);

        if (logger.isDebugEnabled()) {
            System.out.println("templateId:" + templateId);
            System.out.println("editStr:" + editList);
            System.out.println("resultParam:" + resultParam);
        }

        if (StringUtils.isNotEmpty(editList)) {
            JSONObject editStrObj = JSONObject.fromObject(editList);
            if (editStrObj != null) {
                // 文本数据
                String edit = editStrObj.optString("editText");
                // 多选数据
                String chekBox = editStrObj.optString("checkboxs");
                // 表格数据
                String table = editStrObj.optString("editTable");

                if (StringUtils.isNotEmpty(edit)) {
                    infoMap.put("editText", edit);
                }
                if (StringUtils.isNotEmpty(chekBox)) {
                    infoMap.put("checkboxs", chekBox);
                }
                if (StringUtils.isNotEmpty(table)) {
                    infoMap.put("editTable", table);
                }
            }
        }
        return infoMap;
    }

    /**
     * 提交审批接口
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static String WebServicesClient(String url) throws Exception {

        // logger.info("Enter in WebServicesClient...");

        if (!StringUtils.isEmpty(url)) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost method = new HttpPost(url);
            logger.info("Request url:" + String.valueOf(method.getURI()));
            HttpResponse result = httpClient.execute(method);
            if (result.getStatusLine().getStatusCode() == 200) {
                try {
                    String str = EntityUtils.toString(result.getEntity());
                    // logger.info("WebServicesClient return:" + str);
                    return str;
                } catch (Exception e) {
                    logger.error("请求提交失败", e);
                }
            }
        }
        return null;
    }

    /**
     * 封装返回消息
     *
     * @param msg    成功或者失败提示
     * @param status 状态 0：成功 1：失败
     * @return
     */
    public static String getReturnResult(String msg, String status) {
        StringBuffer errorBuff = new StringBuffer();
        errorBuff.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        errorBuff.append("<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">");
        errorBuff.append("<SOAP-ENV:Body>");
        errorBuff.append(
                "<ns0:updateToDoFlowStatusSrvResponse xmlns:ns0=\"http://www.csot.tcl.com/ESB_MAS_MAS_UpdateToDoFlowStatusSrv/1.0\">");
        errorBuff.append("<ns0:return>&lt;?xml version=\"1.0\" encoding=\"UTF-8\"?&gt;");
        errorBuff.append("&lt;dataList&gt;");
        errorBuff.append("&lt;desc&gt;");
        errorBuff.append(msg);
        errorBuff.append("&lt;/desc&gt;");
        errorBuff.append("&lt;status&gt;");
        errorBuff.append(status);
        errorBuff.append("&lt;/status&gt;");
        errorBuff.append("&lt;/dataList&gt;");
        errorBuff.append("</ns0:return>");
        errorBuff.append("</ns0:updateToDoFlowStatusSrvResponse>");
        errorBuff.append("</SOAP-ENV:Body>");
        errorBuff.append("</SOAP-ENV:Envelope>");
        return errorBuff.toString();
    }

    /**
     * 修改xml内容
     *
     * @param fdId    流程id
     * @param editMap 可编辑属性Map
     * @return
     * @throws Exception
     */
    public String modifyDateXml(String fdId, Map<String, String> editMap) throws Exception {
        logger.debug("Enter in modifyDateXml... ");
        JSONObject jsObj = JSONObject.fromObject(editMap.get("editText"));
        JSONObject checkBoxJson = JSONObject.fromObject(editMap.get("checkboxs"));
        String table = editMap.get("editTable");
        JSONObject tableJson = JSONObject.fromObject(table);
        List<String> tempNames = getTemplateNames(editMap.get("templateId"));

        HashMap<String, String> maps = toHashMap(jsObj);
        // 根据流程id获取流程信息表名
        String tableName = getTableName(fdId);
        if (StringUtils.isEmpty(tableName)) {
            return tableName;
        }
        String dateXml = getBasicInfoXml(tableName, fdId);
        List extendList = ObjectXML.objectXMLDecoderByString(dateXml);
        logger.debug("extendList:" + extendList);
        if (CollectionUtils.isEmpty(extendList)) {
            return null;
        }
        ProcessProcessor processor = new ProcessProcessor(oaRestMapper);
        String newDateXmlStr = "";
        Map<String, Object> extendDataMap = (Map<String, Object>) extendList.get(0);
        if (CollectionUtils.isEmpty(extendDataMap) || CollectionUtils.isEmpty(tempNames)) {
            return null;
        } else if (tempNames.contains("外勤申请")) {
            newDateXmlStr = OaSZWFCommitProcess.modifyCsotHrMainXmlData(extendDataMap, maps);
        } else if (tempNames.contains("加班审批")) {
            if (StringUtils.isNotEmpty(table)) {
                Object arr = JSONObject.fromObject(table).get("work_detail");
                newDateXmlStr = OaSZWFCommitProcess.modifyCsotHrMainXmlData(extendDataMap, JSONArray.fromObject(arr));
            }
        } else if (tempNames.contains("出差/驻厂申请")) {
            newDateXmlStr = OaSZWFCommitProcess.modifyCsotHrMainEvectionXmlData(extendDataMap, maps);
        } else if (tempNames.contains("报关业务委托单")) {

            HashMap<String, String> checkBoxDef = toHashMap(checkBoxJson);
            checkBoxDef.put("fd_zdfh", "User");

            extendDataMap = processor.processCheckBox(extendDataMap, checkBoxJson, checkBoxDef);
            newDateXmlStr = ObjectXML.objectXmlEncoder(extendDataMap);

        } else if (tempNames.contains("来宾进入CSOT管制区申请")) {
            newDateXmlStr = OaSZWFCommitProcess.modifyKmReviewMain_CSOTManage_XmlData(extendDataMap, maps);
        } else if (tempNames.contains("备品备件领料")) {
            HashMap<String, String> detailTableAttrDef = new HashMap<String, String>();
            // detailTableAttrDef.put("fdBDTER", "Date");
            detailTableAttrDef.put("fd_is_emergency", "boolean");
            extendDataMap = processor.processText(extendDataMap, jsObj, detailTableAttrDef);
            newDateXmlStr = ObjectXML.objectXmlEncoder(extendDataMap);
            // newDateXmlStr =
            // OaSZWFCommitProcess.modifyKmReviewMain_CSOTManage_XmlData(extendDataMap,
            // maps);
        } else if ((tempNames.contains("特采申请")) || (tempNames.contains("供应商主数据申请流程"))
                || (tempNames.contains("客户主数据创建申请")) || (tempNames.contains("备品备件退库至不良品"))) {// table:id
            newDateXmlStr = OaSZWFCommitProcess.modifyCsotSpecialPurchaseXmlData(extendDataMap, maps);
        } else if (tempNames.contains("备品备件退库至备件维修")) {// table:fdId
            // {"templateId":"1429edd690f696cee4eee824e8a9f221","opts":{},"editList":{"editText":{"fd_3130c1bfde94c2":"iuo"},"checkboxs":{},"editTable":{"work_detail":[{"fd_is_baoshui":"是","fd_baoshui_no":"435","fdId":"15d77cf96ce48df7f965af341f080262"}]}}}

            if (tableJson == null) {
                return newDateXmlStr = ObjectXML.objectXmlEncoder(extendDataMap);
            } else {
                extendDataMap = processor.processText(extendDataMap, jsObj, null);
                HashMap<String, String> detailTableAttrDef = new HashMap<String, String>();
                detailTableAttrDef.put("fd_is_baoshui", "boolean");
                JSONArray array = tableJson.getJSONArray("fdItemDetails");
                extendDataMap = processor.processTable(extendDataMap, array, "fdItemDetails", "fdId",
                        detailTableAttrDef);
                newDateXmlStr = ObjectXML.objectXmlEncoder(extendDataMap);
            }
        } else if (tempNames.contains("请假申请")) {// table:id
            // editTable={"fd_detail_form":[{"fdId":"15d7c99a1e4ee79fcf1feeb4fbfa9dec","fd_change_leave":"是"}]}

            if (tableJson == null) {
                return newDateXmlStr = ObjectXML.objectXmlEncoder(extendDataMap);
            } else {
                HashMap<String, String> detailTableAttrDef = new HashMap<String, String>();
                detailTableAttrDef.put("fd_change_leave", "boolean");
                JSONArray array = tableJson.getJSONArray("fd_detail_form");
                extendDataMap = processor.processTable(extendDataMap, array, "fd_detail_form", "fdId",
                        detailTableAttrDef);
                newDateXmlStr = ObjectXML.objectXmlEncoder(extendDataMap);
            }
        } else if (tempNames.contains("备品备件借料")) {
            newDateXmlStr = OaSZWFCommitProcess.modifyKmReviewMain_Borrow_XmlData(extendDataMap, maps);
        }
        return newDateXmlStr;
    }

    /**
     * 校验自定义参数是否为空
     *
     * @param fdId
     * @param maps
     * @return
     */
    public String checkCustomIsNotEmpty(String fdId, Map<String, String> maps) {
        // logger.info("Enter in checkCustomIsNotEmpty...");
        StringBuffer checkMsg = new StringBuffer();
        List<String> tempNames = getTemplateNames(maps.get("templateId"));
        JSONObject jsonObj = JSONObject.fromObject(maps.get("editText"));
        JSONObject jsonCheckBox = JSONObject.fromObject(maps.get("checkboxs"));
        String node = getCurrNode(fdId);
        if (CollectionUtils.isEmpty(tempNames)) {
            checkMsg.append("流程对应模板不存在或页面必填属性不能为空");
        } else if (StringUtils.isEmpty(node)) {
            checkMsg.append("该流程暂未发起审批提交");
        } else if (tempNames.contains("外勤申请") && "N7".equalsIgnoreCase(node)) {
            if (CollectionUtils.isEmpty(maps)) {
                checkMsg.append("实际开始日期和实际结束日期不能为空！");
            } else {
                if (StringUtils.isEmpty(jsonObj.optString("fd_real_start"))
                        || StringUtils.isEmpty(jsonObj.optString("fd_real_shour"))
                        || StringUtils.isEmpty(jsonObj.optString("fd_real_sminute"))) {
                    checkMsg.append("实际开始日期不能为空");
                } else if (StringUtils.isEmpty(jsonObj.optString("fd_real_end"))
                        || StringUtils.isEmpty(jsonObj.optString("fd_real_ehour"))
                        || StringUtils.isEmpty(jsonObj.optString("fd_real_eminute"))) {
                    checkMsg.append("实际结束日期不能为空");
                }
            }
        } else if (tempNames.contains("出差/驻厂申请") && "N20".equalsIgnoreCase(node)) {
            if (StringUtils.isEmpty(jsonObj.optString("fd_real_start"))) {
                checkMsg.append("请输入 实际开始日期");
            } else if (StringUtils.isEmpty(jsonObj.optString("fd_real_end"))) {
                checkMsg.append("请输入 实际结束日期");
            } else if (StringUtils.isEmpty(jsonObj.optString("fd_real_day"))
                    || StringUtils.isEmpty(jsonObj.optString("fd_real_night"))) {
                checkMsg.append("请输入 实际期限天或实际期限夜");
            } else if (StringUtils.isEmpty(jsonObj.optString("fd_2ef318839938e6"))) {
                checkMsg.append("请选择 驻厂地是否提供用餐或用车");
            }
        } else if (tempNames.contains("报关业务委托单") && "N5".equalsIgnoreCase(node)) {
            if (StringUtils.isEmpty(jsonCheckBox.optString("fd_zdfh"))) {
                checkMsg.append("请输入 报关员复核指定");
            }
        } else if (tempNames.contains("来宾进入CSOT管制区申请") && ("N26".equalsIgnoreCase(node) || "N27".equalsIgnoreCase(node) // OK
                || "N28".equalsIgnoreCase(node) || "N29".equalsIgnoreCase(node) || "N34".equalsIgnoreCase(node)
                || "N37".equalsIgnoreCase(node) || "N47".equalsIgnoreCase(node))) {
            if (StringUtils.isEmpty(jsonObj.optString("fd_real_intime"))) {
                checkMsg.append("请输入 实际进厂时间");
            } else if (StringUtils.isEmpty(jsonObj.optString("fd_real_outtime"))) {
                checkMsg.append("请输入 实际出厂时间");
            }
        } else if (tempNames.contains("备品备件领料") && "N5".equalsIgnoreCase(node)) {
            if (StringUtils.isEmpty(jsonObj.optString("fd_is_emergency"))) {
                checkMsg.append("是否紧急领料内容不能为空");
            }
        } else if (tempNames.contains("特采申请")) {
            if ("N9".equalsIgnoreCase(node) && StringUtils.isEmpty(jsonObj.optString("fd_2f861304d840c0"))) {
                checkMsg.append("请输入 客户结果回复（CQA填写）");
            } else if ("N34".equalsIgnoreCase(node) && StringUtils.isEmpty(jsonObj.optString("fd_2f861380c0312a"))) {
                checkMsg.append("请输入 PQC结案确认");
            }
        } else if (tempNames.contains("供应商主数据申请流程")) {
            if ("N12".equalsIgnoreCase(node)) {
                if (StringUtils.isEmpty(jsonObj.optString("fd_supplier_no"))) {
                    checkMsg.append("请输入 供应商编号");
                }
            }

        } else if (tempNames.contains("客户主数据申请流程") && "N5".equalsIgnoreCase(node)) {
            if (StringUtils.isEmpty(jsonObj.optString("fd_bank_code1"))) {
                checkMsg.append("请输入 银行代码1");
            } else if (StringUtils.isEmpty(jsonObj.optString("fd_bank_code2"))) {
                checkMsg.append("请输入 银行代码2");
            } else if (StringUtils.isEmpty(jsonObj.optString("fd_bank_code3"))) {
                checkMsg.append("请输入 银行代码3");
            }
        } else if (tempNames.contains("备品备件退库至备件维修")) {
            if ("N7".equalsIgnoreCase(node)) { // 校验PO单号
                String value = jsonObj.optString("fd_3130c1bfde94c2");
                if (StringUtils.isEmpty(value)) {
                    checkMsg.append("请输入 PO单号");
                }
            }
            if ("N12".equalsIgnoreCase(node)) { // 是否保税品 保税品数量
                String value1 = jsonObj.optString("fd_is_baoshui");
                if (StringUtils.isEmpty(value1)) {
                    checkMsg.append("请输入 是否保税品");
                }
                String value2 = jsonObj.optString("fd_baoshui_no");
                if (StringUtils.isEmpty(value2)) {
                    checkMsg.append("请输入 保税品数量");
                }
            }
        } else if (tempNames.contains("备品备件退库至不良品") && "N8".equalsIgnoreCase(node)) {
            if (CollectionUtils.isEmpty(maps)) {
                checkMsg.append("PO单号内容不能为空");
            } else {
                if (StringUtils.isEmpty(jsonObj.optString("fd_3130c1bfde94c2"))) {
                    checkMsg.append("PO单号内容不能为空");
                }
            }
        } else if (tempNames.contains("备品备件借料")) {
            if ("N4".equalsIgnoreCase(node)) { // 校验PO单号
                String value1 = jsonObj.optString("fd_return_type");
                if (StringUtils.isEmpty(value1)) {
                    checkMsg.append("请输入 归还类型");
                }
                String value2 = jsonObj.optString("fd_return_date");
                if (StringUtils.isEmpty(value2)) {
                    checkMsg.append("请输入 需归还日期");
                }
            }
        } else if (tempNames.contains("请假申请")
                && ("N89".equalsIgnoreCase(node) || "N52".equalsIgnoreCase(node) || "N5".equalsIgnoreCase(node))) {
            if (StringUtils.isEmpty(jsonObj.optString("fd_change_leave"))) {
                checkMsg.append("请选择 是否有证明");
            }
        }
        String resultMsg = checkMsg.toString();
        if (StringUtils.isNotEmpty(resultMsg)) {
            return resultMsg;
        }
        return checkMsg.toString();
    }

    /**
     * 将json格式的字符串解析成Map对象
     * <li>json格式：{"name":"admin","retries":"3fff","testname"
     * :"ddd","testretries":"fffffffff"}
     */
    public static HashMap<String, String> toHashMap(Object object) {
        HashMap<String, String> data = new HashMap<String, String>();
        // 将json字符串转换成jsonObject
        JSONObject jsonObject = JSONObject.fromObject(object);
        //modify by xiangdong.he at 2017/07/31 add condition "jsonObject.size() > 0"
        if (jsonObject != null && jsonObject.size() > 0) {
            Iterator it = jsonObject.keys();
            // 遍历jsonObject数据，添加到Map对象
            while (it.hasNext()) {
                String key = String.valueOf(it.next());
                String value = String.valueOf(jsonObject.get(key));
                data.put(key, value);
            }
        }
        return data;
    }

    /**
     * 根据流程id获取表名称
     *
     * @param fdId
     * @return
     */
    public String getTableName(String fdId) {
        // logger.info("Enter in getTableName...");
        // logger.info("getTableName fdId:" + fdId);
        Map<String, String> tableMaps = new HashMap<String, String>();
        String mapKey = oaRestMapper.getModelName(fdId);
        // logger.info("mapKey:" + mapKey);
        tableMaps.put("com.landray.kmss.csot.hr.model.CsotHrMain", "csot_hr_main");
        tableMaps.put("com.landray.kmss.csot.revers.model.CsotReversMain", "csot_revers_main");
        tableMaps.put("com.landray.kmss.km.review.model.KmReviewMain", "km_review_main");
        tableMaps.put("com.landray.kmss.csot.special.model.CsotSpecialPurchase", "csot_special_purchase");
        String tableName = tableMaps.get(mapKey);
        logger.debug("getTableName  mapKey:" + mapKey + " tableName:" + tableName);
        return tableName;
    }

    /**
     * 流程审批必填参数校验
     *
     * @param fdId
     * @param fdFlowOpt
     * @param loginName
     * @return
     */
    public static String checkIsEmpty(String fdId, String fdFlowOpt, String loginName, String toLoginNames,
                                      String extend) {
        // logger.info("Enter in checkIsEmpty...");
        StringBuffer notEmptyMsg = new StringBuffer();
        // 流程ID
        if (StringUtils.isEmpty(fdId)) {
            notEmptyMsg.append("流程ID不能为空 ");
        }
        // 操作
        if (StringUtils.isEmpty(fdFlowOpt)) {
            notEmptyMsg.append("操作类型不能为空 ");
        }
        // 登录名称
        if (StringUtils.isEmpty(loginName)) {
            notEmptyMsg.append("登录名称不能为空");
        }

        // 流程模板不能为空
        Map<String, String> map = getCustomInfo(extend);
        if (StringUtils.isEmpty(map.get("templateId"))) {
            notEmptyMsg.append("流程模板ID获取失败 ");
        }

        // 驳回时，驳回节点是否为空
        if ("handler_refuse".equals(fdFlowOpt.trim())) {
            if (StringUtils.isEmpty(map.get("resultParam"))) {
                notEmptyMsg.append("resultParam 不能为空 ");
            }
        }

        // 沟通时，校验沟通人是否为空
        if ("handler_communicate".equals(fdFlowOpt.trim())) {
            if (StringUtils.isEmpty(toLoginNames)) {
                notEmptyMsg.append("沟通人不能为空 ");
            }
        }

        // 错误信息
        String errorMsg = notEmptyMsg.toString();
        if (!StringUtils.isEmpty(errorMsg)) {
            return getReturnResult(errorMsg, "1");
        }
        return errorMsg;
    }

    /**
     * 校验是否需要编辑
     *
     * @param editMaps
     * @return
     */
    public static Boolean isEdit(Map<String, String> editMaps) {
        logger.info("Enter in isEdit...");
        boolean flag = true;
        // 此次之校验文本格式
        String editAttr = editMaps.get("editText");
        String tabel = editMaps.get("editTable");
        String checkboxs = editMaps.get("checkboxs"); // TODO: 2017/7/19 预留
        /*if (StringUtils.isEmpty(editAttr) ) {
            return !flag;
        }*/
        // 校验表格是否有值
        if (StringUtils.isBlank(checkboxs) && StringUtils.isBlank(tabel) && StringUtils.isBlank(editAttr)) {
            flag = false;
        } else {
            if (StringUtils.isNotBlank(tabel)) {
                JSONObject obj = JSONObject.fromObject(tabel);
                for (Object entry : obj.keySet()) {
                    Object value = obj.get(entry);
                    if (value != null && !value.equals("")) {
                        JSONArray araay = JSONArray.fromObject(value);
                        if (araay == null && araay.size() == 0) {
                            flag = false;
                        }
                    }
                }
            }
            if (StringUtils.isNotBlank(editAttr)) {
                JSONObject jsObj = JSONObject.fromObject(editAttr);
                HashMap<String, String> maps = toHashMap(jsObj);
                if (!CollectionUtils.isEmpty(maps)) {
                    // map 存在value值全部为空的情况
                    Iterator<Map.Entry<String, String>> it = maps.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<String, String> entry = it.next();
                        if (StringUtils.isEmpty(entry.getValue())) {
                            flag = false;
                            break;
                        }
                    }
                }
            }
        }
        return flag;
    }

    /**
     * 获取表单基本信息返回xml
     *
     * @param fdId
     * @return
     */
    public String getBasicInfoXml(String tableName, String fdId) {

        String fromBasicInfoXmlStr = oaRestMapper.getDateXml(tableName, fdId);
        return fromBasicInfoXmlStr;
    }

    /**
     * 获取当前节点信息
     *
     * @param fdId
     * @return
     */
    public String getCurrNode(String fdId) {
        // logger.info("Enter in getCurrNode...");
        String nodeId = oaRestMapper.getCurrNode(fdId);
        return nodeId;
    }

    /**
     * 根据模板id获取流程流程不可编辑的节点
     *
     * @param templateId
     * @return
     */
    public List<String> getEditNode(String templateId) {
        // logger.info("Enter in getNotEditNodes ...");
        // logger.info("templateId" + templateId);
        List<String> lists = oaRestMapper.getEditNodes(templateId);
        return lists;
    }

    /**
     * 根据模板id获取流程流程不可编辑的节点
     *
     * @param templateId
     * @return
     */
    public List<String> getTemplateNames(String templateId) {
        // logger.info("Enter in getNotEditNodes ...");
        // logger.info("templateId" + templateId);
        List<String> lists = oaRestMapper.getTemplateNames(templateId);
        return lists;
    }

}
