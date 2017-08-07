package com.csot.csotoa.util;

import java.util.HashMap;
import java.util.Map;

public class CsotToDoContextUtil {
    public static Map scopeMap = new HashMap();
    static {
        scopeMap.put("1429e136aaeef5fb910ae114314851bc","CsotReversMainServiceImpl 备品备件转仓");
        scopeMap.put("14337c1bbbf332e0e3c923b4580b289f","CsotReversMainServiceImpl 备品备件退库至备件非常规报废");
        scopeMap.put("1429ed495c1bda69977a3d540c09556d","CsotReversMainServiceImpl 备品备件退库至不良品");
        scopeMap.put("1429ddeec9f1a60861390824f1e95f19","CsotReversMainServiceImpl 备品备件借料");
        scopeMap.put("1429dd1425bc079b0f8dfd04a2b95a0b","CsotReversMainServiceImpl 备品备件领料");
        scopeMap.put("1433724a31cdcf9d4457d7142a3a3a58","CsotReversMainServiceImpl 备品备件退库至备件常规报废");
        scopeMap.put("1429e17a1836dcafd0ab54843d1a3348","CsotReversMainServiceImpl 备品备件退库至良品仓");
        scopeMap.put("1429edd690f696cee4eee824e8a9f221","CsotReversMainServiceImpl 备品备件退库至备件维修");
        scopeMap.put("1366114483819eae6a6d04a4aad99d1e","CsotReversMainServiceImpl Cell资料出库预留单");
        scopeMap.put("13660fdc71180412c919cca4900a717f","CsotReversMainServiceImpl 预留单");

        scopeMap.put("133a17407cc959921621855459694297","DccApplyServiceImpl 新增申请");
        scopeMap.put("133a1e429cf80fb28bcd09f42b681a88","DccApplyServiceImpl 借阅申请");
        scopeMap.put("133a1cbfe760edb4f9a3e9d473284673","DccApplyServiceImpl 改版申请");

        scopeMap.put("13f88598d24c672105df43241e29e7d1","CsotDccmodApplyServiceImpl 借阅申请");
        scopeMap.put("13f885c121588bea0f3959b47249b6ae","CsotDccmodApplyServiceImpl 新增申请");
        scopeMap.put("13f8861400552dbe7631eb34dcfa6d65","CsotDccmodApplyServiceImpl 改版申请");

        scopeMap.put("145ac0443a2b1514a0c95db4f65b76ae","CsotHrMainServiceImpl 外勤申请");
        scopeMap.put("145ac02ab1c7e9ac869d9314fcfa0069","CsotHrMainServiceImpl 刷卡异常因私补签");
        scopeMap.put("145ab30e3b716bc8736dcf34f35a5a55","CsotHrMainServiceImpl 请假申请");
        scopeMap.put("145ab0f015782a624ba7edf4c9580f6d","CsotHrMainServiceImpl 离职申请流程");
        scopeMap.put("145aaf0b0e3ebf796a34074407589f64","CsotHrMainServiceImpl 出差/驻厂申请");
        scopeMap.put("145a78a80cfb5a6b9662db84926b5bcc","CsotHrMainServiceImpl 职员试用期转正");
        scopeMap.put("145a7855ba5c250b1cb9fa14eb994d72","CsotHrMainServiceImpl 排班申请");
        scopeMap.put("145a704c79a36b49d8aa9054a8083d27","CsotHrMainServiceImpl 内部调动");
        scopeMap.put("145a653b22c733ee53356e24cd7922b1","CsotHrMainServiceImpl 晋级晋等流程");
        scopeMap.put("145a6450c633f658d0ca885424a987bc","CsotHrMainServiceImpl 加班审批");
        scopeMap.put("145a6137abec314b7dc8e9f42b09c3c0","CsotHrMainServiceImpl 调班申请");

        scopeMap.put("13668c75f961cd0ef5dd09f4f96a7494","GeneralServiceImpl 一般文件签核");

        scopeMap.put("1365e820e69c1afa471d5cc4008bb723","MonthlyPlanCategoryServiceImpl 零星采购申请");
        scopeMap.put("143afaea3ff4364b53aa9fc406ab1138","CsotPoCategoryServiceImpl 采购订单审批单");
        scopeMap.put("143af69893bc1b5a0e027194cee8deb2","CsotPrCategoryServiceImpl 采购申请单");

        scopeMap.put("138e764fcf34f2d37d420414fefa0dba","SpecialPurchaseServiceImpl 特采申请");

        scopeMap.put("134d1afe1d7ca814286857a4a78aa985","CsotManageBorrowMainSercviceImpl 借款申请");
        scopeMap.put("13c1f189d7407e8cc516cc845df9d686","CsotManageBorrowMainSercviceImpl 借款补单申请");

        scopeMap.put("13f4fd5609797b177439582453a88aa0","ManageTaxCategoryServiceImpl 银关通付款流程");
        scopeMap.put("14960d042f308f783e175164bc9aafdd","ManageTaxCategoryServiceImpl t2设备分期付税流程");
        scopeMap.put("139d7e13e633a6406181bb945f58b027","ManageTaxCategoryServiceImpl 海关关税增值税保证金付款流程");
        scopeMap.put("1464a969fa7a741ff05f91145c48c0cc","ManageTaxCategoryServiceImpl 汇总征税付款流程");


        scopeMap.put("1465c6b874f0143d528ef7b4bb1b3ef7","TpmMainServiceImpl 提案改善系统申请");

        scopeMap.put("134d1eb00341bd4815ee14641e8aa2dc","CsotManagePayServiceImpl 无采购订单付款流程");
        scopeMap.put("134d1eb77c316cc6cc491eb437496aa0","CsotManagePayServiceImpl 预付款流程");
        scopeMap.put("134d1ec392ec01086627c0f446b8a605","CsotManagePayServiceImpl 有采购订单发票拆分付款流程");
        scopeMap.put("150ef5c8c040720e429ecc34296b8f79","CsotManagePayServiceImpl 专利付款预付流程");
        scopeMap.put("14c9de1c0a16cd1ddca5bb74add9930a","CsotManagePayServiceImpl 工艺设备到货付款流程");
        scopeMap.put("14c9de256a7be355a86ea6946ca9f7bc","CsotManagePayServiceImpl 工艺设备验收款/尾款支付流程");
        scopeMap.put("14c202bbf6b78e832b9161c4c22bea13","CsotManagePayServiceImpl 有采购订单的付款审批单");

        scopeMap.put("13a9adef1879f24cfb36541494e99cd8","CsotCarApplicationServiceImpl 商务车使用流程");

        scopeMap.put("146997ce02dd2c969331e47447c8faf4","CsotmanageHKPayServiceImpl 香港采购部门业务预付款流程");
        scopeMap.put("14699888109a4c4455545c64085bcdae","CsotmanageHKPayServiceImpl 香港其他业务部门支付流程");
        scopeMap.put("13a780abe39480f90532b7b4fc2948ad","CsotmanageHKPayServiceImpl 香港采购部门业务付款流程（对账平台上线前校验单）");
        scopeMap.put("151af8e3719c5fecb7946a44ea690c1c","CsotmanageHKPayServiceImpl 香港采购部门业务付款流程（对账平台上线后匹配单）");

        scopeMap.put("134d1c60759f678d935fbb8451abbdac","CsotManageDisbServiceImpl 差旅费用报销");
        scopeMap.put("134d1c4ea875485a63e493b4d7a9c32e","CsotManageDisbServiceImpl 日常费用报销");
    }

}
