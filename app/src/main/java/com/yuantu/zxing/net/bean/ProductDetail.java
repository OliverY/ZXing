package com.yuantu.zxing.net.bean;

import java.util.List;

/**
 * Author:  Yxj
 * Time:    2018/7/2 下午3:50
 * -----------------------------------------
 * Description:
 */
public class ProductDetail {

    /**
     * createBy : 93
     * createDate : 2018-07-02 10:20:32
     * updateBy : null
     * updateDate : null
     * deleted : false
     * id : 13
     * barcode : 1-107-012-20180702-019
     * name : null
     * model : null
     * deviceTypeId : 107
     * deviceTypeName : YT-DT550
     * hospitalId : 8
     * parentId : 0
     * recievingId : 2
     * inventoryId : 5
     * produced : true
     * troubleCount : null
     * areaId : null
     * areaName : 华北大区
     * hospitalName : 威海市中心医院
     * modelName : null
     * printed : false
     * position : null
     * childDevices : [{"createBy":93,"createDate":"2018-07-02 10:19:00","updateBy":92,"updateDate":null,"deleted":false,"id":1,"barcode":"2-136-012-20180702-006","name":null,"model":null,"deviceTypeId":136,"deviceTypeName":"主板","hospitalId":8,"parentId":13,"recievingId":1,"inventoryId":4,"produced":false,"troubleCount":null,"areaId":null,"areaName":"华北大区","hospitalName":"威海市中心医院","modelName":null,"printed":false,"position":null,"childDevices":null,"u8BatchNo":"966445"},{"createBy":93,"createDate":"2018-07-02 10:19:00","updateBy":92,"updateDate":null,"deleted":false,"id":2,"barcode":"2-136-012-20180702-007","name":null,"model":null,"deviceTypeId":136,"deviceTypeName":"主板","hospitalId":8,"parentId":13,"recievingId":1,"inventoryId":4,"produced":false,"troubleCount":null,"areaId":null,"areaName":"华北大区","hospitalName":"威海市中心医院","modelName":null,"printed":false,"position":null,"childDevices":null,"u8BatchNo":"966445"},{"createBy":93,"createDate":"2018-07-02 10:19:00","updateBy":92,"updateDate":null,"deleted":false,"id":3,"barcode":"2-136-012-20180702-008","name":null,"model":null,"deviceTypeId":136,"deviceTypeName":"主板","hospitalId":8,"parentId":13,"recievingId":1,"inventoryId":4,"produced":false,"troubleCount":null,"areaId":null,"areaName":"华北大区","hospitalName":"威海市中心医院","modelName":null,"printed":false,"position":null,"childDevices":null,"u8BatchNo":"966445"},{"createBy":93,"createDate":"2018-07-02 10:19:00","updateBy":92,"updateDate":null,"deleted":false,"id":4,"barcode":"2-136-012-20180702-009","name":null,"model":null,"deviceTypeId":136,"deviceTypeName":"主板","hospitalId":8,"parentId":13,"recievingId":1,"inventoryId":4,"produced":false,"troubleCount":null,"areaId":null,"areaName":"华北大区","hospitalName":"威海市中心医院","modelName":null,"printed":false,"position":null,"childDevices":null,"u8BatchNo":"966445"}]
     * u8BatchNo : 567766
     */

    private int createBy;
    private String createDate;
    private Object updateBy;
    private Object updateDate;
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
    private boolean printed;
    private Object position;
    private String u8BatchNo;
    private List<ProductBean> childDevices;

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

    public Object getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Object updateDate) {
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

    public boolean isPrinted() {
        return printed;
    }

    public void setPrinted(boolean printed) {
        this.printed = printed;
    }

    public Object getPosition() {
        return position;
    }

    public void setPosition(Object position) {
        this.position = position;
    }

    public String getU8BatchNo() {
        return u8BatchNo;
    }

    public void setU8BatchNo(String u8BatchNo) {
        this.u8BatchNo = u8BatchNo;
    }

    public List<ProductBean> getChildDevices() {
        return childDevices;
    }

    public void setChildDevices(List<ProductBean> childDevices) {
        this.childDevices = childDevices;
    }
}
