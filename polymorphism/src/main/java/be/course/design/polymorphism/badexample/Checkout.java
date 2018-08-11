package be.course.design.polymorphism.badexample;

import java.util.List;

/**
 * This is another client in need of VAT calculations. Unfortunately, there is 
 * no uniform way of using these calculations. The developers of the different 
 * vat calculations have no contract to uphold, so the client code needs some
 * sort of a check to know which VAT system to use. If there is a new market with
 * a new VAT system, this class will also have to chance. And the changes can be
 * pretty bad. 
 * 
 * Imagine the code changes in this class for an integration with the 
 * AsianVatCalculator. A new if-else structure to check, but the signature of the
 * doCheckout method would need a new parameter, namely the originCountry 
 * parameter wich is required by the AsianVatCalculator. Since there is no way 
 * in this Checkout class what the origin country is, you need to pass in as a
 * parameter. That means you now need to change the doCheckout signature everywhere
 * so that you can use the new parameter AND you also need to figure out a way 
 * to get to the right value for that parameter! 
 */
public class Checkout {
    
    public void doCheckout(List<Product> products, String vatSystem, boolean isAllForeignServices) {
        double totalPrice = 0;
        double totalVat = 0;
        
        for(Product product : products) {
            totalPrice += product.getPrice();
        }
        
        if(vatSystem != null && vatSystem.equals("Belgian")) {
            BelgianVatCalculator calculator = new BelgianVatCalculator();
            totalVat = calculator.doBelgianVatCalculationsOnList(products);
        }
        
        else if(vatSystem != null && vatSystem.equals("European")) {
            EuropeanVatCalculator vatCalculator = new EuropeanVatCalculator();
            
            //please mark the yukkie boolean that was passed into the method of
            //the checkout class.
            totalVat = vatCalculator.doCalculations(products, isAllForeignServices);
        }
        
        System.out.println("Total price: " + totalPrice);
        System.out.println("Total VAT: " + totalVat);
    }
}
