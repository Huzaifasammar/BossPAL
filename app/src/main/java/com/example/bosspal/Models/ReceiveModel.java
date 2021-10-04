package com.example.bosspal.Models;

public class ReceiveModel {
    int pic;
    String name,price;

    public ReceiveModel(int pic, String name, String price) {
        this.pic = pic;
        this.name = name;
        this.price = price;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
