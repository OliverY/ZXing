package com.yuantu.okhttp;

import java.util.List;

/**
 * Author:  Yxj
 * Time:    2018/6/29 下午9:37
 * -----------------------------------------
 * Description:
 */
public class LoginBean {

    /**
     * phoneNum : 18848958292
     * pirosId : 154
     * pirosName : 董金叶
     * corporationName : 青岛市妇女儿童医院
     * corporationId : 261
     * serviceItems : [{"id":12,"name":"预约挂号管理平台","code":"1006","serviceRole":{"id":63,"createDate":1513148367000,"updateDate":1513148367000,"serviceCode":"1006","name":"审核","description":"审核排班权限","value":"55","canAuthorize":2,"status":1,"selectResurceType":"[]"}},{"id":36,"name":"医生端","code":"1018","serviceRole":{"id":100,"createDate":1511940021000,"updateDate":1511940052000,"serviceCode":"1018","name":"医生","description":"医生角色","value":"1111","canAuthorize":2,"status":1,"selectResurceType":"[]"}},{"id":38,"name":"医生管理平台","code":"1019"}]
     */

    private String phoneNum;
    private int pirosId;
    private String pirosName;
    private String corporationName;
    private int corporationId;
    private List<ServiceItemsBean> serviceItems;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getPirosId() {
        return pirosId;
    }

    public void setPirosId(int pirosId) {
        this.pirosId = pirosId;
    }

    public String getPirosName() {
        return pirosName;
    }

    public void setPirosName(String pirosName) {
        this.pirosName = pirosName;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

    public int getCorporationId() {
        return corporationId;
    }

    public void setCorporationId(int corporationId) {
        this.corporationId = corporationId;
    }

    public List<ServiceItemsBean> getServiceItems() {
        return serviceItems;
    }

    public void setServiceItems(List<ServiceItemsBean> serviceItems) {
        this.serviceItems = serviceItems;
    }

    public static class ServiceItemsBean {
        /**
         * id : 12
         * name : 预约挂号管理平台
         * code : 1006
         * serviceRole : {"id":63,"createDate":1513148367000,"updateDate":1513148367000,"serviceCode":"1006","name":"审核","description":"审核排班权限","value":"55","canAuthorize":2,"status":1,"selectResurceType":"[]"}
         */

        private int id;
        private String name;
        private String code;
        private ServiceRoleBean serviceRole;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public ServiceRoleBean getServiceRole() {
            return serviceRole;
        }

        public void setServiceRole(ServiceRoleBean serviceRole) {
            this.serviceRole = serviceRole;
        }

        public static class ServiceRoleBean {
            /**
             * id : 63
             * createDate : 1513148367000
             * updateDate : 1513148367000
             * serviceCode : 1006
             * name : 审核
             * description : 审核排班权限
             * value : 55
             * canAuthorize : 2
             * status : 1
             * selectResurceType : []
             */

            private int id;
            private long createDate;
            private long updateDate;
            private String serviceCode;
            private String name;
            private String description;
            private String value;
            private int canAuthorize;
            private int status;
            private String selectResurceType;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getCreateDate() {
                return createDate;
            }

            public void setCreateDate(long createDate) {
                this.createDate = createDate;
            }

            public long getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(long updateDate) {
                this.updateDate = updateDate;
            }

            public String getServiceCode() {
                return serviceCode;
            }

            public void setServiceCode(String serviceCode) {
                this.serviceCode = serviceCode;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public int getCanAuthorize() {
                return canAuthorize;
            }

            public void setCanAuthorize(int canAuthorize) {
                this.canAuthorize = canAuthorize;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getSelectResurceType() {
                return selectResurceType;
            }

            public void setSelectResurceType(String selectResurceType) {
                this.selectResurceType = selectResurceType;
            }
        }
    }
}
