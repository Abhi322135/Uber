package com.example.geektrust.Model;

import com.example.geektrust.Model.POJO.Location;

public class Driver {
    private String id;
    private Location driver;
    private boolean isOccupied;
    public Driver(String id, Location driver, boolean isOccupied) {
        this.id = id;
        this.driver = driver;
        this.isOccupied = isOccupied;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Location getDriver() {
        return driver;
    }

    public void setDriver(Location driver) {
        this.driver = driver;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id='" + id + '\'' +
                ", driver=" + driver +
                ", isOccupied=" + isOccupied +
                '}';
    }
}
