package com.example.geektrust;

import com.example.geektrust.Model.Location;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Util {
    public static String getDistance(Location a, Location b){ //TODO: Migrate it to Location class
        return a.distanceTo(b);
    }
    public static String calculateBill (double distance, int min) {
        double bill = Constant.BASE_PRICE + (Constant.RATE_PER_KILOMETER * distance) + (Constant.RATE_PER_MINUTE * min);
        return getTwoDecimalNumber(bill * Constant.SERVICE_TAX);
    }
    public static String getTwoDecimalNumber(double number){
        BigDecimal roundedValue = new BigDecimal(number).setScale(2, RoundingMode.HALF_UP);
        String formattedNumber = String.format("%.2f", roundedValue);
        return formattedNumber;
    }
}
