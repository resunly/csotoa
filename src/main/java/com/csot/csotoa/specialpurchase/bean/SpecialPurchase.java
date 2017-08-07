package com.csot.csotoa.specialpurchase.bean;

import com.csot.csotoa.util.bean.AttMain;

import java.util.List;

public class SpecialPurchase {
    private String fdId;
    private String docSubject;
    private String docCreateTime;
    private String docStatus;
    private String docPublishTime;
    private String fdNumber;
    private String fdTemplate;
    private String docCreatorId;
    private String docApplyerDept;
    private String extendFilePath;
    private Object extendDataXml;
    private String authAttNodownload;
    private String authAttNocopy;
    private String authAttNoprint;
    private String authReaderFlag;
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

    public String getDocCreateTime() {
        return docCreateTime;
    }

    public void setDocCreateTime(String docCreateTime) {
        this.docCreateTime = docCreateTime;
    }

    public String getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
    }

    public String getDocPublishTime() {
        return docPublishTime;
    }

    public void setDocPublishTime(String docPublishTime) {
        this.docPublishTime = docPublishTime;
    }

    public String getFdNumber() {
        return fdNumber;
    }

    public void setFdNumber(String fdNumber) {
        this.fdNumber = fdNumber;
    }

    public String getFdTemplate() {
        return fdTemplate;
    }

    public void setFdTemplate(String fdTemplate) {
        this.fdTemplate = fdTemplate;
    }

    public String getDocCreatorId() {
        return docCreatorId;
    }

    public void setDocCreatorId(String docCreatorId) {
        this.docCreatorId = docCreatorId;
    }

    public String getDocApplyerDept() {
        return docApplyerDept;
    }

    public void setDocApplyerDept(String docApplyerDept) {
        this.docApplyerDept = docApplyerDept;
    }

    public String getExtendFilePath() {
        return extendFilePath;
    }

    public void setExtendFilePath(String extendFilePath) {
        this.extendFilePath = extendFilePath;
    }

    public Object getExtendDataXml() {
        return extendDataXml;
    }

    public void setExtendDataXml(Object extendDataXml) {
        this.extendDataXml = extendDataXml;
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

    public List<AttMain> getFileList() {
        return fileList;
    }

    public void setFileList(List<AttMain> fileList) {
        this.fileList = fileList;
    }
}
