package com.example.uploadfilebaihat.model;

public class BaiHat {
    private String ten;
    private String ngheSi;
    private String theLoai;
    private String file;

    public BaiHat() {
    }

    public BaiHat(String ten, String ngheSi, String theLoai, String file) {
        this.ten = ten;
        this.ngheSi = ngheSi;
        this.theLoai = theLoai;
        this.file = file;
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}