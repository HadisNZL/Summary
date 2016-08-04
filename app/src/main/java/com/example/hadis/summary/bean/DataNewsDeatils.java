package com.example.hadis.summary.bean;

import java.io.Serializable;

/**
 * @author hadis on 16.7.26.
 */
public class DataNewsDeatils implements Serializable {


    /**
     * id : 255279
     * title : 李克强倡议1+6对话会：全球化和多边主义新起点
     * thumb : http://p4.ubetween.com/2016/0726/201607260948551021622.jpg
     * descriptionNews : 未来人们在描述全球经济复苏进程时，2016年7月22日在北京钓鱼台国宾馆内摆放的这张圆桌，想必会被一再提及。
     * url : http://news.ubetween.com/index.php?m=content&c=app_v4&a=show&catid=46&id=255279
     * type : small
     * clicks : 100
     * txt :
     * time : 1469497686
     * timetext : 15分钟前
     */

    private String id;
    private String title;
    private String thumb;
    private String descriptionNews;
    private String url;
    private String type;
    private String clicks;
    private String txt;
    private String time;
    private String timetext;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getDescriptionNews() {
        return descriptionNews;
    }

    public void setDescriptionNews(String descriptionNews) {
        this.descriptionNews = descriptionNews;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClicks() {
        return clicks;
    }

    public void setClicks(String clicks) {
        this.clicks = clicks;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimetext() {
        return timetext;
    }

    public void setTimetext(String timetext) {
        this.timetext = timetext;
    }
}
