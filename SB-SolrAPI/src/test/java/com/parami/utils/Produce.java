package com.parami.utils;

import org.apache.solr.client.solrj.beans.Field;

public class Produce {
    @Field("id")
    private String id;
    @Field("price")
    private int price;
    @Field("saleNum")
    private int saleNum;
    @Field("favNum")
    private int favNum;
    @Field("color")
    private String color;
    @Field("size")
    private int size;
    @Field("itemNum")
    private int itemNum;
    @Field("created_at")
    private long created_at;
    @Field("dsr")
    private float dsr;
    @Field("tag")
    private String tag;

    public Produce(String id, int price, int saleNum, int favNum, String color, int size, int itemNum, long created_at,
            float dsr, String tag) {
        this.id = id;
        this.price = price;
        this.saleNum = saleNum;
        this.favNum = favNum;
        this.color = color;
        this.size = size;
        this.itemNum = itemNum;
        this.created_at = created_at;
        this.dsr = dsr;
        this.tag = tag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public int getFavNum() {
        return favNum;
    }

    public void setFavNum(int favNum) {
        this.favNum = favNum;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public float getDsr() {
        return dsr;
    }

    public void setDsr(float dsr) {
        this.dsr = dsr;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
