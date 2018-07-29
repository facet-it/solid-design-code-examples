package be.course.design.encapsulation.coffeemachine.good;

public class GoodEncapsulationInAction {
    
    public static void main(String[] arguments) {
        InstantCoffeeMachine coffeeMachine = new InstantCoffeeMachine();
        CoffeeDrinker regularCoffeeDrinker = new CoffeeDrinker();

        regularCoffeeDrinker.needsACoffee(coffeeMachine);
        
    }
}
