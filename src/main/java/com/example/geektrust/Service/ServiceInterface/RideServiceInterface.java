package com.example.geektrust.Service.ServiceInterface;

import com.example.geektrust.Model.Ride;

import java.util.List;
import java.util.Optional;

public interface RideServiceInterface {
    void add(Ride r);
    List<Ride> getAllRideList();
    Optional<Ride> getRideById(String id);
    boolean isRiderOnRide(String id);
}
