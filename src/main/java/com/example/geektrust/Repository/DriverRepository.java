package com.example.geektrust.Repository;

import com.example.geektrust.Constant;
import com.example.geektrust.Model.Driver;
import com.example.geektrust.Model.Location;
import com.example.geektrust.Util;

import java.util.*;
import java.util.stream.Collectors;

public class DriverRepository {
    List<Driver> driverList = new ArrayList<>();
    public void add(Driver d){
        driverList.add(d);
    }
    public List<Driver> getAllDriverList(){
        return driverList;
    }
    public void updateDriverDetails(Driver updatedList){
        Optional<Driver> driver = driverList.stream().filter(d -> Objects.equals(updatedList.getId(), d.getId()))
                                  .findFirst();
        if (driver.isPresent()){
            remove(driver.get());
            add(updatedList);
        }
    }

    public void remove(Driver details) {
        driverList.remove(details);
    }
    public List<Driver> getTopFiveDriver(Location riderLocation){
        return driverList.stream()
                .filter(driver -> !driver.isOccupied() && Double.parseDouble(driver.getLocation().distanceTo(riderLocation)) <= Constant.MAX_DIST && Double.parseDouble(driver.getLocation().distanceTo(riderLocation)) != 0) //TODO: NEED TO ADD CONSTANT
                .sorted(Comparator.comparingDouble((Driver d) -> Double.parseDouble(Util.getDistance(d.getLocation() , riderLocation))).thenComparing(Driver::getId))
                .limit(Constant.MAX_SIZE).collect(Collectors.toList());
    }
}
