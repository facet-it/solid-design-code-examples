package be.course.design.polymorphism.benefits;

import be.course.design.polymorphism.benefits.client.IntroductionBusinessRules;
import be.course.design.polymorphism.benefits.impl.DutchGreet;

public class App {

    public static void main(String[] args) {
        IntroductionBusinessRules rules = new IntroductionBusinessRules(new DutchGreet());
        rules.introduce("Nicholas");
    }

}
