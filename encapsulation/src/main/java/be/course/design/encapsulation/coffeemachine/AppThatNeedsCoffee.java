package be.course.design.encapsulation.coffeemachine;

public class AppThatNeedsCoffee {
    
    public static void main(String[] arguments) {
        SimpleCoffeeMachine machine = new SimpleCoffeeMachine();
        Coffee coffee = machine.makeCoffee(120, 100);
    } 
}
