package com.csot.csotoa.manageborrow.bean;

import com.csot.csotoa.util.bean.AttMain;

import java.util.List;

public class CsotManageBorrowMain {
    private String fdId;
    private String fdSapMessage;
    private String fdSapStatus;
    private String accModeId;
    private String docSubject;
    private String fdApplyNumber;
    private String fdEmpNo;
    private String fdEmpPost;
    private String fdDeptname;
    private String fdEmpDept;
    private String fdPayeeno;
    private String fdPayeename;
    private String fdPayeepost;
    private String fdPayeedept;
    private String fdPayeedeptname;
    private String fdPaymenttype;
    private String fdLedgerId;
    private String fdBankaccount;
    private String fdProvincename;
    private String fdCityname;
    private String fdBranchname;
    private String fdBankname;
    private String fdTraveno;
    private String docBorrowTime;
    private String fdVoucherState;
    private String fdBorrowCountMoney;
    private String fdMoneyCapital;
    private String fdAttCount;
    private String fdPrintState;
    private String fdPrintTotal;
    private String fdCreatorPhoneno;
    private String docAlterTime;
    private String fdEmpName;
    private String fdCheckMoney;
    private String fdLcMoney;
    private String fdCollectingMoney;
    private String fdActualMoney;
    private String fdCheckDescrip;
    private String fdLcDescrip;
    private String fdCollectingDescrip;
    private String fdActualMoneyCapital;
    private String fdQuitsMoneyCapital;
    private String fdChargeType;
    private String fdLedgerFlag;
    private String fdBankPayState;
    private String fdVoucherNumber;
    private String fNumber;
    private String docCreateTime;
    private String fdAccountPeriod;
    private String fdBankMoney;
    private String fdBankMoneyDesc;
    private String fdMoneyIoSum;
    private String fdCash;
    private String fdDescrip;
    private String fdSummary;
    private String docStatus;
    private String fdCashSummary;
    private String authAttNodownload;
    private String authAttNocopy;
    private String authAttNoprint;
    private String authReaderFlag;
    private String fdCashSubject;
    private String fdBankSubject;
    private String docCreatorId;
    private String docCreatorName;
    private String docCategoryId;
    private String docBorrowId;
    private String docBorrowName;
    private String fdBorrowItemId;
    private String docAlterId;
    private String docAlterName;
    private String fdMoneyIoItemId;
    private String fdMoneyIoItemBank;
    private String fdItemId;
    private String fdCurrency;
    private String fdRoe;
    private String fdCollecting;
    private String fdLc;
    private String fdCheck;
    private String fdInclusionbudgetId;
    private String fdBankMoneyItemId;
    private String fdPersonPositionId;
    private String fdPersonPositionName;
    private String docPublishTime;
    private String isCsf;
    private String fdCsf;
    private String fdPaymentWay;
    private String fdDisplayAccount;
    private List<CsotManageBorrow> borrowList;
    private List<AttMain> fileList;
    private CsotDictData csotDictData;
    private KmCsotmanageSapBankaccsub bankaccsub;

    public String getFdId() {
        return fdId;
    }

    public void setFdId(String fdId) {
        this.fdId = fdId;
    }

    public String getFdSapMessage() {
        return fdSapMessage;
    }

    public void setFdSapMessage(String fdSapMessage) {
        this.fdSapMessage = fdSapMessage;
    }

    public String getFdSapStatus() {
        return fdSapStatus;
    }

    public void setFdSapStatus(String fdSapStatus) {
        this.fdSapStatus = fdSapStatus;
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

    public String getFdApplyNumber() {
        return fdApplyNumber;
    }

    public void setFdApplyNumber(String fdApplyNumber) {
        this.fdApplyNumber = fdApplyNumber;
    }

    public String getFdEmpNo() {
        return fdEmpNo;
    }

    public void setFdEmpNo(String fdEmpNo) {
        this.fdEmpNo = fdEmpNo;
    }

    public String getFdEmpPost() {
        return fdEmpPost;
    }

    public void setFdEmpPost(String fdEmpPost) {
        this.fdEmpPost = fdEmpPost;
    }

    public String getFdDeptname() {
        return fdDeptname;
    }

    public void setFdDeptname(String fdDeptname) {
        this.fdDeptname = fdDeptname;
    }

    public String getFdEmpDept() {
        return fdEmpDept;
    }

    public void setFdEmpDept(String fdEmpDept) {
        this.fdEmpDept = fdEmpDept;
    }

    public String getFdPayeeno() {
        return fdPayeeno;
    }

    public void setFdPayeeno(String fdPayeeno) {
        this.fdPayeeno = fdPayeeno;
    }

    public String getFdPayeename() {
        return fdPayeename;
    }

    public void setFdPayeename(String fdPayeename) {
        this.fdPayeename = fdPayeename;
    }

    public String getFdPayeepost() {
        return fdPayeepost;
    }

    public void setFdPayeepost(String fdPayeepost) {
        this.fdPayeepost = fdPayeepost;
    }

    public String getFdPayeedept() {
        return fdPayeedept;
    }

    public void setFdPayeedept(String fdPayeedept) {
        this.fdPayeedept = fdPayeedept;
    }

    public String getFdPayeedeptname() {
        return fdPayeedeptname;
    }

    public void setFdPayeedeptname(String fdPayeedeptname) {
        this.fdPayeedeptname = fdPayeedeptname;
    }

    public String getFdPaymenttype() {
        return fdPaymenttype;
    }

    public void setFdPaymenttype(String fdPaymenttype) {
        this.fdPaymenttype = fdPaymenttype;
    }

    public String getFdLedgerId() {
        return fdLedgerId;
    }

    public void setFdLedgerId(String fdLedgerId) {
        this.fdLedgerId = fdLedgerId;
    }

    public String getFdBankaccount() {
        return fdBankaccount;
    }

    public void setFdBankaccount(String fdBankaccount) {
        this.fdBankaccount = fdBankaccount;
    }

    public String getFdProvincename() {
        return fdProvincename;
    }

    public void setFdProvincename(String fdProvincename) {
        this.fdProvincename = fdProvincename;
    }

    public String getFdCityname() {
        return fdCityname;
    }

    public void setFdCityname(String fdCityname) {
        this.fdCityname = fdCityname;
    }

    public String getFdBranchname() {
        return fdBranchname;
    }

    public void setFdBranchname(String fdBranchname) {
        this.fdBranchname = fdBranchname;
    }

    public String getFdBankname() {
        return fdBankname;
    }

    public void setFdBankname(String fdBankname) {
        this.fdBankname = fdBankname;
    }

    public String getFdTraveno() {
        return fdTraveno;
    }

    public void setFdTraveno(String fdTraveno) {
        this.fdTraveno = fdTraveno;
    }

    public String getDocBorrowTime() {
        return docBorrowTime;
    }

    public void setDocBorrowTime(String docBorrowTime) {
        this.docBorrowTime = docBorrowTime;
    }

    public String getFdVoucherState() {
        return fdVoucherState;
    }

    public void setFdVoucherState(String fdVoucherState) {
        this.fdVoucherState = fdVoucherState;
    }

    public String getFdBorrowCountMoney() {
        return fdBorrowCountMoney;
    }

    public void setFdBorrowCountMoney(String fdBorrowCountMoney) {
        this.fdBorrowCountMoney = fdBorrowCountMoney;
    }

    public String getFdMoneyCapital() {
        return fdMoneyCapital;
    }

    public void setFdMoneyCapital(String fdMoneyCapital) {
        this.fdMoneyCapital = fdMoneyCapital;
    }

    public String getFdAttCount() {
        return fdAttCount;
    }

    public void setFdAttCount(String fdAttCount) {
        this.fdAttCount = fdAttCount;
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

    public String getFdCreatorPhoneno() {
        return fdCreatorPhoneno;
    }

    public void setFdCreatorPhoneno(String fdCreatorPhoneno) {
        this.fdCreatorPhoneno = fdCreatorPhoneno;
    }

    public String getDocAlterTime() {
        return docAlterTime;
    }

    public void setDocAlterTime(String docAlterTime) {
        this.docAlterTime = docAlterTime;
    }

    public String getFdEmpName() {
        return fdEmpName;
    }

    public void setFdEmpName(String fdEmpName) {
        this.fdEmpName = fdEmpName;
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

    public String getFdBankPayState() {
        return fdBankPayState;
    }

    public void setFdBankPayState(String fdBankPayState) {
        this.fdBankPayState = fdBankPayState;
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

    public String getDocCreateTime() {
        return docCreateTime;
    }

    public void setDocCreateTime(String docCreateTime) {
        this.docCreateTime = docCreateTime;
    }

    public String getFdAccountPeriod() {
        return fdAccountPeriod;
    }

    public void setFdAccountPeriod(String fdAccountPeriod) {
        this.fdAccountPeriod = fdAccountPeriod;
    }

    public String getFdBankMoney() {
        return fdBankMoney;
    }

    public void setFdBankMoney(String fdBankMoney) {
        this.fdBankMoney = fdBankMoney;
    }

    public String getFdBankMoneyDesc() {
        return fdBankMoneyDesc;
    }

    public void setFdBankMoneyDesc(String fdBankMoneyDesc) {
        this.fdBankMoneyDesc = fdBankMoneyDesc;
    }

    public String getFdMoneyIoSum() {
        return fdMoneyIoSum;
    }

    public void setFdMoneyIoSum(String fdMoneyIoSum) {
        this.fdMoneyIoSum = fdMoneyIoSum;
    }

    public String getFdCash() {
        return fdCash;
    }

    public void setFdCash(String fdCash) {
        this.fdCash = fdCash;
    }

    public String getFdDescrip() {
        return fdDescrip;
    }

    public void setFdDescrip(String fdDescrip) {
        this.fdDescrip = fdDescrip;
    }

    public String getFdSummary() {
        return fdSummary;
    }

    public void setFdSummary(String fdSummary) {
        this.fdSummary = fdSummary;
    }

    public String getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
    }

    public String getFdCashSummary() {
        return fdCashSummary;
    }

    public void setFdCashSummary(String fdCashSummary) {
        this.fdCashSummary = fdCashSummary;
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

    public String getAuthReaderFlag() {
        return authReaderFlag;
    }

    public void setAuthReaderFlag(String authReaderFlag) {
        this.authReaderFlag = authReaderFlag;
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

    public String getDocCategoryId() {
        return docCategoryId;
    }

    public void setDocCategoryId(String docCategoryId) {
        this.docCategoryId = docCategoryId;
    }

    public String getDocBorrowId() {
        return docBorrowId;
    }

    public void setDocBorrowId(String docBorrowId) {
        this.docBorrowId = docBorrowId;
    }

    public String getDocBorrowName() {
        return docBorrowName;
    }

    public void setDocBorrowName(String docBorrowName) {
        this.docBorrowName = docBorrowName;
    }

    public String getFdBorrowItemId() {
        return fdBorrowItemId;
    }

    public void setFdBorrowItemId(String fdBorrowItemId) {
        this.fdBorrowItemId = fdBorrowItemId;
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

    public String getFdMoneyIoItemId() {
        return fdMoneyIoItemId;
    }

    public void setFdMoneyIoItemId(String fdMoneyIoItemId) {
        this.fdMoneyIoItemId = fdMoneyIoItemId;
    }

    public String getFdMoneyIoItemBank() {
        return fdMoneyIoItemBank;
    }

    public void setFdMoneyIoItemBank(String fdMoneyIoItemBank) {
        this.fdMoneyIoItemBank = fdMoneyIoItemBank;
    }

    public String getFdItemId() {
        return fdItemId;
    }

    public void setFdItemId(String fdItemId) {
        this.fdItemId = fdItemId;
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

    public String getFdInclusionbudgetId() {
        return fdInclusionbudgetId;
    }

    public void setFdInclusionbudgetId(String fdInclusionbudgetId) {
        this.fdInclusionbudgetId = fdInclusionbudgetId;
    }

    public String getFdBankMoneyItemId() {
        return fdBankMoneyItemId;
    }

    public void setFdBankMoneyItemId(String fdBankMoneyItemId) {
        this.fdBankMoneyItemId = fdBankMoneyItemId;
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

    public String getDocPublishTime() {
        return docPublishTime;
    }

    public void setDocPublishTime(String docPublishTime) {
        this.docPublishTime = docPublishTime;
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

    public String getFdPaymentWay() {
        return fdPaymentWay;
    }

    public void setFdPaymentWay(String fdPaymentWay) {
        this.fdPaymentWay = fdPaymentWay;
    }

    public String getFdDisplayAccount() {
        return fdDisplayAccount;
    }

    public void setFdDisplayAccount(String fdDisplayAccount) {
        this.fdDisplayAccount = fdDisplayAccount;
    }

    public List<CsotManageBorrow> getBorrowList() {
        return borrowList;
    }

    public void setBorrowList(List<CsotManageBorrow> borrowList) {
        this.borrowList = borrowList;
    }

    public List<AttMain> getFileList() {
        return fileList;
    }

    public void setFileList(List<AttMain> fileList) {
        this.fileList = fileList;
    }

    public CsotDictData getCsotDictData() {
        return csotDictData;
    }

    public void setCsotDictData(CsotDictData csotDictData) {
        this.csotDictData = csotDictData;
    }

    public KmCsotmanageSapBankaccsub getBankaccsub() {
        return bankaccsub;
    }

    public void setBankaccsub(KmCsotmanageSapBankaccsub bankaccsub) {
        this.bankaccsub = bankaccsub;
    }
}
