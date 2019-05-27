package com.yuantu.zxing.bean;

import java.util.List;

/**
 * Author:  Yxj
 * Time:    2019/5/27 下午3:28
 * -----------------------------------------
 * Description:
 */
public class ConfigBean {
    private List<Config> typeId_122;
    private List<Config> typeId_121;
    private List<Config> typeId_123;

    public List<Config> getTypeId_122() {
        return typeId_122;
    }

    public void setTypeId_122(List<Config> typeId_122) {
        this.typeId_122 = typeId_122;
    }

    public List<Config> getTypeId_121() {
        return typeId_121;
    }

    public void setTypeId_121(List<Config> typeId_121) {
        this.typeId_121 = typeId_121;
    }

    public List<Config> getTypeId_123() {
        return typeId_123;
    }

    public void setTypeId_123(List<Config> typeId_123) {
        this.typeId_123 = typeId_123;
    }

    public static class Config {
        /**
         * id : 1
         * typeId : 122
         * describe : 进行中
         */

        private int id;
        private int typeId;
        private String describe;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }
    }

    /*
    {
        "typeId_122": [
            {
                "id": 1,
                "typeId": 122,
                "describe": "进行中"
            },
            {
                "id": 2,
                "typeId": 122,
                "describe": "已完成"
            },
            {
                "id": 3,
                "typeId": 122,
                "describe": "已取消"
            }
        ],
        "typeId_121": [
            {
                "id": 1,
                "typeId": 121,
                "describe": "自助机"
            },
            {
                "id": 2,
                "typeId": 121,
                "describe": "诊间屏"
            }
        ],
        "typeId_123": [
            {
                "id": 1,
                "typeId": 123,
                "describe": "安装模块"
            },
            {
                "id": 2,
                "typeId": 123,
                "describe": "设备布线"
            },
            {
                "id": 3,
                "typeId": 123,
                "describe": "设备测试"
            }
        ]
    }
     */



}
