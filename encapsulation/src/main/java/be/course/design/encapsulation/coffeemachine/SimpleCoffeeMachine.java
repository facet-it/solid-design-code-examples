package be.course.design.encapsulation.coffeemachine;

/**
 * A decent example of encapsulation
 */
public class SimpleCoffeeMachine {
    private int boilingTemperatureInCelcius = 100;
    
    //this is a coffee machine that works on electricity
    private int incomingElectricalCurrentInVolt = 220;
    private int electricalCurrentForBoiler = 120;
    
    private int maximumVolumeOfCanInCentiliter = 150;
    //maybe even more details 
    
    public Coffee makeCoffee(int amountOfCoffeePowder, int volumeOfWater) {
        boilWater(volumeOfWater);
        return infuse(amountOfCoffeePowder, volumeOfWater);
    }
    
    private void boilWater(int volume) {
        while(getTemperatureOfWater(volume) < boilingTemperatureInCelcius) {
            heat();
        }
    }
    
    private void heat() {
        transformElectricalCurrent();
        //Electrical current flows through the heating element and heats up the
        //water
    }
    
    /**
     * The heating element in this machine is an electrical one and it only works
     * on 120 volts.
     */
    private void transformElectricalCurrent() {
        //a process to go from 220 volts to 120 volts
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
