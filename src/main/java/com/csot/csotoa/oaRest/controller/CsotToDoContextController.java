package com.csot.csotoa.oaRest.controller;

import com.csot.csotoa.carapplication.service.ICsotCarApplicationService;
import com.csot.csotoa.managedisb.service.impl.CsotManageDisbServiceImpl;
import com.csot.csotoa.managehkpay.service.ICsotManageHKPayService;
import com.csot.csotoa.managepay.service.impl.CsotManagePayServiceImpl;
import com.csot.csotoa.managetax.service.impl.KmCsotManageTaxMainService;
import com.csot.csotoa.oaRest.service.OaRestService;
import com.csot.csotoa.process.bean.RejectNode;
import com.csot.csotoa.process.service.IProcessService;
import com.csot.csotoa.process.service.impl.ProcessServiceImpl;
import com.csot.csotoa.tpm.service.impl.TpmMainServiceImpl;
import com.csot.csotoa.util.CsotToDoContextUtil;
import com.csot.csotoa.dccmodapply.service.impl.DccModApplyImpl;
import com.csot.csotoa.general.service.GeneralServiceImpl;
import com.csot.csotoa.hr.service.impl.CsotHrServiceImpl;
import com.csot.csotoa.dccapply.service.impl.DccApplyServiceImpl;
import com.csot.csotoa.manageborrow.service.impl.CsotManageBorrowMainSercviceImpl;
import com.csot.csotoa.monthplan.service.Impl.MonthPlanCategoryServiceImpl;
import com.csot.csotoa.pocategory.service.impl.PoCategoryServiceImpl;
import com.csot.csotoa.prcategory.service.impl.PrCategoryServiceImpl;
import com.csot.csotoa.revers.service.impl.CsotReversMainServiceImpl;
import com.csot.csotoa.specialpurchase.service.impl.SpecialPurchaseServiceImpl;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/CsotMainApplication")
public class CsotToDoContextController {
    private static final Logger logger = LoggerFactory.getLogger(CsotToDoContextController.class);
    @Autowired
    private ProcessServiceImpl processService;

    @Autowired
    private CsotReversMainServiceImpl reversService;

    @Autowired
    private DccApplyServiceImpl dccApplyService;

    @Autowired
    private CsotHrServiceImpl csotHrService;

    @Autowired
    private GeneralServiceImpl generalService;

    @Autowired
    private MonthPlanCategoryServiceImpl monthPlanCategoryService;

    @Autowired
    private PoCategoryServiceImpl poCategoryService;

    @Autowired
    private PrCategoryServiceImpl prCategoryService;

    @Autowired
    private DccModApplyImpl dccModApply;

    @Autowired
    private SpecialPurchaseServiceImpl purchaseService;

    @Autowired
    private CsotManageBorrowMainSercviceImpl borrowMainSercvice;

    @Autowired
    private KmCsotManageTaxMainService taxMainService;

    @Autowired
    private TpmMainServiceImpl tpmMainService;

    @Autowired
    private CsotManageDisbServiceImpl disbService;

    @Autowired
    private CsotManagePayServiceImpl payService;

    @Autowired
    private ICsotCarApplicationService carApplicationService;

    @Autowired
    private ICsotManageHKPayService hkPayService;

    @Autowired
    private OaRestService oaService;

    @RequestMapping(value = "/getOperationList", method = RequestMethod.GET)
    public String getOperateList(@RequestParam(value = "processId", required = true) String processId,
                                 @RequestParam(value = "loginName", required = true) String loginName) {
        logger.info("查询操作项，流程ID:" + processId);
        String operateStr = processService.getOperationStr(processId, loginName);
        return operateStr;
    }

    @RequestMapping(value = "/getToDoContentInfo", method = RequestMethod.GET)
    public String getToDoContentInfo(@RequestParam(value = "templateId", required = true) String templateId,
                                     @RequestParam(value = "fdId", required = true) String fdId,
                                     @RequestParam(value = "loginName", required = true) String loginName,
                                     @RequestParam(value = "extend", required = false) String extend) {
        Map map = new HashMap();
        String isApproval = "1";
        String isShowFlow = "1";
        String isCustom = "0";
        String showModel = "";
        String begin = "<ns2:getToDoContentInfoResponse xmlns:ns2=\"http://***/\">\n<return>\n";
        String end = "\n</return>\n</ns2:getToDoContentInfoResponse>";

        map.put("isApproval", isApproval);
        map.put("isShowFlow", isShowFlow);
        map.put("isCustom", isCustom);
        map.put("showModel", showModel);
        String processName = "";

        try {
            if (null == fdId || fdId.length() == 0 || null == templateId || templateId.length() == 0) {
                map.put("status", "1");
                map.put("desc", "模板ID和流程实例ID不能为空！");
                return begin + new Gson().toJson(map) + end;
            }
            Object serviceName = CsotToDoContextUtil.scopeMap.get(templateId);
            if (null != serviceName) {
                String[] services = serviceName.toString().split(" ");
                String name = services[0];
                String label = services[1];
                logger.info("fdId:" + fdId + " templateId:" + templateId + " " + name + " " + label);
                processName = name;
                if ("CsotReversMainServiceImpl".equals(name)) {
                    map = reversService.getCsotReversMainById(fdId, templateId, label);
                } else if ("DccApplyServiceImpl".equals(name)) {
                    map = dccApplyService.getDccApplyInfo(fdId, templateId, label);
                } else if ("CsotHrMainServiceImpl".equals(name)) {
                    map = csotHrService.getCsotHrInfo(fdId, templateId, label);
                } else if ("GeneralServiceImpl".equals(name)) {
                    map = generalService.getGeneralInfo(fdId, templateId, label);
                } else if ("MonthlyPlanCategoryServiceImpl".equals(name)) {
                    map = monthPlanCategoryService.getMonthPlanInfo(fdId, templateId, label);
                } else if ("CsotPoCategoryServiceImpl".equals(name)) {
                    map = poCategoryService.getCsotPoMain(fdId,templateId,label);
                } else if ("CsotPrCategoryServiceImpl".equals(name)) {
                    map = prCategoryService.getCsotPrMain(fdId,templateId,label);
                } else if ("CsotDccmodApplyServiceImpl".equals(name)) {
                    map = dccModApply.getDccModApply(fdId, templateId, label);
                } else if ("SpecialPurchaseServiceImpl".equals(name)) {
                    map = purchaseService.getSpecialPurchase(fdId, label);
                } else if ("CsotManageBorrowMainSercviceImpl".equals(name)) {
                    map = borrowMainSercvice.getCostManageBorrowMainInfo(fdId, label);
                } else if ("ManageTaxCategoryServiceImpl".equals(name)) {
                    map = taxMainService.getKmCostManageTaxMainInfo(fdId, label);
                } else if ("TpmMainServiceImpl".equals(name)) {
                    map = tpmMainService.getTpmMainInfo(fdId,templateId,label);
                } else if ("CsotManageDisbServiceImpl".equals(name)) {
                    map = disbService.getCsotManageDisbInfo(fdId, label);
                } else if ("CsotManagePayServiceImpl".equals(name)) {
                    map = payService.getCostManagePayInfo(fdId, label);
                } else if ("CsotCarApplicationServiceImpl".equals(name)) {
                    map = carApplicationService.getCostCarInfo(fdId, label);
                } else if ("CsotmanageHKPayServiceImpl".equals(name)) {
                    map = hkPayService.getHKPayServiceInfo(fdId, label);
                }
                //获取可以驳回的节点
                getCutstomMap(map, fdId);

                //頁面權限部分
                Map<String, String> permitList = oaService.getPagePermit(fdId, templateId, loginName);
                map.put("permitList", permitList);

                //流程节点上是否设置修改其他流程节点的处理人信息
                boolean result = oaService.checkFlowNodeSet(fdId,loginName);
                map.put("mustModifyHandler", result);
            } else {
                logger.error("模板ID:" + templateId + "不正确！");
            }
        } catch (Exception e) {
            logger.error("查询[" + processName + "]流程详细信息出错！", e);
            e.printStackTrace();
        }
        return begin + new Gson().toJson(map) + end;
    }

    private Map getCutstomMap(Map map, String fdId) {
        List<RejectNode> rejectNodeList = processService.getRejectNodes(fdId);
        Map customDetail = new HashMap();
        customDetail.put("infType", "handler_refuse");
        List optionList = new ArrayList();
        boolean isDefault = true;
        for (int i = 0; i < rejectNodeList.size(); i++) {
            Map optMap = new HashMap();
            optMap.put("isDefault", isDefault);
            List optChilds = new ArrayList();
            Map optChildMap = new HashMap();
            optChildMap.put("cCode", "returnToThisNode");
            optChildMap.put("isDefault", true);
            optChildMap.put("cName", "再次提交返回本节点");
            optChilds.add(optChildMap);

            Map optChildMap2 = new HashMap();
            optChildMap2.put("cCode", "returnToFirstNode");
            optChildMap2.put("isDefault", false);
            optChildMap2.put("cName", "再次提交重新审批");
            optChilds.add(optChildMap2);

            optMap.put("optChilds", optChilds);

            RejectNode rejectNode = rejectNodeList.get(i);

            optMap.put("name", rejectNode.getNodeId() + "." + rejectNode.getNodeName());
            optMap.put("code", rejectNode.getNodeId());
            optionList.add(optMap);
            isDefault = false;
        }
        customDetail.put("options", optionList);
        Map detailMap = new HashMap();

        Object[] objects = new Object[1];
        objects[0] = customDetail;
        detailMap.put("opts", objects);
        map.put("customDetail", detailMap);
        return map;
    }
}
