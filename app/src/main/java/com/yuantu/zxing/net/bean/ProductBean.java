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
     * createDate : 2018-06-28 23:35:43
     * updateBy : null
     * updateDate : 2018-06-28 23:35:43
     * deleted : false
     * id : 12
     * barcode : 1-06b-003-20180629-055
     * name : null
     * model : null
     * deviceTypeId : 107
     * deviceTypeName : YT-DT550
     * hospitalId : 9
     * parentId : 0
     * recievingId : 3
     * inventoryId : 3
     * produced : true
     * troubleCount : null
     * areaId : null
     * areaName : 华北大区
     * hospitalName : 监控监控
     * modelName : null
     */

    private int createBy;
    private String createDate;
    private Object updateBy;
    private String updateDate;
    private boolean deleted;
    private int id;
    private String barcode;
    private Object name;
    private Object model;
    private int deviceTypeId;
    private String deviceTypeName;
    private int hospitalId;
    private int parentId;
    private int recievingId;
    private int inventoryId;
    private boolean produced;
    private Object troubleCount;
    private Object areaId;
    private String areaName;
    private String hospitalName;
    private Object modelName;

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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Object getModel() {
        return model;
    }

    public void setModel(Object model) {
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

    public Object getTroubleCount() {
        return troubleCount;
    }

    public void setTroubleCount(Object troubleCount) {
        this.troubleCount = troubleCount;
    }

    public Object getAreaId() {
        return areaId;
    }

    public void setAreaId(Object areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Object getModelName() {
        return modelName;
    }

    public void setModelName(Object modelName) {
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
