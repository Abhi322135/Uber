package com.example.geektrust.Repository;

import com.example.geektrust.Model.Driver;
import com.example.geektrust.Model.POJO.Location;
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
    public List<Driver> getTopFiveDriver(Location rider){
        return driverList.stream()
                .filter(d -> ! d.isOccupied() && Util.getDistance(d.getDriver(),rider) <= 5)
                .sorted(Comparator.comparingDouble((Driver d) -> Util.getDistance(d.getDriver() , rider)).thenComparing(Driver::getId))
                .limit(5).collect(Collectors.toList());
    }
}
