package com.csot.csotoa.oaRest.controller;

import java.util.HashMap;
import java.util.Map;

import com.csot.csotoa.util.mapper.ICsotUtilMapper;
import org.jsoup.helper.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.csot.csotoa.config.TemplateDateUtil;
import com.csot.csotoa.oaRest.service.OaRestService;

/**
 * Created by hank.he on 2017/6/15.
 */
@RestController
@RequestMapping(value = "/oaRest")
public class OaRestMapperController {
    private static final Logger logger = LoggerFactory.getLogger(OaRestMapperController.class);

    @Autowired
    private OaRestService oaRestService;

    @Autowired
    private TemplateDateUtil templateDateUtil;

    /**
     * 根据单据ID查询单据表单使用的模板ID
     *
     * @param fdId     单据ID
     * @param callback
     * @return 模板ID
     * @author hank.he
     * @date
     */
    @RequestMapping(value = "/getTemplateId", method = RequestMethod.GET)
    public Map<String, Object> getTemplateIdByFdId(@RequestParam(value = "fdId", required = true) String fdId, @RequestParam(value = "callback", required = false) String callback) {
        String msgCode = "200";
        //模板ID
        String templateId = "";
        //是否配置移动
        boolean flag = false;
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("callback", callback);

        if (!StringUtils.isEmpty(fdId)) {
            try {
                templateId = oaRestService.getTempletIdByfdId(fdId);
                //check 是否有配置移动化
                if(!StringUtil.isBlank(templateId)){
                    flag = templateDateUtil.checkTemplate(templateId);
                }
            } catch (Exception e) {
                msgCode = "205";
                logger.error("查詢異常，fdId：" + fdId, e.getMessage());
            }
        } else {
            msgCode = "205";
        }
        returnMap.put("templateId", templateId);
        returnMap.put("isMobile",flag);
        returnMap.put("msgCode", msgCode);
        return returnMap;
    }

    /**
     * 标准流程模版在审核节点设置的页面权限
     * @param fdId 流程ID
     * @param templateId 流程所用模板
     * @param loginName 系统登陆用户
     * @param callback callback
     * @return {key:value} key:页面标签ID，key:hidden/edit
     */
    @RequestMapping(value = "/getPagePermit", method = RequestMethod.GET)
    public Map<String, Object> getPagePermit(@RequestParam(value = "fdId", required = true) String fdId,
                                             @RequestParam(value = "templateId", required = true) String templateId,
                                             @RequestParam(value = "loginName", required = true) String loginName,
                                             @RequestParam(value = "callback", required = false) String callback) {
        String msgCode = "200";
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("callback", "callback");

        if (!StringUtils.isEmpty(fdId) && !StringUtils.isEmpty(templateId)) {
            try {
                //标准流程页面权限
                Map<String, String> pagePermit = oaRestService.getPagePermit(fdId,templateId,loginName);
                returnMap.put("permitList",pagePermit);

                //流程节点上是否设置修改其他流程节点的处理人信息
                boolean result = oaRestService.checkFlowNodeSet(fdId,loginName);
                returnMap.put("mustModifyHandler", result);

            } catch (Exception e) {
                msgCode = "205";
                logger.error("查詢pagePermit異常", e.getMessage());
            }
        } else {
            msgCode = "205";
            logger.error("查詢参数異常");
        }
        returnMap.put("msgCode", msgCode);
        return returnMap;
    }


    /**
     * @param fdId 流程详情id(不能为空)
     * @param fdFlowOpt 审批人流程处理方式(不能为空)，前台传参内容如：
     *      通过:handler_pass
     *      驳回：handler_refuse
     *      沟通：handler_communicate
     *      转办：handler_commission
     * @param fdFlowNote 流程处理意见(不能为空)
     * @param loginName 用户登录名(不能为空);
     * @param toLoginNames 转办、沟通用户登录名,多个用户名用“;”隔开;
     * @param extend
     * @return
     */
    @RequestMapping(value = "/updateToDoFlowStatusCustom", method = RequestMethod.GET)
    public String updateToDoFlowStatusCustom(String fdId, String fdFlowOpt, String fdFlowNote, String loginName, String toLoginNames, String extend) throws Exception {

        logger.info("Process Start...");
        logger.info("fid:" + fdId);
        logger.info("fdFlowOpt:" + fdFlowOpt);
        logger.info("fdFlowNote:" + fdFlowNote);
        logger.info("loginName:" + loginName);
        logger.info("toLoginNames:" + toLoginNames);
        logger.info("extend:" + extend);

        String returnMsg = oaRestService.updateToDoFlowStatusCustom(fdId, fdFlowOpt, fdFlowNote, loginName, toLoginNames, extend);

        logger.info("Process Finished:" + returnMsg);

        return returnMsg;
    }

}
