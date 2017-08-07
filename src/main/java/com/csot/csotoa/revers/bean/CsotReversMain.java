package com.csot.csotoa.revers.bean;

import oracle.sql.CLOB;

import java.sql.Clob;

public class CsotReversMain {
    private String fdId;
    private String docCreatorId;
    private String docCreatorName;
    private String docSubject;
    private String docStatus;
    private Object xml;

    public String getFdId() {
        return fdId;
    }

    public void setFdId(String fdId) {
        this.fdId = fdId;
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

    public Object getXml() {
        return xml;
    }

    public void setXml(Object xml) {
        this.xml = xml;
    }
}

