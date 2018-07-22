package be.course.design.encapsulation.coffeemachine;

import java.util.Random;

/**
 * A decent example of encapsulation. Why? Well, all of the data and processes needed
 * to make coffee are bundled together in this class 'InstantCoffeeMachine' and hidden
 * for possible users of this class. Users have no idea how coffee is made, and they
 * don't need to know either. In this case, there is only method which hides all of 
 * the inner working. Access to this class is limited, so clients can't change any 
 * of the internals of this class.
 */
public class InstantCoffeeMachine {
    private int boilingTemperatureInCelcius = 100;
    private int currentWaterTemperatureInCelcius;
    
    //This coffeemachine runs on electricity
    private int netVoltage = 220;
    private int currentVoltage = 0;
    private final int boilerVoltage = 120;
    
    private int maximumVolumeOfCanInCentiliter = 150;
    
    public Coffee makeCoffee(int amountOfCoffeePowder, int volumeOfWater) {
        if(volumeOfWater > maximumVolumeOfCanInCentiliter) {
            throw new IllegalArgumentException("The amount of water you added is higher then the current coffee can can handle!!!");
        }
        
        transformElectricalCurrent();
        
        boilWater(volumeOfWater);
        currentVoltage = 0;
        return infuse(amountOfCoffeePowder, volumeOfWater);
    }
    
    private void boilWater(int volume) {
        this.currentWaterTemperatureInCelcius = getInitialWaterTemperature(volume);
        while(currentWaterTemperatureInCelcius < boilingTemperatureInCelcius) {
            heatUp();
        }
    }
    
    /**
     * Realistically put somewhere between 10 and 20 degrees I guess
     */
    private int getInitialWaterTemperature(int volume) {
        Random random = new Random();
        return random.nextInt(10)+10;
    }
    
    private void heatUp() {  
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie) {
            throw new RuntimeException("Something went very wrong when heating up the water!");
        }
        
        currentWaterTemperatureInCelcius ++;
    }
    
    private void transformElectricalCurrent() {
        currentVoltage = netVoltage - 100;
    }
    
    //This is where you slowly pour the boiling water over the coffee powder
    private Coffee infuse(int amountOfPowder, int volumeOfBoilingWater) {
        System.out.println("infusing....");
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie) {
            throw new RuntimeException("Something went very wrong when infusing the coffee tast in the water!");
        }
        System.out.println("enjoy your coffee");
        return new Coffee(volumeOfBoilingWater);
    }
}
