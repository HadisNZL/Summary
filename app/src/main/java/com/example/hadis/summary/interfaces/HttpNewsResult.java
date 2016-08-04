package com.example.hadis.summary.interfaces;

/**
 * @author hadis on 16.7.26.
 */
public class HttpNewsResult<T> {

//    {
//        "status": 1,
//            "message": "ok",
//            "data": {},
//        "errorcode": "0"
//    }

    private int status;
    private String message;
    private T data;
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
}
