package com.yuantu.zxing.bean;

/**
 * Author:  Yxj
 * Time:    2019/5/27 下午1:41
 * -----------------------------------------
 * Description:
 */
public class SchedulerBean {

    private int id;
    private String projectName; // 医院名称
    private String deviceTypeDesc;  // 设备类型 诊间屏
    private int deviceNumber; // 设备总数
    private int moduleInstalled;  // 模块安装
    private int deviceWired;  // 设备布线
    private int deviceTested; // 设备测试
    private String rate;// 进度
    private String startTime;// 开始时间

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

    public String getDeviceTypeDesc() {
        return deviceTypeDesc;
    }

    public void setDeviceTypeDesc(String deviceTypeDesc) {
        this.deviceTypeDesc = deviceTypeDesc;
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

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
