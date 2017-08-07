package com.csot.csotoa.dccmodapply.bean;

public class CsotDccmodBorrowList {
    private String fdId;
    private String fdNumber;
    private String fdRemark;
    private String fdBorrowId;
    private String fdDocId;
    private CsotDccmodDocumentMain documentMain;
    public String getFdId() {
        return fdId;
    }

    public void setFdId(String fdId) {
        this.fdId = fdId;
    }

    public String getFdNumber() {
        return fdNumber;
    }

    public void setFdNumber(String fdNumber) {
        this.fdNumber = fdNumber;
    }

    public String getFdRemark() {
        return fdRemark;
    }

    public void setFdRemark(String fdRemark) {
        this.fdRemark = fdRemark;
    }

    public String getFdBorrowId() {
        return fdBorrowId;
    }

    public void setFdBorrowId(String fdBorrowId) {
        this.fdBorrowId = fdBorrowId;
    }

    public String getFdDocId() {
        return fdDocId;
    }

    public void setFdDocId(String fdDocId) {
        this.fdDocId = fdDocId;
    }

    public CsotDccmodDocumentMain getDocumentMain() {
        return documentMain;
    }

    public void setDocumentMain(CsotDccmodDocumentMain documentMain) {
        this.documentMain = documentMain;
    }
}
