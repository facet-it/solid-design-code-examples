package be.course.design.encapsulation.coffeemachine.good;

import be.course.design.encapsulation.coffeemachine.Coffee;

public class CoffeeDrinker {
    
    private Coffee coffee;
    
    public void needsACoffee(InstantCoffeeMachine coffeeMachine) {
        System.out.println("Getting myself some nice coffee...");
        coffeeMachine.turnOn();
        coffeeMachine.makeCoffee(150, 150);
        coffeeMachine.turnOff();
        System.out.println("Ooh yeah!");
    }

}
