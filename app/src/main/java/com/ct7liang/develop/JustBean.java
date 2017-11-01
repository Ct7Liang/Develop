package com.ct7liang.develop;

import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 */

public class JustBean {

    /**
     * code : 000
     * data : [{"actualDuration":0,"address":"高新区","amounts":500000,"beginTime":"2017-10-23 17:25:26","businessId":8,"code":"c246a4f40adf49d6ab1b5435d542ddec","customerId":1,"customerName":"李","description":"电子商务","endTime":"2017-10-23 17:29:59","expectedDuration":60,"extraAmounts":0,"id":7,"orderId":7,"status":"12","transactionId":"","type":"01","updateTime":"2017-10-23 17:29:59"},{"actualDuration":0,"address":"路","amounts":123,"beginTime":"2017-10-24 15:19:32","businessId":8,"code":"7136dd4e5882488cafd633e85b197313","customerId":9,"customerName":"邻居","description":"吐","endTime":"2017-10-24 15:23:46","expectedDuration":5,"extraAmounts":0,"id":11,"orderId":11,"status":"12","transactionId":"","type":"01","updateTime":"2017-10-24 15:23:46"},{"actualDuration":0,"address":"郑州金水区东风路经三路","amounts":5000,"beginTime":"2017-10-25 10:35:00","businessId":8,"code":"6e3d0294c28e4c08b2bc60512b11e083","customerId":9,"customerName":"","description":"金城国际广场西单元","endTime":"2017-10-25 10:41:35","expectedDuration":5,"extraAmounts":0,"id":23,"orderId":23,"status":"12","transactionId":"","type":"01","updateTime":"2017-10-25 10:41:35"},{"actualDuration":0,"address":"郑州金水区东风路经三路","amounts":6000,"beginTime":"2017-10-25 15:19:23","businessId":8,"code":"c432e6d74a7947cda002745ef5b2c360","customerId":9,"customerName":"","description":"金城国际广场西单元","endTime":"2017-10-25 16:05:33","expectedDuration":5,"extraAmounts":0,"id":27,"orderId":27,"status":"12","transactionId":"","type":"01","updateTime":"2017-10-25 16:05:33"},{"actualDuration":0,"address":"郑州金水区东风路经三路","amounts":5000,"beginTime":"2017-10-25 16:38:31","businessId":8,"code":"dd912049d221448e852934f06dec7717","customerId":9,"customerName":"","description":"金城国际广场西单元","endTime":"2017-10-27 15:07:02","expectedDuration":5,"extraAmounts":0,"id":34,"orderId":34,"status":"12","transactionId":"","type":"01","updateTime":"2017-10-27 15:07:02"}]
     * msg : success
     */

    private String code;
    private String msg;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * actualDuration : 0
         * address : 高新区
         * amounts : 500000
         * beginTime : 2017-10-23 17:25:26
         * businessId : 8
         * code : c246a4f40adf49d6ab1b5435d542ddec
         * customerId : 1
         * customerName : 李
         * description : 电子商务
         * endTime : 2017-10-23 17:29:59
         * expectedDuration : 60
         * extraAmounts : 0
         * id : 7
         * orderId : 7
         * status : 12
         * transactionId :
         * type : 01
         * updateTime : 2017-10-23 17:29:59
         */

        private int actualDuration;
        private String address;
        private int amounts;
        private String beginTime;
        private int businessId;
        private String code;
        private int customerId;
        private String customerName;
        private String description;
        private String endTime;
        private int expectedDuration;
        private int extraAmounts;
        private int id;
        private int orderId;
        private String status;
        private String transactionId;
        private String type;
        private String updateTime;

        public int getActualDuration() {
            return actualDuration;
        }

        public void setActualDuration(int actualDuration) {
            this.actualDuration = actualDuration;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getAmounts() {
            return amounts;
        }

        public void setAmounts(int amounts) {
            this.amounts = amounts;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public int getBusinessId() {
            return businessId;
        }

        public void setBusinessId(int businessId) {
            this.businessId = businessId;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public int getExpectedDuration() {
            return expectedDuration;
        }

        public void setExpectedDuration(int expectedDuration) {
            this.expectedDuration = expectedDuration;
        }

        public int getExtraAmounts() {
            return extraAmounts;
        }

        public void setExtraAmounts(int extraAmounts) {
            this.extraAmounts = extraAmounts;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }
}
