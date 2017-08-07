package com.csot.csotoa.hr.bean;

import com.csot.csotoa.util.bean.AttMain;

import java.util.List;

public class CsotHrMain {
    private String fdId;
    private String docSubject;
    private String docStatus;
    private String docCreatorId;
    private String docCreatorName;
    private Object extendDataXml;
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

    public Object getExtendDataXml() {
        return extendDataXml;
    }

    public void setExtendDataXml(Object extendDataXml) {
        this.extendDataXml = extendDataXml;
    }

    public List<AttMain> getFileList() {
        return fileList;
    }

    public void setFileList(List<AttMain> fileList) {
        this.fileList = fileList;
    }
}
