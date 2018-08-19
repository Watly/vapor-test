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

import co.watly.vapor.model.IDroneData;

/**
 * Simple mockup implementation of a {@link IDroneData} for test purposes
 * @author Marco Vasapollo
 *
 */
public class InjectedDroneData implements IDroneData {
    
    private final long maxReachableSpeed = 70;
    private final long maxWeightCapability = 30;
    private final double speedDecreasingFactor = 0;
    private final long totalJourney = 800000;
    private final String modelName;
    
    public InjectedDroneData(String modelName) {
        this.modelName = modelName;
    }
    
    @Override
    public long getMaxReachableSpeed() {
        return maxReachableSpeed;
    }
    
    @Override
    public long getMaxWeightCapability() {
        return maxWeightCapability;
    }
    
    @Override
    public double getSpeedDecreasingFactor() {
        return speedDecreasingFactor;
    }
    
    @Override
    public long getTotalJourney() {
        return totalJourney;
    }
    
    @Override
    public String getModelName() {
        return modelName;
    }

    @Override
    public String toString() {
        return "InjectedDroneData [modelName=" + modelName + ", maxReachableSpeed=" + maxReachableSpeed + " cm/sec, maxWeightCapability=" + maxWeightCapability + " hg, speedDecreasingFactor=" + speedDecreasingFactor + " %, totalJourney=" + totalJourney + " cm]";
    }
}