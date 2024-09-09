package com.example.geektrust.Service;

import com.example.geektrust.Model.Driver;
import com.example.geektrust.Model.Location;
import com.example.geektrust.Repository.DriverRepository;

import java.util.List;

public class DriverService {
    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public void add(Driver d){
        driverRepository.add(d);
    }
    public List<Driver> getTopFiveDriver(Location rider){
        return driverRepository.getTopFiveDriver(rider);
    }
    public void updateDriver(Driver d){
        driverRepository.updateDriverDetails(d);
    }
    public List<Driver> getAllDriver(){
        return driverRepository.getAllDriverList();
    }
    public Driver getDriver(String id , Location driverLoc, boolean isOccupied){
        return new Driver(id,driverLoc,isOccupied);
    }
}
