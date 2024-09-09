package com.example.geektrust.Model;

public class Driver {
    private String id;
    private Location location;
    private boolean isOccupied;
    public Driver(String id, Location driver, boolean isOccupied) {
        this.id = id;
        this.location = driver;
        this.isOccupied = isOccupied;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location driver) {
        this.location = driver;
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
                ", driver=" + location +
                ", isOccupied=" + isOccupied +
                '}';
    }
}
