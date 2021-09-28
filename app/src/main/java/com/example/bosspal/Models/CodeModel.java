package com.example.bosspal.Models;

public class CodeModel {
    int item;
    String code;

    public CodeModel(int item, String code) {
        this.item = item;
        this.code = code;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
