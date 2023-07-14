package com.example.demo1.model;

public class Setting {
    private String languege;
    private int pageSize;
    private int spamFilter;
    private String signnature;

    public Setting() {
    }

    public Setting(String languege, int pageSize, int spamFilter, String signnature) {
        this.languege = languege;
        this.pageSize = pageSize;
        this.spamFilter = spamFilter;
        this.signnature = signnature;
    }

    public String getLanguege() {
        return languege;
    }

    public void setLanguege(String languege) {
        this.languege = languege;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(int spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignnature() {
        return signnature;
    }

    public void setSignnature(String signnature) {
        this.signnature = signnature;
    }
}
