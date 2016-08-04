package com.example.hadis.summary.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author hadis on 16.7.26.
 */
public class DataNews<T> {
    //
//    "data": {
//        "count": 30,
//                "data2": []
//    },

    private int count;
    private T data2;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getData2() {
        return data2;
    }

    public void setData2(T data2) {
        this.data2 = data2;
    }
}
