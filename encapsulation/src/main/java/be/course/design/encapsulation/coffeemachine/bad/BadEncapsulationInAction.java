package be.course.design.encapsulation.coffeemachine.bad;

public class BadEncapsulationInAction {
    
    public static void main(String[] args) {
        BadCoffeeMachine coffeeMachine = new BadCoffeeMachine();
        CuriousCoffeeDrinker curiousDrinker = new CuriousCoffeeDrinker();
        RegularCoffeeDrinker drinker = new RegularCoffeeDrinker();
        
        curiousDrinker.needsACoffee(coffeeMachine);
        drinker.needsACoffee(coffeeMachine);

    }

}
