package com.csot.csotoa.dccmodapply.bean;

import com.csot.csotoa.util.bean.AttMain;
import com.csot.csotoa.util.bean.SysOrgElement;

import java.util.List;

public class DccModApply {
    private String fdId;
    private String fdApplicantNumber;
    private String fdApplicantTel;
    private String fdFlowType;
    private String docSubject;
    private String docNumber;
    private String fdVersion;
    private String fdApplyNumber;
    private String fdStatus;
    private String docStatus;
    private String fdSuitDeptType;
    private String docApplyReason;
    private String docApplyDate;
    private Object fdMemo;
    private String fdCreatorNumber;
    private String fdCreatorTel;
    private String docType;
    private String fdSecretLevel;
    private String csotDccmodApplyTemplateId;
    private String docApplicant;
    private String docApplicantName;
    private String docApplicantDept;
    private String docApplicantDeptName;
    private String docCreator;
    private String docCreatorName;
    private String fdCreateDept;
    private String fdCreateDeptName;
    private String authAttNodownload;
    private String authAttNocopy;
    private String authAttNoprint;
    private String authReaderFlag;
    private String fdSystemType;
    private String fdReferenceFile;
    private String docMediaType;

    private CsotDccmodApplyBorrow borrow;
    private List <CsotDccmodBorrowList> borrowLists;

    private List<SysOrgElement> baseDeptList;
    private List<SysOrgElement> relDeptList;
    private List<SysOrgElement> newDeptList;
    private List<SysOrgElement> mainDeptList;

    private List<AttMain> fileList;
    private List<DccModDocumentMain> refFileList;
    private List<DccModDocumentMain> refTableList;

    private List<SysOrgElement> redisDeptList;
    private List<AttMain> documentList;
    private List<AttMain> revisionDocList;

    public String getFdId() {
        return fdId;
    }

    public void setFdId(String fdId) {
        this.fdId = fdId;
    }

    public String getFdApplicantNumber() {
        return fdApplicantNumber;
    }

    public void setFdApplicantNumber(String fdApplicantNumber) {
        this.fdApplicantNumber = fdApplicantNumber;
    }

    public String getFdApplicantTel() {
        return fdApplicantTel;
    }

    public void setFdApplicantTel(String fdApplicantTel) {
        this.fdApplicantTel = fdApplicantTel;
    }

    public String getFdFlowType() {
        return fdFlowType;
    }

    public void setFdFlowType(String fdFlowType) {
        this.fdFlowType = fdFlowType;
    }

    public String getDocSubject() {
        return docSubject;
    }

    public void setDocSubject(String docSubject) {
        this.docSubject = docSubject;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getFdVersion() {
        return fdVersion;
    }

    public void setFdVersion(String fdVersion) {
        this.fdVersion = fdVersion;
    }

    public String getFdApplyNumber() {
        return fdApplyNumber;
    }

    public void setFdApplyNumber(String fdApplyNumber) {
        this.fdApplyNumber = fdApplyNumber;
    }

    public String getFdStatus() {
        return fdStatus;
    }

    public void setFdStatus(String fdStatus) {
        this.fdStatus = fdStatus;
    }

    public String getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
    }

    public String getFdSuitDeptType() {
        return fdSuitDeptType;
    }

    public void setFdSuitDeptType(String fdSuitDeptType) {
        this.fdSuitDeptType = fdSuitDeptType;
    }

    public String getDocApplyReason() {
        return docApplyReason;
    }

    public void setDocApplyReason(String docApplyReason) {
        this.docApplyReason = docApplyReason;
    }

    public String getDocApplyDate() {
        return docApplyDate;
    }

    public void setDocApplyDate(String docApplyDate) {
        this.docApplyDate = docApplyDate;
    }

    public Object getFdMemo() {
        return fdMemo;
    }

    public void setFdMemo(Object fdMemo) {
        this.fdMemo = fdMemo;
    }

    public String getFdCreatorNumber() {
        return fdCreatorNumber;
    }

    public void setFdCreatorNumber(String fdCreatorNumber) {
        this.fdCreatorNumber = fdCreatorNumber;
    }

    public String getFdCreatorTel() {
        return fdCreatorTel;
    }

    public void setFdCreatorTel(String fdCreatorTel) {
        this.fdCreatorTel = fdCreatorTel;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getFdSecretLevel() {
        return fdSecretLevel;
    }

    public void setFdSecretLevel(String fdSecretLevel) {
        this.fdSecretLevel = fdSecretLevel;
    }

    public String getCsotDccmodApplyTemplateId() {
        return csotDccmodApplyTemplateId;
    }

    public void setCsotDccmodApplyTemplateId(String csotDccmodApplyTemplateId) {
        this.csotDccmodApplyTemplateId = csotDccmodApplyTemplateId;
    }

    public String getDocApplicant() {
        return docApplicant;
    }

    public void setDocApplicant(String docApplicant) {
        this.docApplicant = docApplicant;
    }

    public String getDocApplicantDept() {
        return docApplicantDept;
    }

    public void setDocApplicantDept(String docApplicantDept) {
        this.docApplicantDept = docApplicantDept;
    }

    public String getDocCreator() {
        return docCreator;
    }

    public void setDocCreator(String docCreator) {
        this.docCreator = docCreator;
    }

    public String getFdCreateDept() {
        return fdCreateDept;
    }

    public void setFdCreateDept(String fdCreateDept) {
        this.fdCreateDept = fdCreateDept;
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

    public String getFdSystemType() {
        return fdSystemType;
    }

    public void setFdSystemType(String fdSystemType) {
        this.fdSystemType = fdSystemType;
    }

    public String getFdReferenceFile() {
        return fdReferenceFile;
    }

    public void setFdReferenceFile(String fdReferenceFile) {
        this.fdReferenceFile = fdReferenceFile;
    }

    public String getDocMediaType() {
        return docMediaType;
    }

    public void setDocMediaType(String docMediaType) {
        this.docMediaType = docMediaType;
    }

    public String getDocCreatorName() {
        return docCreatorName;
    }

    public void setDocCreatorName(String docCreatorName) {
        this.docCreatorName = docCreatorName;
    }

    public String getFdCreateDeptName() {
        return fdCreateDeptName;
    }

    public void setFdCreateDeptName(String fdCreateDeptName) {
        this.fdCreateDeptName = fdCreateDeptName;
    }

    public String getDocApplicantName() {
        return docApplicantName;
    }

    public void setDocApplicantName(String docApplicantName) {
        this.docApplicantName = docApplicantName;
    }

    public String getDocApplicantDeptName() {
        return docApplicantDeptName;
    }

    public void setDocApplicantDeptName(String docApplicantDeptName) {
        this.docApplicantDeptName = docApplicantDeptName;
    }

    public CsotDccmodApplyBorrow getBorrow() {
        return borrow;
    }

    public void setBorrow(CsotDccmodApplyBorrow borrow) {
        this.borrow = borrow;
    }

    public List<CsotDccmodBorrowList> getBorrowLists() {
        return borrowLists;
    }

    public void setBorrowLists(List<CsotDccmodBorrowList> borrowLists) {
        this.borrowLists = borrowLists;
    }

    public List<AttMain> getFileList() {
        return fileList;
    }

    public void setFileList(List<AttMain> fileList) {
        this.fileList = fileList;
    }

    public List<DccModDocumentMain> getRefFileList() {
        return refFileList;
    }

    public void setRefFileList(List<DccModDocumentMain> refFileList) {
        this.refFileList = refFileList;
    }

    public List<DccModDocumentMain> getRefTableList() {
        return refTableList;
    }

    public void setRefTableList(List<DccModDocumentMain> refTableList) {
        this.refTableList = refTableList;
    }

    public List<SysOrgElement> getBaseDeptList() {
        return baseDeptList;
    }

    public void setBaseDeptList(List<SysOrgElement> baseDeptList) {
        this.baseDeptList = baseDeptList;
    }

    public List<SysOrgElement> getRelDeptList() {
        return relDeptList;
    }

    public void setRelDeptList(List<SysOrgElement> relDeptList) {
        this.relDeptList = relDeptList;
    }

    public List<SysOrgElement> getNewDeptList() {
        return newDeptList;
    }

    public void setNewDeptList(List<SysOrgElement> newDeptList) {
        this.newDeptList = newDeptList;
    }

    public List<SysOrgElement> getMainDeptList() {
        return mainDeptList;
    }

    public void setMainDeptList(List<SysOrgElement> mainDeptList) {
        this.mainDeptList = mainDeptList;
    }

    public List<SysOrgElement> getRedisDeptList() {
        return redisDeptList;
    }

    public void setRedisDeptList(List<SysOrgElement> redisDeptList) {
        this.redisDeptList = redisDeptList;
    }

    public List<AttMain> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<AttMain> documentList) {
        this.documentList = documentList;
    }

    public List<AttMain> getRevisionDocList() {
        return revisionDocList;
    }

    public void setRevisionDocList(List<AttMain> revisionDocList) {
        this.revisionDocList = revisionDocList;
    }
}
