package com.bishe.travel.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 景点实体类
 */
public class Scenic {

    @TableId
    private int scenicId;
    private String name;
    private String cover; // 封面图片
    private String address;
    private String des;
    private float price; // 原价
    private float priceCar; // 汽车拼团价
    private float priceTrain; // 火車拼团价
    private float pricePlane; // 飞机拼团价
    private String text; // 景点介绍正文
    private String pindanNum; // 拼团数量

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate; //创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate; //更新时间

    @Override
    public String toString() {
        return "Scenic{" +
                "scenicId=" + scenicId +
                ", name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                ", address='" + address + '\'' +
                ", describe='" + des + '\'' +
                ", price=" + price +
                ", priceCar=" + priceCar +
                ", priceTrain=" + priceTrain +
                ", pricePlane=" + pricePlane +
                ", text='" + text + '\'' +
                ", pindanNum=" + pindanNum +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }

    public int getScenicId() {
        return scenicId;
    }

    public void setScenicId(int scenicId) {
        this.scenicId = scenicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPriceCar() {
        return priceCar;
    }

    public void setPriceCar(float priceCar) {
        this.priceCar = priceCar;
    }

    public float getPriceTrain() {
        return priceTrain;
    }

    public void setPriceTrain(float priceTrain) {
        this.priceTrain = priceTrain;
    }

    public float getPricePlane() {
        return pricePlane;
    }

    public void setPricePlane(float pricePlane) {
        this.pricePlane = pricePlane;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPindanNum() {
        return pindanNum;
    }

    public void setPindanNum(String pindanNum) {
        this.pindanNum = pindanNum;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
