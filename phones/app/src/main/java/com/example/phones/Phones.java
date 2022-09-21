package com.example.phones;

import java.io.Serializable;

public class Phones implements Serializable {

    private String phoneName;
    private int phonePrice;
    private String phoneImg;

    public Phones() {
    }

    public Phones(String phoneName, int phonePrice, String phoneImg) {
        this.phoneName = phoneName;
        this.phonePrice = phonePrice;
        this.phoneImg = phoneImg;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public int getPhonePrice() {
        return phonePrice;
    }

    public void setPhonePrice(int phonePrice) {
        this.phonePrice = phonePrice;
    }

    public String getPhoneImg() {
        return phoneImg;
    }

    public void setPhoneImg(String phoneImg) {
        this.phoneImg = phoneImg;
    }
}
