package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            BookCabService service = new BookCabService();
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                String[] arr = s.split(" ");
                if (arr[0].equalsIgnoreCase("ADD_DRIVER")){
                    service.addDriver(arr);
                }
                else if (arr[0].equalsIgnoreCase("ADD_RIDER")){
                    service.addRider(arr);
                }
                else if (arr[0].equalsIgnoreCase("MATCH")){
                    service.matchDriver(arr);
                }
                else if (arr[0].equalsIgnoreCase("START_RIDE")){
                    service.startRide(arr);
                }
                else if (arr[0].equalsIgnoreCase("STOP_RIDE")){
                    service.stopRide(arr);
                }
                else {
                    service.generateBill(arr);
                }
            }
             sc.close(); // closes the scanner
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
