package com.example.geektrust.Service;

import com.example.geektrust.Model.Rider;
import com.example.geektrust.Repository.RiderRepository;
import com.example.geektrust.Service.ServiceInterface.RiderServiceInterface;

import java.util.List;
import java.util.Optional;


public class RiderService implements RiderServiceInterface {
    private final RiderRepository riderRepository;

    public RiderService(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }
    public void addRider(Rider r){
        riderRepository.add(r);
    }
    public void updateRider(Rider r){
        riderRepository.update(r);
    }
    public Optional<Rider> getRiderById(String id){
        return riderRepository.getById(id);
    }
    public List<Rider> getAllRiderList(){
        return riderRepository.getAllRiders();
    }
}
