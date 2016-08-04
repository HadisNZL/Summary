package com.example.hadis.summary.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author hadis on 16.7.18.
 */
public class MovieEntity implements Serializable {


    /**
     * count : 10
     * start : 0
     * total : 250
     * subjects : []
     * title : 豆瓣电影Top250
     */

    private int count;
    private int start;
    private int total;
    private String title;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
