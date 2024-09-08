package com.example.geektrust;

import com.example.geektrust.Model.POJO.Location;

public class Util {
    public static double getDistance(Location a, Location b){
        int x1 = a.getX();
        int y1 = a.getY();
        int x2 = b.getX();
        int y2 = b.getY();
        return Math.round(Math.sqrt(((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1))) * Constant.ROUND) / Constant.ROUND;
    }
    public static double calculateBill (double distance, int min){
        double bill = Constant.BASE_PRICE + (Constant.RATE_PER_KILOMETER * distance) + (Constant.RATE_PER_MINUTE * min);
        return Math.round(bill * Constant.SERVICE_TAX * Constant.ROUND) / Constant.ROUND;
    }
}
