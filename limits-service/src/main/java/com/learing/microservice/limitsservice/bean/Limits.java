package com.learing.microservice.limitsservice.bean;

public class Limits {
    private int minmum;
    private int maxmum;

    public Limits() {
    }

    public Limits(int minmum, int maxmum) {
        super();
        this.minmum = minmum;
        this.maxmum = maxmum;
    }

    public int getMinmum() {
        return minmum;
    }

    public void setMinmum(int minmum) {
        this.minmum = minmum;
    }

    public int getMaxmum() {
        return maxmum;
    }

    public void setMaxmum(int maxmum) {
        this.maxmum = maxmum;
    }
}
