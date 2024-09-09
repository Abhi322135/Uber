package com.example.geektrust;

public class CommandLineService {
    BookCabService service = new BookCabService();
    public void executeLines(String arr[]){
        if (arr[0].equalsIgnoreCase("ADD_DRIVER")){
            executeAddDriverCommand(arr);
        }
        else if (arr[0].equalsIgnoreCase("ADD_RIDER")){
            executeAddRiderCommand(arr);
        }
        else if (arr[0].equalsIgnoreCase("MATCH")){
            executeMatchDriverCommand(arr);
        }
        else if (arr[0].equalsIgnoreCase("START_RIDE")){
            executeStartRideCommand(arr);
        }
        else if (arr[0].equalsIgnoreCase("STOP_RIDE")){
            executeStopRideCommand(arr);
        }
        else {
            executeGenerateBillCommand(arr);
        }
    }
    private void executeAddDriverCommand(String[] arr){
        service.addDriver(arr);
    }
    private void executeAddRiderCommand(String[] arr){
        service.addRider(arr);
    }
    private void executeMatchDriverCommand(String[] arr){
        service.matchDriver(arr);
    }
    private void executeStartRideCommand(String[] arr){
        service.startRide(arr);
    }
    private void executeStopRideCommand(String[] arr){
        service.stopRide(arr);
    }
    private void executeGenerateBillCommand(String[] arr){
        service.generateBill(arr);
    }
}
