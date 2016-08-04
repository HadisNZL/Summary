package com.example.hadis.summary.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author hadis on 16.7.21.
 */
public class Subject implements Serializable {


    /**
     * rating : {}
     * title : 肖申克的救赎
     * collect_count : 942283
     * original_title : The Shawshank Redemption
     * subtype : movie
     * year : 1994
     * images : {}
     * alt : https://movie.douban.com/subject/1292052/
     * id : 1292052
     */

    private String title;
    private int collect_count;
    private String original_title;
    private String subtype;
    private String year;
    private String alt;
    private String id;

    private ImgData images;

    public ImgData getImages() {
        return images;
    }

    public void setImages(ImgData images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
