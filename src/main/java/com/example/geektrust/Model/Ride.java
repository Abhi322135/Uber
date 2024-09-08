package com.example.geektrust.Model;

import com.example.geektrust.Model.POJO.Location;

public class Ride {
    private String id;
    private Rider rider;
    private Driver driver;
    private int minutes;
    private Location location;
    private double distanceCovered ;
    public Ride(String id, Rider rider, int minutes, Driver driver,Location location,double distanceCovered) {
        this.id = id;
        this.rider = rider;
        this.minutes = minutes;
        this.driver = driver;
        this.location = location;
        this.distanceCovered = distanceCovered;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Rider getRider() {
        return new Rider(rider.getId(),rider.getRider());
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public Driver getDriver() {
        return new Driver(driver.getId(),driver.getDriver(), driver.isOccupied());
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

    @Override
    public String toString() {
        return "Ride{" +
                "id='" + id + '\'' +
                ", rider=" + rider +
                ", driver=" + driver +
                ", minutes=" + minutes +
                ", location=" + location +
                ", distanceCovered=" + distanceCovered +
                '}';
    }
}
