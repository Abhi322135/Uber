package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            CommandLineService  service = new CommandLineService();
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                String[] arr = s.split(" ");
                service.executeLines(arr);
            }
             sc.close(); // closes the scanner
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
