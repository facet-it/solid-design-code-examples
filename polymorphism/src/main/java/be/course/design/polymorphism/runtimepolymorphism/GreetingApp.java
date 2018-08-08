package be.course.design.polymorphism.runtimepolymorphism;

/**
 * Very basic demonstration of polymorphism in java. 
 * 
 * In the example, the variable "greeter" is of the type "Greeter". You could say
 * that the type "Greeter" has different forms (there is a "DutchGreeter" and 
 * there is a "SpanishGreeter"). 
 * 
 * Java allows us to assign another form or implementation to the "greeter" 
 * variable at runtime by means of "late binding". This is in my opinion the 
 * most powerful variant of polymorphism.
 */
public class GreetingApp {
    public static void main(String[] args) {
        Greeter greeter = new DutchGreeter();
        greeter.greet("Sally");
        
        greeter = new SpanishGreeter();
        greeter.greet("Juan");
    }
}
