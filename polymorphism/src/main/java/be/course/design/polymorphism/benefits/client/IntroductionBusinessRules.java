package be.course.design.polymorphism.benefits.client;

public class IntroductionBusinessRules {

    private Greet greetings;

    public IntroductionBusinessRules(Greet greetings) {
        this.greetings = greetings;
    }

    public void introduce(String name) {
        greetings.sayHello(name);
    }
}
