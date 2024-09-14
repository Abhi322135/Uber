package com.example.geektrust.Model;

public class Bill {
    private Ride ride;
    // TODO: rename to fare.
    private double bill;
    public Bill(Ride ride, double bill) {
        this.ride = ride;
        this.bill = bill;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "ride=" + ride +
                ", bill=" + bill +
                '}';
    }
}
