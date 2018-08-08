package be.course.design.polymorphism.runtimepolymorphism;

public class DutchGreeter implements Greeter{

    @Override
    public void greet(String name) {
        System.out.println("Hallo " + name);
    }
}
