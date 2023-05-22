package com.data_binding.model;

public class Email {
    private  String languasges;
    private String pageSize;
    private Boolean spamsFillter;
    private String signature;

    public Email() {
    }

    public Email(String languasges, String pageSize, Boolean spamsFillter, String signature) {
        this.languasges = languasges;
        this.pageSize = pageSize;
        this.spamsFillter = spamsFillter;
        this.signature = signature;
    }

    public String getLanguasges() {
        return languasges;
    }

    public void setLanguasges(String languasges) {
        this.languasges = languasges;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getSpamsFillter() {
        return spamsFillter;
    }

    public void setSpamsFillter(Boolean spamsFillter) {
        this.spamsFillter = spamsFillter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
