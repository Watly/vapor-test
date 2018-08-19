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
package co.watly.vapor.mock;

import java.util.concurrent.CompletableFuture;

import co.watly.vapor.model.IDrone;
import co.watly.vapor.model.IDroneData;

import static java.util.concurrent.CompletableFuture.completedFuture;


/**
 * Simple mockup implementation of a {@link IDrone} for test purposes
 * @author Marco Vasapollo
 *
 */
public class DroneMockup implements IDrone {
    
    private static final IDroneData DATA = new InjectedDroneData(DroneMockup.class.getSimpleName());
    
    public DroneMockup() {
        System.out.println("DroneMockup: Initialized");
    }
    
    @Override
    public CompletableFuture<IDroneData> getData() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("DroneMockup: Request for Data:\n\t" + DATA + "\n");
            return DATA;
        });
    }
    
    @Override
    public CompletableFuture<Void> rotate(long speed, double degrees) {
        System.out.println("DroneMockup: I'm rotating at " + speed + " cm/sec of " + degrees + " degrees");
        return completedFuture(null);
    }
    
    @Override
    public CompletableFuture<Void> forward(long speed, long millisecs) {
        System.out.println("DroneMockup: I'm going forward at " + speed + " cm/sec for " + millisecs + " milliseconds");
        return completedFuture(null);
    }
    
    @Override
    public CompletableFuture<Void> back(long speed, long millisecs) {
        System.out.println("DroneMockup: I'm going back at " + speed + " cm/sec for " + millisecs + " milliseconds");
        return completedFuture(null);
    }
    
    @Override
    public CompletableFuture<Void> up(long speed, long millisecs) {
        System.out.println("DroneMockup: I'm going up at " + speed + " cm/sec for " + millisecs + " milliseconds");
        return completedFuture(null);
    }
    
    @Override
    public CompletableFuture<Void> down(long speed, long millisecs) {
        System.out.println("DroneMockup: I'm going down at " + speed + " cm/sec for " + millisecs + " milliseconds");
        return completedFuture(null);
    }
    
    @Override
    public CompletableFuture<Void> left(long speed, long millisecs) {
        System.out.println("DroneMockup: I'm going left at " + speed + " cm/sec for " + millisecs + " milliseconds");
        return completedFuture(null);
    }
    
    @Override
    public CompletableFuture<Void> right(long speed, long millisecs) {
        System.out.println("DroneMockup: I'm going right at " + speed + " cm/sec for " + millisecs + " milliseconds");
        return completedFuture(null);
    }
}
