// TODO: Should be under 'services' package
package com.example.geektrust;

// TODO: CommandLineService -> CommandLineExecutorService
public class CommandLineService {

    // TODO: Use dependency injection to inject BookCabService
    BookCabService service = new BookCabService();

    // TODO: Update to accept a command object/function args containing String action and String[] args.
    // TODO: executeLines -> just execute
    public void executeLines(String arr[]){
        // TODO: Use switch case instead of if else
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
