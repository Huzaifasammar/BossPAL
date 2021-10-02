package com.example.bosspal.Models;

public class TokenModel {
    int pic;
    String coinName,rate,percent,value;

    public TokenModel(int pic, String coinName, String rate, String percent, String value) {
        this.pic = pic;
        this.coinName = coinName;
        this.rate = rate;
        this.percent = percent;
        this.value = value;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
