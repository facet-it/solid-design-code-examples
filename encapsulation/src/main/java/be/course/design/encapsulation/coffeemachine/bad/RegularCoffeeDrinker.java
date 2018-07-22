package be.course.design.encapsulation.coffeemachine.bad;

import be.course.design.encapsulation.coffeemachine.Coffee;

public class RegularCoffeeDrinker {
    private Coffee coffee;
    
    public void needsACoffee(BadCoffeeMachine coffeeMachine) {
        System.out.println("I just want a coffee");
        try {
            coffeeMachine.makeCoffee(100, 150);
        }
        catch(Exception e) {
            System.out.println("------ " + e.getMessage());
            
            System.out.println("Whaat? Where is my coffee!?");
        }
    }
}
