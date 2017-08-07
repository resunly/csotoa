package com.csot.csotoa.managepay.bean;

import com.csot.csotoa.manageborrow.bean.CsotDictData;
import com.csot.csotoa.util.bean.AttMain;

import java.util.List;

public class CsotManagePayMain {
    private String fdId;
    private String fdPaymenttype;
    private String fdOpenBankName;
    private String fdProvinceOfBank;
    private String fdCityOfBank;
    private String fdProposerDept;
    private String fdBankfiliale;
    private String fdUnrepayment;
    private String fdTax;
    private String fdSapStatus;
    private String fdSapMessage;
    private String fdPoNo;
    private String fdInvoiceNo;
    private String fdBudgetNo;
    private String fdPayDate;
    private String fdCreatorPhoneno;
    private String fdEmpNo;
    private String fdEmpName;
    private String fdEmpDept;
    private String fdEmpDeptno;
    private String fdEmpPost;
    private String fdPrintState;
    private String fdPrintTotal;
    private String fdCheckMoney;
    private String fdLcMoney;
    private String fdMoneyHome;
    private String fdCollectingMoney;
    private String fdActualMoney;
    private String fdCheckDescrip;
    private String fdLcDescrip;
    private String fdCollectingDescrip;
    private String fdMoneyCapital;
    private String fdActualMoneyCapital;
    private String fdQuitsMoneyCapital;
    private String fdChargeType;
    private String fdLedgerFlag;
    private String hasBill;
    private String accModeId;
    private String docSubject;
    private String fdVoucherNumber;
    private String fNumber;
    private String budgetNeeded;
    private String docCreateTime;
    private String fdPayTime;
    private String docAlterTime;
    private String fdOpenAccountBank;
    private String fdApplyNumber;
    private String fdBankAccount;
    private String fdDescrip;
    private String fdVoucherState;
    private String fdCountMoney;
    private String fdAttCount;
    private String fdCashDescrip;
    private String fdOtherDescrip;
    private String fdBankPayState;
    private String docStatus;
    private String fdBankMoney;
    private String authAttNodownload;
    private String authAttNocopy;
    private String authAttNoprint;
    private String fdCash;
    private String fdOtherMoney;
    private String fdAccountPeriod;
    private String fdBankDescrip;
    private String fdQuitsPrePaymentMoney;
    private String fdQuitsPrePaymentDesc;
    private String authReaderFlag;
    private String fdChargeDetailId;
    private String fdChargeDetailName;
    private String fdReasonCodeId;
    private String fdLedgerId;
    private String fdCurrency;
    private String fdRoe;
    private String fdCollecting;
    private String fdLc;
    private String fdCheck;
    private String fdPayeeId;
    private String fdCashSubject;
    private String fdBankSubject;
    private String docCreatorId;
    private String docCreatorName;
    private String docCreatorNo;
    private String getDocCreatorName;
    private String fdDeptId;
    private String docAlterId;
    private String docAlterName;
    private String fdItemId;
    private String fdFactPayId;
    private String fdBankId;
    private String docCategoryId;
    private String getDocCategoryName;
    private String fdProposerId;
    private String fdProposerName;
    private String fdProposerNo;
    private String fdOtherId;
    private String fdPayeePerson;
    private String fdBudgetFlag;
    private String fdTaxFlag;
    private String fdPersonPositionId;
    private String fdPersonPositionName;
    private String fdMonEndStatus;
    private String fdSapStatusMonEnd;
    private String fdSapMessageMonEnd;
    private String fdVoucherDate;
    private String fdFproductState;
    private String docPublishTime;
    private String fdPrepayFlag;
    private String fdJason;
    private String fdRole;
    private String fdIsRead;
    private String isCsf;
    private String fdCsf;
    private String fdTaketaxtype;
    private String fdIsProa;
    private String fdSupplierNo;
    private String fdPurchaseOrg;
    private String fdIsUrgent;
    private String fdIsDirectBank;
    private String fdLedgerBankAccNo;
    private String fdLedgerBank;
    private String fdLedgerBankName;
    private String fdPayeeSupplier;
    private String fdPayeeSupplierName;
    private String fdEquipmentAccNo;
    private String fdEquipmentPayType;
    private String fdProcessType;
    private String fdDeductionMoney;
    private String fdIsContract;
    private String fdContractNumber;
    private String fdContractMoney;
    private String fdNoContractReason;
    private String fdPayCategory;
    private String fdPayProportion;
    private String fdBarcodeStatus;
    private String projectApplicant;
    private String projectApplicantName;
    private String fdSwiftCode;
    private CsotDictData dictData;
    private List<CsotManageFeeDetail> detail;
    private List<CsotManagePrePay> prePayList;
    private List<AttMain> fileList;
    private List<CsotManagePayPatDetail> payPatDetailList;
    private List<CsotManagePayEquipment> payEquipmentList;
    private List<CsotManagePayGysDz> payGysDzList;

    public String getFdId() {
        return fdId;
    }

    public void setFdId(String fdId) {
        this.fdId = fdId;
    }

    public String getFdPaymenttype() {
        return fdPaymenttype;
    }

    public void setFdPaymenttype(String fdPaymenttype) {
        this.fdPaymenttype = fdPaymenttype;
    }

    public String getFdOpenBankName() {
        return fdOpenBankName;
    }

    public void setFdOpenBankName(String fdOpenBankName) {
        this.fdOpenBankName = fdOpenBankName;
    }

    public String getFdProvinceOfBank() {
        return fdProvinceOfBank;
    }

    public void setFdProvinceOfBank(String fdProvinceOfBank) {
        this.fdProvinceOfBank = fdProvinceOfBank;
    }

    public String getFdCityOfBank() {
        return fdCityOfBank;
    }

    public void setFdCityOfBank(String fdCityOfBank) {
        this.fdCityOfBank = fdCityOfBank;
    }

    public String getFdProposerDept() {
        return fdProposerDept;
    }

    public void setFdProposerDept(String fdProposerDept) {
        this.fdProposerDept = fdProposerDept;
    }

    public String getFdBankfiliale() {
        return fdBankfiliale;
    }

    public void setFdBankfiliale(String fdBankfiliale) {
        this.fdBankfiliale = fdBankfiliale;
    }

    public String getFdUnrepayment() {
        return fdUnrepayment;
    }

    public void setFdUnrepayment(String fdUnrepayment) {
        this.fdUnrepayment = fdUnrepayment;
    }

    public String getFdTax() {
        return fdTax;
    }

    public void setFdTax(String fdTax) {
        this.fdTax = fdTax;
    }

    public String getFdSapStatus() {
        return fdSapStatus;
    }

    public void setFdSapStatus(String fdSapStatus) {
        this.fdSapStatus = fdSapStatus;
    }

    public String getFdSapMessage() {
        return fdSapMessage;
    }

    public void setFdSapMessage(String fdSapMessage) {
        this.fdSapMessage = fdSapMessage;
    }

    public String getFdPoNo() {
        return fdPoNo;
    }

    public void setFdPoNo(String fdPoNo) {
        this.fdPoNo = fdPoNo;
    }

    public String getFdInvoiceNo() {
        return fdInvoiceNo;
    }

    public void setFdInvoiceNo(String fdInvoiceNo) {
        this.fdInvoiceNo = fdInvoiceNo;
    }

    public String getFdBudgetNo() {
        return fdBudgetNo;
    }

    public void setFdBudgetNo(String fdBudgetNo) {
        this.fdBudgetNo = fdBudgetNo;
    }

    public String getFdPayDate() {
        return fdPayDate;
    }

    public void setFdPayDate(String fdPayDate) {
        this.fdPayDate = fdPayDate;
    }

    public String getFdCreatorPhoneno() {
        return fdCreatorPhoneno;
    }

    public void setFdCreatorPhoneno(String fdCreatorPhoneno) {
        this.fdCreatorPhoneno = fdCreatorPhoneno;
    }

    public String getFdEmpNo() {
        return fdEmpNo;
    }

    public void setFdEmpNo(String fdEmpNo) {
        this.fdEmpNo = fdEmpNo;
    }

    public String getFdEmpName() {
        return fdEmpName;
    }

    public void setFdEmpName(String fdEmpName) {
        this.fdEmpName = fdEmpName;
    }

    public String getFdEmpDept() {
        return fdEmpDept;
    }

    public void setFdEmpDept(String fdEmpDept) {
        this.fdEmpDept = fdEmpDept;
    }

    public String getFdEmpDeptno() {
        return fdEmpDeptno;
    }

    public void setFdEmpDeptno(String fdEmpDeptno) {
        this.fdEmpDeptno = fdEmpDeptno;
    }

    public String getFdEmpPost() {
        return fdEmpPost;
    }

    public void setFdEmpPost(String fdEmpPost) {
        this.fdEmpPost = fdEmpPost;
    }

    public String getFdPrintState() {
        return fdPrintState;
    }

    public void setFdPrintState(String fdPrintState) {
        this.fdPrintState = fdPrintState;
    }

    public String getFdPrintTotal() {
        return fdPrintTotal;
    }

    public void setFdPrintTotal(String fdPrintTotal) {
        this.fdPrintTotal = fdPrintTotal;
    }

    public String getFdCheckMoney() {
        return fdCheckMoney;
    }

    public void setFdCheckMoney(String fdCheckMoney) {
        this.fdCheckMoney = fdCheckMoney;
    }

    public String getFdLcMoney() {
        return fdLcMoney;
    }

    public void setFdLcMoney(String fdLcMoney) {
        this.fdLcMoney = fdLcMoney;
    }

    public String getFdMoneyHome() {
        return fdMoneyHome;
    }

    public void setFdMoneyHome(String fdMoneyHome) {
        this.fdMoneyHome = fdMoneyHome;
    }

    public String getFdCollectingMoney() {
        return fdCollectingMoney;
    }

    public void setFdCollectingMoney(String fdCollectingMoney) {
        this.fdCollectingMoney = fdCollectingMoney;
    }

    public String getFdActualMoney() {
        return fdActualMoney;
    }

    public void setFdActualMoney(String fdActualMoney) {
        this.fdActualMoney = fdActualMoney;
    }

    public String getFdCheckDescrip() {
        return fdCheckDescrip;
    }

    public void setFdCheckDescrip(String fdCheckDescrip) {
        this.fdCheckDescrip = fdCheckDescrip;
    }

    public String getFdLcDescrip() {
        return fdLcDescrip;
    }

    public void setFdLcDescrip(String fdLcDescrip) {
        this.fdLcDescrip = fdLcDescrip;
    }

    public String getFdCollectingDescrip() {
        return fdCollectingDescrip;
    }

    public void setFdCollectingDescrip(String fdCollectingDescrip) {
        this.fdCollectingDescrip = fdCollectingDescrip;
    }

    public String getFdMoneyCapital() {
        return fdMoneyCapital;
    }

    public void setFdMoneyCapital(String fdMoneyCapital) {
        this.fdMoneyCapital = fdMoneyCapital;
    }

    public String getFdActualMoneyCapital() {
        return fdActualMoneyCapital;
    }

    public void setFdActualMoneyCapital(String fdActualMoneyCapital) {
        this.fdActualMoneyCapital = fdActualMoneyCapital;
    }

    public String getFdQuitsMoneyCapital() {
        return fdQuitsMoneyCapital;
    }

    public void setFdQuitsMoneyCapital(String fdQuitsMoneyCapital) {
        this.fdQuitsMoneyCapital = fdQuitsMoneyCapital;
    }

    public String getFdChargeType() {
        return fdChargeType;
    }

    public void setFdChargeType(String fdChargeType) {
        this.fdChargeType = fdChargeType;
    }

    public String getFdLedgerFlag() {
        return fdLedgerFlag;
    }

    public void setFdLedgerFlag(String fdLedgerFlag) {
        this.fdLedgerFlag = fdLedgerFlag;
    }

    public String getHasBill() {
        return hasBill;
    }

    public void setHasBill(String hasBill) {
        this.hasBill = hasBill;
    }

    public String getAccModeId() {
        return accModeId;
    }

    public void setAccModeId(String accModeId) {
        this.accModeId = accModeId;
    }

    public String getDocSubject() {
        return docSubject;
    }

    public void setDocSubject(String docSubject) {
        this.docSubject = docSubject;
    }

    public String getFdVoucherNumber() {
        return fdVoucherNumber;
    }

    public void setFdVoucherNumber(String fdVoucherNumber) {
        this.fdVoucherNumber = fdVoucherNumber;
    }

    public String getfNumber() {
        return fNumber;
    }

    public void setfNumber(String fNumber) {
        this.fNumber = fNumber;
    }

    public String getBudgetNeeded() {
        return budgetNeeded;
    }

    public void setBudgetNeeded(String budgetNeeded) {
        this.budgetNeeded = budgetNeeded;
    }

    public String getDocCreateTime() {
        return docCreateTime;
    }

    public void setDocCreateTime(String docCreateTime) {
        this.docCreateTime = docCreateTime;
    }

    public String getFdPayTime() {
        return fdPayTime;
    }

    public void setFdPayTime(String fdPayTime) {
        this.fdPayTime = fdPayTime;
    }

    public String getDocAlterTime() {
        return docAlterTime;
    }

    public void setDocAlterTime(String docAlterTime) {
        this.docAlterTime = docAlterTime;
    }

    public String getFdOpenAccountBank() {
        return fdOpenAccountBank;
    }

    public void setFdOpenAccountBank(String fdOpenAccountBank) {
        this.fdOpenAccountBank = fdOpenAccountBank;
    }

    public String getFdApplyNumber() {
        return fdApplyNumber;
    }

    public void setFdApplyNumber(String fdApplyNumber) {
        this.fdApplyNumber = fdApplyNumber;
    }

    public String getFdBankAccount() {
        return fdBankAccount;
    }

    public void setFdBankAccount(String fdBankAccount) {
        this.fdBankAccount = fdBankAccount;
    }

    public String getFdDescrip() {
        return fdDescrip;
    }

    public void setFdDescrip(String fdDescrip) {
        this.fdDescrip = fdDescrip;
    }

    public String getFdVoucherState() {
        return fdVoucherState;
    }

    public void setFdVoucherState(String fdVoucherState) {
        this.fdVoucherState = fdVoucherState;
    }

    public String getFdCountMoney() {
        return fdCountMoney;
    }

    public void setFdCountMoney(String fdCountMoney) {
        this.fdCountMoney = fdCountMoney;
    }

    public String getFdAttCount() {
        return fdAttCount;
    }

    public void setFdAttCount(String fdAttCount) {
        this.fdAttCount = fdAttCount;
    }

    public String getFdCashDescrip() {
        return fdCashDescrip;
    }

    public void setFdCashDescrip(String fdCashDescrip) {
        this.fdCashDescrip = fdCashDescrip;
    }

    public String getFdOtherDescrip() {
        return fdOtherDescrip;
    }

    public void setFdOtherDescrip(String fdOtherDescrip) {
        this.fdOtherDescrip = fdOtherDescrip;
    }

    public String getFdBankPayState() {
        return fdBankPayState;
    }

    public void setFdBankPayState(String fdBankPayState) {
        this.fdBankPayState = fdBankPayState;
    }

    public String getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
    }

    public String getFdBankMoney() {
        return fdBankMoney;
    }

    public void setFdBankMoney(String fdBankMoney) {
        this.fdBankMoney = fdBankMoney;
    }

    public String getAuthAttNodownload() {
        return authAttNodownload;
    }

    public void setAuthAttNodownload(String authAttNodownload) {
        this.authAttNodownload = authAttNodownload;
    }

    public String getAuthAttNocopy() {
        return authAttNocopy;
    }

    public void setAuthAttNocopy(String authAttNocopy) {
        this.authAttNocopy = authAttNocopy;
    }

    public String getAuthAttNoprint() {
        return authAttNoprint;
    }

    public void setAuthAttNoprint(String authAttNoprint) {
        this.authAttNoprint = authAttNoprint;
    }

    public String getFdCash() {
        return fdCash;
    }

    public void setFdCash(String fdCash) {
        this.fdCash = fdCash;
    }

    public String getFdOtherMoney() {
        return fdOtherMoney;
    }

    public void setFdOtherMoney(String fdOtherMoney) {
        this.fdOtherMoney = fdOtherMoney;
    }

    public String getFdAccountPeriod() {
        return fdAccountPeriod;
    }

    public void setFdAccountPeriod(String fdAccountPeriod) {
        this.fdAccountPeriod = fdAccountPeriod;
    }

    public String getFdBankDescrip() {
        return fdBankDescrip;
    }

    public void setFdBankDescrip(String fdBankDescrip) {
        this.fdBankDescrip = fdBankDescrip;
    }

    public String getFdQuitsPrePaymentMoney() {
        return fdQuitsPrePaymentMoney;
    }

    public void setFdQuitsPrePaymentMoney(String fdQuitsPrePaymentMoney) {
        this.fdQuitsPrePaymentMoney = fdQuitsPrePaymentMoney;
    }

    public String getFdQuitsPrePaymentDesc() {
        return fdQuitsPrePaymentDesc;
    }

    public void setFdQuitsPrePaymentDesc(String fdQuitsPrePaymentDesc) {
        this.fdQuitsPrePaymentDesc = fdQuitsPrePaymentDesc;
    }

    public String getAuthReaderFlag() {
        return authReaderFlag;
    }

    public void setAuthReaderFlag(String authReaderFlag) {
        this.authReaderFlag = authReaderFlag;
    }

    public String getFdChargeDetailId() {
        return fdChargeDetailId;
    }

    public void setFdChargeDetailId(String fdChargeDetailId) {
        this.fdChargeDetailId = fdChargeDetailId;
    }

    public String getFdChargeDetailName() {
        return fdChargeDetailName;
    }

    public void setFdChargeDetailName(String fdChargeDetailName) {
        this.fdChargeDetailName = fdChargeDetailName;
    }

    public String getFdReasonCodeId() {
        return fdReasonCodeId;
    }

    public void setFdReasonCodeId(String fdReasonCodeId) {
        this.fdReasonCodeId = fdReasonCodeId;
    }

    public String getFdLedgerId() {
        return fdLedgerId;
    }

    public void setFdLedgerId(String fdLedgerId) {
        this.fdLedgerId = fdLedgerId;
    }

    public String getFdCurrency() {
        return fdCurrency;
    }

    public void setFdCurrency(String fdCurrency) {
        this.fdCurrency = fdCurrency;
    }

    public String getFdRoe() {
        return fdRoe;
    }

    public void setFdRoe(String fdRoe) {
        this.fdRoe = fdRoe;
    }

    public String getFdCollecting() {
        return fdCollecting;
    }

    public void setFdCollecting(String fdCollecting) {
        this.fdCollecting = fdCollecting;
    }

    public String getFdLc() {
        return fdLc;
    }

    public void setFdLc(String fdLc) {
        this.fdLc = fdLc;
    }

    public String getFdCheck() {
        return fdCheck;
    }

    public void setFdCheck(String fdCheck) {
        this.fdCheck = fdCheck;
    }

    public String getFdPayeeId() {
        return fdPayeeId;
    }

    public void setFdPayeeId(String fdPayeeId) {
        this.fdPayeeId = fdPayeeId;
    }

    public String getFdCashSubject() {
        return fdCashSubject;
    }

    public void setFdCashSubject(String fdCashSubject) {
        this.fdCashSubject = fdCashSubject;
    }

    public String getFdBankSubject() {
        return fdBankSubject;
    }

    public void setFdBankSubject(String fdBankSubject) {
        this.fdBankSubject = fdBankSubject;
    }

    public String getDocCreatorId() {
        return docCreatorId;
    }

    public void setDocCreatorId(String docCreatorId) {
        this.docCreatorId = docCreatorId;
    }

    public String getDocCreatorName() {
        return docCreatorName;
    }

    public void setDocCreatorName(String docCreatorName) {
        this.docCreatorName = docCreatorName;
    }

    public String getDocCreatorNo() {
        return docCreatorNo;
    }

    public void setDocCreatorNo(String docCreatorNo) {
        this.docCreatorNo = docCreatorNo;
    }

    public String getGetDocCreatorName() {
        return getDocCreatorName;
    }

    public void setGetDocCreatorName(String getDocCreatorName) {
        this.getDocCreatorName = getDocCreatorName;
    }

    public String getFdDeptId() {
        return fdDeptId;
    }

    public void setFdDeptId(String fdDeptId) {
        this.fdDeptId = fdDeptId;
    }

    public String getDocAlterId() {
        return docAlterId;
    }

    public void setDocAlterId(String docAlterId) {
        this.docAlterId = docAlterId;
    }

    public String getDocAlterName() {
        return docAlterName;
    }

    public void setDocAlterName(String docAlterName) {
        this.docAlterName = docAlterName;
    }

    public String getFdItemId() {
        return fdItemId;
    }

    public void setFdItemId(String fdItemId) {
        this.fdItemId = fdItemId;
    }

    public String getFdFactPayId() {
        return fdFactPayId;
    }

    public void setFdFactPayId(String fdFactPayId) {
        this.fdFactPayId = fdFactPayId;
    }

    public String getFdBankId() {
        return fdBankId;
    }

    public void setFdBankId(String fdBankId) {
        this.fdBankId = fdBankId;
    }

    public String getDocCategoryId() {
        return docCategoryId;
    }

    public void setDocCategoryId(String docCategoryId) {
        this.docCategoryId = docCategoryId;
    }

    public String getGetDocCategoryName() {
        return getDocCategoryName;
    }

    public void setGetDocCategoryName(String getDocCategoryName) {
        this.getDocCategoryName = getDocCategoryName;
    }

    public String getFdProposerId() {
        return fdProposerId;
    }

    public void setFdProposerId(String fdProposerId) {
        this.fdProposerId = fdProposerId;
    }

    public String getFdProposerName() {
        return fdProposerName;
    }

    public void setFdProposerName(String fdProposerName) {
        this.fdProposerName = fdProposerName;
    }

    public String getFdProposerNo() {
        return fdProposerNo;
    }

    public void setFdProposerNo(String fdProposerNo) {
        this.fdProposerNo = fdProposerNo;
    }

    public String getFdOtherId() {
        return fdOtherId;
    }

    public void setFdOtherId(String fdOtherId) {
        this.fdOtherId = fdOtherId;
    }

    public String getFdPayeePerson() {
        return fdPayeePerson;
    }

    public void setFdPayeePerson(String fdPayeePerson) {
        this.fdPayeePerson = fdPayeePerson;
    }

    public String getFdBudgetFlag() {
        return fdBudgetFlag;
    }

    public void setFdBudgetFlag(String fdBudgetFlag) {
        this.fdBudgetFlag = fdBudgetFlag;
    }

    public String getFdTaxFlag() {
        return fdTaxFlag;
    }

    public void setFdTaxFlag(String fdTaxFlag) {
        this.fdTaxFlag = fdTaxFlag;
    }

    public String getFdPersonPositionId() {
        return fdPersonPositionId;
    }

    public void setFdPersonPositionId(String fdPersonPositionId) {
        this.fdPersonPositionId = fdPersonPositionId;
    }

    public String getFdPersonPositionName() {
        return fdPersonPositionName;
    }

    public void setFdPersonPositionName(String fdPersonPositionName) {
        this.fdPersonPositionName = fdPersonPositionName;
    }

    public String getFdMonEndStatus() {
        return fdMonEndStatus;
    }

    public void setFdMonEndStatus(String fdMonEndStatus) {
        this.fdMonEndStatus = fdMonEndStatus;
    }

    public String getFdSapStatusMonEnd() {
        return fdSapStatusMonEnd;
    }

    public void setFdSapStatusMonEnd(String fdSapStatusMonEnd) {
        this.fdSapStatusMonEnd = fdSapStatusMonEnd;
    }

    public String getFdSapMessageMonEnd() {
        return fdSapMessageMonEnd;
    }

    public void setFdSapMessageMonEnd(String fdSapMessageMonEnd) {
        this.fdSapMessageMonEnd = fdSapMessageMonEnd;
    }

    public String getFdVoucherDate() {
        return fdVoucherDate;
    }

    public void setFdVoucherDate(String fdVoucherDate) {
        this.fdVoucherDate = fdVoucherDate;
    }

    public String getFdFproductState() {
        return fdFproductState;
    }

    public void setFdFproductState(String fdFproductState) {
        this.fdFproductState = fdFproductState;
    }

    public String getDocPublishTime() {
        return docPublishTime;
    }

    public void setDocPublishTime(String docPublishTime) {
        this.docPublishTime = docPublishTime;
    }

    public String getFdPrepayFlag() {
        return fdPrepayFlag;
    }

    public void setFdPrepayFlag(String fdPrepayFlag) {
        this.fdPrepayFlag = fdPrepayFlag;
    }

    public String getFdJason() {
        return fdJason;
    }

    public void setFdJason(String fdJason) {
        this.fdJason = fdJason;
    }

    public String getFdRole() {
        return fdRole;
    }

    public void setFdRole(String fdRole) {
        this.fdRole = fdRole;
    }

    public String getFdIsRead() {
        return fdIsRead;
    }

    public void setFdIsRead(String fdIsRead) {
        this.fdIsRead = fdIsRead;
    }

    public String getIsCsf() {
        return isCsf;
    }

    public void setIsCsf(String isCsf) {
        this.isCsf = isCsf;
    }

    public String getFdCsf() {
        return fdCsf;
    }

    public void setFdCsf(String fdCsf) {
        this.fdCsf = fdCsf;
    }

    public String getFdTaketaxtype() {
        return fdTaketaxtype;
    }

    public void setFdTaketaxtype(String fdTaketaxtype) {
        this.fdTaketaxtype = fdTaketaxtype;
    }

    public String getFdIsProa() {
        return fdIsProa;
    }

    public void setFdIsProa(String fdIsProa) {
        this.fdIsProa = fdIsProa;
    }

    public String getFdSupplierNo() {
        return fdSupplierNo;
    }

    public void setFdSupplierNo(String fdSupplierNo) {
        this.fdSupplierNo = fdSupplierNo;
    }

    public String getFdPurchaseOrg() {
        return fdPurchaseOrg;
    }

    public void setFdPurchaseOrg(String fdPurchaseOrg) {
        this.fdPurchaseOrg = fdPurchaseOrg;
    }

    public String getFdIsUrgent() {
        return fdIsUrgent;
    }

    public void setFdIsUrgent(String fdIsUrgent) {
        this.fdIsUrgent = fdIsUrgent;
    }

    public String getFdIsDirectBank() {
        return fdIsDirectBank;
    }

    public void setFdIsDirectBank(String fdIsDirectBank) {
        this.fdIsDirectBank = fdIsDirectBank;
    }

    public String getFdLedgerBankAccNo() {
        return fdLedgerBankAccNo;
    }

    public void setFdLedgerBankAccNo(String fdLedgerBankAccNo) {
        this.fdLedgerBankAccNo = fdLedgerBankAccNo;
    }

    public String getFdLedgerBank() {
        return fdLedgerBank;
    }

    public void setFdLedgerBank(String fdLedgerBank) {
        this.fdLedgerBank = fdLedgerBank;
    }

    public String getFdLedgerBankName() {
        return fdLedgerBankName;
    }

    public void setFdLedgerBankName(String fdLedgerBankName) {
        this.fdLedgerBankName = fdLedgerBankName;
    }

    public String getFdPayeeSupplier() {
        return fdPayeeSupplier;
    }

    public void setFdPayeeSupplier(String fdPayeeSupplier) {
        this.fdPayeeSupplier = fdPayeeSupplier;
    }

    public String getFdPayeeSupplierName() {
        return fdPayeeSupplierName;
    }

    public void setFdPayeeSupplierName(String fdPayeeSupplierName) {
        this.fdPayeeSupplierName = fdPayeeSupplierName;
    }

    public String getFdEquipmentAccNo() {
        return fdEquipmentAccNo;
    }

    public void setFdEquipmentAccNo(String fdEquipmentAccNo) {
        this.fdEquipmentAccNo = fdEquipmentAccNo;
    }

    public String getFdEquipmentPayType() {
        return fdEquipmentPayType;
    }

    public void setFdEquipmentPayType(String fdEquipmentPayType) {
        this.fdEquipmentPayType = fdEquipmentPayType;
    }

    public String getFdProcessType() {
        return fdProcessType;
    }

    public void setFdProcessType(String fdProcessType) {
        this.fdProcessType = fdProcessType;
    }

    public String getFdDeductionMoney() {
        return fdDeductionMoney;
    }

    public void setFdDeductionMoney(String fdDeductionMoney) {
        this.fdDeductionMoney = fdDeductionMoney;
    }

    public String getFdIsContract() {
        return fdIsContract;
    }

    public void setFdIsContract(String fdIsContract) {
        this.fdIsContract = fdIsContract;
    }

    public String getFdContractNumber() {
        return fdContractNumber;
    }

    public void setFdContractNumber(String fdContractNumber) {
        this.fdContractNumber = fdContractNumber;
    }

    public String getFdContractMoney() {
        return fdContractMoney;
    }

    public void setFdContractMoney(String fdContractMoney) {
        this.fdContractMoney = fdContractMoney;
    }

    public String getFdNoContractReason() {
        return fdNoContractReason;
    }

    public void setFdNoContractReason(String fdNoContractReason) {
        this.fdNoContractReason = fdNoContractReason;
    }

    public String getFdPayCategory() {
        return fdPayCategory;
    }

    public void setFdPayCategory(String fdPayCategory) {
        this.fdPayCategory = fdPayCategory;
    }

    public String getFdPayProportion() {
        return fdPayProportion;
    }

    public void setFdPayProportion(String fdPayProportion) {
        this.fdPayProportion = fdPayProportion;
    }

    public String getFdBarcodeStatus() {
        return fdBarcodeStatus;
    }

    public void setFdBarcodeStatus(String fdBarcodeStatus) {
        this.fdBarcodeStatus = fdBarcodeStatus;
    }

    public String getProjectApplicant() {
        return projectApplicant;
    }

    public void setProjectApplicant(String projectApplicant) {
        this.projectApplicant = projectApplicant;
    }

    public String getProjectApplicantName() {
        return projectApplicantName;
    }

    public void setProjectApplicantName(String projectApplicantName) {
        this.projectApplicantName = projectApplicantName;
    }

    public String getFdSwiftCode() {
        return fdSwiftCode;
    }

    public void setFdSwiftCode(String fdSwiftCode) {
        this.fdSwiftCode = fdSwiftCode;
    }

    public CsotDictData getDictData() {
        return dictData;
    }

    public void setDictData(CsotDictData dictData) {
        this.dictData = dictData;
    }

    public List<CsotManageFeeDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<CsotManageFeeDetail> detail) {
        this.detail = detail;
    }

    public List<CsotManagePrePay> getPrePayList() {
        return prePayList;
    }

    public void setPrePayList(List<CsotManagePrePay> prePayList) {
        this.prePayList = prePayList;
    }

    public List<AttMain> getFileList() {
        return fileList;
    }

    public void setFileList(List<AttMain> fileList) {
        this.fileList = fileList;
    }

    public List<CsotManagePayPatDetail> getPayPatDetailList() {
        return payPatDetailList;
    }

    public void setPayPatDetailList(List<CsotManagePayPatDetail> payPatDetailList) {
        this.payPatDetailList = payPatDetailList;
    }

    public List<CsotManagePayEquipment> getPayEquipmentList() {
        return payEquipmentList;
    }

    public void setPayEquipmentList(List<CsotManagePayEquipment> payEquipmentList) {
        this.payEquipmentList = payEquipmentList;
    }

    public List<CsotManagePayGysDz> getPayGysDzList() {
        return payGysDzList;
    }

    public void setPayGysDzList(List<CsotManagePayGysDz> payGysDzList) {
        this.payGysDzList = payGysDzList;
    }
}
