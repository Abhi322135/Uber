package com.example.geektrust.Service;

import com.example.geektrust.Model.Driver;
import com.example.geektrust.Model.Location;
import com.example.geektrust.Repository.DriverRepository;
import com.example.geektrust.Service.ServiceInterface.DriverServiceInterface;

import java.util.List;

public class DriverService implements DriverServiceInterface {
    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    // TODO: return the saved driver object after saving it to the repository
    public void add(Driver d){
        driverRepository.add(d);
    }
    public List<Driver> getTopFiveDriver(Location rider){
        return driverRepository.getTopFiveDriver(rider);
    }
    // TODO: Update should also return the updated driver object
    public void updateDriver(Driver d){
        driverRepository.updateDriverDetails(d);
    }
    public List<Driver> getAllDriver(){
        return driverRepository.getAllDriverList();
    }

    // TODO: Rename this method to add with the same signature, it should save the driver to the repository and return the driver object
    public Driver getDriver(String id , Location driverLoc, boolean isOccupied){
        return new Driver(id,driverLoc,isOccupied);
    }
}
