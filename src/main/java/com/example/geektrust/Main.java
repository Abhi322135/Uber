package com.example.geektrust;

import com.example.geektrust.Model.Bill;
import com.example.geektrust.Model.Driver;
import com.example.geektrust.Model.POJO.Location;
import com.example.geektrust.Model.Ride;
import com.example.geektrust.Model.Rider;
import com.example.geektrust.Repository.DriverRepository;
import com.example.geektrust.Repository.RideRepository;
import com.example.geektrust.Repository.RiderRepository;
import com.example.geektrust.Service.DriverService;
import com.example.geektrust.Service.RideService;
import com.example.geektrust.Service.RiderService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            RiderService riderService = new RiderService(new RiderRepository());
            RideService rideService = new RideService(new RideRepository());
            DriverService driverService = new DriverService(new DriverRepository());
            List<Driver> drivers = null;
            while (sc.hasNextLine()) {
                //Add your code here to process input commands
                String s = sc.nextLine();
                String[] arr = s.split(" ");
                if (arr[0].equalsIgnoreCase("ADD_DRIVER")){
                    Location driverLoc = new Location(Integer.parseInt(arr[2]),Integer.parseInt(arr[3]));
                    driverService.add(new Driver(arr[1],driverLoc,false));
                }
                else if (arr[0].equalsIgnoreCase("ADD_RIDER")){
                    Location riderLoc = new Location(Integer.parseInt(arr[2]),Integer.parseInt(arr[3]));
                    riderService.addRider(new Rider(arr[1],riderLoc));
                }
                else if (arr[0].equalsIgnoreCase("MATCH")){
                    Location rider = riderService.getRiderById(arr[1]).get().getRider();
                    drivers = driverService.getTopFiveDriver(rider);
                    if (drivers.size() == 0) {
                        System.out.println("NO_DRIVERS_AVAILABLE");
                        continue;
                    }
                    System.out.print("DRIVERS_MATCHED ");
                    drivers.forEach(a -> System.out.print(a.getId()+" "));
                    System.out.println();
                }
                else if (arr[0].equalsIgnoreCase("START_RIDE")){
                    int driverInd = Integer.parseInt(arr[2]);
                    Location loc = riderService.getRiderById(arr[3]).get().getRider();
                    drivers = driverService.getTopFiveDriver(loc);
                    if (drivers.size() < driverInd){
                        System.out.println("INVALID_RIDE");
                        continue;
                    }
                    Driver driver = drivers.get(driverInd - 1);
                    driver.setOccupied(true);
                    Rider rider = riderService.getRiderById(arr[3]).get();
                    rideService.add(new Ride(arr[1],rider,0,driver,driver.getDriver(),0));
                    System.out.println("RIDE STARTED "+arr[1]);
                }
                else if (arr[0].equalsIgnoreCase("STOP_RIDE")){
                    Optional<Ride> rideOptional = rideService.getRideById(arr[1]);
                    if (! rideOptional.isPresent()) {
                        System.out.println("INVALID_RIDE");
                        continue;
                    }
                    Ride ride = rideOptional.get();
                    Driver driver = ride.getDriver();
                    Rider rider = ride.getRider();
                    ride.setDistanceCovered(Util.getDistance(rider.getRider(),new Location(Integer.parseInt(arr[2]),Integer.parseInt(arr[3]))));
                    driver.setDriver(new Location(Integer.parseInt(arr[2]),Integer.parseInt(arr[3])));
                    driver.setOccupied(false);
                    ride.setMinutes(Integer.parseInt(arr[4]));
                    rider.setRider(new Location(Integer.parseInt(arr[2]),Integer.parseInt(arr[3])));
                    driverService.updateDriver(driver);
                    riderService.updateRider(rider);
                    System.out.println("RIDE STOPPED "+arr[1]);
                }
                else {
                    Optional<Ride> rideOptional = rideService.getRideById(arr[1]);
                    if (! rideOptional.isPresent()) {
                        System.out.println("INVALID_RIDE");
                        continue;
                    }
                    Ride ride = rideOptional.get();
                    double billAmount = Util.calculateBill(ride.getDistanceCovered(),ride.getMinutes());
                    Bill bill = new Bill(ride,billAmount);
                    System.out.println("BILL "+bill.getRide().getId()+" "+ride.getDriver().getId()+" "+billAmount);
                }
            }
             sc.close(); // closes the scanner
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
