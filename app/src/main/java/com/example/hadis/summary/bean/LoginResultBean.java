package com.example.hadis.summary.bean;

import java.io.Serializable;

/**
 * Created by zmm on 2016/4/15.
 * Describe:
 */
public class LoginResultBean implements Serializable{


    /**
     * status : 1
     * message : 登录成功
     * data : {"sessionName":"?","sessionID":"?","token":"33_521c5346deca5a7882815769850ca838_1460965006"}
     * errorcode : 0
     */

    private String status;
    private String message;
    private T data;
    private String errorcode;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }
    /**
     * sessionName : ?
     * sessionID : ?
     * token : 33_521c5346deca5a7882815769850ca838_1460965006
     */
    public static class T {
        private String sessionName;
        private String sessionID;
        private String token;

        public String getSessionName() {
            return sessionName;
        }

        public void setSessionName(String sessionName) {
            this.sessionName = sessionName;
        }

        public String getSessionID() {
            return sessionID;
        }

        public void setSessionID(String sessionID) {
            this.sessionID = sessionID;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
