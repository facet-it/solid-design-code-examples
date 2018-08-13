package be.course.design.inheritance.polymorphism;

public class BigGreeter extends Greeter {

    @Override
    public void greet(String name) {
        super.greet(name); 
        System.out.println("How are you?");
    }

}
