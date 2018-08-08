package be.course.design.polymorphism.staticpolymorphism;

/**
 * Example of using static polymorphism. The "simpleDivision()" method of the
 * SimpleCalculator class has multiple forms but it is static polymorphism because
 * the program already knows at compiletime which method will be used by looking
 * at the parameters of the method. 
 * 
 * As a developer you can choose what method to use but your choice will be known
 * already at the time of compilation. 
 */
public class CalculatorApp {
    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();
        
        calculator.simpleDivision(10, 2); //this is the case of integers
        calculator.simpleDivision(11.2, 2d); //this is the case of the doubles
    }
}
