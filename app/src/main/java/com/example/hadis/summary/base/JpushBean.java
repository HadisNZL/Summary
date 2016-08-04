package com.example.hadis.summary.base;

import java.io.Serializable;

/**
 * @author hadis on 16.7.13.
 */
public class JpushBean implements Serializable {
    private String Jpushurl;

    public String getJpushurl() {
        return Jpushurl;
    }

    public void setJpushurl(String jpushurl) {
        Jpushurl = jpushurl;
    }
}
