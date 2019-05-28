package com.yuantu.zxing.bean;

/**
 * Author:  Yxj
 * Time:    2019/5/27 下午1:41
 * -----------------------------------------
 * Description:
 */
public class SchedulerBean {

    /**
     * id : 23
     * projectName : 青岛市妇女儿童医院
     * projectId : 1
     * deviceType : 1
     * deviceNumber : 2
     * moduleInstalled : 0
     * deviceWired : 0
     * deviceTested : 0
     * planStatus : 1
     * operateUser : 93
     * startTime : 2019-05-27
     * endTime : null
     * deviceTypeName : null
     * progress : 0
     * rate : 0%
     * deviceTypeDesc : 自助机
     * planStatusDesc : 进行中
     */

    private int id;
    private String projectName;
    private int projectId;
    private int deviceType;
    private int deviceNumber;
    private int moduleInstalled;
    private int deviceWired;
    private int deviceTested;
    private int planStatus;
    private int operateUser;
    private String startTime;
    private String endTime;
    private String deviceTypeName;
    private float progress;
    private String rate;
    private String deviceTypeDesc;
    private String planStatusDesc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public int getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(int deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public int getModuleInstalled() {
        return moduleInstalled;
    }

    public void setModuleInstalled(int moduleInstalled) {
        this.moduleInstalled = moduleInstalled;
    }

    public int getDeviceWired() {
        return deviceWired;
    }

    public void setDeviceWired(int deviceWired) {
        this.deviceWired = deviceWired;
    }

    public int getDeviceTested() {
        return deviceTested;
    }

    public void setDeviceTested(int deviceTested) {
        this.deviceTested = deviceTested;
    }

    public int getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(int planStatus) {
        this.planStatus = planStatus;
    }

    public int getOperateUser() {
        return operateUser;
    }

    public void setOperateUser(int operateUser) {
        this.operateUser = operateUser;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDeviceTypeDesc() {
        return deviceTypeDesc;
    }

    public void setDeviceTypeDesc(String deviceTypeDesc) {
        this.deviceTypeDesc = deviceTypeDesc;
    }

    public String getPlanStatusDesc() {
        return planStatusDesc;
    }

    public void setPlanStatusDesc(String planStatusDesc) {
        this.planStatusDesc = planStatusDesc;
    }
}
