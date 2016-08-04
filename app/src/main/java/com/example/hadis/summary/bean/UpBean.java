package com.example.hadis.summary.bean;

import java.io.Serializable;

/**
 * @author hadis on 16.5.04.
 */
public class UpBean implements Serializable {

    /**
     * status : 1
     * message : ok
     * data : {"url":"http://www.ubetween.cn/download/UbetweenPatient_1.0.1.apk","version":"1.0.1","info":"用户与医生的在线沟通","forceupdate":"0","code":"2"}
     * errorcode : 0
     */

    private int status;
    private String message;
    private DataBean data;
    private String errorcode;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    /**
     * url : http://www.ubetween.cn/download/UbetweenPatient_1.0.1.apk
     * version : 1.0.1
     * info : 用户与医生的在线沟通
     * forceupdate : 0
     * code : 2
     */

    public static class DataBean implements Serializable {
        private String url;
        private String version;
        private String info;
        private String forceupdate;
        private String code;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getForceupdate() {
            return forceupdate;
        }

        public void setForceupdate(String forceupdate) {
            this.forceupdate = forceupdate;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
