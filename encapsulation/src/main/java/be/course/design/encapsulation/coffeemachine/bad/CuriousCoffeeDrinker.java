package be.course.design.encapsulation.coffeemachine.bad;

import be.course.design.encapsulation.coffeemachine.Coffee;

public class CuriousCoffeeDrinker {
    
    public void needsACoffee(BadCoffeeMachine coffeeMachine) {
        System.out.println("I want a coffee but... there is so much stuff I can do with this machine!!");
        coffeeMachine.turnOn();

        coffeeMachine.heatUp();
        coffeeMachine.heatUp();
        coffeeMachine.boilWater(150);
        Coffee coffee = coffeeMachine.infuse(250, 150);
        coffeeMachine.maximumVolumeOfCanInCentiliter = 10;
        System.out.println("That was fun and I got a coffee!");
        
        coffeeMachine.transformElectricalCurrent();
        coffeeMachine.currentVoltage = 120;
    }
}
