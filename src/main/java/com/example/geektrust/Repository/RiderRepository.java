package com.example.geektrust.Repository;

import com.example.geektrust.Model.Rider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RiderRepository {
    private List<Rider> riderList =new ArrayList<>();
    public void add(Rider rider){
        riderList.add(rider);
    }
    public void remove(Rider rider){
        riderList.remove(rider);
    }
    public void update(Rider rider){
        Optional<Rider> getRider = riderList.stream().filter(a -> a.getId().equals(rider.getId()))
                .findAny();
        if (getRider.isPresent()){
            remove(getRider.get());
            add(rider);
        }
    }

    public List<Rider> getAllRiders() {
        return riderList;
    }

    public Optional<Rider> getById(String id) {
        return riderList.stream().filter(r -> r.getId().equals(id)).findAny();
    }
}
