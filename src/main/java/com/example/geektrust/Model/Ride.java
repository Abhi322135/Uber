package com.example.geektrust.Model;

import com.example.geektrust.Model.POJO.Location;

public class Ride {
    private String id;
    private Rider rider;
    private Driver driver;
    private int minutes;
    private Location location;
    private double distanceCovered ;
    private boolean isRideCompleted;
    public Ride(String id, Rider rider, int minutes, Driver driver,Location location,double distanceCovered,boolean isRideCompleted) {
        this.id = id;
        this.rider = rider;
        this.minutes = minutes;
        this.driver = driver;
        this.location = location;
        this.distanceCovered = distanceCovered;
        this.isRideCompleted = isRideCompleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Rider getRider() {
        return this.rider;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public Driver getDriver() {
        return this.driver;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getDistanceCovered() {
        return distanceCovered;
    }

    public void setDistanceCovered(double distanceCovered) {
        this.distanceCovered = distanceCovered;
    }

    public boolean isRideCompleted() {
        return isRideCompleted;
    }

    public void setRideCompleted(boolean rideCompleted) {
        isRideCompleted = rideCompleted;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id='" + id + '\'' +
                ", rider=" + rider +
                ", driver=" + driver +
                ", minutes=" + minutes +
                ", location=" + location +
                ", distanceCovered=" + distanceCovered +
                ", isRideCompleted=" + isRideCompleted +
                '}';
    }
}
