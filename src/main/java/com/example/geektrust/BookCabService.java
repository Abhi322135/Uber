package com.example.geektrust;

import com.example.geektrust.Model.Bill;
import com.example.geektrust.Model.Driver;
import com.example.geektrust.Model.Location;
import com.example.geektrust.Model.Ride;
import com.example.geektrust.Model.Rider;
import com.example.geektrust.Repository.DriverRepository;
import com.example.geektrust.Repository.RideRepository;
import com.example.geektrust.Repository.RiderRepository;
import com.example.geektrust.Service.DriverService;
import com.example.geektrust.Service.RideService;
import com.example.geektrust.Service.RiderService;
import com.example.geektrust.Service.ServiceInterface.DriverServiceInterface;
import com.example.geektrust.Service.ServiceInterface.RideServiceInterface;
import com.example.geektrust.Service.ServiceInterface.RiderServiceInterface;

import java.util.List;
import java.util.Optional;

public class BookCabService {
    private DriverServiceInterface driverService;
    private RideServiceInterface rideService;
    private RiderServiceInterface riderService;
    private  DriverRepository driverRepository;
    private  RideRepository rideRepository;
    private  RiderRepository riderRepository;

    // TODO: Use dependency injection to inject DriverRepository, RideRepository, RiderRepository
    public BookCabService() {
        initialize();
    }

    private void initialize() {
        this.driverRepository = new DriverRepository();
        this.rideRepository = new RideRepository();
        this.riderRepository = new RiderRepository();
        this.driverService = new DriverService(this.driverRepository);
        this.rideService = new RideService(this.rideRepository);
        this.riderService = new RiderService(this.riderRepository);
    }

    public void addDriver(String[] arr){
        Location driverLoc = new Location(Integer.parseInt(arr[2]),Integer.parseInt(arr[3]));
        // TODO: Redundant function getDriver(), why not use new Driver() directly?
        driverService.add(driverService.getDriver(arr[1],driverLoc,Constant.FALSE));
    }
    public void addRider(String[] arr){
        Location riderLoc = new Location(Integer.parseInt(arr[2]),Integer.parseInt(arr[3]));
        riderService.addRider(new Rider(arr[1],riderLoc));
    }
    public void matchDriver(String[] arr){
        Location rider = riderService.getRiderById(arr[1]).get().getRider();
        List<Driver> drivers = driverService.getTopFiveDriver(rider);
        if (drivers.size() == 0) {
            System.out.println(Constant.DRIVER_NOT_MATCHED_MESSAGE);
            return;
        }
        System.out.print(Constant.DRIVER_MATCH_MESSAGE);
        drivers.forEach(a -> System.out.print(a.getId()+" "));
        System.out.println();
    }
    public void startRide(String[] arr){
        int driverInd = Integer.parseInt(arr[2]);
        Location loc = riderService.getRiderById(arr[3]).get().getRider();
        List<Driver> drivers = driverService.getTopFiveDriver(loc);
        if (drivers.size() < driverInd || rideService.isRiderOnRide(arr[3])){
            System.out.println(Constant.INVALID_RIDE_MESSAGE);
            return;
        }
        Driver driver = drivers.get(driverInd - 1);
        driver.setOccupied(Constant.TRUE);
        Rider rider = riderService.getRiderById(arr[3]).get();
        rideService.add(new Ride(arr[1],rider,0,driver,driver.getLocation(),0,Constant.FALSE));
        System.out.println(Constant.RIDE_STARTED_MESSAGE+arr[1]);
    }

    public void stopRide(String[] arr){
        Optional<Ride> rideOptional = rideService.getRideById(arr[1]);
        if (isStopRideInvalid(rideOptional,arr[1])){
            return;
        }

        Ride ride = rideOptional.get();
        Driver driver = ride.getDriver();
        Rider rider = ride.getRider();
        String distance = Util.getDistance(rider.getRider(),new Location(Integer.parseInt(arr[2]),Integer.parseInt(arr[3])));
        ride.setDistanceCovered(Double.parseDouble(distance));
        driver.setLocation(new Location(Integer.parseInt(arr[2]),Integer.parseInt(arr[3])));
        driver.setOccupied(Constant.FALSE);
        ride.setMinutes(Integer.parseInt(arr[4]));
        rider.setRider(new Location(Integer.parseInt(arr[2]),Integer.parseInt(arr[3])));
        ride.setRideCompleted(Constant.TRUE);
        driverService.updateDriver(driver);
        riderService.updateRider(rider);
        System.out.println(Constant.RIDE_STOPPED_MESSAGE+arr[1]);
    }

    public void generateBill(String[] arr){
        Optional<Ride> rideOptional = rideService.getRideById(arr[1]);
        if (! isRideStopped(rideOptional,arr[1])){
            return;
        }
        Ride ride = rideOptional.get();
        String totalBillAmount = Util.calculateBill(ride.getDistanceCovered(),ride.getMinutes());
        double billAmount = Double.parseDouble(totalBillAmount);
        Bill bill = new Bill(ride,billAmount);
        System.out.println(Constant.RIDE_BILL_MESSAGE+bill.getRide().getId()+" "+ride.getDriver().getId()+" "+totalBillAmount);
    }

    private boolean isRideStopped(Optional<Ride> rideOptional, String s) {
        if (! rideOptional.isPresent() || rideService.isRiderOnRide(s)) {
            System.out.println(Constant.INVALID_RIDE_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean isStopRideInvalid(Optional<Ride> rideOptional, String s) {
        if (! rideOptional.isPresent() || !rideService.isRiderOnRide(s)) {
            System.out.println(Constant.INVALID_RIDE_MESSAGE);
            return true;
        }
        return false;
    }
}
