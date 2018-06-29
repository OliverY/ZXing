package com.yuantu.zxing.net.bean;

/**
 * Author:  Yxj
 * Time:    2018/6/28 下午1:49
 * -----------------------------------------
 * Description:
 */
public class ApiResponse<T> {
    /**
     * success : true
     * msg : 操作成功
     * data : {"page":1,"size":10,"total":1,"value":[{"createBy":93,"createDate":"2018-06-26 21:14:33","updateBy":null,"updateDate":"2018-06-26 21:14:33","delFlag":"0","id":237,"barcode":"1-001-002-20180627-001","name":"自助机","model":"1","deviceTypeId":1,"deviceTypeName":"自助机","hospitalId":9,"parentId":0,"recievingId":96,"inventoryId":87,"produced":false,"troubleCount":0,"areaId":1,"areaName":"华北大区","hospitalName":null,"modelName":"ABC"}]}
     */

    private boolean success;
    private String msg;
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
