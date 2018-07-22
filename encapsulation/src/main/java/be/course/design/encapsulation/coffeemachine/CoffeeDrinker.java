package be.course.design.encapsulation.coffeemachine;

public class CoffeeDrinker {
    
    private Coffee coffee;
    
    public void iNeedACoffee(InstantCoffeeMachine coffeeMachine) {
        coffeeMachine.makeCoffee(150, 150);
    }

}
