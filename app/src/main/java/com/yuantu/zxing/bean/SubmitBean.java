package com.yuantu.zxing.bean;

/**
 * Author:  Yxj
 * Time:    2019/5/27 下午3:04
 * -----------------------------------------
 * Description:
 */
public class SubmitBean {

    private String barCode;
    private int planOnwardStatus;
    private int deviceId;
    private int projectId;

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public int getPlanOnwardStatus() {
        return planOnwardStatus;
    }

    public void setPlanOnwardStatus(int planOnwardStatus) {
        this.planOnwardStatus = planOnwardStatus;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
