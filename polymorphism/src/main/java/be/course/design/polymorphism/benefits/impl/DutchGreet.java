package be.course.design.polymorphism.benefits.impl;

import be.course.design.polymorphism.benefits.client.Greet;

public class DutchGreet implements Greet {

    @Override
    public void sayHello(String name) {
        System.out.println("Hallo, ik ben " + name);
    }
}
