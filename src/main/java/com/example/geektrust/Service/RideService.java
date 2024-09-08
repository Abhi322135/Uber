package com.example.geektrust.Service;

import com.example.geektrust.Model.Ride;
import com.example.geektrust.Repository.RideRepository;

import java.util.List;
import java.util.Optional;

public class RideService {
    private final RideRepository rideRepository;

    public RideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }
    public void add(Ride r){
        rideRepository.add(r);
    }
    public List<Ride> getAllRideList(){
        return rideRepository.getAllRideList();
    }
    public Optional<Ride> getRideById(String id){
        return rideRepository.findById(id);
    }
    public boolean isRiderOnRide(String id){
        return rideRepository.findIfUserIsOnARide(id);
    }
}
