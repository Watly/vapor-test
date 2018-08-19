/**
 * This work is licensed under the 
 * Creative Commons Attribution-ShareAlike 4.0 International License. 
 * To view a copy of this license, visit 
 * http://creativecommons.org/licenses/by-sa/4.0/ 
 * or send a letter to 
 * Creative Commons, 
 * PO Box 1866, Mountain View, 
 * CA 94042, USA.
 */
package co.watly.vapor.test;

import static com.ea.async.Async.await;
import static java.util.concurrent.CompletableFuture.completedFuture;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import co.watly.vapor.controller.VaporController;
import co.watly.vapor.data.Itinerary;
import co.watly.vapor.mock.DroneMockup;
import co.watly.vapor.model.IDrone;
import co.watly.vapor.util.Helper;
/**
 * Main Class - Used for test purposes
 * @author Marco Vasapollo
 *
 */
public class Main {
    
    /**
     * Loads an itinerary from json file passed through params
     */
    public static void main(String[] args) {

        System.out.println("=== Vapor by Watly ===");
        System.out.println("=== TEST START ===\n");
        
        //Instantiate the Drone communication channel
        final IDrone drone = new DroneMockup();
        
        final VaporController vaporController = new VaporController(drone);
        
        String itineraryFileName = args[0];
        System.out.println("Reading itinerary from JSON File: " + itineraryFileName);
        
        Itinerary itinerary = Helper.readJSONFile(itineraryFileName, Itinerary.class);
        
        doJob(vaporController, itinerary);
        
        //Useful to lock Main Thread
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static final CompletableFuture<Void> doJob(VaporController vaporController, Itinerary itinerary) {
        try {
            await(vaporController.setup(itinerary));
            await(vaporController.fly());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n=== Vapor by Watly ===");
        System.out.println("=== TEST END ===");
        System.exit(1);
        return completedFuture(null);
    }
}
