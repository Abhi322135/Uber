package com.example.geektrust;

import com.example.geektrust.Model.Location;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Util {
    // TODO: Move to Location class and remove this function
    public static String getDistance(Location a, Location b){ //TODO: Migrate it to Location class
        return a.distanceTo(b);
    }

    // TODO: Move this functionality to ride class, There should be a endRide function that calculated the Bill and
    //  return the object.
    public static String calculateBill (double distance, int min) {
        double bill = Constant.BASE_PRICE + (Constant.RATE_PER_KILOMETER * distance) + (Constant.RATE_PER_MINUTE * min);
        return getTwoDecimalNumber(bill * Constant.SERVICE_TAX);
    }

    // TODO: Move this function to Bill class, it should be renamed to showAmount.
    public static String getTwoDecimalNumber(double number){
        BigDecimal roundedValue = new BigDecimal(number).setScale(2, RoundingMode.HALF_UP);
        return String.format("%.2f", roundedValue);
    }
}
