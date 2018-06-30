package com.yuantu.okhttp;

/**
 * Author:  Yxj
 * Time:    2018/6/29 下午9:36
 * -----------------------------------------
 * Description:
 */
public class ApiResponse<T> {

    /**
     * success : true
     * resultCode : 100
     * msg : 成功
     * data : {"phoneNum":"18848958292","pirosId":154,"pirosName":"董金叶","corporationName":"青岛市妇女儿童医院","corporationId":261,"serviceItems":[{"id":12,"name":"预约挂号管理平台","code":"1006","serviceRole":{"id":63,"createDate":1513148367000,"updateDate":1513148367000,"serviceCode":"1006","name":"审核","description":"审核排班权限","value":"55","canAuthorize":2,"status":1,"selectResurceType":"[]"}},{"id":36,"name":"医生端","code":"1018","serviceRole":{"id":100,"createDate":1511940021000,"updateDate":1511940052000,"serviceCode":"1018","name":"医生","description":"医生角色","value":"1111","canAuthorize":2,"status":1,"selectResurceType":"[]"}},{"id":38,"name":"医生管理平台","code":"1019"}]}
     * startTime : 1530279382983
     * timeConsum : 146
     */

    private boolean success;
    private String resultCode;
    private String msg;
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
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
