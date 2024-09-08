package com.example.geektrust.Model.POJO;

import com.example.geektrust.Util;

import java.text.DecimalFormat;

public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public String distanceTo(Location that) {
        int x1 = this.x;
        int y1 = this.y;
        int x2 = that.getX();
        int y2 = that.getY();
        int sqX = (x2 - x1) * (x2 - x1);
        int sqY = (y2 - y1) * (y2 - y1);
        return Util.getTwoDecimalNumber(Math.sqrt(sqX + sqY));
    }
}
