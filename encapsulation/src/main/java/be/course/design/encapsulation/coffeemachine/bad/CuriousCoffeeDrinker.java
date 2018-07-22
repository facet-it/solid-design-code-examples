package be.course.design.encapsulation.coffeemachine.bad;

import be.course.design.encapsulation.coffeemachine.Coffee;

public class CuriousCoffeeDrinker {
    
    private Coffee coffee;
    
    public void needsACoffee(BadCoffeeMachine coffeeMachine) {
        System.out.println("I want a coffee but... there is so much stuff I can do with this machine!!");
        coffeeMachine.makeCoffee(150, 150);
        
        coffeeMachine.heatUp();
        coffeeMachine.heatUp();
        
        coffeeMachine.maximumVolumeOfCanInCentiliter = 10;
        System.out.println("That was fun and I got a coffee!");
    }

}
