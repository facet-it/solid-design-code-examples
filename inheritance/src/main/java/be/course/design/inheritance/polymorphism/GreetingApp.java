package be.course.design.inheritance.polymorphism;

/**
 * Showing polymorphism by using inheritance. A variable of a certain super type
 * can dynamically be refered to an object of a subtype which may or may not have
 * a different implementation for methods.
 */
public class GreetingApp {
    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        greeter.greet("James");
        
        greeter = new BigGreeter();
        greeter.greet("Anne");
    }
}
