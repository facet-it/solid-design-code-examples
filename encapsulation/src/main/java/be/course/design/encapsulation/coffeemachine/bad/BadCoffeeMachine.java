package be.course.design.encapsulation.coffeemachine.bad;

import be.course.design.encapsulation.coffeemachine.Coffee;
import java.util.Random;

/**
 * No encapsulation at all :(
 */
public class BadCoffeeMachine {
    
    public int boilingTemperatureInCelcius = 100;
    public int currentWaterTemperatureInCelcius;
    
    //This coffeemachine runs on electricity
    public int netVoltage = 220;
    public int currentVoltage = 0;
    public final int boilerVoltage = 120;
    
    public int maximumVolumeOfCanInCentiliter = 150;
    
    public Coffee makeCoffee(int amountOfCoffeePowder, int volumeOfWater) {
        System.out.println("- Making a coffee ... -");
        if(volumeOfWater > maximumVolumeOfCanInCentiliter) {
            throw new IllegalArgumentException("The amount of water you added is higher then the current coffee can can handle!!!");
        }
        
        transformElectricalCurrent();
        
        boilWater(volumeOfWater);
        currentVoltage = 0;
        return infuse(amountOfCoffeePowder, volumeOfWater);
    }
    
    public void boilWater(int volume) {
        if(currentVoltage > boilerVoltage) {
            throw new RuntimeException("To high voltage! Boiler broke");
        }
        
        if(currentVoltage < boilerVoltage - 10) {
            throw new RuntimeException("To low voltage! Boiling water will take forever");
        }
        
        System.out.println("- ...boiling water...");
        this.currentWaterTemperatureInCelcius = getInitialWaterTemperature(volume);
        while(currentWaterTemperatureInCelcius < boilingTemperatureInCelcius) {
            heatUp();
        }
    }
    
    /**
     * Realistically put somewhere between 10 and 20 degrees I guess
     */
    public int getInitialWaterTemperature(int volume) {
        Random random = new Random();
        return random.nextInt(10)+10;
    }
    
    public void heatUp() {  
        try{
            Thread.sleep(100);
        }
        catch(InterruptedException ie) {
            throw new RuntimeException("Something went very wrong when heating up the water!");
        }
        
        currentWaterTemperatureInCelcius ++;
    }
    
    public void transformElectricalCurrent() {
        currentVoltage = netVoltage - 100;
    }
    
    //This is where you slowly pour the boiling water over the coffee powder
    public Coffee infuse(int amountOfPowder, int volumeOfBoilingWater) {
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
