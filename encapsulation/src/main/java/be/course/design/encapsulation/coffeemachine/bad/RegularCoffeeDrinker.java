package be.course.design.encapsulation.coffeemachine.bad;

import be.course.design.encapsulation.coffeemachine.Coffee;

public class RegularCoffeeDrinker {
    
    public void needsACoffee(BadCoffeeMachine coffeeMachine) {
        System.out.println("I just want a coffee");
        try {
            coffeeMachine.turnOn();
            coffeeMachine.boilWater(150);
            Coffee myCoffee = coffeeMachine.infuse(200, 150);
            coffeeMachine.turnOff();
            
        }
        catch(Exception e) {
            System.out.println("------ " + e.getMessage());
            System.out.println("Whaat? Where is my coffee!?");
        }
    }
}
