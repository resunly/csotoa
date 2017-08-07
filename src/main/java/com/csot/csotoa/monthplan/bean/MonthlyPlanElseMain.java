package com.csot.csotoa.monthplan.bean;

import com.csot.csotoa.util.bean.AttMain;

import java.util.List;

public class MonthlyPlanElseMain{
    private String fdId;
    private String docSubject;
    private String docStatus;
    private String docCreateTime;
    private String docAlterTime;
    private String fdLastModifiedTime;
    private String fdApplypersonPhone;
    private String fdApplypersonEmail;
    private String fdPersonMobile;
    private String fdTotalPrice;
    private String fdDeptCode;
    private String docCreatorId;
    private String docCreatorName;
    private String docAlterorId;
    private String docCategoryId;
    private String fdApplydeptId;
    private String fdApplydeptName;
    private String authEditorFlag;
    private String authReaderFlag;

    private List<MonthlyPlanElseDetail> detailList;
    private List<AttMain> fileList;

    public String getFdId() {
        return fdId;
    }

    public void setFdId(String fdId) {
        this.fdId = fdId;
    }

    public String getDocSubject() {
        return docSubject;
    }

    public void setDocSubject(String docSubject) {
        this.docSubject = docSubject;
    }

    public String getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
    }

    public String getDocCreateTime() {
        return docCreateTime;
    }

    public void setDocCreateTime(String docCreateTime) {
        this.docCreateTime = docCreateTime;
    }

    public String getDocAlterTime() {
        return docAlterTime;
    }

    public void setDocAlterTime(String docAlterTime) {
        this.docAlterTime = docAlterTime;
    }

    public String getFdLastModifiedTime() {
        return fdLastModifiedTime;
    }

    public void setFdLastModifiedTime(String fdLastModifiedTime) {
        this.fdLastModifiedTime = fdLastModifiedTime;
    }

    public String getFdApplypersonPhone() {
        return fdApplypersonPhone;
    }

    public void setFdApplypersonPhone(String fdApplypersonPhone) {
        this.fdApplypersonPhone = fdApplypersonPhone;
    }

    public String getFdApplypersonEmail() {
        return fdApplypersonEmail;
    }

    public void setFdApplypersonEmail(String fdApplypersonEmail) {
        this.fdApplypersonEmail = fdApplypersonEmail;
    }

    public String getFdPersonMobile() {
        return fdPersonMobile;
    }

    public void setFdPersonMobile(String fdPersonMobile) {
        this.fdPersonMobile = fdPersonMobile;
    }

    public String getFdTotalPrice() {
        return fdTotalPrice;
    }

    public void setFdTotalPrice(String fdTotalPrice) {
        this.fdTotalPrice = fdTotalPrice;
    }

    public String getFdDeptCode() {
        return fdDeptCode;
    }

    public void setFdDeptCode(String fdDeptCode) {
        this.fdDeptCode = fdDeptCode;
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

    public String getDocAlterorId() {
        return docAlterorId;
    }

    public void setDocAlterorId(String docAlterorId) {
        this.docAlterorId = docAlterorId;
    }

    public String getDocCategoryId() {
        return docCategoryId;
    }

    public void setDocCategoryId(String docCategoryId) {
        this.docCategoryId = docCategoryId;
    }

    public String getFdApplydeptId() {
        return fdApplydeptId;
    }

    public void setFdApplydeptId(String fdApplydeptId) {
        this.fdApplydeptId = fdApplydeptId;
    }

    public String getAuthEditorFlag() {
        return authEditorFlag;
    }

    public void setAuthEditorFlag(String authEditorFlag) {
        this.authEditorFlag = authEditorFlag;
    }

    public String getAuthReaderFlag() {
        return authReaderFlag;
    }

    public void setAuthReaderFlag(String authReaderFlag) {
        this.authReaderFlag = authReaderFlag;
    }

    public List<MonthlyPlanElseDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<MonthlyPlanElseDetail> detailList) {
        this.detailList = detailList;
    }

    public List<AttMain> getFileList() {
        return fileList;
    }

    public void setFileList(List<AttMain> fileList) {
        this.fileList = fileList;
    }

    public String getFdApplydeptName() {
        return fdApplydeptName;
    }

    public void setFdApplydeptName(String fdApplydeptName) {
        this.fdApplydeptName = fdApplydeptName;
    }
}
