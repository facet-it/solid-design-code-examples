package be.course.design.polymorphism;

public class DutchGreeter implements Greeter{

    @Override
    public void greet(String name) {
        System.out.println("Hallo " + name);
    }
}
