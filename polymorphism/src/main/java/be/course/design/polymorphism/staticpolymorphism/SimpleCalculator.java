package be.course.design.polymorphism.staticpolymorphism;

/**
 * Here is an example of static polymorphism, which can be obtained by method 
 * overloading. In this example the method "simpleDivision()" has multiple 
 * forms and thus is polymorphic. However, which form to be used will already be
 * clear at compile time, as the decision is made when the businesslogic codes the
 * parameters. 
 */
public class SimpleCalculator {
    public void simpleDivision(int number, int divisor) {
        int result = number/divisor;
        System.out.println("Result after dividing: " + result);
    }
    
    public void simpleDivision(double number, double divisor) {
        double result = number/divisor;
        System.out.println("Result of decimal dividing: " + result);
    }
}
