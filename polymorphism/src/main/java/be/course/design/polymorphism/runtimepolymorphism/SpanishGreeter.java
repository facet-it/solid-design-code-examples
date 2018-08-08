package be.course.design.polymorphism.runtimepolymorphism;

public class SpanishGreeter implements Greeter {

    @Override
    public void greet(String name) {
        System.out.println("Buenos dias " + name);
    }
}
