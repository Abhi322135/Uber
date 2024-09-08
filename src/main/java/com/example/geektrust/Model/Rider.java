package com.example.geektrust.Model;


import com.example.geektrust.Model.POJO.Location;

public class Rider {
    private String id;
    private Location rider;

    public Rider(String id, Location rider) {
        this.id = id;
        this.rider = rider;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Location getRider() {
        return rider;
    }

    public void setRider(Location rider) {
        this.rider = rider;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "id='" + id + '\'' +
                ", rider=" + rider +
                '}';
    }
}
