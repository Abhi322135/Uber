// TODO: Instead of keeping interfaces in a separate package keep the implementations.
package com.example.geektrust.Service.ServiceInterface;

import com.example.geektrust.Model.Driver;
import com.example.geektrust.Model.Location;

import java.util.List;

// TODO: DriverServiceInterface -> DriverService, use DriverServiceImpl for implementation class name
public interface DriverServiceInterface {
    void add(Driver d);
    List<Driver> getTopFiveDriver(Location rider);
    void updateDriver(Driver d);
    List<Driver> getAllDriver();
    Driver getDriver(String id , Location driverLoc, boolean isOccupied);
}
