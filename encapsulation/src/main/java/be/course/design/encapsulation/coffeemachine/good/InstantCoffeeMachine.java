package be.course.design.encapsulation.coffeemachine.good;

import be.course.design.encapsulation.coffeemachine.Coffee;
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
    private boolean isOn = false;
    
    public Coffee makeCoffee(int amountOfCoffeePowder, int volumeOfWater) {
        System.out.println("- Making a coffee ... -");
        if(volumeOfWater > maximumVolumeOfCanInCentiliter) {
            throw new IllegalArgumentException("The amount of water you added is higher then the current coffee can can handle!!!");
        }
        boilWater(volumeOfWater);
        return infuse(amountOfCoffeePowder, volumeOfWater);
    }
    
    private void boilWater(int volume) {
        if(currentVoltage > boilerVoltage) {
            throw new RuntimeException("To high voltage! Boiler broke");
        }
        
        if(currentVoltage < boilerVoltage - 10) {
            throw new RuntimeException("To low voltage! Boiling water will take forever");
        }
        
        System.out.println("- ...Boiling water... -");
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
            Thread.sleep(100);
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
        System.out.println("- ...infusing.... -");
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie) {
            throw new RuntimeException("Something went very wrong when infusing the coffee tast in the water!");
        }
        System.out.println("- coffee ready -");
        return new Coffee(volumeOfBoilingWater);
    }
    
    public void turnOn() {
        if(!isOn) {
            this.currentVoltage = netVoltage;
            transformElectricalCurrent();
        }
        else {
            System.out.println("Can't turn on, the machine is already on");
        }
    }
    
    public void turnOff() {
        if(isOn) {
            this.currentVoltage = 0;
        }
        else{
            System.out.println("Can't turn off, the machine is not turned on");
        }
    }
}
