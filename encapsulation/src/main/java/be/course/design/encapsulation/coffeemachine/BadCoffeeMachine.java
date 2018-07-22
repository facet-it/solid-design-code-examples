package be.course.design.encapsulation.coffeemachine;

/**
 * No encapsulation at all :(
 */
public class BadCoffeeMachine {
    
    public int boilingTemperatureInCelcius = 100;
    
    //this is a coffee machine that works on electricity
    public int incomingElectricalVoltage = 220;
    public final int boilerVoltage = 120;
    
    public int maximumVolumeOfCanInCentiliter = 150;
    //maybe even more details 
    
    public Coffee makeCoffee(int amountOfCoffeePowder, int volumeOfWater) {
        if(volumeOfWater > maximumVolumeOfCanInCentiliter) {
            throw new IllegalArgumentException("The amount of water you added is higher then the current coffee can can handle!!!");
        }
        boilWater(volumeOfWater);
        return infuse(amountOfCoffeePowder, volumeOfWater);
    }
    
    public void boilWater(int volume) {
        while(getTemperatureOfWater(volume) < boilingTemperatureInCelcius) {
            heatUp();
        }
    }
    
    private void heatUp() {
        if(transformElectricalCurrent(incomingElectricalVoltage) > boilerVoltage) {
            throw new RuntimeException("Voltage too high for this boiler");
        }
        //Electrical current flows through the heating element and heats up the
        //water
    }
    
    /**
     * The heating element in this machine is an electrical one and it only works
     * on 120 volts.
     */
    private int transformElectricalCurrent(int incomingVol) {
        //a process to go from 220 volts to 120 volts
        return 120;
    }
    
    private int getTemperatureOfWater(int volume) {
        int temperature = 0; // this gets set by some kind of sensor
        return temperature;
    }
    
    //This is where you slowly pour the boiling water over the coffee powder
    private Coffee infuse(int amountOfPowder, int volumeOfBoilingWater) {
        //the moment where the water turns into coffee by infusion
        return new Coffee(volumeOfBoilingWater);
    }

}
