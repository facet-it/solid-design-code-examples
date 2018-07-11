package be.course.design.abstraction.examples.thing;

import java.util.List;

public class DatingPerson {
    private String name;
    private int age;
    private String sex;
    private List<String> interests;
    
    public DatingPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
