package be.course.design.encapsulation.coffeemachine;

public class Application {
    
    public static void main(String[] arguments) {
        InstantCoffeeMachine machine = new InstantCoffeeMachine();
        Coffee coffee = machine.makeCoffee(120, 100);
    } 
}
