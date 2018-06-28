package com.yuantu.zxing.net.bean;

/**
 * Author:  Yxj
 * Time:    2018/6/28 下午1:58
 * -----------------------------------------
 * Description:
 */
public class ProductBean {

    /**
     * createBy : 93
     * createDate : 2018-06-26 21:14:33
     * updateBy : null
     * updateDate : 2018-06-26 21:14:33
     * delFlag : 0
     * id : 237
     * barcode : 1-001-002-20180627-001
     * name : 自助机
     * model : 1
     * deviceTypeId : 1
     * deviceTypeName : 自助机
     * hospitalId : 9
     * parentId : 0
     * recievingId : 96
     * inventoryId : 87
     * produced : false
     * troubleCount : 0
     * areaId : 1
     * areaName : 华北大区
     * hospitalName : null
     * modelName : ABC
     */

    private int createBy;
    private String createDate;
    private Object updateBy;
    private String updateDate;
    private String delFlag;
    private int id;
    private String barcode;
    private String name;
    private String model;
    private int deviceTypeId;
    private String deviceTypeName;
    private int hospitalId;
    private int parentId;
    private int recievingId;
    private int inventoryId;
    private boolean produced;
    private int troubleCount;
    private int areaId;
    private String areaName;
    private Object hospitalName;
    private String modelName;

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Object getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Object updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(int deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getRecievingId() {
        return recievingId;
    }

    public void setRecievingId(int recievingId) {
        this.recievingId = recievingId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public boolean isProduced() {
        return produced;
    }

    public void setProduced(boolean produced) {
        this.produced = produced;
    }

    public int getTroubleCount() {
        return troubleCount;
    }

    public void setTroubleCount(int troubleCount) {
        this.troubleCount = troubleCount;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Object getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(Object hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String toString() {
        return "ProductBean{" +
                "createDate='" + createDate + '\'' +"\r\n" +
                ", id=" + id +"\r\n" +
                ", name='" + name + '\'' +"\r\n" +
                ", areaName='" + areaName + '\'' +"\r\n" +
                ", hospitalName=" + hospitalName +
                '}';
    }
}
