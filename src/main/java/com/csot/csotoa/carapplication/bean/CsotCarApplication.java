package com.csot.csotoa.carapplication.bean;

import com.csot.csotoa.util.bean.AttMain;
import com.csot.csotoa.util.bean.SysOrgElement;

import java.util.List;

public class CsotCarApplication {
    private String docSubject;			//标 题
    private String docApplicationId;	//申请人Id
    private String docApplicationName;	//申请人名称
    private String docDeptId;			//用车部门Id
    private String docDeptName;			//用车部门名称
    private String fdMobile;			//手机号
    private String fdClusterNo;			//固定电话/短 号
    private String fdReason;			//用车事由
    private String fdOutPersonsNumber;	//用车人数
    private String fdWay;				//单程或往返
    private String fdCarUser;			//公司用车人员
    private String fdOtherOutPersons;	//非公司人员
    private String fdType;				//用车类型
    private String fdAddress;			//乘车地点
    private String fdStartTime;			//用车时间
    private String fdBackTime;			//返回时间
    private String fdRoute;				//路 线
    private String docCreateTime;		//创建时间
    private String docCreatorId;		//创建者ID
    private String docCreatorName;		//创建者名称
    private String fdOverTime;			//用车结束时间
    private List<SysOrgElement> carUserList;
    private List<CsotCarInfo> carInfoList;
    private List<AttMain> fileList;

    public String getDocSubject() {
        return docSubject;
    }

    public void setDocSubject(String docSubject) {
        this.docSubject = docSubject;
    }

    public String getDocApplicationId() {
        return docApplicationId;
    }

    public void setDocApplicationId(String docApplicationId) {
        this.docApplicationId = docApplicationId;
    }

    public String getDocApplicationName() {
        return docApplicationName;
    }

    public void setDocApplicationName(String docApplicationName) {
        this.docApplicationName = docApplicationName;
    }

    public String getDocDeptId() {
        return docDeptId;
    }

    public void setDocDeptId(String docDeptId) {
        this.docDeptId = docDeptId;
    }

    public String getDocDeptName() {
        return docDeptName;
    }

    public void setDocDeptName(String docDeptName) {
        this.docDeptName = docDeptName;
    }

    public String getFdMobile() {
        return fdMobile;
    }

    public void setFdMobile(String fdMobile) {
        this.fdMobile = fdMobile;
    }

    public String getFdClusterNo() {
        return fdClusterNo;
    }

    public void setFdClusterNo(String fdClusterNo) {
        this.fdClusterNo = fdClusterNo;
    }

    public String getFdReason() {
        return fdReason;
    }

    public void setFdReason(String fdReason) {
        this.fdReason = fdReason;
    }

    public String getFdOutPersonsNumber() {
        return fdOutPersonsNumber;
    }

    public void setFdOutPersonsNumber(String fdOutPersonsNumber) {
        this.fdOutPersonsNumber = fdOutPersonsNumber;
    }

    public String getFdWay() {
        return fdWay;
    }

    public void setFdWay(String fdWay) {
        this.fdWay = fdWay;
    }

    public String getFdCarUser() {
        return fdCarUser;
    }

    public void setFdCarUser(String fdCarUser) {
        this.fdCarUser = fdCarUser;
    }

    public String getFdOtherOutPersons() {
        return fdOtherOutPersons;
    }

    public void setFdOtherOutPersons(String fdOtherOutPersons) {
        this.fdOtherOutPersons = fdOtherOutPersons;
    }

    public String getFdType() {
        return fdType;
    }

    public void setFdType(String fdType) {
        this.fdType = fdType;
    }

    public String getFdAddress() {
        return fdAddress;
    }

    public void setFdAddress(String fdAddress) {
        this.fdAddress = fdAddress;
    }

    public String getFdStartTime() {
        return fdStartTime;
    }

    public void setFdStartTime(String fdStartTime) {
        this.fdStartTime = fdStartTime;
    }

    public String getFdBackTime() {
        return fdBackTime;
    }

    public void setFdBackTime(String fdBackTime) {
        this.fdBackTime = fdBackTime;
    }

    public String getFdRoute() {
        return fdRoute;
    }

    public void setFdRoute(String fdRoute) {
        this.fdRoute = fdRoute;
    }

    public String getDocCreateTime() {
        return docCreateTime;
    }

    public void setDocCreateTime(String docCreateTime) {
        this.docCreateTime = docCreateTime;
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

    public String getFdOverTime() {
        return fdOverTime;
    }

    public void setFdOverTime(String fdOverTime) {
        this.fdOverTime = fdOverTime;
    }

    public List<SysOrgElement> getCarUserList() {
        return carUserList;
    }

    public void setCarUserList(List<SysOrgElement> carUserList) {
        this.carUserList = carUserList;
    }

    public List<CsotCarInfo> getCarInfoList() {
        return carInfoList;
    }

    public void setCarInfoList(List<CsotCarInfo> carInfoList) {
        this.carInfoList = carInfoList;
    }

    public List<AttMain> getFileList() {
        return fileList;
    }

    public void setFileList(List<AttMain> fileList) {
        this.fileList = fileList;
    }
}
