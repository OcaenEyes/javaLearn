package com.gzy.page.model;

import java.io.Serializable;
import java.util.Map;

public class YouoneInfo implements Serializable {

    private static final long serialVersionUID = -3741387742734765797L;
    private int id;
    private String imgUrl;
    private String textNum;
    private String imgAuther;
    private String textContent;
    private String mon;
    private String day;

    public YouoneInfo() {
    }

    public YouoneInfo(int id, String imgUrl, String textNum, String imgAuther, String textContent, String mon, String day) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.textNum = textNum;
        this.imgAuther = imgAuther;
        this.textContent = textContent;
        this.mon = mon;
        this.day = day;
    }

    public YouoneInfo(Map<String, Object> map) {
        this.id = (int) map.get("id");
        this.imgUrl = (String) map.get("imgUrl");
        this.textNum = (String) map.get("textNum");
        this.imgAuther = (String) map.get("imgAuther");
        this.textContent = (String) map.get("textContent");
        this.mon = (String) map.get("mon");
        this.day = (String) map.get("day");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTextNum() {
        return textNum;
    }

    public void setTextNum(String textNum) {
        this.textNum = textNum;
    }

    public String getImgAuther() {
        return imgAuther;
    }

    public void setImgAuther(String imgAuther) {
        this.imgAuther = imgAuther;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "YouoneInfo{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                ", textNum='" + textNum + '\'' +
                ", imgAuther='" + imgAuther + '\'' +
                ", textContent='" + textContent + '\'' +
                ", mon='" + mon + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}
