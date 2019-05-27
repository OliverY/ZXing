package com.yuantu.zxing.bean;

import java.io.Serializable;

/**
 * Author:  Yxj
 * Time:    2019/5/27 下午2:32
 * -----------------------------------------
 * Description:
 */
public class EquipmentBean implements Serializable{

    private int id;
    private String barcode;
    private String deviceTypeName;  //设备型号
    private int hospitalId;         //项目id
    private String hospitalName;
    private int deviceType;         //设备类型（1，2）
    private String deviceTypeDesc;  //设备类型（自助机、诊间屏）

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceTypeDesc() {
        return deviceTypeDesc;
    }

    public void setDeviceTypeDesc(String deviceTypeDesc) {
        this.deviceTypeDesc = deviceTypeDesc;
    }
}
