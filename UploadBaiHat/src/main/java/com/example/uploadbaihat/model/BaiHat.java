package com.example.uploadbaihat.model;

public class BaiHat {
    private String ten;
    private String ngheSi;
    private String theLoai;

    public BaiHat() {
    }

    public BaiHat(String ten, String ngheSi, String theLoai) {
        this.ten = ten;
        this.ngheSi = ngheSi;
        this.theLoai = theLoai;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgheSi() {
        return ngheSi;
    }

    public void setNgheSi(String ngheSi) {
        this.ngheSi = ngheSi;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

}
