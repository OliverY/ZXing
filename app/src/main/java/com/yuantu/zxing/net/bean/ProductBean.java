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
     * createDate : 2018-07-17 16:50:07
     * updateBy : null
     * updateDate : null
     * deleted : false
     * id : 5
     * barcode : 1107-023005180717018
     * name : null
     * model : null
     * deviceTypeId : 107
     * deviceTypeName : YT-DT550
     * hospitalId : 8
     * parentId : 0
     * recievingId : 1
     * inventoryId : 1
     * produced : true
     * troubleCount : null
     * areaId : null
     * areaName : 华北大区
     * hospitalName : 威海市中心医院
     * modelName : null
     * printed : false
     * position : null
     * childDevices : null
     * produceDate : 2018-07-17
     * warrantyDate : null
     * attachBatchNo : 3123123
     * attachSerialNo : 3123123005
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
    private Object childDevices;
    private String produceDate;
    private Object warrantyDate;
    private String attachBatchNo;
    private String attachSerialNo;

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

    public Object getChildDevices() {
        return childDevices;
    }

    public void setChildDevices(Object childDevices) {
        this.childDevices = childDevices;
    }

    public String getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(String produceDate) {
        this.produceDate = produceDate;
    }

    public Object getWarrantyDate() {
        return warrantyDate;
    }

    public void setWarrantyDate(Object warrantyDate) {
        this.warrantyDate = warrantyDate;
    }

    public String getAttachBatchNo() {
        return attachBatchNo;
    }

    public void setAttachBatchNo(String attachBatchNo) {
        this.attachBatchNo = attachBatchNo;
    }

    public String getAttachSerialNo() {
        return attachSerialNo;
    }

    public void setAttachSerialNo(String attachSerialNo) {
        this.attachSerialNo = attachSerialNo;
    }

    @Override
    public String toString() {
        return "产品简介" + "\r\n" +
                "产品名称：\t\t" + deviceTypeName + "\r\n" +
                "产品id：\t\t" + id + "\r\n" +
                "入库时间：\t\t" + createDate + "\r\n" +
                "批次号：\t\t" + attachBatchNo + "\r\n" +
                "区域：\t\t" + areaName + "\r\n" +
                "医院：\t\t" + hospitalName + "\r\n" +
                "成品序列号：\t\t" + attachSerialNo + "\r\n" +
                "生产日期：\t\t" + produceDate + "\r\n";
    }

    public String toMaterialString(){
        return "产品简介" + "\r\n" +
                "产品名称：\t\t" + deviceTypeName + "\r\n" +
                "产品id：\t\t" + id + "\r\n" +
                "入库时间：\t\t" + createDate + "\r\n" +
                "批次号：\t\t" + attachBatchNo + "\r\n" +
                "区域：\t\t" + areaName + "\r\n" +
                "医院：\t\t" + hospitalName + "\r\n" +
                "生产日期：\t\t" + produceDate + "\r\n";
    }
}
