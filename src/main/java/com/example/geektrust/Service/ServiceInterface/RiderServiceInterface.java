package com.example.geektrust.Service.ServiceInterface;

import com.example.geektrust.Model.Rider;

import java.util.List;
import java.util.Optional;

public interface RiderServiceInterface {
    void addRider(Rider r);
    void updateRider(Rider r);
    Optional<Rider> getRiderById(String id);
    List<Rider> getAllRiderList();
}
