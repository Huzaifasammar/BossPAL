package com.example.bosspal.Models;

import android.widget.Switch;

public class FilterModel {
    int pic;
    String name,onSwitch;


    public FilterModel(int pic, String name, String onSwitch) {
        this.pic = pic;
        this.name = name;
        this.onSwitch = onSwitch;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOnSwitch() {
        return onSwitch;
    }

    public void setOnSwitch(String onSwitch) {
        this.onSwitch = onSwitch;
    }
}
